import entidades.Carrera;
import jakarta.persistence.EntityManager;
import utilidades.JpaUtil;

import java.util.Scanner;

public class HibernateEliminarCarrera {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        System.out.printf("Digite el código de la carrera a eliminar: ");
        Long id = s.nextLong();
        EntityManager em = JpaUtil.getEntityManager();

        try {
            // Buscar la carrera por el ID
            Carrera carrera = em.find(Carrera.class, id);

            if (carrera != null) {
                // Mostrar detalles de la carrera y pedir confirmación
                System.out.println("Carrera encontrada: " + carrera.getNombre());
                System.out.print("¿Está seguro que desea eliminar esta carrera? (si/no): ");
                String confirmacion = s.next();

                if (confirmacion.equalsIgnoreCase("si")) {
                    // Iniciar la transacción
                    em.getTransaction().begin();

                    // Eliminar la carrera
                    em.remove(carrera);

                    // Confirmar la transacción
                    em.getTransaction().commit();
                    System.out.println("Carrera eliminada exitosamente.");
                } else {
                    System.out.println("Operación cancelada.");
                }

            } else {
                System.out.println("No se encontró una carrera con el ID especificado.");
            }

        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}

