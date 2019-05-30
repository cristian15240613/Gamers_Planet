/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import controladores.AccesoBD;
import entidades.Area;
import entidades.Producto;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author trebo
 */
public class modeloArea {

    private AccesoBD conexion;
    boolean estadoBD;
    String query;

    public modeloArea() {
        conexion = new AccesoBD();
        estadoBD = conexion.conectarBD();
        query = "";

    }

//    public boolean crearProducto(Producto producto) {
//        query = "INSERT INTO producto(nombre,descripcion,unidad,existencia,idArea,statusProd,idUsrAlta,fechaAlta,idUsrMod,fechaMod,precio)"
//                + "VALUES("
//                + "'" + producto.getNombre() + "',"
//                + "'" + producto.getDescripcion() + "',"
//                + "'" + producto.getUnidad() + "',"
//                + producto.getExistencia() + ","
//                + producto.getIdArea() + ","
//                + producto.isStatusProd() + ","
//                + producto.getIdUsrAlta() + ","
//                + producto.getFechaAlta() + ","
//                + producto.getIdUsrMod() + ","
//                + producto.getFechaMod() + ","
//                + producto.getPrecio() + ");";
//
//        if (conexion.ejecutarSQL(query)) {
//            return true;
//        } else {
//            return false;
//        }
//
//    }
    public ArrayList<Area> getAllAreas() {
        ArrayList<Area> areas = new ArrayList<>();

        query = "SELECT * FROM areaAlmacen";
        ResultSet response = conexion.ejecutarSQLSelect(query);
        if (response != null) {
            try {
                boolean status = false;
                while (response.next()) {
                    Area area = new Area();
                    area.setIdArea(response.getInt(1));
                    area.setNombre(response.getString(2));
                    area.setIdUsrAlta(response.getInt(3));
                    area.setIdUsrAltaS(getIdToString(response.getInt(3), "idUsuario", "nombre", "usuario"));
                    area.setFechaAlta(response.getTimestamp(4));
                    area.setIdUsrMod(response.getInt(5));
                    area.setIdUsrModS(getIdToString(response.getInt(5), "idUsuario", "nombre", "usuario"));
                    area.setFechaMod(response.getTimestamp(6));
                    
                    areas.add(area);
                }
                conexion.cerrarConexion();

            } catch (SQLException e) {
                conexion.cerrarConexion();
                System.out.println("fallo traer todos los productos");
            }
            return areas;
        } else {
            return areas;
        }
    }

    private String getIdToString(int id, String idName, String nombreCampo, String tabla) {
        query = "SELECT " + nombreCampo + " FROM " + tabla + " WHERE " + idName + "=" + id + ";";
        ResultSet response = conexion.ejecutarSQLSelect(query);
        try {
            String nombre = "";
            while (response.next()) {
                nombre = response.getString(1);
            }
            return nombre;
        } catch (SQLException e) {
            conexion.cerrarConexion();
            System.out.println(e);
        }
        return "Area no encontrada";
    }

//    public Producto searchProductoByName(String nameProduct) {
//        Producto producto = new Producto();
//        query = "SELECT * FROM producto where nombre='" + nameProduct + "'";
//        ResultSet response = conexion.ejecutarSQLSelect(query);
//        if (response != null) {
//            try {
//                boolean status = false;
//                while (response.next()) {
//
//                    producto.setIdProducto(response.getInt(1));
//                    producto.setNombre(response.getString(2));
//                    producto.setDescripcion(response.getString(3));
//                    producto.setUnidad(response.getString(4));
//                    producto.setExistencia(response.getInt(5));
//                    producto.setIdArea(response.getInt(6));
//                    producto.setIdAreaS(getIdToString(response.getInt(6), "idArea", "nombre", "areaAlmacen"));
//                    if (response.getInt(7) == 0) {
//                        status = false;
//                    } else if (response.getInt(7) == 1) {
//                        status = true;
//                    }
//                    producto.setStatusProd(status);
//                    producto.setIdUsrAlta(response.getInt(8));
//                    producto.setIdUsrAltaS(getIdToString(response.getInt(8), "idUsuario", "nombre", "usuario"));
//                    producto.setFechaAlta(response.getTimestamp(9));
//                    producto.setIdUsrMod(response.getInt(10));
//                    producto.setIdUsrModS(getIdToString(response.getInt(10), "idUsuario", "nombre", "usuario"));
//                    producto.setFechaMod(response.getTimestamp(11));
//                    producto.setPrecio(response.getFloat(12));
//
//                }
//
//            } catch (SQLException e) {
//                conexion.cerrarConexion();
//                System.out.println("fallo traer todos los productos");
//            }
//            return producto;
//        } else {
//            return producto;
//        }
//    }

//    public Producto buscarProducto(int idProdcuto) {
//        String query = "SELECT * FROM usuario WHERE idUsuario = " + idUsuario;
//        ResultSet query = conexion.ejecutarSQLSelect(query);
//
//        try {
//            if (query.next()) {
//                
//                return new Usuario(
//                query.getInt(1),
//                query.getString(2),
//                query.getString(3),
//                query.getString(4),
//                query.getString(5),
//                query.getString(6),
//                query.getString(7),
//                query.getInt(8),
//                query.getInt(9),
//                query.getInt(10),
//                query.getString(11),
//                query.getInt(12),
//                query.getString(13));                
//                
//            }else{
//                return null;
//            }        
//            
//        } catch (SQLException sqlExc) {
//            System.err.println("ERROR AL OBTENER LOS DATOS DEL USUARIO");
//            return null;
//        }
//
//    }
//
//    public boolean eliminarProducto(int idProducto) {
//        String query = "UPDATE producto SET statusProd = 0 WHERE idProducto =" + idProducto;
//        System.out.println("New query: " + query);
//        if (conexion.ejecutarSQL(query)) {
//            return true;
//        } else {
//            return false;
//        }
//    }
//
//    public boolean actualizaProducto(Producto producto) {
//        int status = 0;
//        if (producto.isStatusProd()) {
//            status = 1;
//        } else {
//            status = 0;
//        }
//        String query = "UPDATE producto SET "
//                + "nombre = '" + producto.getNombre() + "',"
//                + "descripcion = '" + producto.getDescripcion() + "',"
//                + "unidad = '" + producto.getUnidad() + "',"
//                + "existencia = " + producto.getExistencia() + ","
//                + "idArea = " + producto.getIdArea() + ","
//                + "statusProd = " +status + ","
//                + "idUsrAlta = " + producto.getIdUsrAlta() + ","
//                + "fechaAlta = '" + producto.getFechaAlta() + "',"
//                + "idUsrMod = " + producto.getIdUsrMod() + ","
//                + "fechaMod = '" + producto.getFechaMod() + "',"
//                + "precio = " + producto.getPrecio()
//                + " WHERE idProducto =" + producto.getIdProducto() + ";";
//        System.out.println("Query: "+query);
//        if (conexion.ejecutarSQL(query)) {
//            return true;
//        } else {
//            return false;
//        }
//
//    } 
}
