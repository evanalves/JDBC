package filter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import connection.SingleConnectionBanco;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@WebFilter(urlPatterns = { "/principal/*" }) /* Intercepta todas as requisições que vierem do projeto ou mapeamento */
public class FilterAutenticacao implements Filter {

	private static Connection connection;

	public FilterAutenticacao() {

	}

	/* Encerra os processos quando o servidor é parado */
	/* Mataria os processos de conexão com o banco */
	public void destroy() {
		try {
			connection.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	/* Intercepta as requisições e da as respostas no sistema */
	/* Tudo o que ficar no sistema vai passar po aqui */
	/* Validaç~eo de autenticação */
	/* Dar Commit e rolback de transação no banco */
	/* validar e fazer redirecionamento de página */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		try {
			HttpServletRequest req = (HttpServletRequest) request;
			HttpSession session = req.getSession();

			String usuarioLogado = (String) session.getAttribute("usuario");

			String urlParaAutenticar = req.getServletPath();/* Url que está sendo acessada */

			/* validar se está lodado se não redirecionar para a tela de login */

			if (usuarioLogado == null
					&& !urlParaAutenticar.equalsIgnoreCase("/principal/ServletLogin")) { /* não está logado */

				RequestDispatcher redireciona = request.getRequestDispatcher("/index.jsp?url=" + urlParaAutenticar);
				request.setAttribute("msg", "Por Favor Realize o Login!");
				redireciona.forward(request, response);
				return; /* Para a execução e redireciona para o login */

			} else {

				chain.doFilter(request, response);

			}
			
			connection.commit();/*Deu tudo certo, ele commita a alteração no banco de dados*/
			
		} catch (Exception e) {
			
			e.printStackTrace();
			RequestDispatcher redirecionar = request.getRequestDispatcher("erro.jsp");
			request.setAttribute("msg", e.getMessage());
			redirecionar.forward(request, response);
			
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}

	}

	/* Inicia os processos ou recursos quando o servidor sobe o projeto */
	// iniciar a conexão com o banco
	public void init(FilterConfig fConfig) throws ServletException {
		connection = SingleConnectionBanco.getConnection();
	}

}
