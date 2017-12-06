package BLL;


import java.sql.SQLException;
import java.util.List;

import javax.swing.plaf.synth.SynthScrollBarUI;

import BD.*;
import Entidades.*;
public class ClienteBLL {
	
	private Cliente cli;
	
	
	
	public ClienteBLL(Cliente cli)
	{
		this.cli=cli;
	}
	public ClienteBLL() {
		// TODO Auto-generated constructor stub
	}
	
	public ClienteBLL(String nombre,String ape1,String ape2,String edad,String telefono) throws Exception {
		// TODO Auto-generated method stub
		cli=new Cliente();
		if (!Utilidades.EsVacia(nombre))
		{
			cli.setNombre(nombre);
		}
		if (!Utilidades.EsVacia(ape1)) {
			cli.setApellido1(ape1);	
		}
		if (!Utilidades.EsVacia(ape2)) {
			cli.setApellido1(ape2);	
		}
		if (!Utilidades.EsVacia(edad)) {
		cli.setEdad(edad);}
		if (!Utilidades.EsVacia(telefono)) {
		cli.setTelefono(telefono);}
	}
	
	/**
	 * 
	 * Metodo que nos realizara el alta, validaciones, llamada a dal y nos devuelve el id
	 * del cliente dado de alta.
	 * @return devuelve el id del cliente dado de alta, en caso de error devuelve un 0
	 */
	public int altacliente()
	{
		
		int exito=0;;
		try {
				ClienteDAL cdal=new ClienteDAL(cli);
				if (cdal.AltaCliente()>0)
				{					
					exito=cdal.obtenerultimoid();	
				}
		} catch (Exception e) {
			// TODO: handle exception
			exito=0;
			System.err.println("Error en cliente.bll alta cliente" + e);
		}
		
		return exito;
	}

	/**
	 * Metodo que me valida los datos recogidos del cliente, devolvera 
	 * true cuando este todo correcto o false cuando algún dato falle
	 * @return val = ture o false dependiendo si esta todo correcto o no
	 */
	public boolean validardatoscliente(String nombre,String ape1,String ape2,String edad,String telefono)
	{
		boolean val=true;
		
		if (Utilidades.EsVacia(nombre)
			|| Utilidades.EsVacia(ape1)
					|| Utilidades.EsVacia(ape2))
		{
			val=false;
		}else if (!Utilidades.EsValidoTlfno(""+telefono))
		{
			val=false;
		}else if (!Utilidades.EsPositivo(Integer.parseInt(edad)))
		{
			val=false;
		}
		
		return val;
	}
	
	

	public List<Cliente> buscarclientes()
	{
		List<Cliente> alist;
		if (Utilidades.EsNulo(cli.getNombre()))
		{
			cli.setNombre("");
		}
		
		ClienteDAL clidal=new ClienteDAL(cli);
		
		alist=clidal.buscarclientes();
		
	/*	
	 * Si no encuentro nada en la jsp pondre un modal de no encontrar nada y listo. Aqui no devuelvo siempre
	 * una 
	 * if (alist.size()==0)
		{
			Cliente vacio=new Cliente();
			vacio.setNombre("No se encontro ningun registro");
			vacio.setApellido1("");
			vacio.setApellido2("");
			vacio.setEdad("");
			vacio.setTelefono("");
			alist.add(vacio);
		}
		*/
		return alist;
	}

	public List<Cliente> recortarlista(int numeropaginacion,int numeromaximo)
	{
		List<Cliente> alist;
		List<Cliente> auxlist;
		if (Utilidades.EsNulo(cli.getNombre()))
		{
			cli.setNombre("");
		}
		
		ClienteDAL clidal=new ClienteDAL(cli);
		
		alist=clidal.buscarclientes();
	
		
		if (numeropaginacion > 0 && numeropaginacion < numeromaximo && numeromaximo > 10)
		{
			auxlist=alist.subList(numeropaginacion*10+1, numeropaginacion*10+11);
		}
		else if ( numeropaginacion == 0 && numeromaximo < 1 )
		{
			auxlist=alist;
		}
		else if (numeropaginacion == 0)
		{
			auxlist=alist.subList(numeropaginacion, numeropaginacion+10);	
		}
		else 
		{
			auxlist=alist.subList(numeropaginacion*10+1,alist.size());
		}
		
		return auxlist;
		
	}
	
	public Cliente RellenarCliente(Cliente cli)
	{
		ClienteDAL clidal=new ClienteDAL(cli);
		
		return clidal.RellenarCliente(""+cli.getOid());
		
	}
	
	public List<Cliente> RecargarTodosCliente()
	{
		List<Cliente> alist;
		List<Cliente> auxlist;
		
		ClienteDAL clidal=new ClienteDAL();
		
		alist=clidal.RecargarTodosCliente();
	
		
		
		
		return alist;
	}
}
