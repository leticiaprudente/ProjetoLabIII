package adega;
import static spark.Spark.*;

public class MainServer {
	final static Model model = new Model();
	
  public static void main(String[] args) 
  {
      ProcessBuilder process = new ProcessBuilder();
      Integer port;
      if (process.environment().get("PORT") != null) 
      {
          port = Integer.parseInt(process.environment().get("PORT"));
      } 
      else 
      {
          port = 2020;
      }
      port(port);

  	staticFileLocation("/");
	testeBebidas();
	Controller controller = new Controller(model);
	controller.addBebida();
	controller.buscarCodigoDeBarras();
	controller.buscarCodigoDeBarrasAdmin();
	controller.buscarIbu();
	controller.buscarMarca();
	controller.buscarNome();
	controller.buscarTeorAlcoolico();
	controller.buscarTipo();
  }
  public static void testeBebidas()
	{
	  	model.addBebida(new Bebida("001", new Especificacao("45", "Colorado Indica", "7,0", "American India Pale Ale", "Colorado", "https://emporiodacerveja.vteximg.com.br/arquivos/ids/169389-1000-1000/ColoradoIndica1000x1000.jpg?v=636542262631100000", "15,90")));
	  	model.addBebida(new Bebida("002", new Especificacao("38", "Red Ale Baden Baden", "9,2", "Double Red", "Baden Baden", "https://http2.mlstatic.com/baden-baden-red-ale-600-ml-D_NQ_NP_756947-MLB25618407664_052017-F.jpg", "19,90")));
	  	model.addBebida(new Bebida("003", new Especificacao("19", "Heineken", "6", "Lager", "Heineken", "https://www.imigrantesbebidas.com.br/bebida/images/products/full/222_Cerveja_Heineken_Long_Neck_330_ml.jpg", "4,50")));
	}
}
