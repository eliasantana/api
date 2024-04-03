package br.com.escola.api.model;

import br.com.escola.api.dto.ViewNotasDto;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "view_notas")
public class ViewNotas {
    @Id
    private Long cd_aluno;
    private String nome;
    private long matricula;
    private String status;
    private String disciplina;
    private Long cd_notas;
    private double nota;
    private String tipo_nota;

    public ViewNotas(){}

    public ViewNotas(ViewNotasDto dto) {
        this.cd_aluno = dto.getCd_aluno();
        this.nome = dto.getNome();
        this.matricula = dto.getMatricula();
        this.status = dto.getStatus();
        this.disciplina = dto.getDisciplina();
        this.cd_notas = dto.getCd_notas();
        this.nota = dto.getNota();
        this.tipo_nota = dto.getTipo_nota();
    }

    public Long getCd_aluno() {
        return cd_aluno;
    }

    public void setCd_aluno(Long cd_aluno) {
        this.cd_aluno = cd_aluno;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getMatricula() {
        return matricula;
    }

    public void setMatricula(long matricula) {
        this.matricula = matricula;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public Long getCd_notas() {
        return cd_notas;
    }

    public void setCd_notas(Long cd_notas) {
        this.cd_notas = cd_notas;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public String getTipo_nota() {
        return tipo_nota;
    }

    public void setTipo_nota(String tipo_nota) {
        this.tipo_nota = tipo_nota;
    }

    @Override
    public String toString() {
        return "ViewNotas{" +
                "cd_aluno=" + cd_aluno +
                ", nome='" + nome + '\'' +
                ", localizador=" + matricula +
                ", status='" + status + '\'' +
                ", disciplina='" + disciplina + '\'' +
                ", cd_notas=" + cd_notas +
                ", nota=" + nota +
                ", tipo_nota='" + tipo_nota + '\'' +
                '}';
    }
}
