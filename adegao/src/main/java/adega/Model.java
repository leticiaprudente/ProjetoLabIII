package adega;
import java.util.List;
import java.util.LinkedList;
import adega.Bebida;
public class Model 
{
	
	private List<Bebida> bebidas = new LinkedList<Bebida>();

	public void addBebida(Bebida bebida)
	{
		bebidas.add(bebida);
	}
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
	public void removeBebida(String codigoDeBarras)
	{
		for(Bebida bebida:bebidas) {
			if(bebida.getCodigoDeBarras().equals(codigoDeBarras)) 
				bebidas.remove(bebida);
		}
	}
	
	public List<Bebida> buscarEspecificacao(Especificacao esp)
	{
		List<Bebida> bebidasEncontradas = new LinkedList<Bebida>();
		
		for(Bebida bebida:bebidas)
		{
			 if(esp.comparar(bebida.getEspc())) 
				 bebidasEncontradas.add(bebida);
		}
		return bebidasEncontradas;
	}
	public Bebida buscarCodigoDeBarras(String codigoDeBarras)
	{
		for(Bebida bebida:bebidas)
		{
			if(bebida.getCodigoDeBarras().equals(codigoDeBarras))
			return bebida;
		}
		return null;
		
	}
	public Bebida buscarCodigoDeBarrasAdmin(String codigoDeBarras)
	{
		for(Bebida bebida:bebidas)
		{
			if(bebida.getCodigoDeBarras().equals(codigoDeBarras))
			return bebida;
		}
		return null;
		
	}
	public List<Bebida> buscarMarca(String marca)
	{
		List<Bebida> bebidasEncontradas= new LinkedList<Bebida>();
		for(Bebida bebida:bebidas) 
		{
			if(bebida.getEspc().getMarca().equals(marca)) 
				bebidasEncontradas.add(bebida);
		}
		return bebidasEncontradas;
	}
	public List<Bebida> buscarIbu(String ibu)
	{
		List<Bebida> bebidasEncontradas= new LinkedList<Bebida>();
		for(Bebida bebida:bebidas) 
		{
			if(bebida.getEspc().getIbu().equals(ibu)) 
				bebidasEncontradas.add(bebida);
		}
		return bebidasEncontradas;
	}
	public List<Bebida> buscarNome(String nome)
	{
		List<Bebida> bebidasEncontradas= new LinkedList<Bebida>();
		for(Bebida bebida:bebidas) 
		{
			if(bebida.getEspc().getNome().equals(nome)) 
				bebidasEncontradas.add(bebida);
		}
		return bebidasEncontradas;
	}

	public List<Bebida> buscarTipo(String tipo)
	{
		List<Bebida> bebidasEncontradas= new LinkedList<Bebida>();
		for(Bebida bebida:bebidas) 
		{
			if(bebida.getEspc().getTipo().equals(tipo)) 
				bebidasEncontradas.add(bebida);
		}
		return bebidasEncontradas;
	}
	public List<Bebida> buscarTeorAlcoolico(String teorAlcoolico)
	{
		List<Bebida> bebidasEncontradas= new LinkedList<Bebida>();
		for(Bebida bebida:bebidas) 
		{
			if(bebida.getEspc().getTeorAlcoolico().equals(teorAlcoolico)) 
				bebidasEncontradas.add(bebida);
		}
		return bebidasEncontradas;
	}
	
	
	
	public List<Bebida> getBebidas(){
		return bebidas;
	}
	
	

}
