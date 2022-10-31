package modelo;

import java.util.Set;
import javax.persistence.*;

@Entity
public class Artista {

    @Id
    @SequenceGenerator(name = "sec_artista", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sec_artista")

    private Long id;

    private String nombre;

    //acá se indica que varios objetos de esta clase están vinculados con la clase artista o con la clase principal (spotruchy)
    @ManyToOne(cascade = CascadeType.REFRESH)
    private Spotruchy spotruchy;

    @OneToMany(mappedBy = "artista")
    private Set<Album> albumes;

    public Artista() {
    }

    public Artista(String nombre, Spotruchy spotruchy) {
        this.nombre = nombre;
        this.spotruchy = spotruchy;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return this.nombre;
    }

    public Set<Album> getAlbumes() {
        return albumes;
    }

    public void setAlbumes(Set<Album> albumes) {
        this.albumes = albumes;
    }

}
