import React, { useState, useEffect } from "react";
import axios from "axios";

import LatestMatch from "./LatestMatch";
import More from "./More";
import WinRate from "./WinRate";
import { useParams, Link } from 'react-router-dom';
import MatchDetailCard from "./MatchDetailCard";
import MatchSmallCard from "./SmallCard";
import Status from "./Status";

export default function TeamPage() {
  const [team, setTeam] = useState({
    team: []
  });

  const { teamName } = useParams()
  // var teamName = {this.props.match.params.teamName};

  console.log(`${teamName}`);
  useEffect(() => {
    console.log(`${teamName}`);
    const fetchMatches = async () => {
      var r = await axios.get(`http://localhost:8080/team/${teamName}`);
      var data = r.data;
      // console.log("data returned from team API "+JSON.stringify(data));
      try {
        setTeam(r.data);
      } catch (error) {
        console.log("error " + error);
      }

    }
    fetchMatches();
  },
    [teamName]);

  if (!team || !team.teamName) {
    return (
      <div>
        <p>team is not present</p>
      </div>
    )
  }



  return (

    <div className="card mb-4 rounded-3 shadow-sm">
      {team && (

        <div>
          <h2>{team.teamName}</h2>
          {/* <LatestMatch team={team} /> */}
          <MatchDetailCard match={team.matches[0]} teamName={team.teamName} />
          {team.matches && team.matches.slice(1).map(match => <MatchSmallCard match={match} teamName={team.teamName} />)}
          {/* {console.log("team "+JSON.stringify(team))} */}
          {/* {   <Status team={team} teamName = {team.teamName}/> }     */}

          <div>
            <WinRate />
            <More />
          </div>
        </div>
      )}
    </div>
  );
}
