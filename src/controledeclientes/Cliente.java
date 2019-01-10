package controledeclientes;

public class Cliente {
    
    private String nome;
    private String telefone;
    private String endereco;
    
    private String bairro;
    private String rua;
    private String numero;
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    
    public String getEndereco() {
        return endereco;
    }

    public void setEndereco() {
        this.endereco = this.bairro + " - " + this.rua + ", " + this.numero;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

}
