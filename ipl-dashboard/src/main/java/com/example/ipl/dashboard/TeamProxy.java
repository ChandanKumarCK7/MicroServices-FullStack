package com.example.ipl.dashboard;




import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.ipl.dashboard.model.Team;

//@FeignClient(name="currency-exchange", url="localhost:8000")
@FeignClient(name="Team-Microservice")
@RibbonClient(name="Team-Microservice")
public interface TeamProxy {

//    @GetMapping("/currency-exchange/from/{from}/to/{to}")
//    public CurrencyConversion retrieveExchangeValue(
//            @PathVariable String from,
//            @PathVariable String to);

    @GetMapping("/Team-Microservice/getTeam/{teamName}")
    public Team getTeam(@PathVariable("teamName") String teamName);

}
