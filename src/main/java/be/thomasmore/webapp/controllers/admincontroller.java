package be.thomasmore.webapp.controllers;

import be.thomasmore.webapp.model.Game;
import be.thomasmore.webapp.model.Tournament;
import be.thomasmore.webapp.repositories.GameRepository;
import be.thomasmore.webapp.repositories.TournamentRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class admincontroller {

    @Autowired
    private TournamentRepository tournamentRepository;
    @Autowired
    private GameRepository gameRepository;

    @GetMapping("/tournamentedit/{id}")
    public String tournamentEdit(Model model, @PathVariable int id) {
        model.addAttribute("tournament", tournamentRepository.findById(id));
        model.addAttribute("games", gameRepository.findAll());
        return "admin/tournamentedit";
    }

    @PostMapping("/tournamentedit/{id}")
    public String tournamentEditPost(Model model, @PathVariable int id, @Valid Tournament tournament) {
        tournamentRepository.save(tournament);
        return "redirect:/tournaments";
    }

    @GetMapping("/tournamentnew")
    public String tournamentNew(Model model) {
        model.addAttribute("tournament", new Tournament());

        model.addAttribute("games", gameRepository.findAllBy());
        return "admin/tournamentnew";
    }

    @PostMapping("/tournamentnew")
    public String tournamentNewPost(Model model, @Valid Tournament tournament) {
        tournamentRepository.save(tournament);
        return "redirect:/tournaments";
    }
}
