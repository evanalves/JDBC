package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import connection.SingleConnectionBanco;
import model.ModelLogin;

public class DAOUsuarioRepository {

	private Connection connection;

	public DAOUsuarioRepository() {

		connection = SingleConnectionBanco.getConnection();

	}

	public void gravarUser(ModelLogin objeto) throws Exception {

		//try {

			String sql = " INSERT INTO model_login (login, senha, nome, email)  VALUES (?, ?, ?, ?)";
			
			PreparedStatement preparedSql = connection.prepareStatement(sql);
			preparedSql.setString(1, objeto.getLogin());
			preparedSql.setString(2, objeto.getSenha());
			preparedSql.setString(3, objeto.getNome());
			preparedSql.setString(4, objeto.getEmail());
			
			preparedSql.execute();
			connection.commit();

		//} catch (Exception e) {
			//e.printStackTrace();
		//}

	}

}
