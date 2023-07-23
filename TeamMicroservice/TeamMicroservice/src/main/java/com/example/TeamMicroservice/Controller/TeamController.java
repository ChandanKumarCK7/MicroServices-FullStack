package com.example.TeamMicroservice.Controller;





import com.example.TeamMicroservice.Service.MyService;
import com.example.TeamMicroservice.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.TeamMicroservice.model.Match;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class TeamController {

    @Autowired
    private MyService myService;


    @GetMapping("/Team-Microservice/getTeam/{teamName}")
    public Team getTeam(@PathVariable("teamName") String teamName){
        System.out.println("Team-Microservice has been called");
        Team team =  myService.getTeam(teamName);
        System.out.println(team.toString());
        return team;
    }




}
