package cn.pipipan.eisproject.brokergatewayquery.controller;

import cn.pipipan.eisproject.brokergatewayquery.domain.OrderBlotterDTO;
import cn.pipipan.eisproject.brokergatewayquery.repository.OrderBlottleDTORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/OrderBlotter")
public class OrderBlotterController {
    @Autowired
    OrderBlottleDTORepository orderBlottleDTORepository;

    public List<OrderBlotterDTO> getOrderBlotters(){
        return orderBlottleDTORepository.findAll();
    }
}
