import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ComentarioDAO {

    public void inserir(Comentario c) throws Exception {
        Connection conn = DAO.getConnection();
        String sql = "INSERT INTO comentario (idReceita, idUsuario, conteudo) VALUES (?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        stmt.setInt(1, c.getIdReceita());
        if (c.getIdUsuario() == null) {
            stmt.setNull(2, java.sql.Types.INTEGER);
        } else {
            stmt.setInt(2, c.getIdUsuario());
        }
        stmt.setString(3, c.getConteudo());
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            c.setId(rs.getInt(1));
        }
        rs.close();
        stmt.close();
        conn.close();
    }

    public List<Comentario> listar() throws Exception {
        Connection conn = DAO.getConnection();
        String sql = "SELECT idComentario, idReceita, idUsuario, conteudo FROM comentario";
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        List<Comentario> lista = new ArrayList<>();
        while (rs.next()) {
            Integer idUsu = (Integer) rs.getObject("idUsuario");
            lista.add(new Comentario(
                rs.getInt("idComentario"),
                rs.getInt("idReceita"),
                idUsu,
                rs.getString("conteudo")
            ));
        }
        rs.close();
        stmt.close();
        conn.close();
        return lista;
    }

    public void atualizar(Comentario c) throws Exception {
        Connection conn = DAO.getConnection();
        String sql = "UPDATE comentario SET idReceita = ?, idUsuario = ?, conteudo = ? WHERE idComentario = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, c.getIdReceita());
        if (c.getIdUsuario() == null) {
            stmt.setNull(2, java.sql.Types.INTEGER);
        } else {
            stmt.setInt(2, c.getIdUsuario());
        }
        stmt.setString(3, c.getConteudo());
        stmt.setInt(4, c.getId());
        stmt.executeUpdate();
        stmt.close();
        conn.close();
    }

    public void deletar(int id) throws Exception {
        Connection conn = DAO.getConnection();
        String sql = "DELETE FROM comentario WHERE idComentario = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.executeUpdate();
        stmt.close();
        conn.close();
    }
}
