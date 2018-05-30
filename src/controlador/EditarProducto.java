package controlador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Categoria;
import modelo.CategoriaModelo;
import modelo.Producto;
import modelo.ProductoModelo;

/**
 * Servlet implementation class EditarProducto
 */
@WebServlet("/EditarProducto")
public class EditarProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CategoriaModelo categoriaModelo = new CategoriaModelo();
		ProductoModelo productoModelo = new ProductoModelo();
		
		int id = Integer.parseInt(request.getParameter("id"));
		String nombre = request.getParameter("nombre");
		String descripcion = request.getParameter("descripcion");
		double precio = Double.parseDouble(request.getParameter("precio"));
		int stock = Integer.parseInt(request.getParameter("stock"));
		String nombre_categoria = request.getParameter("categoria");
		
		Categoria categoria = categoriaModelo.selectPorNombre(nombre_categoria);
		
		Producto producto = new Producto();
		producto.setId(id);
		producto.setNombre(nombre);
		producto.setDescripcion(descripcion);
		producto.setPrecio(precio);
		producto.setStock(stock);
		producto.setIdCategoria(categoria.getId());
		
		
		productoModelo.updateProducto(producto);
		request.setAttribute("producto", producto);
		RequestDispatcher rd = request.getRequestDispatcher("EditarProducto.jsp");
		rd.forward(request, response);
		response.sendRedirect("http://localhost:8080/ZubiriTechnology/EditarProducto.jsp");
	}
	

}
