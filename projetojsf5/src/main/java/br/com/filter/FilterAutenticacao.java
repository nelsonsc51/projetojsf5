package br.com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
//import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.com.entidades.Pessoa;
import br.com.jpautil.JPAUtil;

//@WebFilter  (urlPatterns = {"/*"})
public class FilterAutenticacao implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		// pegando o objeto da requisição, tem todos os dados da requisição
		// quando clica em algum botão, para uma requisição
		HttpServletRequest req = (HttpServletRequest) request;
		// Adcionando a sessão que é única para cada requisição
		HttpSession session = req.getSession();

		Pessoa usuarioLogado = (Pessoa) session.getAttribute("usuarioLogado");
		
		//é o endereço do nosso sistema na url
		String url = req.getServletPath();
		
		if(!url.equalsIgnoreCase("index.jsf") && usuarioLogado == null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsf");
			dispatcher.forward(request, response);
			return;
		} else {
			chain.doFilter(request, response);
		}

	}

	// é executado quando sobe o servidor
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// levanta a conexão do BD
		JPAUtil.getEntityManager();
	}

}