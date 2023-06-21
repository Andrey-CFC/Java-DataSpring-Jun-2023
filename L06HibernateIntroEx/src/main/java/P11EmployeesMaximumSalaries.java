import javax.persistence.EntityManager;
import java.util.List;

public class P11EmployeesMaximumSalaries {
    public static void main(String[] args) {
        EntityManager em = Utils.createEntityManager();
        em.getTransaction().begin();
        List<Object[]> resultList = em.createQuery("SELECT e.department.name, MAX (e.salary)  FROM Employee e GROUP BY e.department.name HAVING MAX (e.salary)  NOT BETWEEN 30000 AND 70000", Object[].class).getResultList();
        resultList.forEach(r -> System.out.println(r[0]+" "+r[1]));
        em.getTransaction().commit();
        em.close();
    }
}
