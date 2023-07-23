package com.example.ipl.dashboard.controller;


import com.example.ipl.dashboard.Service.MyService;
import com.example.ipl.dashboard.model.Match;
import com.example.ipl.dashboard.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import java.util.HashMap;
import com.example.ipl.dashboard.TeamProxy;

@Configuration(proxyBeanMethods = false)
class RestTemplateConfiguration {

    @Bean
    RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }
}

@RestController
@CrossOrigin
public class TeamController {





    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private MyService myService;

    @Autowired
    private TeamProxy teamProxy;

    @GetMapping("/documents")
    public List<Match> getAllDocuments() {
        List<Match> documents = myService.getAllDocuments();
        return documents;
    }

    @GetMapping("/stats")
    public List<Team> getMatchStats() {
        return myService.getMatchStats();
    }

    @GetMapping("/team/{teamName}")
    public Team getTeam(@PathVariable("teamName") String teamName){
//        Team team =  myService.getTeam(teamName);      // convert this to a microservice


        HashMap<String, String> uriVariables = new HashMap<>();
        uriVariables.put("teamName",teamName);

        ResponseEntity<Team> responseEntity = restTemplate.getForEntity
                ("http://localhost:8081/Team-Microservice/getTeam/{teamName}",
                        Team.class, uriVariables);
        Team team = responseEntity.getBody();
        System.out.println(team);
        team.setMatches(myService.getLatestMatchesPlayedByTeam(team.getTeamName(), 4));
        return team;
    }

    @GetMapping("/team-feign/{teamName}")
    public Team getTeamFeignClient(@PathVariable("teamName") String teamName){
//        Team team =  myService.getTeam(teamName);      // convert this to a microservice



        Team team = teamProxy.getTeam(teamName);
        System.out.println(team);
        System.out.println(team.toString());
        team.setMatches(myService.getLatestMatchesPlayedByTeam(team.getTeamName(), 4));
        return team;
    }

    @GetMapping("/teams/{teamName}/matches")
    public List<Match> getMatchesForTeamsAndYear(@PathVariable("teamName") String teamName, @RequestParam("year") int year){
        return myService.getMatchesForTeamsAndYear(teamName, year);
    }
//
//    @GetMapping("/team")
//    public Iterable<Team> getAllTeam() {
//        return this.teamRepository.findAll();
//    }
//
//    @GetMapping("/team/{teamName}")
//    public Team getTeam(@PathVariable String teamName) {
//        Team team = this.teamRepository.findByTeamName(teamName);
//        team.setMatches(matchRepository.findLatestMatchesbyTeam(teamName,4));
//
//        return team;
//    }
//
//    @GetMapping("/team/{teamName}/matches")
//    public List<Match> getMatchesForTeam(@PathVariable String teamName, @RequestParam int year) {
//        LocalDate startDate = LocalDate.of(year, 1, 1);
//        LocalDate endDate = LocalDate.of(year + 1, 1, 1);
//        return this.matchRepository.getMatchesByTeamBetweenDates(
//                teamName,
//                startDate,
//                endDate
//        );
//    }


}
