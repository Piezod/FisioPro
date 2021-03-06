
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
	
	/**
	 * Comprueba si la cadena tiene 0 caracteres
	 * @param cadena
	 * @return 
	 */
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
	
		
	/**Mira si algo ( objeto ) es nulo
	 *  comprueba objeto == null devuelve true
	 * @param objeto
	 * @return
	 */
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
