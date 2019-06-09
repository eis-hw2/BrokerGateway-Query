package cn.pipipan.eisproject.brokergatewayquery.repository;

import cn.pipipan.eisproject.brokergatewayquery.domain.MarketOrder;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MarketOrderRepository extends MongoRepository<MarketOrder, String> {
    @RestResource(path = "traderName", rel = "traderName")
    public List<MarketOrder> findAllByTraderNameLike(String traderName);
    @RestResource(path = "clientId", rel = "clientId")
    public MarketOrder findMarketOrderByClientIdEquals(String clientId);
}
