import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static final String football_PU =  "footballBet";

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(football_PU);
        EntityManager em = emf.createEntityManager();
        Engine engine = new Engine(em);
        engine.run();

    }
}
