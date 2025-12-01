import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    public void inserir(Usuario u) throws Exception {
        Connection conn = DAO.getConnection();
        String sql = "INSERT INTO usuario (nome, email) VALUES (?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1, u.getNome());
        stmt.setString(2, u.getEmail());
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            u.setId(rs.getInt(1));
        }
        rs.close();
        stmt.close();
        conn.close();
    }

    public List<Usuario> listar() throws Exception {
        Connection conn = DAO.getConnection();
        String sql = "SELECT idUsuario, nome, email FROM usuario";
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        List<Usuario> lista = new ArrayList<>();
        while (rs.next()) {
            lista.add(new Usuario(
                rs.getInt("idUsuario"),
                rs.getString("nome"),
                rs.getString("email")
            ));
        }
        rs.close();
        stmt.close();
        conn.close();
        return lista;
    }

    public void atualizar(Usuario u) throws Exception {
        Connection conn = DAO.getConnection();
        String sql = "UPDATE usuario SET nome = ?, email = ? WHERE idUsuario = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, u.getNome());
        stmt.setString(2, u.getEmail());
        stmt.setInt(3, u.getId());
        stmt.executeUpdate();
        stmt.close();
        conn.close();
    }

    public void deletar(int id) throws Exception {
        Connection conn = DAO.getConnection();
        String sql = "DELETE FROM usuario WHERE idUsuario = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.executeUpdate();
        stmt.close();
        conn.close();
    }
}
