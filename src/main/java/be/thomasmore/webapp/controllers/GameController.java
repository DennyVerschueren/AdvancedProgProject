package be.thomasmore.webapp.controllers;

import be.thomasmore.webapp.model.Game;
import be.thomasmore.webapp.model.Tournament;
import be.thomasmore.webapp.repositories.GameRepository;
import be.thomasmore.webapp.repositories.TournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Controller
public class GameController {
    @Autowired
    private GameRepository gameRepository;
    @Autowired
    private TournamentRepository tournamentRepository;

    @GetMapping("/games")
    public String game(Model model) {
        List<Game> games = gameRepository.findAllBy();
        model.addAttribute("games", games);
        return "gamelist";
    }

    @GetMapping({"/gamedetails", "/gamedetails/{id}"})
    public String gameDetails(Model model, Principal principal, @PathVariable(required = false) Integer id) {
        if (id==null) return "gamedetails";
        Optional<Game> optionalGame = gameRepository.findById(id);
        Optional<Game> optionalPrev = gameRepository.findFirstByIdLessThanOrderByIdDesc(id);
        Optional<Game> optionalNext = gameRepository.findFirstByIdGreaterThanOrderById(id);
        if (optionalGame.isPresent()) {
            Game game = optionalGame.get();
            model.addAttribute("game", game);
            model.addAttribute("tournaments", tournamentRepository.findAllByGame_Id(id));
        }
        if (optionalPrev.isPresent()) {
            model.addAttribute("prev", optionalPrev.get().getId());
        } else {
            model.addAttribute("prev", gameRepository.findFirstByOrderByIdDesc().get().getId());
        }
        if (optionalNext.isPresent()) {
            model.addAttribute("next", optionalNext.get().getId());
        } else {
            model.addAttribute("next", gameRepository.findFirstByOrderByIdAsc().get().getId());
        }
        return "gamedetails";
    }
}
