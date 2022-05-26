package model;

import java.io.Serializable;
import java.util.Objects;

public class ModelLogin implements Serializable {

	/* Para parte de compilação das classes */
	private static final long serialVersionUID = 1L;

	private Long id;
	private String Nome;
	private String email;
	private String login;
	private String senha;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
	

	@Override
	public int hashCode() {
		return Objects.hash(Nome, email, id);
	}

	
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ModelLogin other = (ModelLogin) obj;
		return Objects.equals(Nome, other.Nome) && Objects.equals(email, other.email) && Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "ModelLogin [id=" + id + ", Nome=" + Nome + ", email=" + email + ", login=" + login + ", senha=" + senha
				+ "]";
	}
	

}
