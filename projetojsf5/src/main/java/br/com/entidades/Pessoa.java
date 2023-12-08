package br.com.entidades;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// Mapeamanto - identifica que será uma tabela no BD
 @Entity
public class Pessoa implements Serializable {
	
	

	private static final long serialVersionUID = 1L;

	// mapeamento necessário para  @Entity
	// Gerador de primary Key
	@Id
	// identifica que é a primary key da tabela
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String nome;
	
	private String sobrenome;
	
	private Integer idade;
	
	private String  sexo;
	
	private String[]  frameWorks;
	
	private  Boolean  ativo;
	
	private String  login;

	private String  senha;
	
	private String  perfilUser;
	
	private String sexoRadio;
	
	private String nivelProgramador;
	
	private Integer[] linguagens;
	

	private String cep;
	
	private String logradouro;
	
	private String complemento;
	
	private String bairro;
	
	private String localidade;
	
	private String uf;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getSexo() {
		return sexo;
	}
	
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	public String[]  getFrameWorks() {
		return frameWorks;
	}
	
	public void setFrameWorks(String[]  frameWorks) {
		this.frameWorks = frameWorks;
	}
	

	public Boolean  getAtivo() {
		return ativo;
	}

	public void  setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
	
	public String  getLogin() {
		return login;
	}
	
	public void  setLogin(String login) {
		this.login = login;
	}
	
	public String  getSenha() {
		return senha;
	}
	
	public void  setSenha(String senha) {
		this.senha = senha;
	}
	
	public String  getPerfilUser() {
		return perfilUser;
	}
	
	public void  setPerfilUser(String perfilUser) {
		this.perfilUser = perfilUser;
	}
	
	public String getSexoRadio() {
		return sexoRadio;
	}
	
	public void setSexoRadio(String sexoRadio) {
		this.sexoRadio = sexoRadio;
	}
	
	public String getNivelProgramador() {
		return nivelProgramador;
	}
	
	public void setNivelProgramador(String nivelProgramador) {
		this.nivelProgramador = nivelProgramador;
	}
	
	
	public Integer[] getLinguagens() {
		return linguagens;
	}
	
	public void setLinguagens(Integer[] linguagens) {
		this.linguagens = linguagens;
	}
	
	public void setCep(String cep) {
		this.cep = cep;
	}
	
	public String getCep() {
		return cep;
	}

	public String getLogradouro() {
		return logradouro;
	}
	
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	
	public String getComplemento() {
		return complemento;
	}
	
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
	public String getBairro() {
		return bairro;
	}
	
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	public String getLocalidade() {
		return localidade;
	}
	
	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}
	
	public String getUf() {
		return uf;
	}
	
	public void setUf(String uf) {
		this.uf = uf;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		return Objects.equals(id, other.id);
	}
	
	

}
