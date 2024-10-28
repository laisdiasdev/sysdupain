package modelos;

public class Pedido extends Produto{

    public String nomeCliente;
    public String produto;
    public int quantidade;

    // Construtor padrão
    public Pedido() {
    }

    // Construtor com parâmetros
    public Pedido(String nomeCliente, String produto, Integer quantidade) {
        this.nomeCliente = nomeCliente;
        this.produto = produto;
        this.quantidade = quantidade;
    }

    // Getters e setters
    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    // Método para emitir a nota fiscal
    public void emitirNotaFiscal() {
        System.out.println("Nota fiscal emitida para o cliente: " + nomeCliente);
        System.out.println("Produto: " + produto);
        System.out.println("Quantidade: " + quantidade);
    }
}
