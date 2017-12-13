package BD;
import java.sql.*;

public class Conexion {

	private Connection conexion=null;
   
	//Conexion a hostinger funcionando.
	/*private String servidor="sql139.main-hosting.eu";
    private String database="u222872483_java";
    private String usuario="u222872483_java";
    private String password="123456";
    private String url="";*/
 
    
    private String servidor="localhost";
    private String database="u222872483_java";
    private String usuario="root";
    private String password="123456";
    private String url="";
    
    /**
     * Metodo para conectar a la base de datos
     * @param servidor el servidor
     * @param database
     * @param usuario
     * @param password
     */
 /*   public  Conexion(String servidor, String database, String usuario, String password){
        try {
 
            this.servidor = servidor;
            this.database = database;
 
            Class.forName("com.mysql.jdbc.Driver");
            //Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            url="jdbc:mysql://"+servidor+"/"+database;
            System.out.println(url);
           //conexion = DriverManager.getConnection("jdbc:mysql://sql139.main-hosting.eu/u222872483_java", "u222872483_java", "123456");
            conexion=DriverManager.getConnection(url, usuario, password);
            System.out.println("Conexion a Base de Datos "+url+" . . . . .Ok");
 
        }
        catch (SQLException ex) {
            System.out.println(ex);
        }
        catch (ClassNotFoundException ex) {
            System.out.println(ex);
        }
    }*/
    
    /**
     * Metodo para conectar a la base de datos
     * @param servidor el servidor
     * @param database
     * @param usuario
     * @param password
     */
    public Conexion(){
        try {
 
            this.servidor = servidor;
            this.database = database;
 
            Class.forName("com.mysql.jdbc.Driver");
            //Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            url="jdbc:mysql://"+servidor+"/"+database;
            System.out.println(url);
            //Esto permite aumentar el tiempo de espera
            DriverManager.setLoginTimeout(120);
            conexion=DriverManager.getConnection(url, usuario, password);
            System.out.println("Conexion a Base de Datos "+url+" . . . . .Ok");
 
        }
        catch (SQLException ex) {
            System.out.println(ex);
        }
        catch (ClassNotFoundException ex) {
            System.out.println(ex);
        }
    }
 
    public Connection getConexion(){
        return conexion;
    }
 
    public Statement getstm() throws SQLException
    {
    	Statement stm=conexion.createStatement();
    	return stm;
    }
    public Connection cerrarConexion(){
        try {
            conexion.close();
             System.out.println("Cerrando conexion a "+url+" . . . . . Ok");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        conexion=null;
        return conexion;
    }
	
}
