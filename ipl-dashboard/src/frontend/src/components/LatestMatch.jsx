import React from "react";




import SmallCard from "./SmallCard";
export default function LatestMatch(props) {
  return (
    <div className="LatestMatch">
        <p> latest match </p>
        <p> Match Details</p>
        {/* <p> small card </p>
        <p> small card </p> */}
        {/* {console.log(props)} */}
        {
            props.matches.map(item => (
                <SmallCard team1 = {item.team1} team2 = {item.team2} />
            ))
        }

    </div>
  );
}