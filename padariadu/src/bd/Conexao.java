package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private Connection con;

    // P.O.J.O - Plain Old Java Object
    public Connection getConnection() {
        return this.con;
    }

    public Conexao() {
        try {
            con = DriverManager.getConnection("jdbc:*****",
                    "****",
                    "****");
            System.out.println("Conectado!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
