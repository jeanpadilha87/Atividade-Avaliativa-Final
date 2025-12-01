public class Comentario {

    private int id;
    private int idReceita;
    private Integer idUsuario;
    private String conteudo;

    public Comentario() { }

    public Comentario(int id, int idReceita, Integer idUsuario, String conteudo) {
        this.id = id;
        this.idReceita = idReceita;
        this.idUsuario = idUsuario;
        this.conteudo = conteudo;
    }

    public Comentario(int idReceita, Integer idUsuario, String conteudo) {
        this.idReceita = idReceita;
        this.idUsuario = idUsuario;
        this.conteudo = conteudo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdReceita() {
        return idReceita;
    }

    public void setIdReceita(int idReceita) {
        this.idReceita = idReceita;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    @Override
    public String toString() {
        return id + " - " + conteudo;
    }
}
