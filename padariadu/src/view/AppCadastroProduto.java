package view;
// Nesta classe pode-se aplicar o Princípio da Substituição de Liskov
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import bd.TabelaProdutos;
import modelos.Produto;

public class AppCadastroProduto {

    private JFrame frame;
    private JTextField txtNomeProduto;
    private JTextField txtQtdEstoque;
    private JTextField txtPrecoProduto;
    private JTable table;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AppCadastroProduto window = new AppCadastroProduto();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public AppCadastroProduto() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 800, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblNomeProduto = new JLabel("Nome do Produto");
        lblNomeProduto.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblNomeProduto.setBounds(20, 38, 162, 27);
        frame.getContentPane().add(lblNomeProduto);

        txtNomeProduto = new JTextField();
        txtNomeProduto.setFont(new Font("Tahoma", Font.BOLD, 18));
        txtNomeProduto.setBounds(254, 38, 232, 26);
        frame.getContentPane().add(txtNomeProduto);

        txtQtdEstoque = new JTextField();
        txtQtdEstoque.setFont(new Font("Tahoma", Font.BOLD, 18));
        txtQtdEstoque.setColumns(10);
        txtQtdEstoque.setBounds(254, 74, 96, 26);
        frame.getContentPane().add(txtQtdEstoque);

        JLabel lblQtdEstoque = new JLabel("Quantidade em Estoque");
        lblQtdEstoque.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblQtdEstoque.setBounds(20, 80, 232, 27);
        frame.getContentPane().add(lblQtdEstoque);

        txtPrecoProduto = new JTextField();
        txtPrecoProduto.setFont(new Font("Tahoma", Font.BOLD, 18));
        txtPrecoProduto.setColumns(10);
        txtPrecoProduto.setBounds(254, 122, 96, 26);
        frame.getContentPane().add(txtPrecoProduto);

        JLabel lblPrecoProduto = new JLabel("Preço do Produto");
        lblPrecoProduto.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblPrecoProduto.setBounds(20, 122, 220, 27);
        frame.getContentPane().add(lblPrecoProduto);
        
        
        JButton btnInserir = new JButton("Inserir");
        btnInserir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Inserindo produto na tabela
                Produto produto = new Produto();
                produto.setNomeProduto(txtNomeProduto.getText());
                produto.setQtdEstoque(Integer.parseInt(txtQtdEstoque.getText()));
                produto.setPrecoProduto(Double.parseDouble(txtPrecoProduto.getText()));

                // Inserir na tabela e mostrar os dados
                TabelaProdutos tabela = new TabelaProdutos();
                tabela.insert(produto);
            }
        });
               
        btnInserir.setBounds(20, 220, 85, 21);
        frame.getContentPane().add(btnInserir);

        JButton btnListarProdutos = new JButton("Listar Produtos");
        btnListarProdutos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TabelaProdutos tabela = new TabelaProdutos();

                DefaultTableModel modelo = (DefaultTableModel) table.getModel();
                modelo.setNumRows(0);

                for (Produto produto : tabela.getAll()) {
                    modelo.addRow(new Object[] { produto.getIdProduto(), produto.getNomeProduto(),
                            produto.getQtdEstoque(), produto.getPrecoProduto() });
                }
            }
        });
        btnListarProdutos.setBounds(129, 220, 150, 21);
        frame.getContentPane().add(btnListarProdutos);
        
        JButton btnExcluirProduto = new JButton("Excluir Produto");
        btnExcluirProduto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
                DefaultTableModel modelo = (DefaultTableModel) table.getModel();
              
                if (table.getSelectedRow() != -1) {
                    int idProduto = (int) modelo.getValueAt(table.getSelectedRow(), 0);

                    Produto produto = new Produto();
                    produto.setIdProduto(idProduto);

                    TabelaProdutos tabela = new TabelaProdutos();
                    tabela.delete(produto);
                } else {
                    JOptionPane.showMessageDialog(frame, "Selecione um produto para excluir.");
                }
            }
        });
        btnExcluirProduto.setBounds(289, 219, 147, 23);
        frame.getContentPane().add(btnExcluirProduto);
        
       
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 280, 765, 120);
        frame.getContentPane().add(scrollPane);

        table = new JTable();
        scrollPane.setViewportView(table);
        table.setModel(new DefaultTableModel(
            new Object[][] {
                { null, null, null, null },
            },
            new String[] {
                "ID Produto", "Nome do Produto", "Quantidade em Estoque", "Preço do Produto"
            }
        ));
    }
}
