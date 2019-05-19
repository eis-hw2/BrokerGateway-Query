package cn.pipipan.eisproject.brokergatewayquery.repository;

import cn.pipipan.eisproject.brokergatewayquery.domain.LimitOrderDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LimitOrderDTORepository extends MongoRepository<LimitOrderDTO, String> {
    public LimitOrderDTO findLimitOrderDTOById(String id);
}
