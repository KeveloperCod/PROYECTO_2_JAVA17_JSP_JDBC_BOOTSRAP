package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import interfaces.CursoInterface;
import model.Curso;
import utils.MySQLConexion;

//recuerda implementar los métodos 

public class GestionCurso implements CursoInterface { 

	@Override
	public int registrar(Curso curso) {
		//Declaración de variables
		int resultado=0;
		Connection con = null;
		PreparedStatement pst= null;
		
		try {
			  //Conexión
			  con = MySQLConexion.getConexion();
			  //Creado en query sql
			  String sql = " insert into tb_cursos values (null, ?,?,?,?,?) ";
			  //Enviar la conexión y el sql al PreparedStatement
			  pst= con.prepareStatement(sql);
			  
			  //Parametrizar el PreparedStatement
			  pst.setString(1, curso.getNombre());
			  pst.setInt(2, curso.getNivel());
			  pst.setInt(3, curso.getModalidad());
			  pst.setInt(4, curso.getCreditos());
			  pst.setDouble(5, curso.getPrecio());
			  
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
	public int actualizar(Curso curso) {
		//Declaración de variables - establecer conexión con la base de datos 
		int resultado=0;
		Connection con = null;
		PreparedStatement pst= null; //podemos ejecutar nuestras setencias del sql 
				
		try {
				//Conexión
				con = MySQLConexion.getConexion();
				//Creado en query sql
				String sql = " update  tb_cursos set  nombre=?, nivel=?, modalidad=?, creditos=?, precio=?  where id=? ";
				//Enviar la conexión y el sql al PreparedStatement
				pst= con.prepareStatement(sql);
					  
				//Parametrizar el PreparedStatement
				pst.setString(1, curso.getNombre());
				pst.setInt(2, curso.getNivel());
				pst.setInt(3, curso.getModalidad());
				pst.setInt(4, curso.getCreditos());
				pst.setDouble(5, curso.getPrecio());
				pst.setInt(6, curso.getCodigo());
					  
				//Ejecutar
				resultado= pst.executeUpdate();//nos devuelve un valor numérico, 0 o mayor a 0
					 
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
	public List<Curso> listar() {

		//Declarar las variables a usar
		List<Curso> lista = new ArrayList<Curso>();
		ResultSet rs= null; //importar, contenedor de datos, como un vasito que vas a colocar datos 
		Connection con = null;
		PreparedStatement pst=null;//ejecutar los scripts en la base de datos
		
		try {//establecer la conexion con la base de datos 
			con=MySQLConexion.getConexion();
			String sql= " select id, nombre, nivel, modalidad, creditos, precio from tb_cursos ";
			pst=con.prepareStatement(sql);//tengo que pasarle la conexion
			
			//Ejecutamos
			rs=pst.executeQuery(); //exclusivo para listar y registrar
			
			while( rs.next()) {//recorrer 
				Curso curso = new Curso();
				curso.setCodigo(  rs.getInt(1));
				curso.setNombre(  rs.getString(2));
				curso.setNivel(   rs.getInt(3));
				curso.setModalidad( rs.getInt(4));
				curso.setCreditos(  rs.getInt(5));
				curso.setPrecio(  rs.getDouble(6));
				
				lista.add(curso);
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
	public Curso obtenerCurso(int codigo) {
		//Declarar las variables a usar
		Curso curso = null;
		ResultSet rs= null;
		Connection con = null;
		PreparedStatement pst=null;
		
		try {
			con=MySQLConexion.getConexion();
			String sql= " select id, nombre, nivel, modalidad, creditos, precio from tb_cursos  where id=? ";//incorporo el id
			pst=con.prepareStatement(sql);
			//Parametrizar, cuando hay signo de interrogacion 
			pst.setInt(1, codigo);
			//Ejecutamos
			rs=pst.executeQuery();
			
			while( rs.next()) {
				curso = new Curso();//declarar y llenar 
				curso.setCodigo(  rs.getInt(1));
				curso.setNombre(  rs.getString(2));
				curso.setNivel(   rs.getInt(3));
				curso.setModalidad( rs.getInt(4));
				curso.setCreditos(  rs.getInt(5));
				curso.setPrecio(  rs.getDouble(6));
			}

		} catch (Exception e) {
			 System.out.println("Error en la sentencia "+e.getMessage());
		} finally {
			try {
				
				if (rs!=null)  rs.close();
				if (pst!=null) pst.close();
				if (con!=null) con.close();
				
				
			} catch (Exception e2) {
				 System.out.println("Erroral cerrar conexiones "+e2.getMessage());
			}
		}
		
		return curso;//devolución del objeto
	}

	@Override
	public int eliminar(int codigo) {
		
		//Paso 1 : declarar las variables a usar
		int resultado=0;
		Connection con= null;
		PreparedStatement pst=null;
		
		try {
			con=MySQLConexion.getConexion();
			String sql=" delete from  tb_cursos   where id=?  ";
			pst=con.prepareStatement(sql);//
			//parametrizar
			pst.setInt(1,codigo);
			resultado=pst.executeUpdate();	//exclusivo insertar,actualizar y eliminar
			
			
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
