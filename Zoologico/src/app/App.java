package app;

import java.util.*;
import colaboradora.Animal;
import dependiente.Cuidador;


public class App {
    public static int menu(){
        System.out.println("\n\n1. Crear Cuidador");
        System.out.println("2. Mostrar Cuidador");
        System.out.println("3. Cantidad Tigres Macho");
        System.out.println("4. Agregar Animal");
        System.out.println("5. Madres");
        System.out.println("6. Eliminar");
        System.out.println("7. Salir");
        System.out.print("Ingrese una opcion ");
        return Leer.datoInt();
    }
    
    public static Cuidador crearCuidador(String runCuidador){
        System.out.print("Nombre del Cuidador? ");
        String nombre = Leer.dato();
        return new Cuidador(runCuidador, nombre);
    }
    
    
    public static Animal crearAnimal(){
        System.out.print("\nCodigo del Animal ");
        String codAnimal = Leer.dato();
        System.out.print("Especie? ");
        String especie = Leer.dato();
        System.out.print("Edad?");
        int edad = Leer.datoInt();
        System.out.print("Genero?");
        String genero = Leer.dato();
        return new Animal(codAnimal, especie, edad, genero);
    }
        
        
    public static int buscar(String runBuscado, ArrayList<Cuidador> d){
        
        for(int i=0; i<d.size(); i++){
            if(d.get(i).getRut().equals(runBuscado)){
                
                return i;
            }
        }
        return -1;
    }
    
    
    
    public static int buscaTigres(ArrayList<Cuidador> cuidadores){
        int contador =0;
        for (int i =0; i<cuidadores.size(); i++){
            contador += cuidadores.get(i).cantidadTigresMacho();
        }
        
        return contador;
    } 
       
    public static int cantidadMamas(ArrayList<Cuidador> cuidadores){
        int contador =0;
        for (int i =0; i<cuidadores.size(); i++){
            for(int x=0; x<cuidadores.get(i).getAnimales().size(); x++){
                if (cuidadores.get(i).getAnimales().get(x).serMama()){
                    contador ++;
                }
            }
        }
        
        return contador;
    }
    
    public static void main(String[] args) {
        
        int opMenu, posicion;
        ArrayList<Cuidador> cuidadores = new ArrayList<Cuidador> ();
        String runCuidador ="";
        
        do{
            opMenu = menu();
            switch(opMenu){
                case 1:
                    cls();
                    System.out.print("\nRun del Cuidador? ");
                    runCuidador = Leer.dato();
                    if(buscar(runCuidador, cuidadores)==-1){
                        Cuidador nuevoCuidador = crearCuidador(runCuidador);
                        cuidadores.add(nuevoCuidador);
                    }
                     else
                        System.out.println("\nYa existe Cuidador run " + runCuidador);
                    pausa();
                    break;
                case 2:
                    cls();
                     if(cuidadores.isEmpty())
                        System.out.println("\nNo hay Cuidadores");
                    else{
                        for(int i=0; i<cuidadores.size(); i++){
                            System.out.println("* )  " + cuidadores.get(i).getNombre()+ "- Cantidad de animales a cargo "+ cuidadores.get(i).cantidadAnimalAcargo());
                        }
                    }
                    pausa();
                    break;
                case 3:
                    cls();
                    System.out.println("\nEl zoologico Alimalitos Unidos S.A. tiene "+ buscaTigres(cuidadores) + " Tigres Macho");
                    pausa();
                    break;
                case 4:
                    cls();
                    if(cuidadores.isEmpty())
                        System.out.println("\nNo hay Cuidadores");
                    else{
                        System.out.print("\nRun del Cuidador a quien se agrega el Animal? ");
                        runCuidador = Leer.dato();
                        posicion = buscar(runCuidador, cuidadores);
                        if(posicion == -1)
                            System.out.println("\nNO EXISTE CUIDADOR!!!");
                        else{
                            Animal nuevoAnimal = crearAnimal();
                            boolean z = cuidadores.get(posicion).agregarAnimal(nuevoAnimal);
                            if(z)
                                System.out.println("\nAnimal agregado");
                            else
                                System.out.println("\nEl Animal ya existe");
                        }
                    }
                    pausa();
                    break;
                case 5:
                    cls();
                    System.out.println("\nEl zoologico Alimalitos Unidos S.A.  "+ cantidadMamas(cuidadores) + " pueden ser Madres"); 
                    pausa();
                    break;
                case 6:
                    cls();
                    if(cuidadores.isEmpty())
                        System.out.println("\nNo hay Cuidadores");
                    else{
                        System.out.print("\nRun del cuidador al que desea eliminar un Animal? ");
                        runCuidador = Leer.dato();
                        posicion = buscar(runCuidador, cuidadores);
                        if(posicion == -1)
                            System.out.println("\nNO EXISTE CUIDADOR!!!");
                        else{
                            System.out.print("\nCodigo del Animal a eliminar? ");
                            String codAnimal = Leer.dato();
                            System.out.println(cuidadores.get(posicion).eliminarAnimal(codAnimal));
                        }
                    }
                    pausa();
                    break;
            }
            cls();
        }while(opMenu != 7);
    }
    
    public static void pausa(){
        System.out.println("\n\n\tPresione ENTER para continuar");;
        String v = Leer.dato();
    }
    public static void cls(){
        for(int i=0;i<28; i++)
            System.out.println("                                          ");
    }
}
