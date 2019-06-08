package adega;

import adega.Especificacao;

public class Bebida 
{
	private String codigoDeBarras;
	private Especificacao espc;	
	public Bebida(String codigoDeBarras, Especificacao espc)
	{
		this.codigoDeBarras = codigoDeBarras;
		this.espc = espc;
	}

	public String getCodigoDeBarras() 
	{
		return codigoDeBarras;
	}

	public void setCodigoDeBarras(String codigoDeBarras) 
	{
		this.codigoDeBarras = codigoDeBarras;
	}

	public Especificacao getEspc() 
	{
		return espc;
	}

	public void setEspc(Especificacao espc) 
	{
		this.espc = espc;
	}
}
