package com.example.ipl.dashboard.Repository;






import com.example.ipl.dashboard.model.Match;
import com.example.ipl.dashboard.model.Team;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;


import java.util.List;






public interface UserRepository extends MongoRepository<Match, String> {
    List<Match> findAll();


    @Aggregation(pipeline = {
            "{$group: {_id: '$team1', totalMatches: {$sum: 1}, totalWins: {$sum: {$cond: [{$eq: ['$matchWinner', '$team1']}, 1, 0]}}}}",
            "{$project: {teamName: '$_id', totalMatches: 1, totalWins: 1, _id: 0}}"
    })
    List<Team> getMatchStatsForTeam1();


    @Aggregation(pipeline = {
            "{$group: {_id: '$team2', totalMatches: {$sum: 1}, totalWins: {$sum: {$cond: [{$eq: ['$matchWinner', '$team2']}, 1, 0]}}}}",
            "{$project: {teamName: '$_id', totalMatches: 1, totalWins: 1, _id: 0}}"
    })
    List<Team> getMatchStatsForTeam2();


    @Aggregation(pipeline = {
            "{$match: {$or: [{ 'team1': ?0 }, { 'team2': ?0 }]}}",
            "{$sort: { 'date': -1 }}",
            "{$limit: ?1}"
    })
    List<Match> getLatestMatchesPlayedByTeam(String teamName, int count);


}




