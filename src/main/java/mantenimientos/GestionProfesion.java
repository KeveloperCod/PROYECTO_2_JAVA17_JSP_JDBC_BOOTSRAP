package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;

import interfaces.ProfesionInterface;
import model.Profesion;
import utils.MySQLConexion;

public class GestionProfesion implements ProfesionInterface{

	@Override
	public int registrar(Profesion profesion) {
		int resultado=0;
		Connection con = null;
		PreparedStatement pst= null;
		
		try {
			  //Conexión
			  con = MySQLConexion.getConexion();
			  //Creado en query sql
			  String sql = " insert into tb_profesion values (null, ?) ";
			  //Enviar la conexión y el sql al PreparedStatement
			  pst= con.prepareStatement(sql);
			  
			  //Parametrizar el PreparedStatement
			  pst.setString(1, profesion.getProfesion());
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
	public int actualizar(Profesion profesion) {
		int resultado=0;
		Connection con = null;
		PreparedStatement pst= null;
		
		try {
			  //Conexión
			  con = MySQLConexion.getConexion();
			  //Creado en query sql
			  String sql = " update tb_profesion set id_profesion=? where id=?";
			  //Enviar la conexión y el sql al PreparedStatement
			  pst= con.prepareStatement(sql);
			  
			  //Parametrizar el PreparedStatement
			  pst.setString(1, profesion.getProfesion());
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

}
