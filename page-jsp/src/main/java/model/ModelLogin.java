package model;

import java.io.Serializable;
import java.util.Objects;

public class ModelLogin implements Serializable {

	/* Para parte de compilação das classes */
	private static final long serialVersionUID = 1L;

	
	private Long id;
	private String nome;
	private String email;
	private String login;
	private String senha;
	
	private String sexo;
	
	private boolean useradmin;
	
	private String fotouser;
	
	private String extensaofotouser;
	
	
	
	
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	public String getSexo() {
		return sexo;
	}
	
	private String perfil;
	
	public String getPerfil() {
		return perfil;
	}
	
	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
	
	
	public void setUseradmin(boolean useradmin) {
		this.useradmin = useradmin;
	}
	
	public boolean getUseradmin() {
		return useradmin;
	}
	
	
	public boolean isNovo() {	
		
		if(this.id == null) {
			return true;/*Inserir Novo*/
			
		}else if(this.id != null && this.id > 0) {
			return false ;/*Atualizar*/
			
		}
		
		return id == null;
	}

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
		return Objects.hash(nome, email, id);
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
		return Objects.equals(nome, other.nome) && Objects.equals(email, other.email) && Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "ModelLogin [id=" + id + ", Nome=" + nome + ", email=" + email + ", login=" + login + ", senha=" + senha
				+ "]";
	}
	

}
