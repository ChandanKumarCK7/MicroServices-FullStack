package com.example.ipl.dashboard.Service;





import com.example.ipl.dashboard.Repository.UserRepository;
import com.example.ipl.dashboard.model.Match;
import com.example.ipl.dashboard.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.query.Collation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MyService {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private UserRepository userRepository;

    public List<Match> getAllDocuments() {
        List<Match> documents = userRepository.findAll();
        System.out.println(documents.size());
        return documents;
    }


    public List<Team> getMatchStats() {
        List<Team> team1 =  userRepository.getMatchStatsForTeam1();
        List<Team> team2 =  userRepository.getMatchStatsForTeam2();

        List<Team> teamN = new ArrayList<>();
//        team1.stream().forEach(team -> {
//            System.out.println("Team Name: " + team.getTeamName());
//            System.out.println("Total Matches: " + team.getTotalMatches());
//            System.out.println("Total Wins: " + team.getTotalWins());
//            System.out.println("------------------------");
//        });
//
//        team2.stream().forEach(team -> {
//            System.out.println("Team Name: " + team.getTeamName());
//            System.out.println("Total Matches: " + team.getTotalMatches());
//            System.out.println("Total Wins: " + team.getTotalWins());
//            System.out.println("------------------------");
//        });

        for(int i = 0; i< team1.size(); i++){
            for(int j = 0; j< team2.size(); j++) {
                if (team1.get(i).getTeamName().equalsIgnoreCase(team2.get(j).getTeamName())) {
                    Team team = new Team();
                    team.setId(team2.get(j).getId());
                    team.setTeamName(team2.get(j).getTeamName());
                    team.setTotalWins(team1.get(i).getTotalWins()+team2.get(j).getTotalWins());
                    team.setTotalMatches(team1.get(i).getTotalMatches()+team2.get(j).getTotalMatches());
                    teamN.add(team);
                    break;
                }
            }
        }


        return teamN;
    }

    public Team getTeam(String teamName){
        List<Team> teams = getMatchStats();
        for (Team team : teams) {
            if (team.getTeamName().equalsIgnoreCase(teamName)) {
                return team;
            }
        }
        return null;
    }

    public List<Match> getMatchesForTeamsAndYear(String teamName, int year){
        List<Match> documents = userRepository.findAll();

        return documents.stream().filter(e -> (e.getTeam1().equalsIgnoreCase(teamName) || e.getTeam2().equalsIgnoreCase(teamName))).filter(e -> e.getDate().getYear() == year).collect(Collectors.toList());

    }

    public List<Match> getLatestMatchesPlayedByTeam(String teamName, int count){
        System.out.println(userRepository.getLatestMatchesPlayedByTeam(teamName, count));
        return userRepository.getLatestMatchesPlayedByTeam(teamName, count);

    }
}

