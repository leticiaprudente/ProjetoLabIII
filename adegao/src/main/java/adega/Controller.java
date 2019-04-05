package adega;

import static spark.Spark.get;

import java.util.LinkedList;
import java.util.List;
import com.google.gson.Gson;
import java.util.List;
import adega.Bebida;
import adega.Especificacao;

public class Controller 
{
	private Model model;
	public Controller(Model model)
	{
		this.model = model;
	}	
	
	public void addBebida() 
	{
		get("/cadastro/:codigoDeBarras/:ibu/:nome/:teorAlcoolico/:tipo/:marca/:img/:preco", (req, res) ->  /*9 parametros*/
		{
			model.addBebida(new Bebida(req.params(":codigoDeBarras"), new Especificacao(req.params(":ibu"), req.params(":nome"), req.params(":teorAlcoolico"), req.params(":tipo"), req.params(":marca"), req.params(":img"), req.params(":preco"))));
		return "";
		});
	}
	public void buscarCodigoDeBarras()
	{
		get("/codigo/:codigoDeBarras", (req,res)-> /*2 parametros*/  
		{ 
			Bebida bebidaEncontrada = model.buscarCodigoDeBarras(req.params(":codigoDeBarras"));
			return new Gson().toJson(bebidaEncontrada);	
		});
	}
	public void buscarCodigoDeBarrasAdmin()
	{
		get("/codigo/admin/:codigoDeBarras", (req,res)-> /*3 parametros*/  
		{ 
			Bebida bebidaEncontrada = model.buscarCodigoDeBarrasAdmin(req.params(":codigoDeBarras"));
			return new Gson().toJson(bebidaEncontrada);	
		});
	}
	/*
	public void removeBebida()
	{
		get("/codigo/admin/remove/:codigoDeBarras", (req,res)-> //4 parametros  
		{ 
			
			Bebida bebidaEncontrada = model.removeBebida();
			return new Gson().toJson(bebidaEncontrada);	
				
		});
	}
	*/
	
	public void alteraBebida()
	{
		get("/codigo/admin/alterar/:codigoDeBarras", (req,res)-> /*4 parametros*/  
		{ 
			Bebida bebidaEncontrada = model.alteraBebidaCodigo(req.params(":codigoDeBarras"),req(:));		
		});
	 
	/*
	public List<Bebida> alteraBebidaCodigo(Bebida bebida)
	{
		List<Bebida> bebidasEncontradas= new LinkedList<Bebida>();
		
		for(Bebida bebida1:bebidas) 
		{
			if(bebida1.getCodigoDeBarras().equals(bebida.getCodigoDeBarras()))
			{
				bebidasEncontradas.remove(bebida1);
				bebidasEncontradas.add(bebida);
			}
				
		}
		return bebidasEncontradas;
	} 
	 * */
	
	public void buscarNome()
	{
		get("/bebida/:nome", (req,res) -> /*2 parametros*/ 
		{
			List<Bebida> bebidasEncontradas = model.buscarNome(req.params(":nome"));
			return new Gson().toJson(bebidasEncontradas);
		});
	}
	public void buscarMarca() 
	{
		get("/bebida/marca/:Marca", (req,res) -> /*3 parametros*/ 
		{
			List<Bebida> bebidasEncontradas = model.buscarMarca(req.params(":marca"));
			return new Gson().toJson(bebidasEncontradas);
		});
	}
	
	public void buscarTipo()
	{
		get("/bebida/tipo/tipo/:Tipo", (req,res) -> /*4 parametros*/ 
		{
			List<Bebida> bebidasEncontradas = model.buscarTipo(req.params(":tipo"));
			return new Gson().toJson(bebidasEncontradas);
		});
	}
	
	public void buscarIbu()
	{
		get("/bebida/amargor/amargor/amargor/:Amargor", (req,res) -> /*5 parametros*/ 
		{
			List<Bebida> bebidasEncontradas = model.buscarIbu(req.params(":tipo"));
			return new Gson().toJson(bebidasEncontradas);
		});
	}
	
	public void buscarTeorAlcoolico()
	{
		get("/bebida/teor/teor/teor/teor/teor/teor/:Amargor", (req,res) -> /*8 parametros*/ 
		{
			List<Bebida> bebidasEncontradas = model.buscarTeorAlcoolico(req.params(":teorAlcoolico"));
			return new Gson().toJson(bebidasEncontradas);
		});
	}
}
