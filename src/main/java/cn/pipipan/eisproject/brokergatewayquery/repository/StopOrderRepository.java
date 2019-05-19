package cn.pipipan.eisproject.brokergatewayquery.repository;

import cn.pipipan.eisproject.brokergatewayquery.domain.StopOrder;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StopOrderRepository extends MongoRepository<StopOrder, String> {
    public StopOrder findStopOrderById(String id);
}
