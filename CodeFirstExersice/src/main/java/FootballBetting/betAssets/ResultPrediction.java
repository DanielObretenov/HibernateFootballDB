package FootballBetting.betAssets;

import entities.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "result_prediction")
public class ResultPrediction extends BaseEntity {
    private String prediction;
    private Set<BetGame> betGamePredictions;

    public ResultPrediction(String prediction) {
        this.prediction = prediction;
    }

    @Column
    public String getPrediction() {
        return prediction;
    }

    public void setPrediction(String prediction) {
        this.prediction = prediction;
    }

    @OneToMany(mappedBy = "resultPrediction")
    public Set<BetGame> getBetGamePredictions() {
        return betGamePredictions;
    }

    public void setBetGamePredictions(Set<BetGame> betGamePredictions) {
        this.betGamePredictions = betGamePredictions;
    }
}
