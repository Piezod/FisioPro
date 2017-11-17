
package BLL;

public class Utilidades {
	
	
	public static boolean EsValidoTlfno(String telefono)
	{

		String regexStr = "^[0-9]*$";
		if (telefono.matches(regexStr))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static boolean EsPositivo(int numero)
	{
		
		if (numero>0)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	public static boolean EsVacia(String cadena)
	{
		if (cadena.trim().length()==0)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	public static boolean EsNulo (Object objeto)
	{
		if (objeto==null)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}

}
