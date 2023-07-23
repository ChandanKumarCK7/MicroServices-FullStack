package com.example.ipl.dashboard.data;





import com.example.ipl.dashboard.data.MatchInput;
import com.example.ipl.dashboard.model.Match;

import org.springframework.batch.item.ItemProcessor;

import java.time.LocalDate;

public class MatchDataProcessor implements ItemProcessor<MatchInput, Match> {



//    private static final Logger log = LoggerFactory.getLogger(PersonItemProcessor.class);


    public MatchDataProcessor() {
        System.out.println("processorrrrrrr");
    }

    @Override
    public Match process(final MatchInput matchInput) throws Exception {
        System.out.println("process called");

        Match match = new Match();

        match.setId(Long.parseLong(matchInput.getId()));
        match.setCity(matchInput.getCity());

        match.setDate(LocalDate.parse(matchInput.getDate()));

        match.setPlayerOfMatch(matchInput.getPlayer_of_match());
//        match.setVenue(matchInput.getVenue());
//
//        // Set Team 1 and Team 2 depending on the innings order
//        String firstInningsTeam, secondInningsTeam;
//
//        if ("bat".equals(matchInput.getToss_decision())) {
//            firstInningsTeam = matchInput.getToss_winner();
//            secondInningsTeam = matchInput.getToss_winner().equals(matchInput.getTeam1())
//                    ? matchInput.getTeam2() : matchInput.getTeam1();
//
//        } else {
//            secondInningsTeam = matchInput.getToss_winner();
//            firstInningsTeam = matchInput.getToss_winner().equals(matchInput.getTeam1())
//                    ? matchInput.getTeam2() : matchInput.getTeam1();
//        }
//        match.setTeam1(firstInningsTeam);
//        match.setTeam2(secondInningsTeam);
//
//        match.setTossWinner(matchInput.getToss_winner());
//        match.setTossDecision(matchInput.getToss_decision());
//        match.setMatchWinner(matchInput.getWinner());
//        match.setResult(matchInput.getResult());
//        match.setResultMargin(matchInput.getResult_margin());
//        match.setUmpire1(matchInput.getUmpire1());
//        match.setUmpire2(matchInput.getUmpire2());
        System.out.println("match recor" +match);
        return match;
    }

}