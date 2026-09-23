package co.edu.uniquindio.poo;
import co.edu.uniquindio.poo.model.Curso;
import co.edu.uniquindio.poo.model.Estudiante;
import co.edu.uniquindio.poo.model.Nota;

import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        JOptionPane.showMessageDialog(null, "Bienvenidos al sistema de gestión academica");
         String nombreCurso= JOptionPane.showInputDialog(null, "Porfavor ingresar el nombre del curso");
        String codigoCurso= JOptionPane.showInputDialog(null, "Porfavor ingresar el código del curso");
        Curso curso= new Curso(nombreCurso, codigoCurso);

        int opcion;

        do{
            opcion= Integer.valueOf(JOptionPane.showInputDialog(null, "Por favor seleccione una opción: ------Menú-----\n"+
                   "1. Agregar un estudiante" +""


                    ));
            switch (opcion){
                case 0:
                    JOptionPane.showMessageDialog(null, "Muchas gracias por utilizar nuestro sistema");
                    break;
                case 1:
            crearEstudiante(curso);
            break;



                default: JOptionPane.showMessageDialog(null, "Opcion no valida");
            }

        }while(opcion != 0);

        }



        private static void crearEstudiante (Curso curso){
            String nombres= JOptionPane.showInputDialog(null, "Porfavor ingresar el nombre del estudiante");
            String apellidos= JOptionPane.showInputDialog(null, "Porfavor ingresar los apellidos del estudiante ");
            String identificacion= JOptionPane.showInputDialog(null, "Porfavor ingresar la identificacion ");
            String edad= JOptionPane.showInputDialog(null, "Porfavor ingresar la edad");
            byte edadEstudiante= Byte.valueOf(edad);
            String correo= JOptionPane.showInputDialog(null, "Porfavor ingresar el correo");
            String telefono= JOptionPane.showInputDialog(null, "Porfavor ingresar el telefono");

            String resultado= curso.registrarEstudiante(nombres, apellidos, identificacion, edadEstudiante, correo, telefono);

            JOptionPane.showMessageDialog(null, resultado);
        }





    }

