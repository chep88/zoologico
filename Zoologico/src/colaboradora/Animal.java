package colaboradora;

/**
 *
 * @author Jean Pierre Perez Varas
 */
public class Animal {

   
    
    private String codigo_animal;
    private String especie;
    private int edad;
    private String genero;
    private int cantidad_crias;
    
    
    public Animal(){}
    
    public Animal(String codigo_animal, String especie, int edad, String genero) {
        this.codigo_animal  = codigo_animal;
        this.especie        = especie;
        this.edad           = edad;
        this.genero         = genero;
        
        if (this.genero.toUpperCase().equals("HEMBRA") || this.genero.toUpperCase().equals("H")){
            this.cantidad_crias = 2;
        }else if (this.genero.toUpperCase().equals("MACHO") || this.genero.toUpperCase().equals("M")){
            this.cantidad_crias = 0;
        }else {
            System.out.println("Genero del animal no corresponde, solo debe ser Macho(M) o Hembra ");
        }
        
    }
     
     
    public String getCodigo_animal() {
        return codigo_animal;
    }

    public void setCodigo_animal(String codigo_animal) {
        this.codigo_animal = codigo_animal;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getCantidad_crias() {
        return cantidad_crias;
    }

    public void setCantidad_crias(int cantidad_crias) {
        this.cantidad_crias = cantidad_crias;
    }
    

    
    public boolean serMama(){
        boolean respuesta = false;
        if (genero.toUpperCase().compareToIgnoreCase("H") ==0 && cantidad_crias<3 &&  edad>4){
            respuesta =true;
        }
        
        return respuesta;
        
    }
    
}
