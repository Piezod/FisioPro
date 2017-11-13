package BD;
import java.sql.*;

public class Conexion {

	private Connection conexion=null;
    private String servidor="sql139.main-hosting.eu";
    private String database="u222872483_java";
    private String usuario="u222872483_java";
    private String password="123456";
    private String url="";
 
    public  Conexion(String servidor, String database, String usuario, String password){
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
    }
/*
    $db = new PDO('mysql:host=mysql.hostinger.es;
    dbname=u222872483_ino;
    charset=utf8mb4', 'u222872483_ino', '123456');
    
    */
    public Conexion(){
        try {
 
            this.servidor = servidor;
            this.database = database;
 
            Class.forName("com.mysql.jdbc.Driver");
            //Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            url="jdbc:mysql://"+servidor+"/"+database;
            System.out.println(url);
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
    	return conexion.createStatement();
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
