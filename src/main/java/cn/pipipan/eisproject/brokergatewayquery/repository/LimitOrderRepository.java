package cn.pipipan.eisproject.brokergatewayquery.repository;

import cn.pipipan.eisproject.brokergatewayquery.domain.LimitOrder;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LimitOrderRepository extends MongoRepository<LimitOrder, String> {
    @RestResource(path = "traderName", rel = "traderName")
    public List<LimitOrder> findAllByTraderNameLike(String traderName);
}
