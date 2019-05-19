package cn.pipipan.eisproject.brokergatewayquery.controller;

import cn.pipipan.eisproject.brokergatewayquery.domain.LimitOrderDTO;
import cn.pipipan.eisproject.brokergatewayquery.repository.CancelOrderRepository;
import cn.pipipan.eisproject.brokergatewayquery.repository.LimitOrderDTORepository;
import cn.pipipan.eisproject.brokergatewayquery.repository.MarketOrderDTORepository;
import cn.pipipan.eisproject.brokergatewayquery.repository.StopOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    CancelOrderRepository cancelOrderRepository;
    @Autowired
    LimitOrderDTORepository limitOrderDTORepository;
    @Autowired
    MarketOrderDTORepository marketOrderDTORepository;
    @Autowired
    StopOrderRepository stopOrderRepository;

    @GetMapping("/LimitOrder")
    public List<LimitOrderDTO> findLimitOrders(){
        return limitOrderDTORepository.findAll();
    }

}
