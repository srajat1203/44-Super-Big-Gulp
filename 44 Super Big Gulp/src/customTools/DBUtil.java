package customTools;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DBUtil {
private static final EntityManagerFactory emf = 
Persistence.createEntityManagerFactory("44 Super Big Gulp");
	public static EntityManagerFactory getEmFactory() {
		return emf;
	}
}


