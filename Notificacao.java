package Sistema_de_Confirmação_de_Compra_Suspeita;



import java.time.LocalDateTime;

public class Notificacao {
    private Score score;
    private LocalDateTime enviadaEm;
    private LocalDateTime expiraEm;
    private RespostaCliente resposta;
public Notificacao(){}
    public Notificacao(Score score, int minutosParaExpirar) {
        this.score = score;
        this.enviadaEm = LocalDateTime.now();
        this.expiraEm = enviadaEm.plusMinutes(minutosParaExpirar);
        this.resposta = RespostaCliente.PENDENTE;
    }

    public boolean expirou() {
        return LocalDateTime.now().isAfter(expiraEm);
    }

    public void confirmar() {
        if (expirou()) {
            this.resposta = RespostaCliente.EXPIRADA;
        } else {
            this.resposta = RespostaCliente.CONFIRMADA;
        }
    }

    public void negar() {
        this.resposta = RespostaCliente.NEGADA;
    }

    public RespostaCliente getResposta() {
        return resposta;
    }

    public Score getScore() {
        return score;
    }
    public Status resolverStatusFinal(Score score, Notificacao notificacao) {
    if (score.getStatus() == Status.AGUARDANDO_CONFIRMACAO) {
        if (notificacao.getResposta() == RespostaCliente.CONFIRMADA) {
            return Status.APROVADO;
        } else {
            
            return Status.REPROVADO;
        }
    }
    return score.getStatus();
}
}