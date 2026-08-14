package br.com.autoficha.backend.entity;

import br.com.autoficha.backend.enums.GrauProficiencia;
import br.com.autoficha.backend.enums.TipoTesteResistencia;
import jakarta.persistence.*;

@Entity
@Table(name = "testes_resistencia")
public class TesteResistencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoTesteResistencia tipo;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private GrauProficiencia grauProficiencia;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "personagem_id", nullable = false)
    private Personagem personagem;

    public TesteResistencia() {
    }

    public TesteResistencia(
            TipoTesteResistencia tipo,
            GrauProficiencia grauProficiencia,
            Personagem personagem
    ) {
        this.tipo = tipo;
        this.grauProficiencia = grauProficiencia;
        this.personagem = personagem;
    }

    public Long getId() {
        return id;
    }

    public TipoTesteResistencia getTipo() {
        return tipo;
    }

    public void setTipo(TipoTesteResistencia tipo) {
        this.tipo = tipo;
    }

    public GrauProficiencia getGrauProficiencia() {
        return grauProficiencia;
    }

    public void setGrauProficiencia(GrauProficiencia grauProficiencia) {
        this.grauProficiencia = grauProficiencia;
    }

    public Personagem getPersonagem() {
        return personagem;
    }

    public void setPersonagem(Personagem personagem) {
        this.personagem = personagem;
    }
}