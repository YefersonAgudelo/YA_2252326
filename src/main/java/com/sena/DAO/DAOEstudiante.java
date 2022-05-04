package com.sena.DAO;

import com.sena.objects.Estudiante;
import com.sena.utils.Conexion;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.*;

public class DAOEstudiante extends Conexion{

    Estudiante estudiante = new Estudiante();
    public void deleteEstudiante(int id){
        Connection connection = this.getConexion();
        String deleteSQL = "DELETE FROM estudiante where id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();

        }catch(SQLException e){
            System.out.println(e.getMessage());
        }

    }
    public void createEstudiante(Estudiante estudiante){
        Connection connection = this.getConexion();
        //Estudiante estudiante1 = new Estudiante(6,"Cedula de ciudadania","1086773898","Santiago","Gomez",1200000);
        Estudiante estudiante1 = estudiante;
        String createSQL = "INSERT INTO estudiante (documento,nombre,apellido,valorMatricula) VALUES (?,?,?,?)";

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(createSQL);
            preparedStatement.setString(1,estudiante1.getDocumento());
            preparedStatement.setString(2,estudiante1.getNombre());
            preparedStatement.setString(3,estudiante1.getApellido());
            preparedStatement.setDouble(4,estudiante1.getValorMatricula());
            preparedStatement.executeUpdate();
        } catch (SQLException ea) {
            System.out.println("Error "+ea.getMessage());
        }

    }

    public ArrayList readAllEstudiante() {
        Connection connection = this.getConexion();

        String selectAllSQL = "SELECT documento,nombre,apellido,valorMatricula FROM estudiante";
        ArrayList<Estudiante> Estudiantes = new ArrayList<Estudiante>();
        try {
            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery(selectAllSQL);
            while (rs.next()) {
                Estudiante estudiante1 = new Estudiante();
                estudiante1.setDocumento(rs.getString(1));
                estudiante1.setNombre(rs.getString(2));
                estudiante1.setApellido(rs.getString(3));
                estudiante1.setValorMatricula(rs.getInt(4));
                Estudiantes.add(estudiante1);
            }

        } catch (SQLException ea) {
            System.out.println(ea.getMessage());
        }
        return Estudiantes;
    }
    public Estudiante readEstudianteByDocumento(String documentoE){
        Connection connection = this.getConexion();
        Estudiante estudiante1 = new Estudiante();
        String documento1 = documentoE;
        String createSQL = "SELECT documento,nombre,apellido,valorMatricula FROM estudiante WHERE documento ='"+documento1+"'";
        try{
            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery(createSQL);
            while(rs.next()) {
                estudiante1.setDocumento(rs.getString(1));
                estudiante1.setNombre(rs.getString(2));
                estudiante1.setApellido(rs.getString(3));
                estudiante1.setValorMatricula(rs.getInt(4));
            }

        }catch (SQLException ea) {
            System.out.println(ea.getMessage());
        }
        return estudiante1;
    }
    public void updateEstudiante(Estudiante estudiante, String documentoE){
        Connection connection = this.getConexion();
        Estudiante estudiante1 = estudiante;
        String documento1 = documentoE;
        String createSQL = "SELECT id_estudiante FROM estudiante WHERE documento ='"+documento1+"'";
        int id_estudiante=0;
        try{
            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery(createSQL);
            while(rs.next()){
                id_estudiante = rs.getInt(1);

            }
        String documento=estudiante1.getDocumento();
        String nombre=estudiante1.getNombre();
        String apellido=estudiante1.getApellido();
        double valorMatricula=estudiante1.getValorMatricula();
        String createSQL2 = "UPDATE estudiante SET documento='"+documento+"',nombre='"+nombre+"',apellido='"+apellido+"',valorMatricula='"+valorMatricula+"' WHERE id_estudiante ='"+id_estudiante+"'";
            PreparedStatement preparedStatement = connection.prepareStatement(createSQL2);
            preparedStatement.execute();


        }catch (SQLException ea) {
            System.out.println(ea.getMessage());
        }

    }

    public void deleteEstudiante(String documentoE){
        Connection connection = this.getConexion();
        String documento1 = documentoE;
        String createSQL = "SELECT id_estudiante FROM estudiante WHERE documento ='"+documento1+"'";
        int id_estudiante = 0;
        try{
            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery(createSQL);
            while(rs.next()) {
                id_estudiante = rs.getInt(1);
            }
            String createSQL2 = "DELETE FROM estudiante WHERE id_estudiante ='"+id_estudiante+"'";
            PreparedStatement preparedStatement = connection.prepareStatement(createSQL2);
            preparedStatement.execute();

        }catch (SQLException ea) {
            System.out.println(ea.getMessage());
        }
    }
}
