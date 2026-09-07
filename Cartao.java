package Sistema_de_Confirmação_de_Compra_Suspeita;

public class Cartao {
    private String numero;
    private String validade;
    private String cvv;
    private Cliente cliente;
    public Cartao(String numero, String validade, String cvv, Cliente cliente) {
        this.numero = numero;
        this.validade = validade;
        this.cvv = cvv;
        this.cliente = cliente;
    }
    public String getNumero() {
        return numero;
    }
    public String getValidade() {
        return validade;
    }
    public String getCvv() {
        return cvv;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public void setNumero(String numero) {
        if(numero.length() == 16){
            this.numero = numero;
        } else {
            System.out.println("Número do cartão inválido. Deve conter 16 dígitos.");
        }
    }
    public void setValidade(String validade) {
        if(validade.matches("\\d{2}/\\d{2}")){
            this.validade = validade;
        } else {
            System.out.println("Validade inválida. Deve estar no formato MM/AA.");
        }
    }
    public void setCvv(String cvv) {
        if(cvv.length() == 3){
            this.cvv = cvv;
        } else {
            System.out.println("CVV inválido. Deve conter 3 dígitos.");
        }
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
}
