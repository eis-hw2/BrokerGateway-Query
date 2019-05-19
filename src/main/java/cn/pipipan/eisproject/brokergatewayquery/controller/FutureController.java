package cn.pipipan.eisproject.brokergatewayquery.controller;

import cn.pipipan.eisproject.brokergatewayquery.domain.FutureDTO;
import cn.pipipan.eisproject.brokergatewayquery.repository.FutureDTORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Future")
public class FutureController {
    @Autowired
    FutureDTORepository futureDTORepository;
    @GetMapping("")
    public List<FutureDTO> getAllFutureDTO(){
        return futureDTORepository.findAll();
    }

    @GetMapping("/{id}")
    public FutureDTO getFutureDTO(@PathVariable(name = "id") String id){
        return futureDTORepository.findFutureDTOById(id);
    }
}
