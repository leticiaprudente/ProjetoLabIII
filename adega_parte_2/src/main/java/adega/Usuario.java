package adega;

public class Usuario
{
	private String login;
	private String senha;
	private String nomeCompleto;
	private int tipo; /*0 - adm e 1 - usuario*/
	private String dataNascimento;
	private String cepEndereco;
	private String ruaEndereco;
	private String cidadeEndereco;
	private String estadoEndereco;
	private String bairroEndereco;
	private String numeroEndereco;
	private String complementoEndereco;
	private String email;
	private String celular;
	
	
	/*construtor*/
	public Usuario(String login, String senha, String nomeCompleto, int tipo, String dataNascimento, String cepEndereco, String bairroEndereco, String ruaEndereco, String cidadeEndereco, String estadoEndereco, String numeroEndereco, String complementoEndereco, String email, String celular)
	{	
		this.login=login;
		this.senha = senha; 
		this.nomeCompleto = nomeCompleto;	
		this.tipo = tipo;
		this.dataNascimento = dataNascimento;
		this.cepEndereco = cepEndereco;
		this.ruaEndereco = ruaEndereco;
		this.cidadeEndereco = cidadeEndereco;
		this.estadoEndereco = estadoEndereco;
		this.bairroEndereco = bairroEndereco;
		this.numeroEndereco = numeroEndereco;
		this.complementoEndereco = complementoEndereco;
		this.email = email;
		this.celular = celular;
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


	public String getDataNascimento() {
		return dataNascimento;
	}


	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}


	public String getCepEndereco() {
		return cepEndereco;
	}


	public void setCepEndereco(String cepEndereco) {
		this.cepEndereco = cepEndereco;
	}


	public String getRuaEndereco() {
		return ruaEndereco;
	}


	public void setRuaEndereco(String ruaEndereco) {
		this.ruaEndereco = ruaEndereco;
	}


	public String getCidadeEndereco() {
		return cidadeEndereco;
	}


	public void setCidadeEndereco(String cidadeEndereco) {
		this.cidadeEndereco = cidadeEndereco;
	}


	public String getEstadoEndereco() {
		return estadoEndereco;
	}


	public void setEstadoEndereco(String estadoEndereco) {
		this.estadoEndereco = estadoEndereco;
	}


	public String getBairroEndereco() {
		return bairroEndereco;
	}


	public void setBairroEndereco(String bairroEndereco) {
		this.bairroEndereco = bairroEndereco;
	}


	public String getNumeroEndereco() {
		return numeroEndereco;
	}


	public void setNumeroEndereco(String numeroEndereco) {
		this.numeroEndereco = numeroEndereco;
	}


	public String getComplementoEndereco() {
		return complementoEndereco;
	}


	public void setComplementoEndereco(String complementoEndereco) {
		this.complementoEndereco = complementoEndereco;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getCelular() {
		return celular;
	}


	public void setCelular(String celular) {
		this.celular = celular;
	}

	
	
	
}


