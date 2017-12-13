package BLL;


import java.sql.SQLException;

import javax.swing.plaf.synth.SynthScrollBarUI;

import BD.*;
import Entidades.*;
public class AntecedentesPersonalesBLL {
	
	private AntecedentesPersonales ap;
	
	
	public AntecedentesPersonalesBLL() {
		ap=new AntecedentesPersonales();
	}
	
	public AntecedentesPersonalesBLL(String idcliente,
			String des_eg,
			String des_oq, 
			String des_tma,
			String des_la) throws Exception {
		// TODO Auto-generated method stub
		
		ap=new AntecedentesPersonales();
		ap.setOid_cliente(Integer.parseInt(idcliente));
		ap.setEnfermedadesGraves(des_eg);
		ap.setLesionesAntiguas(des_la);
		ap.setOperacionesQuirurjicas(des_oq);
		ap.setTratamientoMedicoActual(des_tma);
		
	}
	
	public AntecedentesPersonalesBLL(AntecedentesPersonales ap)
	{
		this.ap=new AntecedentesPersonales();
		this.ap=ap;
	}
	/**
	 * 
	 * Metodo que nos realizara el alta, validaciones, llamada a dal y nos devuelve el id
	 * del cliente dado de alta.
	 * @return devuelve el id del cliente dado de alta, en caso de error devuelve un 0
	 */
	public int altaantecedentes()
	{
		
		int exito=0;
		try {
				AntecedentesPersonalesDAL apd=new AntecedentesPersonalesDAL(ap);
				/*
				 * Miramos los datos, si no hay porque se ha dejado el formulario vacio
				 * se ponen por defecto ninguno.
				 */
				validarnulo();
				validar();
				
				exito=apd.AltaAntecedente();
				
		} catch (Exception e) {
			// TODO: handle exception
			exito=0;
			System.err.println("Error en Antecedentespersonales.bll altaantecedentes" + e);
		}
		
		return exito;
	}

	/**
	 * Nos validara los datos del fomrmulario de alta antecedentes.
	 * En caso de que se deje vacio ( porque rober no quiere rellenarlos ahora)
	 * se pondra como valores por defecto ninguno
	 * 	 */
	public void validar()
	{
		
		if (Utilidades.EsVacia(ap.getEnfermedadesGraves()))
				{
			ap.setEnfermedadesGraves("Ninguna");
				}
		if (Utilidades.EsVacia(ap.getOperacionesQuirurjicas()))
		{
			ap.setOperacionesQuirurjicas("Ninguna");
		}
		if (Utilidades.EsVacia(ap.getTratamientoMedicoActual()))
		{
			ap.setTratamientoMedicoActual("Ninguno");
		}
		if (Utilidades.EsVacia(ap.getLesionesAntiguas()))
		{
			ap.setLesionesAntiguas("Ninguna");
		}
		
	}

	/**
	 * Nos validara los datos del fomrmulario de alta antecedentes.
	 * En caso de que se deje vacio ( porque rober no quiere rellenarlos ahora)
	 * se pondra como valores por defecto ninguno
	 * 	 */
	public void validarnulo()
	{
		
		if (Utilidades.EsNulo(ap.getEnfermedadesGraves()))
				{
			ap.setEnfermedadesGraves("Ninguna");
				}
		if (Utilidades.EsNulo(ap.getOperacionesQuirurjicas()))
		{
			ap.setOperacionesQuirurjicas("Ninguna");
		}
		if (Utilidades.EsNulo(ap.getTratamientoMedicoActual()))
		{
			ap.setTratamientoMedicoActual("Ninguno");
		}
		if (Utilidades.EsNulo(ap.getLesionesAntiguas()))
		{
			ap.setLesionesAntiguas("Ninguna");
		}
		
	}
	public AntecedentesPersonales RellenarAntecedentes (Cliente cli)
	{
		AntecedentesPersonales ap=new AntecedentesPersonales();
		ap.setOid_cliente(cli.getOid());
		AntecedentesPersonalesDAL apdall=new AntecedentesPersonalesDAL(ap);
		
		return apdall.RellenarAntecedentes();
	}

	public int actualizarap()
	{
		AntecedentesPersonalesDAL apdal=new AntecedentesPersonalesDAL(ap);
		validar();
		return apdal.actualizarap();
	}

	/** Metodo para realizar el borrado de ap
	 * @return Devuelve el numero de registros ap borrados
	 */
	public int eliminarantecedente() {
		
		AntecedentesPersonalesDAL apdal=new AntecedentesPersonalesDAL(ap);
		return apdal.eliminarantecedente();
	}
}
