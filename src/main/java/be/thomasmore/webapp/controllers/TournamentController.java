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
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
public class TournamentController {
    @Autowired
    private TournamentRepository tournamentRepository;
    @Autowired
    private GameRepository gameRepository;

    @GetMapping({"/tournamentdetails", "/tournamentdetails/{id}"})
    public String gameDetails(Model model, Principal principal, @PathVariable(required = false) Integer id) {
        if (id==null) return "tournamentdetails";
        Optional<Tournament> optionalTournament = tournamentRepository.findById(id);
        Optional<Tournament> optionalPrev = tournamentRepository.findFirstByIdLessThanOrderByIdDesc(id);
        Optional<Tournament> optionalNext = tournamentRepository.findFirstByIdGreaterThanOrderById(id);
        if (optionalTournament.isPresent()) {
            Tournament tournament = optionalTournament.get();
            model.addAttribute("tournament", tournament);
        }
        if (optionalPrev.isPresent()) {
            model.addAttribute("prev", optionalPrev.get().getId());
        } else {
            model.addAttribute("prev", tournamentRepository.findFirstByOrderByIdDesc().get().getId());
        }
        if (optionalNext.isPresent()) {
            model.addAttribute("next", optionalNext.get().getId());
        } else {
            model.addAttribute("next", tournamentRepository.findFirstByOrderByIdAsc().get().getId());
        }
        return "tournamentdetails";
    }

    @GetMapping({"/tournaments", "/tournaments/{x}"})
    public String tournament(Model model) {
        List<Tournament> tournaments = tournamentRepository.findAllBy();
        model.addAttribute("tournaments", tournaments);
        return "tournamentlist";
    }

    @GetMapping("/tournaments/filter")
    public String tournamentListWithFilter(Model model,
                                      @RequestParam(required = false) String name,
                                      @RequestParam(required = false) Game game,
                                      @RequestParam(required = false) boolean free,
                                      @RequestParam(required = false) Double prizepool,
                                      @RequestParam(required = false) Date date) {
        List<Tournament> tournaments = tournamentRepository.findByNameGameFreePrizepoolDate(name, game, free, prizepool, date);
        model.addAttribute("name", name);
        model.addAttribute("game", game);
        model.addAttribute("free", free);
        model.addAttribute("prizepool", prizepool);
        model.addAttribute("date", date);
        model.addAttribute("tournaments", tournaments);
        List<Game> games = gameRepository.findAllBy();
        model.addAttribute("games", games);
        model.addAttribute("showFilter", true);
        return "tournamentlist";
    }


}
