package cn.pipipan.eisproject.brokergatewayquery.repository;

import cn.pipipan.eisproject.brokergatewayquery.domain.MarketDepthDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarketDepthDTORepository extends MongoRepository<MarketDepthDTO, String> {

}
