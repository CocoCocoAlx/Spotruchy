package persistencia;

import javax.persistence.*;

public class Persistencia {
    
    private final EntityManagerFactory emf;
    private final EntityManager em;
    
    //métodos para manipular objetos
    public Persistencia(){
        this.emf=Persistence.createEntityManagerFactory("SpotruchyPU");
        this.em=emf.createEntityManager();
    }
    
    //método para insertar objetos en la BD
    public void insertar(Object o){
        this.em.getTransaction().begin();
        this.em.persist(o);
        this.em.getTransaction().commit();
    }

    //método para modificar objetos en la BD
    public void modificar(Object o){
        this.em.getTransaction().begin();
        this.em.merge(o);
        this.em.getTransaction().commit();
    }

    //método para eliminar objetos en la BD
    public void eliminar(Object o){
        this.em.getTransaction().begin();
        this.em.remove(o);
        this.em.getTransaction().commit();
    }
    
    //buscar un objeto en la BD
    public Object buscar(Class clase, Object id){
        Object o = em.find(clase, id);
        return o;
    }

    //refrescar la BD
    public void refrescar(Object o){
        this.em.refresh(o);
    }
}
