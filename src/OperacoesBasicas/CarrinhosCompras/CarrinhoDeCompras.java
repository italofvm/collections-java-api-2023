package OperacoesBasicas.CarrinhosCompras;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {

    private List<Item> itemsCarrinho;

    public CarrinhoDeCompras() {
        this.itemsCarrinho = new ArrayList<>();
    }

    public void adicionarItem(String nome, double preco, int quantidade){
        itemsCarrinho.add(new Item(nome, preco, quantidade));
    }

    public void removerItem(String nome) {
        List<Item> itemsParaRemover = new ArrayList<>();

        for (Item item: itemsCarrinho) {
            if (item.getNome().equalsIgnoreCase(nome)) {
                itemsParaRemover.add(item);
            }
        }

        itemsCarrinho.removeAll(itemsParaRemover);
    }

    public double calcularValorTotal() {
        double valorTotal = 0.0;

        for (Item item: itemsCarrinho) {
            double precoItem = item.getPreco();
            int quantidadeItem = item.getQuantidade();

            double valorParcialItem = precoItem * quantidadeItem;
            valorTotal += valorParcialItem;
        }

        return valorTotal;
    }

    public void exibirItens() {
        System.out.println(itemsCarrinho);
    }

    public static void main(String[] args) {
        CarrinhoDeCompras carrinhoDeCompras = new CarrinhoDeCompras();

        carrinhoDeCompras.adicionarItem("Calça Jeans", 35,2 );
        carrinhoDeCompras.adicionarItem("Calça Jeans", 35,2 );
        carrinhoDeCompras.adicionarItem( "Blusa sem manga", 20.90, 3);

        carrinhoDeCompras.exibirItens();
        System.out.println("Valor Total do Carrinho: " + carrinhoDeCompras.calcularValorTotal());

        carrinhoDeCompras.removerItem("Calça Jeans");

        carrinhoDeCompras.exibirItens();
        System.out.println("Valor Total do Carrinho: " + carrinhoDeCompras.calcularValorTotal());

        carrinhoDeCompras.adicionarItem( "Blusa com manga", 20.90, 1);

        carrinhoDeCompras.exibirItens();
        System.out.println("Valor Total do Carrinho: " + carrinhoDeCompras.calcularValorTotal());
    }
}
