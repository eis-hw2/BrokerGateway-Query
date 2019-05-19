package cn.pipipan.eisproject.brokergatewayquery.repository;

import cn.pipipan.eisproject.brokergatewayquery.domain.FutureDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FutureDTORepository extends MongoRepository<FutureDTO, String> {

}
