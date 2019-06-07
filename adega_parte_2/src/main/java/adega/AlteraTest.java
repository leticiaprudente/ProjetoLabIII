package adega;

import static org.junit.Assert.*;

import org.junit.Test;

public class AlteraTest {

	@Test
	public void test() 
	{
		/*instancia��o do Model, para fazer a comunica��o entre as classes*/
		Model model = new Model();
		
		/*adicionar bebida*/
		model.addBebida(new Bebida("042", new Especificacao("42", "HITCHHIKERS GUIDE TO GALAXY", "4,2", "Australian Pale Ale", "Tumut River", "https://craftypint.s3.amazonaws.com/crafty5/beer/Tumut-River-Hitch-Hikers-190401-091609.png", "42,00"))); /*ok*/
	  	
		/*busca bebida por c�digo de barras*/
		Bebida bebida = model.buscarCodigoDeBarras("042"); /*ok*/
		
		/*alterar bebida*/
		assertEquals(bebida.getCodigoDeBarras(),"042"); /*ok*/
		model.addBebida(new Bebida("042", new Especificacao("42", "HITCHHIKERS GUIDE TO GALAXY 2", "4,2", "Australian Pale Ale", "Tumut River", "https://craftypint.s3.amazonaws.com/crafty5/beer/Tumut-River-Hitch-Hikers-190401-091609.png", "42,00"))); /*ok*/
		
		/*remover bebida*/
		model.removeBebida("001"); /*ok*/
		
		/*adicionar usuario - ADM*/
		model.addUsuario(new Usuario("leticia", "prudente", "Leticia Macedo Prudente de Carvalho", 0,"22/10/1998", "12230-530", "Rua Scutum", "S�o Jos� dos Campos", "S�o Paulo", "Brasil", "141", "Frente", "let.prudente@gmail.com", "(12)99627-9107"));/*ok*/
		model.addUsuario(new Usuario("admin", "admin", "'Administrador", 0,"31/05/2019", "00000-000", "-", "-", "S�o Paulo", "Brasil", "141", "-", "admin@adega.com", "-"));/*ok*/
		
		
		/*adicionar usuario repetido - nao pode adicionar! */
		model.addUsuario(new Usuario("leticia", "prudente", "'Leticia Macedo",1, "22/10/1998", "12230-530", "Rua Scutum", "S�o Jos� dos Campos", "S�o Paulo", "Brasil", "141", "Frente", "let.prudente@gmail.com", "(12)99627-9107"));/*ok*/
		
		/*fazer login com usuario correto*/
		model.login("leticia", "prudente"); /*ok*/
		
		/*fazer login com usuario incorreto*/
		model.login("leticia", "macedo"); /*ok*/
		
		/*deletar bebida por codigo de barras*/
		model.removeBebida("z"); /*ok (nao esta funcionando com o front)*/
		
	}
	

}
