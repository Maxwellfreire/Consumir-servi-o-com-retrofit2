package br.com.treinamento.listausuario.model;

public class Company extends Users{

    public String nome;
    public  String catchphrase;
    public String bs;

    public Company() {
    }

    public Company(String nome, String catchphrase, String bs) {
        this.nome = nome;
        this.catchphrase = catchphrase;
        this.bs = bs;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCatchphrase() {
        return catchphrase;
    }

    public void setCatchphrase(String catchphrase) {
        this.catchphrase = catchphrase;
    }

    public String getBs() {
        return bs;
    }

    public void setBs(String bs) {
        this.bs = bs;
    }

    @Override
    public String toString() {
        return "Company{" +
                "nome='" + nome + '\'' +
                ", catchphrase='" + catchphrase + '\'' +
                ", bs='" + bs + '\'' +
                '}';
    }
}
