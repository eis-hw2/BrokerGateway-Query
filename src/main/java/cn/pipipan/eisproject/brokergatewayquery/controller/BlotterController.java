package cn.pipipan.eisproject.brokergatewayquery.controller;

import cn.pipipan.eisproject.brokergatewayquery.domain.OrderBlotter;
import cn.pipipan.eisproject.brokergatewayquery.domain.Response;
import cn.pipipan.eisproject.brokergatewayquery.repository.OrderBlotterDTORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class BlotterController {

    @Autowired 
    OrderBlotterDTORepository orderBlotterDTORepository;

    @GetMapping("/orderBlotters")
    public Response<List<OrderBlotter>> processLimitOrder(@RequestParam("marketDepthId")String marketDepthId,
                                                          @RequestParam("startTime")String startTime,
                                                          @RequestParam("endTime")String endTime){
        List<OrderBlotter> originOrderBlotters = orderBlotterDTORepository.findByMarketDepthId(marketDepthId);
        List<OrderBlotter> resultOrderBlotters = originOrderBlotters.stream().filter(orderBlotter ->
                orderBlotter.isCreationTimeBetween(startTime, endTime)).collect(Collectors.toList());
        return new Response<>(resultOrderBlotters, 200, "OK");
    }

}