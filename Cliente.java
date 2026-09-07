package Sistema_de_Confirmação_de_Compra_Suspeita;

public class Cliente {
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    public Cliente(String nome, String cpf, String email, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        if(nome.length() > 0){
            this.nome = nome;
        } else {
            throw new IllegalArgumentException("Nome inválido. Não pode ser vazio.");
        }
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        if(cpf.length() == 11){
            this.cpf = cpf;
        } else {
             throw new IllegalArgumentException("CPF inválido. Deve conter 11 dígitos.");
        }
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
       if(email.contains("@gmail.com") || email.contains("@hotmail.com") || email.contains("@yahoo.com")){
            this.email = email;
        } else {
             throw new IllegalArgumentException("Email inválido. Deve conter '@'.");
        }
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        if(telefone.length() == 11){
            this.telefone = telefone;
        } else {
             throw new IllegalArgumentException("Telefone inválido. Deve conter 11 dígitos.");
        }
    }
    
}
