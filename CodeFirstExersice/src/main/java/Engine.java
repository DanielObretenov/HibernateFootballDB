//import sales.Customer;
//import sales.Product;
//import sales.Sale;
//import sales.StoreLocation;
//import university.Course;
//import university.Student;
//import university.Teacher;

import FootballBetting.gameAssets.Game;
import FootballBetting.gameAssets.GamePlayerId;
import FootballBetting.gameAssets.GamePlayerStatistics;
import FootballBetting.teamAssets.Player;

import javax.persistence.EntityManager;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Engine implements Runnable {
    private EntityManager entityManager;
    private BufferedReader bf;
    public Engine(EntityManager em) {
        this.entityManager = em;
        this.bf = new BufferedReader(new InputStreamReader(System.in));

    }


    @Override
    public void run() {
        //example
        Player player = new Player("danielObr");
        Game game =new Game();
        entityManager.getTransaction().begin();
        entityManager.persist(player);
        entityManager.persist(game);
        entityManager.flush();
        HashSet<GamePlayerStatistics> gamePlayerStatisticsHashSet = new HashSet<>();
        GamePlayerStatistics gamePlayerStatistics = new GamePlayerStatistics();
        gamePlayerStatistics.setGamePlayerId(new GamePlayerId(game.getId(),player.getId()));
        gamePlayerStatistics.setGame(game);
        gamePlayerStatistics.setPlayer(player);
        gamePlayerStatisticsHashSet.add(gamePlayerStatistics);
        game.setGamePlayerStatistics(gamePlayerStatisticsHashSet);
        player.setGamePlayerStatistics(gamePlayerStatisticsHashSet);
        entityManager.persist(gamePlayerStatistics);

        entityManager.getTransaction().commit();
    }
}
