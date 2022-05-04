package com.sena;
import com.sena.DAO.DAOEstudiante;
import com.sena.DAO.DAOProfesor;
import com.sena.objects.Estudiante;
import com.sena.objects.Profesor;
import com.sena.utils.Conexion;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Conexion conexion = new Conexion();
        DAOEstudiante crud = new DAOEstudiante();
        DAOProfesor crud1 = new DAOProfesor();
        Estudiante estudiante1 = new Estudiante();
        Profesor profesor1 = new Profesor();
        ArrayList<Estudiante> Estudiantes = new ArrayList<Estudiante>();
        ArrayList<Profesor> Profesores = new ArrayList<Profesor>();
        String respuesta1=JOptionPane.showInputDialog(null,"¿Que perfil desea?"+"\n"+
                                                                    "1: Estudiante"+"\n"+
                                                                    "2: Profesor");
        int idRespuesta1 = Integer.parseInt(respuesta1);
        switch (idRespuesta1){
            case 1:
                int idRespuesta = 0;
                String[] botones = {"Selecionar por Documento","Insertar", "Modificar", "Eliminar", "Seleccionar todos"};
                int ventana = JOptionPane.showOptionDialog(null,
                        "Pulsa un boton:",
                        "Hola sapa",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.QUESTION_MESSAGE, null,
                        botones, botones[0]);
                if(ventana == 0) {idRespuesta=1;}
                else if(ventana == 1) {idRespuesta=2;}
                else if(ventana == 2) {idRespuesta=3;}
                else if(ventana == 3) {idRespuesta=4;}
                else if(ventana == 4) {idRespuesta=5;}

                switch (idRespuesta){
                    case 1:
                        String documentoE = JOptionPane.showInputDialog("Ingrese el documento del estudiante: ");
                        estudiante1 = crud.readEstudianteByDocumento(documentoE);
                        JOptionPane.showMessageDialog(null, estudiante1.infoE());

                        break;
                    case 2:
                        JOptionPane.showMessageDialog(null,"Ingrese los datos del estudiante: ");
                        String documentoE1 = JOptionPane.showInputDialog("Ingrese el numero de documento: ");
                        String nombreE = JOptionPane.showInputDialog("Ingrese el nombre del estudiante: ");
                        String apellidoE = JOptionPane.showInputDialog("Ingrese el apellido del estudiante: ");
                        String valorMatricula = JOptionPane.showInputDialog("Ingrese el valor de la matricula: ");
                        double valorMatriculaE = Double.parseDouble(valorMatricula);
                        estudiante1 = new Estudiante(documentoE1,nombreE,apellidoE,valorMatriculaE);
                        crud.createEstudiante(estudiante1);
                        break;
                    case 3:
                        JOptionPane.showMessageDialog(null,"Ingrese el documento del estudiante que desea modificar: ");
                        String documentoE2 = JOptionPane.showInputDialog("Ingrese el numero de documento: ");
                        JOptionPane.showMessageDialog(null,"Ingrese los nuevos datos: ");
                        String documentoE1s = JOptionPane.showInputDialog("Ingrese el numero de documento: ");
                        String nombreEs = JOptionPane.showInputDialog("Ingrese el nombre del estudiante: ");
                        String apellidoEs = JOptionPane.showInputDialog("Ingrese el apellido del estudiante: ");
                        String valorMatriculas = JOptionPane.showInputDialog("Ingrese el valor de la matricula: ");
                        double valorMatriculaEs = Double.parseDouble(valorMatriculas);
                        estudiante1 = new Estudiante(documentoE1s,nombreEs,apellidoEs,valorMatriculaEs);
                        crud.updateEstudiante(estudiante1,documentoE2);
                        break;
                    case 4:
                        JOptionPane.showMessageDialog(null,"Ingrese el documento del estudiante que desea eliminar: ");
                        String documentoE3 = JOptionPane.showInputDialog("Ingrese el numero de documento: ");
                        crud.deleteEstudiante(documentoE3);
                        break;
                    case 5:
                        JOptionPane.showMessageDialog(null,"Los estudiantes registrados son: ");
                        Estudiantes = crud.readAllEstudiante();

                        int i = 1;
                        for (Estudiante info : Estudiantes) {
                            System.out.println("Registro N° "+i+"\n"+
                                    "Nombre: "+info.getNombre() +"\n"+
                                    "Apellido: "+info.getApellido() +"\n"+
                                    "Valor de la Matricula: "+info.getValorMatricula()+"\n"+
                                    "------------------------------");
                            i++;
                        }
                        break;
                }
                break;
            case 2:
                JOptionPane.showMessageDialog(null,"¿Que desea hacer?: ");
                String respuesta2 = JOptionPane.showInputDialog("1: Seleccionar por documento"+"\n"+
                        "2: Insertar"+"\n"+
                        "3: Modificar"+"\n"+
                        "4: Eliminar"+"\n"+
                        "5: Seleccionar todos");
                int idRespuesta2 = Integer.parseInt(respuesta2);

                switch (idRespuesta2){
                    case 1:
                        String documentoP = JOptionPane.showInputDialog("Ingrese el documento del profesor: ");
                        profesor1 = crud1.readProfesorByDocumento(documentoP);
                        JOptionPane.showMessageDialog(null, profesor1.infoP());

                        break;
                    case 2:
                        JOptionPane.showMessageDialog(null,"Ingrese los datos del profesor: ");
                        String doc1 = JOptionPane.showInputDialog("Ingrese el numero de documento: ");
                        int documentoP1 = Integer.parseInt(doc1);
                        String nombreP = JOptionPane.showInputDialog("Ingrese el nombre del profesor: ");
                        String telefonoP = JOptionPane.showInputDialog("Ingrese el telefono del profesor: ");
                        String direccionP = JOptionPane.showInputDialog("Ingrese la direccion del profesor: ");
                        String tituloP = JOptionPane.showInputDialog("Ingrese el titulo del profesor: ");
                        profesor1 = new Profesor(documentoP1,nombreP,telefonoP,direccionP,tituloP);
                        crud1.createProfesor(profesor1);
                        break;
                    case 3:
                        JOptionPane.showMessageDialog(null,"Ingrese el documento del profesor que desea modificar: ");
                        String documentoP2 = JOptionPane.showInputDialog("Ingrese el numero de documento: ");
                        int id2 = Integer.parseInt(documentoP2);
                        JOptionPane.showMessageDialog(null,"Ingrese los nuevos datos: ");
                        String nombreP1s = JOptionPane.showInputDialog("Ingrese el nombre del profesor: ");
                        String telefonoPs = JOptionPane.showInputDialog("Ingrese el telefono del profesor: ");
                        String direccionPs = JOptionPane.showInputDialog("Ingrese la direccion del profesor: ");
                        String tituloPs = JOptionPane.showInputDialog("Ingrese el titulo del profesor: ");


                        profesor1 = new Profesor(id2,nombreP1s,telefonoPs,direccionPs,tituloPs);
                        crud1.updateProfesor(profesor1,documentoP2);
                        break;
                    case 4:
                        JOptionPane.showMessageDialog(null,"Ingrese el documento del profesor que desea eliminar: ");
                        String documentoP3 = JOptionPane.showInputDialog("Ingrese el numero de documento: ");
                        crud1.deleteProfesor(documentoP3);
                        break;
                    case 5:
                        JOptionPane.showMessageDialog(null,"Los profesores registrados son: ");
                        Profesores = crud1.readAllProfesor();

                        int i = 1;
                        for (Profesor info : Profesores) {
                            System.out.println("Registro N° "+i+"\n"+
                                    "Nombre: "+info.getNombre() +"\n"+
                                    "Telefono: "+info.getTelefono() +"\n"+
                                    "Direccion: "+info.getDireccion() +"\n"+
                                    "Titulo: "+info.getTitulo()+"\n"+
                                            "Fecha De registro: "+info.getFecha()+"\n"+
                                    "------------------------------");
                            i++;
                        }
                        break;
                }
                break;
        }



    }
}
