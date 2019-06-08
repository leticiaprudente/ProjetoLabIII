package adega;

import static spark.Spark.get;
import com.db4o.ObjectSet;
import com.google.gson.Gson;
import adega.Bebida;
import adega.Especificacao;

public class Controller 
{
	private Model model;
	public Controller(Model model)
	{
		this.model = model;
	}	
	/*buscar todas as bebidas*/
	public void buscarBebidas()
	{
		get("/todasAsBebidas", (req,res)-> /*1 parametro*/  
		{ 
			ObjectSet<Bebida> bebidaEncontrada = model.buscarBebidas();
			return new Gson().toJson(bebidaEncontrada);	
		});
	}
	/*buscar bebida por codigo de barras*/
	public void buscarCodigoDeBarras()
	{
		get("/codigo/:codigoDeBarras", (req,res)-> /*2 parametros*/  
		{ 
			Bebida bebidaEncontrada = model.buscarCodigoDeBarras(req.params(":codigoDeBarras"));
			return new Gson().toJson(bebidaEncontrada);	
		});
	}
	public void mostraUsuarios()
	{
		get("/mostra/todos/usuarios", (req, res) -> /*3 parametros*/
		{
			ObjectSet<Usuario> usuariosEncontrados = model.mostraUsuarios();
			return new Gson().toJson(usuariosEncontrados);	
		});
	}
	
	/*remover bebida */
	public void removeBebida()
	{
		get("/codigo/admin/remove/:codigoDeBarras", (req,res)-> /*4 parametros*/  
		{ 
			
			model.removeBebida(req.params(":codigoDeBarras"));
			return "";	
			
		});
	}
	
	
	
	public void alterarBebidaCodigo()
	{
		get("/admin/altera/:codigoDeBarras/:ibu/:nome/:teorAlcoolico/:tipo/:marca/:img/:preco", (req,res)-> //10 parametros  
		{ 
			model.alterarBebidaCodigo(new Bebida(req.params(":codigoDeBarras"), new Especificacao(req.params(":ibu"), req.params(":nome"), req.params(":teorAlcoolico"), req.params(":tipo"), req.params(":marca"), req.params(":img"), req.params(":preco"))));
			return "";
		});
	}
	
	/*login usuário*/
	public void login()
	{
		get("/adega/online/login/login/:login/:senha", (req, res) -> /*6 parametros*/
		{
			Usuario cadastrado = model.login(req.params(":login"),req.params(":senha"));	
			return new Gson().toJson(cadastrado);
		});
	}
	
	/*adicionar bebida*/
	public void addBebida() 
	{
		get("/cadastro/:codigoDeBarras/:ibu/:nome/:teorAlcoolico/:tipo/:marca/:img/:preco", (req, res) ->  /*9 parametros*/
		{
			model.addBebida(new Bebida(req.params(":codigoDeBarras"), new Especificacao(req.params(":ibu"), req.params(":nome"), req.params(":teorAlcoolico"), req.params(":tipo"), req.params(":marca"), req.params(":img"), req.params(":preco"))));
			return "";
		});
	}
	/*adicionar usuario*/
	public void addUsuario() 
	{
		get("/:login/:senha/:nomeCompleto/1/:dataNascimento/:cepEndereco/:ruaEndereco/:cidadeEndereco/:bairroEndereco/:estadoEndereco/:numeroEndereco/:complementoEndereco/:email/:celular", (req, res) -> /*14 parametros*/
		{
			model.addUsuario(new Usuario(req.params(":login"),req.params(":senha"), req.params(":nomeCompleto"), 1, req.params(":dataNascimento"),req.params(":cepEndereco"),req.params(":ruaEndereco"), req.params(":cidadeEndereco"), req.params(":bairroEndereco"), req.params(":estadoEndereco"), req.params(":numeroEndereco"), req.params(":complementoEndereco"), req.params(":email"), req.params(":celular")));
			return "";
		});
	}
	
	
	/*adicionar admin*/
	public void addAdmin() 
	{
		get("admin/:login/:senha/:nomeCompleto/0/:dataNascimento/:cepEndereco/:ruaEndereco/:cidadeEndereco/:bairroEndereco/:estadoEndereco/:numeroEndereco/:complementoEndereco/:email/:celular", (req, res) -> /*15 parametros*/
		{
			model.addUsuario(new Usuario(req.params(":login"),req.params(":senha"), req.params(":nomeCompleto"), 0, req.params(":dataNascimento"),req.params(":cepEndereco"),req.params(":ruaEndereco"), req.params(":cidadeEndereco"), req.params(":bairroEndereco"), req.params(":estadoEndereco"), req.params(":numeroEndereco"), req.params(":complementoEndereco"), req.params(":email"), req.params(":celular")));
			return "";
		});
	}

}
	