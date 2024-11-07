package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;

import interfaces.DocenteInterface;
import model.Docente;
import utils.MySQLConexion;

public class GestionDocente implements DocenteInterface{

	@Override
	public int registrar(Docente docente) {
		int resultado=0;
		Connection con = null;
		PreparedStatement pst= null;
		
		try {
			  //Conexión
			  con = MySQLConexion.getConexion();
			  //Creado en query sql
			  String sql = " insert into tb_docente values (null, ?,?,?,?,?,?) ";
			  //Enviar la conexión y el sql al PreparedStatement
			  pst= con.prepareStatement(sql);
			  
			  //Parametrizar el PreparedStatement
			  pst.setString(1, docente.getNombre());
			  pst.setString(2, docente.getApePaterno());
			  pst.setString(3, docente.getApeMaterno());
			  pst.setString(4, docente.getEmail());
			  pst.setLong(5, docente.getCelular());
			  pst.setInt(6, docente.getIdProfesion());
			  
			  //Ejecutar
			  resultado= pst.executeUpdate();
			 
		}catch (Exception e) {
			 System.out.println("Error en la sentencia "+e.getMessage());
		} finally {
			
				try {
					if (pst!=null)pst.close();
					if (con!=null)con.close();
				} catch (Exception e2) {
					 System.out.println("Error al cerrar "+e2.getMessage());
				}
		}
	
		return resultado;
	}

	@Override
	public int actualizar(Docente docente) {
		int resultado=0;
		Connection con = null;
		PreparedStatement pst= null;
		
		try {
			  //Conexión
			  con = MySQLConexion.getConexion();
			  //Creado en query sql
			  String sql = " update tb_docente set  nombre=?, apePaterno=?, apeMaterno=?, email=?, celular=?, id_profesion=? where id=? "  ; 
			  //Enviar la conexión y el sql al PreparedStatement
			  pst= con.prepareStatement(sql);
			  
			  //Parametrizar el PreparedStatement
			  pst.setString(1, docente.getNombre());
			  pst.setString(2, docente.getApePaterno());
			  pst.setString(3, docente.getApeMaterno());
			  pst.setString(4, docente.getEmail());
			  pst.setLong(5, docente.getCelular());
			  pst.setInt(6, docente.getIdProfesion());
			  pst.setInt(7,  docente.getCodigo());
			  
			  //Ejecutar
			  resultado= pst.executeUpdate();
			 
		}catch (Exception e) {
			 System.out.println("Error en la sentencia "+e.getMessage());
		} finally {
			
				try {
					if (pst!=null)pst.close();
					if (con!=null)con.close();
				} catch (Exception e2) {
					 System.out.println("Error al cerrar "+e2.getMessage());
				}
		}
	
		return resultado;
	}

	@Override
	public List<Docente> listar() {

		//Declarar las variables a usar
		List<Docente> lista = new ArrayList<Docente>();
		ResultSet rs= null; //importar, contenedor de datos, como un vasito que vas a colocar datos 
		Connection con = null;
		PreparedStatement pst=null;//ejecutar los scripts en la base de datos
		
		try {//establecer la conexion con la base de datos 
			con=MySQLConexion.getConexion();
			String sql= " select id, nombre, apePaterno, apeMaterno, email, celular, id_profesion from tb_docente ";
			pst=con.prepareStatement(sql);//tengo que pasarle la conexion
			
			//Ejecutamos
			rs=pst.executeQuery(); //exclusivo para listar y registrar
			
			while( rs.next()) {//recorrer 
				Docente docente = new Docente();
				docente.setCodigo(  rs.getInt(1));
				docente.setNombre(  rs.getString(2));
				docente.setApePaterno(rs.getString(3));
				docente.setApeMaterno(rs.getString(4));
				docente.setEmail(rs.getString(5));
				docente.setCelular(rs.getLong(6));
				docente.setIdProfesion(rs.getInt(7));
				
				lista.add(docente);
			}

		} catch (Exception e) {
			 System.out.println("Error en la sentencia "+e.getMessage());
		} finally {//cerrar conexiones
			try {
				
				if (rs!=null)  rs.close();
				if (pst!=null) pst.close();
				if (con!=null) con.close();
				
				
			} catch (Exception e2) {
				 System.out.println("Error al cerrar conexiones "+e2.getMessage());
			}
		}
		
		return lista;
	}
	@Override
	public Docente obtenerDocente(int codigo) {
		//Declarar las variables a usar
				Docente docente = null;
				ResultSet rs= null; //importar, contenedor de datos, como un vasito que vas a colocar datos 
				Connection con = null;
				PreparedStatement pst=null;//ejecutar los scripts en la base de datos
				
				try {//establecer la conexion con la base de datos 
					con=MySQLConexion.getConexion();
					String sql= " select id, nombre, apePaterno, apeMaterno, email, celular, id_profesion from tb_docente where id=?";
					pst=con.prepareStatement(sql);//tengo que pasarle la conexion
					//parametrizar
					pst.setInt(1, codigo);//aquí le paso el codigo
					
					//Ejecutamos
					rs=pst.executeQuery(); //exclusivo para listar y registrar
					
					while( rs.next()) {//recorrer 
						docente = new Docente();
						docente.setCodigo(  rs.getInt(1));
						docente.setNombre(  rs.getString(2));
						docente.setApePaterno(rs.getString(3));
						docente.setApeMaterno(rs.getString(4));
						docente.setEmail(rs.getString(5));
						docente.setCelular(rs.getLong(6));
						docente.setIdProfesion(rs.getInt(7));
						
					}

				} catch (Exception e) {
					 System.out.println("Error en la sentencia "+e.getMessage());
				} finally {//cerrar conexiones
					try {
						
						if (rs!=null)  rs.close();
						if (pst!=null) pst.close();
						if (con!=null) con.close();
						
						
					} catch (Exception e2) {
						 System.out.println("Error al cerrar conexiones "+e2.getMessage());
					}
				}
				
				return docente;//devolución del objeto 
	}

	@Override
	public int eliminar(int codigo) {
		// declarar las variables a usar
		int resultado=0;
		Connection con = null;
		PreparedStatement pst = null;
		
		try {
			con=MySQLConexion.getConexion();
			String sql="delete from tb_docente where id=?" ;
			pst= con.prepareStatement(sql);
			
			pst.setInt(1, codigo);
			
			resultado=pst.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("Error en la sentencia "+e.getMessage());
		} finally {
			
			try {
				if(pst!=null)pst.close();
				if(con!=null)con.close();
			} catch (Exception e2) {
				System.out.println("Error al cerrar "+e2.getMessage());
			}
		}		
		return  resultado;
	}

}