<%-- 
    Document   : crudProductos
    Created on : 15/05/2019, 11:43:17 AM
    Author     : trebo
--%>

<%@page import="java.sql.Timestamp"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entidades.Producto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="menuGamers.css">
<link rel="stylesheet" href="table.css">
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>GAMERS PLANET</title>
    </head>
    <body>
        <!-- Sidebar  -->
        <%@ include file="menuCode.jsp" %>  
        <!-- Page Content  -->
        <div id="content">
            <%@ include file="menuToolBar.jsp" %>  
            <!--Aqui poner contenido de vistas-->
            <div class="container">
                <h1>Alta Productos</h1>
                <p>Productos <strong>(Mercancía)</strong></p>

                <ul>
                    <li>Edita con responsabilidad.</li> 
                    <li>Trabaja duro.</li>
                </ul>

                <form>
                    <di class="form-group">
                        <p>Busquedas</p>
                        Id    <input type="text" name="idProd">
                        <button type="submit">buscar</button>
                    </di>
                </form>
                <div id="table" class="table-editable">
                    <span class="table-add glyphicon glyphicon-plus"></span>
                    <table class="table">
                        <tr>
                            <th>Nombre</th>
                            <th>Descripción</th>
                            <th>Unidad(s)</th>
                            <th>Existencia</th>
                            <th>Precio</th>
                            <th>Area</th>
                            <th>Estatus producto</th>
                            <th>Fecha de alta</th>
                            <th>Usuario ultima modificación</th>
                            <th>Fecha ultima modificación</th>
                            <td><a href="ControllProductoForm?action=add"><button type="button" class="btn btn-success">Añadir</button></a></td>
                        </tr>
                        <%
                            String idProd = request.getParameter("idProd");
                            System.out.println("idProd: " + idProd);
                            int cont = 0;
                            ArrayList<Producto> productos = (ArrayList<Producto>) request.getAttribute("Productos");

                            for (Producto producto : productos) {
                                cont++;
                                if (idProd == null || idProd.equals("")) {

                        %>
                        <tr>
                            <td><%=producto.getNombre()%></td>
                            <td class="celda"><%=producto.getDescripcion()%></td>
                            <td><%=producto.getUnidad()%></td>
                            <td><%=producto.getExistencia()%></td>
                            <td>$<%=producto.getPrecio()%></td>
                            <td><%=producto.getIdAreaS()%></td>
                            <%
                                String status = "";
                                if (producto.isStatusProd()) {
                                    status = "Activo";
                                } else {
                                    status = "Inactivo";
                                }
                            %>
                            <td><%=status%></td>
                            <td><%=producto.getFechaAlta()%></td>
                            <td>Aqui validas crisitan</td>
                            <td><%=producto.getFechaMod()%></td>
                            <td><a href="ControllProductoForm?action=update&producto=<%=producto.getNombre()%>"><button type="button" class="btn btn-primary">Actualizar</button></a></td>
                            <td><a href="ControllProductoForm?action=delete&producto=<%=producto.getNombre()%>"><button type="button" class="btn btn-danger">Eliminar</button></a></td>
                        </tr>
                        <%                                } else {
                            if (producto.getIdProducto() == Integer.parseInt(idProd)) {
                                cont--;
                        %>
                        <tr>
                            <td><%=producto.getNombre()%></td>
                            <td class="celda"><%=producto.getDescripcion()%></td>
                            <td><%=producto.getUnidad()%></td>
                            <td><%=producto.getExistencia()%></td>
                            <td>$<%=producto.getPrecio()%></td>
                            <td><%=producto.getIdAreaS()%></td>
                            <%
                                String status = "";
                                if (producto.isStatusProd()) {
                                    status = "Activo";
                                } else {
                                    status = "Inactivo";
                                }
                            %>
                            <td><%=status%></td>
                            <td><%=producto.getFechaAlta()%></td>
                            <td>Aqui validas crisitan</td>
                            <td><%=producto.getFechaMod()%></td>
                            <td><a href="ControllProductoForm?action=update&producto=<%=producto.getNombre()%>"><button type="button" class="btn btn-primary">Actualizar</button></a></td>
                            <td><a href="ControllProductoForm?action=delete&producto=<%=producto.getNombre()%>"><button type="button" class="btn btn-danger">Eliminar</button></a></td>
                        </tr>
                        <%

                                    }

                                    if (cont == productos.size()) {
                                        response.sendRedirect("ControllProdcutoCRUD");
                                    }
                                }
                            }

                        %>

                    </table>
                </div>             
            </div>
        </div>

        <!--Imports necesarios para menu-->
        <%@ include file="importMenu.jsp" %>  
    </body>
</html>
