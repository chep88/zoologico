package dependiente;

import java.util.ArrayList;
import colaboradora.Animal;

/**
 *
 *  @author Jean Pierre Perez Varas
 */
public class Cuidador {
    
    private String nombre;
    private String rut;
    private ArrayList<Animal> animales;

    public Cuidador() {
    }

    public Cuidador(String rut,String nombre) {
        this.nombre = nombre;
        this.rut = rut;
        animales = new ArrayList<Animal> ();
    }

    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public ArrayList<Animal> getAnimales() {
        return animales;
    }

    public void setAnimales(ArrayList<Animal> animales) {
        this.animales = animales;
    }
    
    
    
    public int buscarAnimal(String codAnimal){
        for(int i=0; i<animales.size(); i++){
            Animal a = animales.get(i);
            if(a.getCodigo_animal().compareToIgnoreCase(codAnimal)==0){
                return i;
            }
        }
        return -1;
    }
    
    public int cantidadAnimalAcargo(String especie){
        int cantidad=0;
        for(int i=0; i<animales.size(); i++){
            Animal a = animales.get(i);
            if(a.getEspecie().toUpperCase().compareToIgnoreCase(especie)==0){
                cantidad ++;
            }
        }
        return cantidad;
    }
    
    
    public int cantidadAnimalAcargo(){
        
        return animales.size();
    }
    
    
    public boolean agregarAnimal(Animal nuevoAnimal){
        if(buscarAnimal(nuevoAnimal.getCodigo_animal())==-1){
            if (cantidadAnimalAcargo(nuevoAnimal.getEspecie().toUpperCase()) <6){
                animales.add(nuevoAnimal);
            }
            return true;
        }
        return false;
    }
    
    public int cantidadTigresMacho(){
        int cantidad=0;
        for (int i=0; i<animales.size(); i++){
            if(animales.get(i).getEspecie().toUpperCase().compareToIgnoreCase("TIGRE")==0 && animales.get(i).getGenero().compareToIgnoreCase("M")==0){
                cantidad ++;
            }
        }
        
        return cantidad;
    }
    
    
    public String eliminarAnimal(String codAnimal){
        int x = buscarAnimal(codAnimal);
        if(x == - 1)
            return "\nNo existe animal con codigo " + codAnimal;
        else{
            animales.remove(x);
            return "\nAnimal eliminado";
        }
    }
    
}
