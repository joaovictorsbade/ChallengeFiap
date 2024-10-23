package org.example.config;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import oracle.jdbc.pool.OracleDataSource;

public class Conexao {

    //SELECT * FROM v$locked_object;
    //SET AUTOCOMMIT ON;

    private static Connection conn;

    // Retorna uma única instância da conexão
    public static Connection getConnection() throws SQLException {
        if (conn == null || conn.isClosed()) {
            OracleDataSource ods = new OracleDataSource();
            ods.setURL("jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl");
            ods.setUser(Credenciais.user);
            ods.setPassword(Credenciais.pwd);
            conn = ods.getConnection();
            System.out.println("\nConexao.getConnection");
        }
        return conn;
    }

    // Fecha a conexão
    public static void fecharConexao() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
                System.out.println("Conexão fechada");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    public static class Credenciais {
//        public static final String user = "rm555446";//Colocar rm do usuario
//        public static final String pwd = "160805";//Inserir senha do usuario
//    }

    public static void Credenciais{
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o RM do usuário: ");
        String user = scanner.nextLine();

        System.out.println("Digite a senha do usuário: ");
        String pwd = scanner.nextLine();
    };


}

