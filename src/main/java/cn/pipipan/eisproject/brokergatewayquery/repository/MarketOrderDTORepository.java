package cn.pipipan.eisproject.brokergatewayquery.repository;

import cn.pipipan.eisproject.brokergatewayquery.domain.MarketOrderDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarketOrderDTORepository extends MongoRepository<MarketOrderDTO, String> {
    public MarketOrderDTO findMarketOrderDTOById(String id);
}
