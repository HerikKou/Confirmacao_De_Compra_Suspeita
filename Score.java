package Sistema_de_Confirmação_de_Compra_Suspeita;


import java.time.LocalTime;

public class Score {
    private Compra compra;
    private int score;
    private Status status;
    private String motivo ;
    public Score(){}
    public Score(Compra compra, int score, Status status, String motivo) {
        this.compra = compra;
        this.score = score;
        this.status = status;
        this.motivo = motivo;
    }
    public Compra getCompra() {
        return compra;
    }
    
    public void setCompra(Compra compra) {
        this.compra = compra;
    }
    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }
    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
       if(status == Status.APROVADO || status == Status.REPROVADO || status == Status.AGUARDANDO_CONFIRMACAO){
    this.status = status;
} else {
                System.out.println("Status inválido.");
        }
    }
    
    public int validarValor(Compra compra) {
        if(compra.getValor() > 4000){
            return 30;
        } else {
            return 20;
        }
    }
public int validarData(Compra compra) {
    LocalTime inicio = LocalTime.of(0, 0);
    LocalTime fim = LocalTime.of(5, 0);
    LocalTime horaCompra = compra.getData().toLocalTime();

    if (!horaCompra.isBefore(inicio) && horaCompra.isBefore(fim)) {
        return 20;
    } else {
        return 10;
    }
}
    public int validarLocalizacao(Compra compra){
        if(compra.getLocalizacao().equals("Brasil")){
            return 10;
        } else {
            return 20;
        }
    }
    public  int validarEstabelecimento(Compra compra){
        if(compra.getEstabelecimento().equals("Loja A")){
            return 10;
        } else {
            return 20;
        }
    }
    public int cacularScore(Compra compra){
        return validarValor(compra) + validarData(compra) + validarLocalizacao(compra) + validarEstabelecimento(compra);
    }
    public Status definirStatus(double score){
        if(score >= 70){
            return  Status.REPROVADO;
        }
        else if(score >= 40){
            return Status.AGUARDANDO_CONFIRMACAO;

        }
        else {
        return Status.APROVADO;        
    }
    }
    public String definirMotivo(Status status){
       if(status == Status.APROVADO){
    return "Compra aprovada.";
} else if(status == Status.AGUARDANDO_CONFIRMACAO){
    return "Aguardando confirmação do cliente.";
} else {
    return "Compra reprovada por conta de risco.";
}
    }
    public String getMotivo() {
        return motivo;
    }
    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
}
