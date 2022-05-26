package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import connection.SingleConnectionBanco;
import model.ModelLogin;

public class DAOUsuarioRepository {

	private Connection connection;

	public DAOUsuarioRepository() {

		connection = SingleConnectionBanco.getConnection();

	}

	public ModelLogin gravarUser(ModelLogin objeto) throws Exception {
		
		if(objeto.isNovo()) {/*Grava um novo*/
		

		String sql = " INSERT INTO model_login (login, senha, nome, email)  VALUES (?, ?, ?, ?)";

		PreparedStatement preparedSql = connection.prepareStatement(sql);
		preparedSql.setString(1, objeto.getLogin());
		preparedSql.setString(2, objeto.getSenha());
		preparedSql.setString(3, objeto.getNome());
		preparedSql.setString(4, objeto.getEmail());

		preparedSql.execute();
		connection.commit();

		}else {
			String sql = "UPDATE model_login SET login=?, senha=?, nome=?, email=? WHERE id = "+objeto.getId()+" ;";
			PreparedStatement prepareSql = connection.prepareStatement(sql);
			
			prepareSql.setString(1, objeto.getLogin());
			prepareSql.setString(2, objeto.getSenha());
			prepareSql.setString(3, objeto.getNome());
			prepareSql.setString(4, objeto.getEmail());
			
			prepareSql.executeUpdate();
			connection.commit();
			
		}
		
		return this.consultaUsuario(objeto.getLogin());
 
	}

	public ModelLogin consultaUsuario(String login) throws Exception {

		ModelLogin modelLogin = new ModelLogin();

		String sql = "select * from model_login where upper(login) = upper('" + login + "')";

		PreparedStatement statement = connection.prepareStatement(sql);

		ResultSet resultado = statement.executeQuery();

		while (resultado.next()) {/* se tem resultado */

			modelLogin.setId(resultado.getLong("id"));
			modelLogin.setEmail(resultado.getString("email"));
			modelLogin.setEmail(resultado.getString("login"));
			modelLogin.setEmail(resultado.getString("senha"));
			modelLogin.setEmail(resultado.getString("nome"));

		}

		return modelLogin;

	}

	public boolean validarLogin(String login) throws Exception {
		
		
			
		

		String sql = "select count(1) > 0 as existe from model_login where upper(login) = upper('" + login + "')";

		PreparedStatement statement = connection.prepareStatement(sql);

		ResultSet resultado = statement.executeQuery();

		resultado.next(); /* pra ele entrar nos resultados do sql */
		return resultado.getBoolean("existe");

	}

}
