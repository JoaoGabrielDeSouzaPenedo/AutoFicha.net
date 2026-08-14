package br.com.autoficha.backend.entity;

import br.com.autoficha.backend.enums.Genero;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "personagens")
public class Personagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // =========================
    // DONO DA FICHA
    // =========================

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;


    // =========================
    // DADOS PRINCIPAIS
    // =========================

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(length = 100)
    private String jogador;

    @Column(length = 100)
    private String antecedente;

    @Column(length = 100)
    private String campanha;

    @Column(name = "manual_de_luta", length = 100)
    private String manualDeLuta;

    @Column(length = 100)
    private String defeito;

    @Column(name = "pt_gastos")
    private Integer ptGastos = 0;

    private Integer refinamento = 0;

    private Integer maestria = 0;

    @Column(length = 100)
    private String profissao;


    // =========================
    // REGISTRO / APARÊNCIA
    // =========================

    private Integer idade;

    @Column(precision = 5, scale = 2)
    private BigDecimal altura;

    @Column(precision = 6, scale = 2)
    private BigDecimal peso;

    @Enumerated(EnumType.STRING)
    private Genero genero;

    @Column(length = 100)
    private String cabelos;

    @Column(length = 100)
    private String olhos;

    @Column(length = 100)
    private String pele;

    @Column(length = 255)
    private String roupas;

    @Column(length = 255)
    private String marca;

    @Column(name = "imagem_url", length = 500)
    private String imagemUrl;


    // =========================
    // TEXTOS LIVRES DA FICHA
    // =========================

    @Column(columnDefinition = "TEXT")
    private String ideias;

    @Column(columnDefinition = "TEXT")
    private String ligacoes;

    @Column(columnDefinition = "TEXT")
    private String complicacoes;

    @Column(name = "rd_resistencias", columnDefinition = "TEXT")
    private String rdResistencias;

    @Column(
            name = "caracteristicas_antecedente",
            columnDefinition = "TEXT"
    )
    private String caracteristicasAntecedente;

    @Column(columnDefinition = "TEXT")
    private String passivas;

    @Column(columnDefinition = "TEXT")
    private String anotacoes;


    // =========================
    // DINHEIRO / INVENTÁRIO
    // =========================

    @Column(precision = 12, scale = 2)
    private BigDecimal dinheiro = BigDecimal.ZERO;

    @Column(name = "limite_espaco", precision = 8, scale = 2)
    private BigDecimal limiteEspaco = BigDecimal.ZERO;


    // =========================
    // RELACIONAMENTOS 1 PARA 1
    // =========================

    @OneToOne(
            mappedBy = "personagem",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private Atributos atributos;

    @OneToOne(
            mappedBy = "personagem",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private Recursos recursos;

    @OneToOne(
            mappedBy = "personagem",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private Combate combate;

    @OneToOne(
            mappedBy = "personagem",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private PerfilAlma perfilAlma;


    // =========================
    // LISTAS DA FICHA
    // =========================

    @OneToMany(
            mappedBy = "personagem",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<PericiaPersonagem> pericias = new ArrayList<>();

    @OneToMany(
            mappedBy = "personagem",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Ataque> ataques = new ArrayList<>();

    @OneToMany(
            mappedBy = "personagem",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<HabilidadeTreino> habilidadesTreino = new ArrayList<>();

    @OneToMany(
            mappedBy = "personagem",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<ItemInventario> inventario = new ArrayList<>();

    @OneToMany(
            mappedBy = "personagem",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<TotemInventario> totens = new ArrayList<>();

    @OneToMany(
            mappedBy = "personagem",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Dom> dons = new ArrayList<>();

    @OneToMany(
            mappedBy = "personagem",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Pacto> pactos = new ArrayList<>();


    // =========================
    // DATAS
    // =========================

    private LocalDateTime dataCriacao;

    private LocalDateTime dataAtualizacao;


    // =========================
    // CONSTRUTOR
    // =========================

    public Personagem() {
    }


    // =========================
    // CICLO DE VIDA JPA
    // =========================

    @PrePersist
    public void prePersist() {

        LocalDateTime agora = LocalDateTime.now();

        this.dataCriacao = agora;
        this.dataAtualizacao = agora;
    }

    @PreUpdate
    public void preUpdate() {

        this.dataAtualizacao = LocalDateTime.now();
    }


    // =========================
    // GETTERS E SETTERS
    // =========================

    public Long getId() {
        return id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getJogador() {
        return jogador;
    }

    public void setJogador(String jogador) {
        this.jogador = jogador;
    }

    public String getAntecedente() {
        return antecedente;
    }

    public void setAntecedente(String antecedente) {
        this.antecedente = antecedente;
    }

    public String getCampanha() {
        return campanha;
    }

    public void setCampanha(String campanha) {
        this.campanha = campanha;
    }

    public String getManualDeLuta() {
        return manualDeLuta;
    }

    public void setManualDeLuta(String manualDeLuta) {
        this.manualDeLuta = manualDeLuta;
    }

    public String getDefeito() {
        return defeito;
    }

    public void setDefeito(String defeito) {
        this.defeito = defeito;
    }

    public Integer getPtGastos() {
        return ptGastos;
    }

    public void setPtGastos(Integer ptGastos) {
        this.ptGastos = ptGastos;
    }

    public Integer getRefinamento() {
        return refinamento;
    }

    public void setRefinamento(Integer refinamento) {
        this.refinamento = refinamento;
    }

    public Integer getMaestria() {
        return maestria;
    }

    public void setMaestria(Integer maestria) {
        this.maestria = maestria;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public BigDecimal getAltura() {
        return altura;
    }

    public void setAltura(BigDecimal altura) {
        this.altura = altura;
    }

    public BigDecimal getPeso() {
        return peso;
    }

    public void setPeso(BigDecimal peso) {
        this.peso = peso;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public String getCabelos() {
        return cabelos;
    }

    public void setCabelos(String cabelos) {
        this.cabelos = cabelos;
    }

    public String getOlhos() {
        return olhos;
    }

    public void setOlhos(String olhos) {
        this.olhos = olhos;
    }

    public String getPele() {
        return pele;
    }

    public void setPele(String pele) {
        this.pele = pele;
    }

    public String getRoupas() {
        return roupas;
    }

    public void setRoupas(String roupas) {
        this.roupas = roupas;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getImagemUrl() {
        return imagemUrl;
    }

    public void setImagemUrl(String imagemUrl) {
        this.imagemUrl = imagemUrl;
    }

    public String getIdeias() {
        return ideias;
    }

    public void setIdeias(String ideias) {
        this.ideias = ideias;
    }

    public String getLigacoes() {
        return ligacoes;
    }

    public void setLigacoes(String ligacoes) {
        this.ligacoes = ligacoes;
    }

    public String getComplicacoes() {
        return complicacoes;
    }

    public void setComplicacoes(String complicacoes) {
        this.complicacoes = complicacoes;
    }

    public String getRdResistencias() {
        return rdResistencias;
    }

    public void setRdResistencias(String rdResistencias) {
        this.rdResistencias = rdResistencias;
    }

    public String getCaracteristicasAntecedente() {
        return caracteristicasAntecedente;
    }

    public void setCaracteristicasAntecedente(
            String caracteristicasAntecedente
    ) {
        this.caracteristicasAntecedente =
                caracteristicasAntecedente;
    }

    public String getPassivas() {
        return passivas;
    }

    public void setPassivas(String passivas) {
        this.passivas = passivas;
    }

    public String getAnotacoes() {
        return anotacoes;
    }

    public void setAnotacoes(String anotacoes) {
        this.anotacoes = anotacoes;
    }

    public BigDecimal getDinheiro() {
        return dinheiro;
    }

    public void setDinheiro(BigDecimal dinheiro) {
        this.dinheiro = dinheiro;
    }

    public BigDecimal getLimiteEspaco() {
        return limiteEspaco;
    }

    public void setLimiteEspaco(BigDecimal limiteEspaco) {
        this.limiteEspaco = limiteEspaco;
    }


    // =========================
    // ATRIBUTOS
    // =========================

    public Atributos getAtributos() {
        return atributos;
    }

    public void setAtributos(Atributos atributos) {

        this.atributos = atributos;

        if (atributos != null) {
            atributos.setPersonagem(this);
        }
    }


    // =========================
    // RECURSOS
    // =========================

    public Recursos getRecursos() {
        return recursos;
    }

    public void setRecursos(Recursos recursos) {

        this.recursos = recursos;

        if (recursos != null) {
            recursos.setPersonagem(this);
        }
    }


    // =========================
    // COMBATE
    // =========================

    public Combate getCombate() {
        return combate;
    }

    public void setCombate(Combate combate) {

        this.combate = combate;

        if (combate != null) {
            combate.setPersonagem(this);
        }
    }


    // =========================
    // PERFIL DA ALMA
    // =========================

    public PerfilAlma getPerfilAlma() {
        return perfilAlma;
    }

    public void setPerfilAlma(PerfilAlma perfilAlma) {

        this.perfilAlma = perfilAlma;

        if (perfilAlma != null) {
            perfilAlma.setPersonagem(this);
        }
    }


    // =========================
    // PERÍCIAS
    // =========================

    public List<PericiaPersonagem> getPericias() {
        return pericias;
    }

    public void setPericias(
            List<PericiaPersonagem> pericias
    ) {

        this.pericias.clear();

        if (pericias != null) {

            for (PericiaPersonagem pericia : pericias) {
                adicionarPericia(pericia);
            }
        }
    }

    public void adicionarPericia(
            PericiaPersonagem pericia
    ) {

        if (pericia != null) {
            pericia.setPersonagem(this);
            this.pericias.add(pericia);
        }
    }


    // =========================
    // ATAQUES
    // =========================

    public List<Ataque> getAtaques() {
        return ataques;
    }

    public void setAtaques(List<Ataque> ataques) {

        this.ataques.clear();

        if (ataques != null) {

            for (Ataque ataque : ataques) {
                adicionarAtaque(ataque);
            }
        }
    }

    public void adicionarAtaque(Ataque ataque) {

        if (ataque != null) {
            ataque.setPersonagem(this);
            this.ataques.add(ataque);
        }
    }


    // =========================
    // HABILIDADES DE TREINO
    // =========================

    public List<HabilidadeTreino> getHabilidadesTreino() {
        return habilidadesTreino;
    }

    public void setHabilidadesTreino(
            List<HabilidadeTreino> habilidadesTreino
    ) {

        this.habilidadesTreino.clear();

        if (habilidadesTreino != null) {

            for (HabilidadeTreino habilidade : habilidadesTreino) {
                adicionarHabilidadeTreino(habilidade);
            }
        }
    }

    public void adicionarHabilidadeTreino(
            HabilidadeTreino habilidade
    ) {

        if (habilidade != null) {
            habilidade.setPersonagem(this);
            this.habilidadesTreino.add(habilidade);
        }
    }


    // =========================
    // INVENTÁRIO
    // =========================

    public List<ItemInventario> getInventario() {
        return inventario;
    }

    public void setInventario(
            List<ItemInventario> inventario
    ) {

        this.inventario.clear();

        if (inventario != null) {

            for (ItemInventario item : inventario) {
                adicionarItemInventario(item);
            }
        }
    }

    public void adicionarItemInventario(
            ItemInventario item
    ) {

        if (item != null) {
            item.setPersonagem(this);
            this.inventario.add(item);
        }
    }


    // =========================
    // TOTENS
    // =========================

    public List<TotemInventario> getTotens() {
        return totens;
    }

    public void setTotens(
            List<TotemInventario> totens
    ) {

        this.totens.clear();

        if (totens != null) {

            for (TotemInventario totem : totens) {
                adicionarTotem(totem);
            }
        }
    }

    public void adicionarTotem(
            TotemInventario totem
    ) {

        if (totem != null) {
            totem.setPersonagem(this);
            this.totens.add(totem);
        }
    }


    // =========================
    // DONS
    // =========================

    public List<Dom> getDons() {
        return dons;
    }

    public void setDons(List<Dom> dons) {

        this.dons.clear();

        if (dons != null) {

            for (Dom dom : dons) {
                adicionarDom(dom);
            }
        }
    }

    public void adicionarDom(Dom dom) {

        if (dom != null) {
            dom.setPersonagem(this);
            this.dons.add(dom);
        }
    }


    // =========================
    // PACTOS
    // =========================

    public List<Pacto> getPactos() {
        return pactos;
    }

    public void setPactos(List<Pacto> pactos) {

        this.pactos.clear();

        if (pactos != null) {

            for (Pacto pacto : pactos) {
                adicionarPacto(pacto);
            }
        }
    }

    public void adicionarPacto(Pacto pacto) {

        if (pacto != null) {
            pacto.setPersonagem(this);
            this.pactos.add(pacto);
        }
    }


    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public LocalDateTime getDataAtualizacao() {
        return dataAtualizacao;
    }
}