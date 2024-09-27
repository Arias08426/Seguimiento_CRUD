
import entidades.Carrera;
import entidades.Facultad;
import jakarta.persistence.EntityManager;
import utilidades.JpaUtil;

import javax.swing.JOptionPane;

public class HibernateCrearCarrera {
    public static void main(String[] args) {
        // Obtenemos el EntityManager de la utilidad JpaUtil
        try (EntityManager em = JpaUtil.getEntityManager()) {

            // Solicitar los datos para crear la nueva carrera
            String nombre = JOptionPane.showInputDialog("Ingrese el nombre de la carrera");
            String tipo = JOptionPane.showInputDialog("Ingrese el tipo de la carrera");
            Long idFacultad = null;

            try {
                idFacultad = Long.valueOf(JOptionPane.showInputDialog("Ingrese el ID de la facultad"));
            } catch (NumberFormatException nfe) {
                System.out.println("ID de facultad inválido.");
                return;
            }

            // Validar las entradas
            if (nombre == null || nombre.trim().isEmpty()) {
                System.out.println("El nombre de la carrera no puede estar vacío.");
                return;
            }

            if (tipo == null || tipo.trim().isEmpty()) {
                System.out.println("El tipo de carrera no puede estar vacío.");
                return;
            }

            // Buscar la facultad correspondiente
            Facultad facultad = em.find(Facultad.class, idFacultad);
            if (facultad == null) {
                System.out.println("Facultad no encontrada.");
                return;
            }

            // Iniciar la transacción para crear la carrera
            try {
                em.getTransaction().begin();
                Carrera carrera = new Carrera();
                carrera.setNombre(nombre);
                carrera.setTipo();
                carrera.setFacultad(facultad);
                em.persist(carrera);
                em.getTransaction().commit();
                System.out.println("Carrera creada con éxito: " + carrera);
            } catch (Exception e) {
                if (em.getTransaction().isActive()) {
                    em.getTransaction().rollback();
                }
                System.out.println("Error al crear la carrera.");
                e.printStackTrace();
            }

        } catch (Exception e) {
            System.out.println("Error al gestionar el EntityManager.");
            e.printStackTrace();
        }
    }
}
