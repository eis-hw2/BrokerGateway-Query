package cn.pipipan.eisproject.brokergatewayquery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import cn.pipipan.eisproject.brokergatewayquery.repository.OrderBlotterDTORepository;
import cn.pipipan.eisproject.brokergatewayquery.domain.OrderBlotter;
import java.text.SimpleDateFormat;
import java.util.*;
import java.text.ParseException;

@RestController
public class BlotterController {

    @Autowired 
    OrderBlotterDTORepository orderBlotterDTORepository;

    @PostMapping("/orderBlotter")
    public Response<String> processLimitOrder(@RequestParam("MarketDepthId")String MarketDepthId, @RequestParam("StartTime")String StartTime, @RequestParam("EndTime")String EndTime){
        List<OrderBlotter> originOrderBlotters = orderBlotterDTORepository.findByMarketDepthId(MarketDepthId);
        List<OrderBlotter> resultOrderBlotters;
        for(OrderBlotter ob : originOrderBlotters){
            String cTime = ob.getCreationTime();
            if(checkTime(StartTime, cTime, EndTime)){
                resultOrderBlotters.add(ob);
            }
        }
        return new Response<>(resultOrderBlotters, 200, "OK");
    }

    public boolean checkTime(String time1, String time2, String time3) throws ParseException
	{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date a=sdf.parse(time1);
		Date b=sdf.parse(time2);
		Date c=sdf.parse(time3);
		if(a.before(b) && b.before(c)){
            return true;
        }
		else{
            return false;
        }
    }

}