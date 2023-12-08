package br.com.cursojsf;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import br.com.dao.DaoGeneric;
import br.com.entidades.Pessoa;
import br.com.reposiytory.IDAOPessoa;
import br.com.reposiytory.IDaoPessoaImpl;

@ViewScoped
@ManagedBean(name = "pessoaBean")
public class PessoaBean {
	// O manageBean é quem controla a tela JSF
	private Pessoa pessoa = new Pessoa();
	private DaoGeneric<Pessoa> daoGeneric = new DaoGeneric<Pessoa>();
	// pra carregar uma lista de pessoas é preciso ter um list de pessoas
	List<Pessoa> pessoas = new ArrayList<Pessoa>();

	private IDAOPessoa iDaoPessoa = new IDaoPessoaImpl();

	// agora salva e retorna a entidade na tela JSF
	public String salvar() {
		// atribui-se a pessoa, a entidade que o JPA irá retornar
		pessoa = daoGeneric.merge(pessoa);
		// quando existem alterações no BD, involve-se o carregar a lista de pessoas
		carregarPessoas();
		return "";
	}

	public String novo() {
		pessoa = new Pessoa();
		// retorno que permite, permanecer na mesma tela
		return "";
	}

	// Método é String para permanecer na mesma tela JSF com return ""
	public String remover() {
		daoGeneric.removerporId(pessoa);
		// retorno que permite, permanecer na mesma tela
		pessoa = new Pessoa();
		// quando existem alterações no BD, invo-se o carregar a lista de pessoas
		carregarPessoas();
		return "";
	}

	// anotação necessária para carregar a lista de dados na tela assim que a mesma
	// for aberta
	@PostConstruct
	public void carregarPessoas() {
		// Atribuido a lista de pessoas a consulta de dados que feita no BD
		pessoas = daoGeneric.getListEntity(Pessoa.class);
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public DaoGeneric<Pessoa> getDaoGeneric() {
		return daoGeneric;
	}

	public void setDaoGeneric(DaoGeneric<Pessoa> daoGeneric) {
		this.daoGeneric = daoGeneric;
	}

	// get é necessário para o JSF carregar a lista de pessoas
	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	public String logar() {

		Pessoa pessoaUser = iDaoPessoa.consultarUsuario(pessoa.getLogin(), pessoa.getSenha());

		if (pessoaUser != null) {// achou o usuário

			// adicionar usuário na sessão "usuarioLogado", que está no filter de
			// autenticação
			// para ser recuperada e setada nas linhas abaixo

			FacesContext context = FacesContext.getCurrentInstance();
			ExternalContext externalContext = context.getExternalContext();
			// alterado para pegar o objeto completo
			//aqui é pego a chave e o valor
			externalContext.getSessionMap().put("usuarioLogado", pessoaUser);

			// no momento do redirecionamento, irá consultar o filter de autenticação e é
			// necessário ter o usuário setado,
			// para deixar redirecionar para a página que queremos

		
			return "primeirapagina.jsf";
		
		}

		return "index.jsf";
	}

	public boolean permiteAcesso(String acesso) {
		
		//recuperado o objeto da sessão
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext externalContext = context.getExternalContext();
		//através do get atribuindo a variável pessoa
		Pessoa pessoaUser = (Pessoa) externalContext.getSessionMap().get("usuarioLogado");

		return pessoaUser.getPerfilUser().equals(acesso);
	}
}