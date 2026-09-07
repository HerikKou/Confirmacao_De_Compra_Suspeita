package Sistema_de_Confirmação_de_Compra_Suspeita;

public class Service {
    
public void executar() {
Cliente cliente = new Cliente("Herik", "123.456.789-10", "herik@gmail.com", "123456789101");
Cartao cartao = new Cartao("1234 5678 9012 3456", "31/27", "12/25", cliente );
Compra compra = new Compra("Produto A", 2000, cartao, "Loja A", "Cidade A");
Score score = new Score();   
int valor = score.validarValor(compra);
int data = score.validarData(compra);
int localizacao = score.validarLocalizacao(compra);
int estabelecimento = score.validarEstabelecimento(compra);
int calculoScore = score.cacularScore(compra);
Status status = score.definirStatus(calculoScore);

Score resultado = new Score(compra, calculoScore, status);

if (resultado.getStatus() == Status.AGUARDANDO_CONFIRMACAO) {
    Notificacao notificacao = new Notificacao(resultado, 5);
    notificacao.confirmar();
    Status statusFinal = notificacao.resolverStatusFinal(resultado, notificacao);
    resultado.setStatus(statusFinal);
     throw new IllegalArgumentException("Status: " + resultado.getStatus() + ", Resposta: " + notificacao.getResposta());
} else {
    throw new IllegalArgumentException("Status: " + resultado.getStatus() + " (decidido direto pelo score, sem necessidade de confirmação)");
}



}


}
