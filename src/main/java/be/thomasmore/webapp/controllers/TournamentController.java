package be.thomasmore.webapp.controllers;

import be.thomasmore.webapp.model.Game;
import be.thomasmore.webapp.model.Tournament;
import be.thomasmore.webapp.repositories.GameRepository;
import be.thomasmore.webapp.repositories.TournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class TournamentController {
    @Autowired
    private TournamentRepository tournamentRepository;

    @GetMapping("/tournaments")
    public String tournament(Model model) {
        List<Tournament> tournaments = tournamentRepository.findAllBy();
        model.addAttribute("tournaments", tournaments);
        return "tournamentlist";
    }

}
