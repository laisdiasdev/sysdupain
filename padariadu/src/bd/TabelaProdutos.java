package bd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelos.Produto;

public class TabelaProdutos {
    private List<Produto> produtos;

    public TabelaProdutos() {
        produtos = new ArrayList<Produto>();
    }

    public void insert(Produto produto) {
        Conexao conexao = new Conexao();
        try {
            Statement st = conexao.getConnection().createStatement();
            st.execute("INSERT INTO produtos (nomeProduto, qtdEstoque, precoProduto)"
            		+ "VALUES ('" + produto.getNomeProduto()
                    + "'," + produto.getQtdEstoque()
                    + "," + produto.getPrecoProduto()
                    + ");");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void delete(Produto produto) {
        String query = "DELETE FROM produtos WHERE idProduto = " + produto.getIdProduto();

        Conexao con = new Conexao();
        try {
            Statement stmt = con.getConnection().createStatement();
            stmt.execute(query);
            produtos.remove(produto);
        	} catch (SQLException e) {
            e.printStackTrace();
        }
     }

    public List<Produto> getAll() {
        Conexao conexao = new Conexao();

        try {
            Statement stmt = conexao.getConnection().createStatement();
            stmt.execute("SELECT * FROM produtos");
            ResultSet rs = stmt.getResultSet();

            produtos.clear();

            while (rs.next()) {
                Produto produto = new Produto();
                produto.setIdProduto(rs.getInt("idProduto"));
                produto.setNomeProduto(rs.getString("nomeProduto"));
                produto.setQtdEstoque(rs.getInt("qtdEstoque"));
                produto.setPrecoProduto(rs.getDouble("precoProduto"));

                produtos.add(produto);
            }

            return produtos;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }   
}
