package adega;
import java.util.List;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;

import java.util.LinkedList;
import adega.Bebida;

public class Model 
{	
	/*banco orientado a objetos*/
	ObjectContainer bebidasBanco = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "bd/bebidas.db4o");
	ObjectContainer usuariosBanco = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "bd/usuarios.db4o");
	
	/*adiciona uma nova bebida em bebidasBanco*/
	public void addBebida(Bebida bebida)
	{
		/*nao permite salvar bebidas com o mesmo codigo de barras*/
		if( validaCodigoBebida(bebida.getCodigoDeBarras())==true  )
		{
			bebidasBanco.store(bebida); /*add no banco*/
			bebidasBanco.commit(); /*comitar o código para concluir o comando*/
		}	
	}
	
	/*busca bebida em bebidasBanco*/
	public ObjectSet<Bebida> buscarBebidas()
	{
		Query query = bebidasBanco.query();
		query.constrain(Bebida.class);
		ObjectSet<Bebida> bebidasNoBanco= query.execute();
		return bebidasNoBanco;
	}
	
	
	/*busca bebida em bebidasBanco pelo código de barras*/
	public Bebida buscarCodigoDeBarras(String codigoDeBarras)
	{
		Query query = bebidasBanco.query();
		query.constrain(Bebida.class);
		ObjectSet<Bebida> bebidasNoBanco= query.execute();
		for(Bebida bebidasBanco:bebidasNoBanco)
		{
			if(bebidasBanco.getCodigoDeBarras().equals(codigoDeBarras))
			return bebidasBanco;
		}
		return null;
	}
	
	/*remove bebida de bebidasBanco pelo codigo de barras*/
	public void removeBebida(String codigoDeBarras)
	{
		
		Query query = bebidasBanco.query();
		query.constrain(Bebida.class);
	    ObjectSet<Bebida> bebidaEncontrada = query.execute();
		for(Bebida bebidaBanco: bebidaEncontrada) 
		{
			if(bebidaBanco.getCodigoDeBarras().equals(codigoDeBarras)) 
			{
				Bebida b = bebidaBanco;
				bebidasBanco.delete(b); /*remove no banco*/
				bebidasBanco.commit(); /*comitar o código para concluir o comando*/
				break;
			}	
		}
	}

	/*altera uma bebida, buscada por codigo de barras, de bebidasBanco*/
	public void alterarBebidaCodigo(Bebida bebida)
	{
		Query query = bebidasBanco.query();  /*query pra acessar o banco*/
		query.constrain(Bebida.class); /*linkando com a classe onde irá buscar*/
		ObjectSet<Bebida> bebidasEncontradasBanco = query.execute(); /*setando os valores encontrados na lista*/
		    
	    for(Bebida bebida1:bebidasEncontradasBanco)  /*estrutura para percorrer a lista*/
		{
			if(bebida1.getCodigoDeBarras().equals(bebida.getCodigoDeBarras())) /*verifica se a bebida foi encontrada, pelo seu codigo de barras*/
			{		
				bebida1.setEspc(bebida.getEspc()); /*pega apenas as especificaçoes novas, o codigo de barras continua o memso*/
				bebidasBanco.store(bebida); /*add no banco*/
				bebidasBanco.commit(); /*comitar o código para concluir o comando*/ 
				break;
			}
		}
	}	
	/*adiciona Usuário em usuariosBanco, se o user nao existir*/
	public boolean addUsuario(Usuario usuario)
	{
		if(validaUsuario(usuario.getLogin()))
		{
			usuariosBanco.store(usuario);
			usuariosBanco.commit();
			return true;
		}
		return false;
	}
	
	/*faz login utilizando dados de usuariosBanco, se os dados estiverem corretos*/
	public Usuario login(String login, String senha)
	{
		Query queryUsuarios = usuariosBanco.query();
		queryUsuarios.constrain(Usuario.class);
	    ObjectSet<Usuario> usuariosEncontrados = queryUsuarios.execute();
	    System.out.println("sizeof:" +usuariosEncontrados.size());
	    for(Usuario usuario:usuariosEncontrados)
	    {
	    	if(usuario.getLogin().equals(login) && usuario.getSenha().equals(senha))
	    	{	
	    		return usuario;
	    	}
	    }
	    return null;
	}
	
	/*valida se usuário já existe, antes de adicionar no usuariosBanco*/
	public boolean validaUsuario(String login)
	{
		Query query = usuariosBanco.query();
		query.constrain(Usuario.class);
	    ObjectSet<Usuario> usuariosEncontrados = query.execute();
	    
	    for(Usuario usuario:usuariosEncontrados)
	    {
	    	if(usuario.getLogin().equals(login)) 
	    		return false;
	    }	
	    return true;
	}
	
	/*valida se a o codigo de barras bebida já existe, antes de adicionar bebidas em bebidasbanco*/
	public boolean validaCodigoBebida(String codigoDeBarras)
	{
		Query query = bebidasBanco.query();
		query.constrain(Bebida.class);
	    ObjectSet<Bebida> codigoEncontrado = query.execute();
	    
	    for(Bebida bebida:codigoEncontrado)
	    {
	    	if(bebida.getCodigoDeBarras().equals(codigoDeBarras)) 
	    		return false;
	    }	
	    return true;
	} 
	
	//retorna todos os usuarios cadastrados
	public ObjectSet<Usuario> mostraUsuarios() 
	{
		Query query1 = usuariosBanco.query();
		query1.constrain(Usuario.class);
		ObjectSet<Usuario> todosUsuarios= query1.execute();
		return todosUsuarios;
	}
	
}
