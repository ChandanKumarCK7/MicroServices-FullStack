import React from "react";



import 'bootstrap/dist/css/bootstrap.css';
import './StatusStyle.css'
import { useEffect} from 'react';
export default function Status({team, teamName}){
    var value = team.totalWins / team.totalMatches




    // function CircleBar(e) {
    //     (e)
    //       .circleProgress({ fill: { color: "#00EAFF" } })
    //       .on("circle-animation-progress", function(_event, _progress, stepValue) {
    //         (this)
    //           .find("strong")
    //           .text(String(parseInt(100 * stepValue)) + "%");
    //       });
    //   }

    //   useEffect(() => {
    //     CircleBar(".round");
    //   }, []);
    
      
      
    return(
 
           
        <div className="container">
            <div className="row">
                <div className="col-md-6">
                    <div
                    className="round"
                    data-value={value}
                    data-size="160"
                    data-thickness="4">
                    <strong></strong>
                    </div>
                </div>
            </div>
        </div>
    );
}