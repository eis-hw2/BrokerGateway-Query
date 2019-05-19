package cn.pipipan.eisproject.brokergatewayquery.repository;

import cn.pipipan.eisproject.brokergatewayquery.domain.CancelOrder;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CancelOrderRepository extends MongoRepository<CancelOrder, String> {
    public CancelOrder findCancelOrderById(String id);
}
