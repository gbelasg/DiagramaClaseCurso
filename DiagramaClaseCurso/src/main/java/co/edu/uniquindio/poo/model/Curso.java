package co.edu.uniquindio.poo.model;
import java.util.List;
import java.util.ArrayList;

public class Curso {
    private String nombre; // es null por defecto
    private String codigo;
    //Relación
    private ArrayList<Estudiante>listaEstudiantes;

    //CONSTRUCTOR

    public Curso(String nombre, String codigo){
        this.nombre=nombre;
        this.codigo=codigo;
       listaEstudiantes= new ArrayList<>();
    }
    //set y get
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    public String getNombre(){

        return nombre;
    }
    public void setCodigo(String codigo){

        this.codigo=codigo;
    }
    public String getCodigo(){
        return codigo;
    }

    public void setListaEstudiantes(ArrayList<Estudiante>listaEstudiantes){
        this.listaEstudiantes=listaEstudiantes;
    }
    public ArrayList<Estudiante> getListaEstudiantes(){
        return listaEstudiantes;
    }
    public void agregarEstudiante(Estudiante estudiante){
        listaEstudiantes.add(estudiante);
    }

    @Override
    public String toString() {
        return "Curso{" +
                "nombre='" + nombre + '\'' +
                ", codigo='" + codigo + '\'' +
                ", listaEstudiantes=" + listaEstudiantes +
                '}';
    }

    //Logica

    //CRUD ESTUDIANTE

    // crear
    public String registrarEstudiante(String nombres, String apellidos, String identificacion, byte edad,
                                      String correo, String telefono){
        String mensaje= "";

        Estudiante buscado= obtenerEstudiante(identificacion);

        if(buscado != null){
            return"Error el estudiante que usted desea registrar ya se encuentra registrado";
        }else{
            Estudiante estudianteNuevo= new Estudiante(nombres, apellidos, identificacion,edad,
                    correo, telefono, this);
            listaEstudiantes.add(estudianteNuevo);
            mensaje ="Estudiante registrado con exito";
        }

        return mensaje;

    }
    public Estudiante obtenerEstudiante(String identificacion){
        Estudiante estudianteEncontrado= null;
        for (Estudiante aux : listaEstudiantes){
            if (aux.getIdentificacion().equals(identificacion)){
                return aux;
            }
        }
        return estudianteEncontrado;
    }
}
