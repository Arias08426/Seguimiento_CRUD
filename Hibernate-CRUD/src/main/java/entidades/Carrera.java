package entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "Carreras")
public class Carrera {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcarrera")
    private int id;

    @Column(name = "nombre", nullable = false, length = 150)
    private String nombre;

    @Column(name = "tipo", nullable = false)
    private int tipo;

    @ManyToOne
    @JoinColumn(name = "idfacultad", nullable = false)
    private Facultad facultad;

    public Carrera(int id, String nombre, int tipo, Facultad facultad) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.facultad = facultad;
    }

    public Carrera() {

    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo() {
        this.tipo = tipo;
    }

    public Facultad getFacultad() {
        return facultad;
    }

    public void setFacultad(Facultad facultad) {
        this.facultad = facultad;
    }
}
