import React, { useEffect, useState } from "react";
import {Link, useParams} from "react-router-dom";

import MatchSmallCard from "./SmallCard";
import axios from "axios";
import 'bootstrap/dist/css/bootstrap.css';
export default function MatchPage() {



    const [matches, setMatches] = useState([]);
    const {teamName, year} = useParams();

    console.log("MatchPage "+`${teamName}` +" "+`${year}`);

    useEffect( () => {
        const fetchData = async () => {
            try{
                console.log("call made");
                const matche= await axios.get(`http://localhost:8080/teams/${teamName}/matches?year=${year}`);
                console.log("matche "+JSON.stringify(matche.data));
                setMatches(matche.data);
            }
            catch(error){

            }
        };
        fetchData();
    }, [teamName, year]);
    return (
        <div className="card mb-4 rounded-3 shadow-sm">
            Match Page
            <h2>{teamName}</h2>
            <div className = "card-title pricing-card-title">
            {matches.map(match => (<MatchSmallCard  match={match} teamName={teamName} />))}
            <MatchSmallCard match={matches[0]} teamName = {teamName}/>
            </div>
        </div>
    )
}