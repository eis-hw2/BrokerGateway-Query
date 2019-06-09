package cn.pipipan.eisproject.brokergatewayquery.repository;

import cn.pipipan.eisproject.brokergatewayquery.domain.StopOrder;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StopOrderRepository extends MongoRepository<StopOrder, String> {
    @RestResource(path = "traderName", rel = "traderName")
    public List<StopOrder> findAllByTraderNameLike(@Param("traderName") String traderName);
    @RestResource(path = "clientId", rel = "clientId")
    public StopOrder findStopOrderByClientIdEquals(String clientId);
}
