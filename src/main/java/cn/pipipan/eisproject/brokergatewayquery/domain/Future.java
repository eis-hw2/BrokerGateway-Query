package cn.pipipan.eisproject.brokergatewayquery.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "futureDTO")
public class Future {
    @Id
    String id;
    String description;

    public String getMarketDepthId() {
        return MarketDepthId;
    }

    public void setMarketDepthId(String marketDepthId) {
        MarketDepthId = marketDepthId;
    }

    String MarketDepthId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
