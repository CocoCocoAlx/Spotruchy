package modelo;

import javax.persistence.*;

@Entity
public class Album {
    
    @Id
    @SequenceGenerator(name="sec_album",initialValue=1,allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sec_album")
    
    private Long id;
    
    private String nombre;
    
    //acá se indica que varios objetos de esta clase están vinculados con la clase artista o con la clase principal (spotruchy)
    @ManyToOne(cascade=CascadeType.REFRESH)
    private Artista artista;

    @ManyToOne(cascade=CascadeType.REFRESH)
    private Spotruchy spotruchy;

    public Album() {
    }

    public Album(String nombre, Artista artista, Spotruchy spotruchy) {
        this.nombre = nombre;
        this.artista = artista;
        this.spotruchy = spotruchy;
    }

    //getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    //métodos
    @Override
    public String toString(){
        return this.nombre;
    }
    
}
