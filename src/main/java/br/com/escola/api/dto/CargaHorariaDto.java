package br.com.escola.api.dto;

import br.com.escola.api.model.Professor;

import java.math.BigDecimal;

public class CargaHorariaDto {

    private ProfessorDto professor;
    private BigDecimal cargaHorariaTotal;

    public CargaHorariaDto(){

    }
    public ProfessorDto getProfessor() {
        return professor;
    }

    public void setProfessor(ProfessorDto professor) {
        this.professor = professor;
    }

    public BigDecimal getCargaHorariaTotal() {
        return cargaHorariaTotal;
    }

    public void setCargaHorariaTotal(BigDecimal cargaHorariaTotal) {
        this.cargaHorariaTotal = cargaHorariaTotal;
    }

    @Override
    public String toString() {
        return "CargaHorariaDto{" +
                "professor=" + professor +
                ", cargaHorariaTotal=" + cargaHorariaTotal +
                '}';
    }
}
