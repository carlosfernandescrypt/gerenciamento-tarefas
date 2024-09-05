package br.com.gerenciamento.enums;

public enum Status {

    ATIVO("Pendente"),
    INATIVO("Concluido");

    private String status;

    private Status(String status) {
        this.status = status;
    }
}
