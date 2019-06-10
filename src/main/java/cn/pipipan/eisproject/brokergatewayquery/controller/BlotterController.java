package cn.pipipan.eisproject.brokergatewayquery.controller;

import cn.pipipan.eisproject.brokergatewayquery.domain.OrderBlotter;
import cn.pipipan.eisproject.brokergatewayquery.domain.Response;
import cn.pipipan.eisproject.brokergatewayquery.repository.OrderBlotterDTORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class BlotterController {

    @Autowired 
    OrderBlotterDTORepository orderBlotterDTORepository;

    @GetMapping("/orderBlotters/query")
    public Response<List<OrderBlotter>> findByQuery(@RequestParam("marketDepthId")String marketDepthId,
                                                          @RequestParam("startTime")String startTime,
                                                          @RequestParam("endTime")String endTime){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String traderName = authentication.getName();
        List<OrderBlotter> originOrderBlotters = orderBlotterDTORepository.findByMarketDepthId(marketDepthId);
        List<OrderBlotter> resultOrderBlotters = originOrderBlotters.stream().filter(orderBlotter ->
                orderBlotter.isCreationTimeBetween(startTime, endTime)).peek(orderBlotter -> {
                    if (!(orderBlotter.getBuyerTraderName().equals(traderName) || orderBlotter.getSellerTraderName().equals(traderName))) {
                        orderBlotter.setBuyerTraderName("");
                        orderBlotter.setSellerTraderName("");
                    }
        }).collect(Collectors.toList());
        return new Response<>(resultOrderBlotters, 200, "OK");
    }

    @GetMapping("/orderBlotters")
    public Response<List<OrderBlotter>> findAll(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String traderName = authentication.getName();
        List<OrderBlotter> originOrderBlotters = orderBlotterDTORepository.findAll();
        List<OrderBlotter> resultOrderBlotters = originOrderBlotters.stream().peek(orderBlotter -> {
            if (!(orderBlotter.getBuyerTraderName().equals(traderName) || orderBlotter.getSellerTraderName().equals(traderName))) {
                orderBlotter.setBuyerTraderName("");
                orderBlotter.setSellerTraderName("");
            }
        }).collect(Collectors.toList());
        return new Response<>(resultOrderBlotters, 200, "OK");
    }
}