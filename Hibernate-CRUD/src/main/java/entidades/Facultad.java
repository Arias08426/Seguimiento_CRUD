package entidades;

import jakarta.persistence.*;

@Entity
@Table(name="facultades")
public class Facultad {
    @Column(name = "idfacultad")
    // para definir un campo llave
    @Id
    //para campos autoIncrementables
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String nombre;
    private String abreviatura;

    public Facultad() {
    }

    public Facultad(Long id, String nombre, String abreviatura) {
        this.id = id;
        this.nombre = nombre;
        this.abreviatura = abreviatura;
    }

    //getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    @Override
    public String toString() {
        return "Facultad{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", abreviatura='" + abreviatura ;
    }
}
