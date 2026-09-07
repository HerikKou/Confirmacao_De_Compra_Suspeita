package Sistema_de_Confirmação_de_Compra_Suspeita;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Compra {
    
private String produto;
    private double valor;
    private Cartao cartao;
    private LocalDateTime data = LocalDateTime.now();
    private String estabelecimento;
    private String localizacao;
    public Compra(String produto, double valor, Cartao cartao, String estabelecimento, String localizacao) {
        this.produto = produto;
        this.valor = valor;
        this.cartao = cartao;
        this.estabelecimento = estabelecimento;
        this.localizacao = localizacao;
    }
    public String getProduto() {
        return produto;
    }
    public void setProduto(String produto) {
        if(produto.length() > 0){
            this.produto = produto;
        } else {
            System.out.println("Produto inválido. Não pode ser vazio.");
        }
    }
    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        if(valor > 0){
            this.valor = valor;
        } else {
            System.out.println("Valor inválido. Deve ser maior que zero.");
        }
    }
    public Cartao getCartao() {
        return cartao;
    }
    public void setCartao(Cartao cartao) {
        this.cartao = cartao;
    }
    public LocalDateTime getData() {
        return data;
    }
    public String getEstabelecimento() {
        return estabelecimento;
    }
    public void setEstabelecimento(String estabelecimento) {
       if(estabelecimento.length() > 0){
            this.estabelecimento = estabelecimento;
        } else {
            System.out.println("Estabelecimento inválido. Não pode ser vazio.");
        }
    }
    public String getLocalizacao() {
        return localizacao;
    }
    public void setLocalizacao(String localizacao) {
        if(localizacao.length() > 0){
            this.localizacao = localizacao;
        } else {
            System.out.println("Localização inválida. Não pode ser vazio.");
        }
    }

}
