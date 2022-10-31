package modelo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Discografica {

    @Id
    @SequenceGenerator(name = "sec_discografica,initialvalue=1,allocationSize=1")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    private long id;

    private String nombre;

    @ManyToMany(cascade = CascadeType.REFRESH)
    private Album album;

    @ManyToOne(cascade = CascadeType.REFRESH)
    private Spotruchy spotruchy;

    //constructores
    public Discografica() {
    }

    public Discografica(String nombre, Album album, Spotruchy spotruchy) {
        this.nombre = nombre;
        this.album = album;
        this.spotruchy = spotruchy;
    }

    //getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    //métodos
    @Override
    public String toString() {
        return this.nombre;
    }
}
