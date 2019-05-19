package cn.pipipan.eisproject.brokergatewayquery.repository;

import cn.pipipan.eisproject.brokergatewayquery.domain.FutureDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FutureDTORepository extends MongoRepository<FutureDTO, String> {
    public List<FutureDTO> findAll();
    public FutureDTO findFutureDTOById(String id);
}
