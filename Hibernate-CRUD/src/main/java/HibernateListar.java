import entidades.Facultad;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import utilidades.JpaUtil;

import java.util.List;

public class HibernateListar {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();
        List<Facultad> facultads = em.createQuery("select c from Facultad c", Facultad.class).getResultList();
        facultads.forEach(System.out::println);
    }
}
