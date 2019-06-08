package adega;

public class Administrador
{
	private String funcao;
	private String login;
	private String senha;
	private String nomeCompleto;
	private int tipo; /*0 - adm e 1 - usuario*/
	/*construtor*/
	public Administrador(String login, String senha, String nomeCompleto, int tipo, String funcao)
	{
		this.login=login;
		this.senha = senha; 
		this.nomeCompleto = nomeCompleto;	
		this.tipo = tipo;
		this.funcao = funcao; 	
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
}
