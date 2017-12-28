package de.rieckpil.controllers;

import de.rieckpil.domain.Team;
import de.rieckpil.repositories.TeamRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

//@RestController
public class TeamController {

    private TeamRepository teamRepository;

    public TeamController(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @GetMapping("/teams")
    public Iterable<Team> getTeams() {

        return teamRepository.findAll();
    }

    @GetMapping("/teams/{id}")
    public Team getTeamById(@PathVariable String id) {
        return teamRepository.findOne(Long.valueOf(id));
    }
}
