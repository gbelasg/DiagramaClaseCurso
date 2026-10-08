package co.edu.uniquindio.poo.model;

import java.util.ArrayList;
import java.util.Locale;

public class Curso {
    //declaracion de atributos
    // modificador de acceso -> tipo de dato -> nombre del atributo
    private String nombre;//por defecto es null
    private String codigo;
    // declarar las relaciones
    private ArrayList<Estudiante> listaEstudiantes;

    /**
     * Constructor: Es el emtood que permite darle valores o inicializar
     * los valores de los atributos de las clases
     */
    public Curso(String nombre,String codigo){//parametros informacion que entra
        //inicializar las variables
        this.nombre = nombre;
        this.codigo = codigo;
        listaEstudiantes = new ArrayList<>();
    }

    // set y get

    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public String getNombre(){
        return nombre;
    }
    public void setCodigo(String codigo){
        this.codigo = codigo;
    }
    public String getCodigo(){
        return codigo;
    }
    public void setListaEstudiantes(ArrayList<Estudiante> listaEstudiantes){
        this.listaEstudiantes = listaEstudiantes;
    }
    public ArrayList<Estudiante> getListaEstudiantes(){
        return listaEstudiantes;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "nombre='" + nombre + '\'' +
                ", codigo='" + codigo + '\'' +
                ", listaEstudiantes=" + listaEstudiantes +
                '}';
    }

    //logica

    //CRUD del estudiante

    //crear
    public String registrarEstudiante(String nombres,String apellidos,String identificacion,
                                      byte edad,String correo,String telefono){
        String mensaje = "";
        Estudiante buscado = buscarEstudiante(identificacion);
        if(buscado != null){
            return "Error el estudiante que usted desea registra ya se encuentra registrado";
        }else{
            Estudiante estudianteNuevo = new Estudiante(nombres,apellidos,identificacion,edad,correo,telefono,this);
            listaEstudiantes.add(estudianteNuevo);
            mensaje = "Estudiante registrado con exito";
        }
        return mensaje;
    }
    public Estudiante buscarEstudiante (String identificacion){
        for(Estudiante aux : listaEstudiantes){
            if(aux.getIdentificacion().equals(identificacion)){
                return aux;
            }
        }
        return null;
    }
    public boolean eliminarEstudiante(String identificacion) {
        Estudiante estudianteEncontrado = buscarEstudiante(identificacion);
        if(estudianteEncontrado != null){
            listaEstudiantes.remove(estudianteEncontrado);
            return true;
        }else return false;
    }

    public boolean actualizarEstudiante(String identificacionAntigua, String identificacionNueva,
                                        String nombresNuevos, String apellidosNuevos,
                                        byte edadEstudianteNueva, String correoNuevo, String telefonoNuevo) {
        Estudiante estudianteEncontrado = buscarEstudiante(identificacionAntigua);
        if(estudianteEncontrado != null){
            estudianteEncontrado.setApellidos(apellidosNuevos);
            estudianteEncontrado.setNombres(nombresNuevos);
            estudianteEncontrado.setIdentificacion(identificacionNueva);
            estudianteEncontrado.setEdad(edadEstudianteNueva);
            estudianteEncontrado.setCorreo(correoNuevo);
            estudianteEncontrado.setTelefono(telefonoNuevo);
            return true;
        }else return false;
    }

    public String registrarNotaEstudiante(String identificacion, String nombreNota, float valorNota) {

        Estudiante estudianteEncontrado = buscarEstudiante(identificacion);
        if(estudianteEncontrado != null){
            return estudianteEncontrado.registrarNota(nombreNota,valorNota);
        }else{
            return "El estudiante no esta registrado";
        }
    }
    public String calcularDefinitivaEstudiante(String identificacion){
        Estudiante estudianteEncontrado= buscarEstudiante(identificacion);
        if (estudianteEncontrado != null){
            double definitiva= estudianteEncontrado.calcularDefinitiva();
            return " La nota definitiva del estudiante es: " +definitiva;
        }else{
            return "El estudiante no esta registrado";
        }
    }
    public boolean verificarNotaEstudiante(){
        boolean siHay= false;
        for (int i=0; i< listaEstudiantes.size(); i++){
            Estudiante estudiante= listaEstudiantes.get(i);//sacar a cada estudiante
            if (estudiante.calcularDefinitiva()==5){
                siHay=true;
            }
        }
        return siHay;

    }
    public boolean verificarNombreMariana(){
        int contador=0;
        for (int i=0; i< listaEstudiantes.size();i++){
            Estudiante estudiante= listaEstudiantes.get(i);
            if (estudiante.getNombres().equalsIgnoreCase("Mariana")){
                contador++;
            }
        }
        return contador > 2;
    }
    public float calcularNotaMayor(){
        float notaMayor=0;
        for (int i=0; i< listaEstudiantes.size(); i++){
            Estudiante estudiante= listaEstudiantes.get(i);
            double definitiva= estudiante.calcularDefinitiva();
            if (definitiva> notaMayor){
                definitiva=notaMayor;
            }
        }
        return notaMayor;
    }
    public float calcularNotaMenor(){
        float notaMenor=0;
        for (int i=0; i< listaEstudiantes.size(); i++){
            Estudiante estudiante= listaEstudiantes.get(i);
            double definitiva= estudiante.calcularDefinitiva();
            if (definitiva< notaMenor){
                definitiva=notaMenor;
            }
        }
        return notaMenor;
    }
    public double calculaPromedioCurso(){
        if (listaEstudiantes.size()==0){
            return 0;
        }
        int suma=0;
        for (int i=0;i< listaEstudiantes.size();i++){
            Estudiante estudiante= listaEstudiantes.get(i);
            suma+= estudiante.calcularDefinitiva();

        }
        return suma/ listaEstudiantes.size();
    }
    public void ordenarEstudianteNombre(){

        for (int i=0; i< listaEstudiantes.size()-1; i++){
            // se comparan los estudiantes
            for (int j=0; i< listaEstudiantes.size()-1-i;j++){
                Estudiante actual= listaEstudiantes.get(j);
                Estudiante siguiente= listaEstudiantes.get(j+1);

                if(vaDespues(actual.getNombres(), siguiente.getNombres())){
                    listaEstudiantes.set(j, siguiente);
                    listaEstudiantes.set(j+1, actual);
                }
            }


        }
    }
    private boolean vaDespues(String nombre1, String nombre2) {
    nombre1= nombre1.toLowerCase();
    nombre2= nombre2.toLowerCase();
    for (int i=0; i<nombre1.length() && i<nombre2.length(); i++){
        if (nombre1.charAt(i)>nombre2.charAt(i)){
            return  true;
        }
        if (nombre1.charAt(i)<nombre2.charAt(i)){
            return  false;
        }
    }
    return nombre1.length() > nombre2.length();
    }
    public ArrayList<Estudiante> obtenerEstudiantesCondiciones(){
        ArrayList<Estudiante> resultado= new ArrayList<>();

        for (int i=0; i<listaEstudiantes.size(); i++){
            Estudiante aux= listaEstudiantes.get(i);
            String nombres= aux.getNombres();

            boolean empiezaS= nombres.length()>0 && (nombres.charAt(0)== 'S' || nombres.charAt(0)=='s');

            boolean promedioMayor= aux.calcularDefinitiva()> 3.5;

            if (empiezaS && promedioMayor){
                resultado.add(aux);
            }
        }
        return resultado;
    }
}
