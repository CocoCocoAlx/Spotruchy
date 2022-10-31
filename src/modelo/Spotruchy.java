package modelo;

import java.util.Set;
import javax.persistence.*;
import persistencia.Persistencia;

@Entity
public class Spotruchy {

    @Id
    private long id;

    private String nombre;
    private static Persistencia persistencia;

    @OneToMany(mappedBy = "spotruchy")
    private Set<Artista> artistas;

    @OneToMany(mappedBy = "spotruchy")
    private Set<Album> albumes;

    @ManyToMany(mappedBy = "spotruchy")
    private Set<Discografica> discografica;
    
    static {
        persistencia = new Persistencia();
    }

    public static Persistencia getPersistencia() {
        return persistencia;
    }

    public Spotruchy() {
    }

    public Spotruchy(long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        Spotruchy.persistencia.insertar(this);
    }

    //setters y getters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<Artista> getArtistas() {
        return artistas;
    }

    public void setArtistas(Set<Artista> artistas) {
        this.artistas = artistas;
    }

    public Set<Album> getAlbumes() {
        return albumes;
    }

    public void setAlbumes(Set<Album> albumes) {
        this.albumes = albumes;
    }

    //métodos de la clase
    
    public void crearArtista(String nombre) {
        Artista a = new Artista(nombre, this);
        //se agrega el artista a la lista
        this.artistas.add(a);
        //se inserta el artista a la BD
        Spotruchy.getPersistencia().insertar(a);
    }

    public void modificarArtista(Artista a, String nombre) {
        if (a != null) {
            a.setNombre(nombre);
            Spotruchy.getPersistencia().modificar(a);
        }
    }

    public void eliminarArtista(Artista a) {
        if (a != null) {
            Spotruchy.getPersistencia().eliminar(a);
        }
    }

    public void crearAlbum(String nombre, Artista artista) {
        Album al = new Album(nombre, artista, this);
        //se agrega el álbum a la lista
        this.albumes.add(al);
        //se inserta el álbum la BD
        Spotruchy.getPersistencia().insertar(al);
    }

    public void modificarAlbum(Album al, String nombre, Artista artista) {
        if (al != null) {
            al.setNombre(nombre);
            al.setArtista(artista);
            Spotruchy.getPersistencia().modificar(al);
        }
    }

    public void eliminarAlbum(Album al) {
        if (al != null) {
            Spotruchy.getPersistencia().eliminar(al);
        }
    }
}
