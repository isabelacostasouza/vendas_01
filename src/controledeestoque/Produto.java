package controledeestoque;

public class Produto {
    
    private String nome;
    private double valor;
    private double valorLiquido;
    private int quantidade;
    private int quantidadeDesejada;
    private String dataCompra;

    public String getNome() {
        return nome;
    }

    public int getQuantidade() {
        return this.quantidade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }

    public void setQuantidadeDesejada(int quantidadeDesejada) {
        this.quantidadeDesejada = quantidadeDesejada;
    }

    public int getQuantidadeDesejada() {
        return quantidadeDesejada;
    }

    public void setValorLiquido(double valorLiquido) {
        this.valorLiquido = valorLiquido;
    }

    public double getValorLiquido() {
        return valorLiquido;
    }

    public String getDataCompra() {
        return dataCompra;
    }
    
    public void setDataCompra(String dataCompra) {
        this.dataCompra = dataCompra;
    }

}
