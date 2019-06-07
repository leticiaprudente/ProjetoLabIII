package adega;

import adega.Especificacao;

public class Especificacao 
{
	private String ibu;
	private String nome;
	private String teorAlcoolico;
	private String tipo;
	private String marca;
	private String img;
	private String preco;
		
	public Especificacao(String ibu, String nome, String teorAlcoolico, String tipo, String marca, String img, String preco)
	{
		this.ibu = ibu;
		this.nome = nome;
		this.teorAlcoolico = teorAlcoolico;
		this.tipo = tipo;
		this.marca = marca;
		this.img = img;
		this.preco = preco;
	}
	
	public String getIbu(){
		return ibu;
	}
	
	public String getNome(){
		return nome;
	}
	
	public String getTeorAlcoolico(){
		return teorAlcoolico;
	}
	
	public String getTipo()
	{
		return tipo;
	}
	
	public String getMarca()
	{
		return marca;
	}
	
	
	public String getImg() 
	{
		return img;
	}

	public void setImg(String img) 
	{
		this.img = img;
	}

	public String getPreco() 
	{
		return preco;
	}

	public void setPreco(String preco) 
	{
		this.preco = preco;
	}

}
