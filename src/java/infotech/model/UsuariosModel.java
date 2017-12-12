package infotech.model;

public class UsuariosModel {

    private int idUsu;
    private String nome;
    private String cpf;
    private String endereco;
    private String telefone;
    private String email;
    private String senha;
    private String tipo;

    public UsuariosModel(int idUsu, String email, String senha) {
        this.idUsu = idUsu;
        this.email = email;
        this.senha = senha;
    }

    public UsuariosModel(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }

    public UsuariosModel(String nome, String cpf, String endereco, String telefone, String email, String senha, String tipo) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
        this.senha = senha;
        this.tipo = tipo;
    }

    public UsuariosModel(int idUsu, String nome, String cpf, String endereco, String telefone, String email, String senha, String tipo) {
        this.idUsu = idUsu;
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
        this.senha = senha;
        this.tipo = tipo;
    }

    public int getIdUsu() {
        return idUsu;
    }

    public void setIdUsu(int idUsu) {
        this.idUsu = idUsu;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    
}
