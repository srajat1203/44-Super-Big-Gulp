
import javax.persistence.EntityManager;
import customTools.DBUtil;

public class Peoplegrades {
	public static void main(String[] args) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		try {
			model.Grade cust = em.find(model.Grade.class, (long)0);
			System.out.println(cust.getAssignment());
		} catch (Exception e){
			System.out.println(e);
		} finally {
			em.close();
			System.out.println("cerrado!");
		}
	}
}
