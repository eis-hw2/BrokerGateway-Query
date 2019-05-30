package cn.pipipan.eisproject.brokergatewayquery.repository;

import cn.pipipan.eisproject.brokergatewayquery.domain.OrderBlotter;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface OrderBlotterDTORepository extends MongoRepository<OrderBlotter, String> {
    
    public List<OrderBlotter> findByMarketDepthId(String MarketDepthId);

}
