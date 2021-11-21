package entities;

public class FuncionarioEntity {

    private Integer idFuncionario;
    private String nomeFuncionario;
    private Integer cargaHoraria;
    private String email;
    private String senha;
    private Integer devCoinFuncionario;
    private Integer pontosFuncionario;
    private Integer fkEmpresa;
    private Integer fkEquipe;
    
    private static FuncionarioEntity instance = new FuncionarioEntity();
    
    public static FuncionarioEntity getInstance() {
        return instance;
    }

    public Integer getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Integer idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    public Integer getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(Integer cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Integer getDevCoinFuncionario() {
        return devCoinFuncionario;
    }

    public void setDevCoinFuncionario(Integer devCoinFuncionario) {
        this.devCoinFuncionario = devCoinFuncionario;
    }

    public Integer getPontosFuncionario() {
        return pontosFuncionario;
    }

    public void setPontosFuncionario(Integer pontosFuncionario) {
        this.pontosFuncionario = pontosFuncionario;
    }

    public Integer getFkEmpresa() {
        return fkEmpresa;
    }

    public void setFkEmpresa(Integer fkEmpresa) {
        this.fkEmpresa = fkEmpresa;
    }

    public Integer getFkEquipe() {
        return fkEquipe;
    }

    public void setFkEquipe(Integer fkEquipe) {
        this.fkEquipe = fkEquipe;
    }

}
