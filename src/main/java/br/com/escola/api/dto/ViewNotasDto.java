package br.com.escola.api.dto;

import br.com.escola.api.model.ViewNotas;

public class ViewNotasDto {

        private Long cd_aluno;
        private String nome;
        private long matricula;
        private String status;
        private String disciplina;
        private Long cd_notas;
        private double nota;
        private String tipo_nota;

        public ViewNotasDto(){}

    public ViewNotasDto(ViewNotas view) {
        this.cd_aluno = view.getCd_aluno();
        this.nome = view.getNome();
        this.matricula = view.getMatricula();
        this.status = view.getStatus();
        this.disciplina = view.getDisciplina();
        this.cd_notas = view.getCd_notas();
        this.nota = view.getNota();
        this.tipo_nota = view.getTipo_nota();
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



