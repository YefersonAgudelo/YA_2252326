package com.sena.DAO;
import com.sena.objects.Estudiante;
import com.sena.objects.Profesor;
import com.sena.utils.Conexion;

import java.sql.*;
import java.util.ArrayList;

public class DAOProfesor extends Conexion{
    Profesor profesor = new Profesor();
    public void deleteProfesor(int documento){
        Connection connection = this.getConexion();
        String deleteSQL = "DELETE FROM profesor where documento_p = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL);
            preparedStatement.setInt(1, documento);
            preparedStatement.execute();

        }catch(SQLException e){
            System.out.println(e.getMessage());
        }

    }
    public void createProfesor(Profesor profesor){
        Connection connection = this.getConexion();
        Profesor profesor1 = profesor;
        String createSQL = "INSERT INTO profesor (documento_p,nombre_p,telefono_p,direccion_p,titulo,fecha_registro) VALUES (?,?,?,?,?,now())";

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(createSQL);
            preparedStatement.setInt(1,profesor1.getDocumento());
            preparedStatement.setString(2,profesor1.getNombre());
            preparedStatement.setString(3,profesor1.getTelefono());
            preparedStatement.setString(4,profesor1.getDireccion());
            preparedStatement.setString(5,profesor1.getTitulo());
            //preparedStatement.setDate(6, (Date) profesor1.getFecha());
            preparedStatement.executeUpdate();
        } catch (SQLException ea) {
            System.out.println("Error "+ea.getMessage());
        }

    }

    public ArrayList readAllProfesor() {
        Connection connection = this.getConexion();

        String selectAllSQL = "SELECT documento_p,nombre_p,telefono_p,direccion_p,titulo,fecha_registro FROM profesor";
        ArrayList<Profesor> Profesores = new ArrayList<Profesor>();
        try {
            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery(selectAllSQL);
            while (rs.next()) {
                Profesor profesor1 = new Profesor();
                profesor1.setDocumento(rs.getInt(1));
                profesor1.setNombre(rs.getString(2));
                profesor1.setTelefono(rs.getString(3));
                profesor1.setDireccion(rs.getString(4));
                profesor1.setTitulo(rs.getString(5));
                profesor1.setFecha(rs.getDate(6));
                Profesores.add(profesor1);
            }

        } catch (SQLException ea) {
            System.out.println(ea.getMessage());
        }
        return Profesores;
    }
    public Profesor readProfesorByDocumento(String documentoP){
        Connection connection = this.getConexion();
        Profesor profesor1 = new Profesor();
        String documento1 = documentoP;
        String createSQL = "SELECT documento_p,nombre_p,telefono_p,direccion_p,titulo,fecha_registro FROM profesor WHERE documento_p ='"+documento1+"'";
        try{
            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery(createSQL);
            while(rs.next()) {
                profesor1.setDocumento(rs.getInt(1));
                profesor1.setNombre(rs.getString(2));
                profesor1.setTelefono(rs.getString(3));
                profesor1.setDireccion(rs.getString(4));
                profesor1.setTitulo(rs.getString(5));
                profesor1.setFecha(rs.getDate(6));
            }

        }catch (SQLException ea) {
            System.out.println(ea.getMessage());
        }
        return profesor1;
    }
    public void updateProfesor(Profesor profesor, String documentoP){
        Connection connection = this.getConexion();
        Profesor profesor1 = profesor;
        String documento1 = documentoP;
        String createSQL = "SELECT documento_p FROM profesor WHERE documento_p ='"+documento1+"'";
        try{
            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery(createSQL);
            while(rs.next()){
                documento1 = rs.getString(1);

            }
            int documento=profesor1.getDocumento();
            String nombre=profesor1.getNombre();
            String telefono=profesor1.getTelefono();
            String direccion=profesor1.getDireccion();
            String titulo=profesor1.getTitulo();
            String createSQL2 = "UPDATE profesor SET nombre_p='"+nombre+"',telefono_p='"+telefono+"',direccion_p='"+direccion+"',titulo='"+titulo+"' WHERE documento ='"+documento+"'";
            PreparedStatement preparedStatement = connection.prepareStatement(createSQL2);
            preparedStatement.execute();


        }catch (SQLException ea) {
            System.out.println(ea.getMessage());
        }

    }

    public void deleteProfesor(String documentoP){
        Connection connection = this.getConexion();
        String documento1 = documentoP;
        String createSQL = "SELECT documento FROM profesor WHERE documento_p ='"+documento1+"'";
        try{
            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery(createSQL);
            while(rs.next()) {
                documento1 = rs.getString(1);
            }
            String createSQL2 = "DELETE FROM profesor WHERE documento ='"+documento1+"'";
            PreparedStatement preparedStatement = connection.prepareStatement(createSQL2);
            preparedStatement.execute();

        }catch (SQLException ea) {
            System.out.println(ea.getMessage());
        }
    }
}
