import { useState } from "react";
import { useNavigate } from "react-router-dom";
import api from "../api/api";

function NovoPersonagem() {

    const navigate = useNavigate();

    const [form, setForm] = useState({

        nome: "",
        jogador: "",
        campanha: "",
        profissao: "",

        antecedente: "",
        familiaNobre: "",
        defeito: "",

        refinamento: 0,
        maestria: 0,

        idade: "",
        genero: "",

        cabelos: "",
        olhos: "",
        pele: "",
        roupas: "",
        marca: "",

        ideias: "",
        ligacoes: "",
        complicacoes: "",
        anotacoes: ""
    });

    const [erro, setErro] = useState("");
    const [carregando, setCarregando] = useState(false);

    function alterarCampo(event) {

        const { name, value } = event.target;

        setForm((anterior) => ({
            ...anterior,
            [name]: value
        }));
    }

    async function criar(event) {

        event.preventDefault();

        setErro("");
        setCarregando(true);

        try {

            const dados = {

                ...form,

                refinamento: Number(form.refinamento),
                maestria: Number(form.maestria),

                idade:
                    form.idade === ""
                        ? null
                        : Number(form.idade),

                antecedente:
                    form.antecedente || null,

                familiaNobre:
                    form.familiaNobre || null,

                defeito:
                    form.defeito || null,

                genero:
                    form.genero || null
            };

            const response = await api.post(
                "/personagens",
                dados
            );

            if (response.data?.id) {

                navigate(
                    `/personagens/${response.data.id}`
                );

            } else {

                navigate("/personagens");
            }

        } catch (error) {

            console.error(error);

            setErro(
                error.response?.data?.mensagem ||
                error.response?.data?.message ||
                "Não foi possível criar o personagem."
            );

        } finally {

            setCarregando(false);
        }
    }

    return (
        <div className="novo-personagem-page">

            <div className="pagina-cabecalho">

                <button
                    className="botao-secundario"
                    onClick={() => navigate("/personagens")}
                >
                    ← Voltar
                </button>

                <div>
                    <h1>Novo Personagem</h1>
                    <p>Preencha os dados iniciais da ficha.</p>
                </div>

            </div>

            <form
                className="ficha-formulario"
                onSubmit={criar}
            >

                <section className="ficha-secao">

                    <h2>Dados principais</h2>

                    <div className="form-grid">

                        <div>

                            <label>Nome</label>

                            <input
                                name="nome"
                                value={form.nome}
                                onChange={alterarCampo}
                                required
                            />

                        </div>

                        <div>

                            <label>Jogador</label>

                            <input
                                name="jogador"
                                value={form.jogador}
                                onChange={alterarCampo}
                            />

                        </div>

                        <div>

                            <label>Campanha</label>

                            <input
                                name="campanha"
                                value={form.campanha}
                                onChange={alterarCampo}
                            />

                        </div>

                        <div>

                            <label>Profissão</label>

                            <input
                                name="profissao"
                                value={form.profissao}
                                onChange={alterarCampo}
                            />

                        </div>

                    </div>

                </section>

                <section className="ficha-secao">

                    <h2>Origem</h2>

                    <div className="form-grid">

                        <div>

                            <label>Antecedente</label>

                            <select
                                name="antecedente"
                                value={form.antecedente}
                                onChange={alterarCampo}
                            >

                                <option value="">
                                    Selecione
                                </option>

                                <option value="BASTARDO">
                                    Bastardo
                                </option>

                                <option value="NOBRE">
                                    Nobre
                                </option>

                                <option value="MERCENARIO">
                                    Mercenário
                                </option>

                                <option value="MERCANTE">
                                    Mercante
                                </option>

                                <option value="PRODIGIO">
                                    Prodígio
                                </option>

                                <option value="CIVIL">
                                    Civil
                                </option>

                                <option value="MEMBRO_DA_NETUNO">
                                    Membro da Netuno
                                </option>

                                <option value="HERDEIRO">
                                    Herdeiro
                                </option>

                            </select>

                        </div>

                        <div>

                            <label>Família Nobre</label>

                            <select
                                name="familiaNobre"
                                value={form.familiaNobre}
                                onChange={alterarCampo}
                            >

                                <option value="">
                                    Nenhuma
                                </option>

                                <option value="FLORES">
                                    Flores
                                </option>

                                <option value="WOHALI">
                                    Wohali
                                </option>

                                <option value="PLATA">
                                    Plata
                                </option>

                                <option value="ARVORADA">
                                    Arvorada
                                </option>

                                <option value="DLASSEI">
                                    d'Lassei
                                </option>

                                <option value="SCHWARTZ">
                                    Schwartz
                                </option>

                                <option value="VACCHIANO">
                                    Vacchiano
                                </option>

                                <option value="TUT">
                                    Tut
                                </option>

                                <option value="TAFARI">
                                    Tafari
                                </option>

                                <option value="YIN">
                                    Yin
                                </option>

                                <option value="TAKEZO">
                                    Takezo
                                </option>

                                <option value="KAEDE">
                                    Kaede
                                </option>

                                <option value="LEBLANC">
                                    Leblanc
                                </option>

                                <option value="GUINTAKE">
                                    Guintake
                                </option>

                            </select>

                        </div>

                        <div>

                            <label>Defeito</label>

                            <select
                                name="defeito"
                                value={form.defeito}
                                onChange={alterarCampo}
                            >

                                <option value="">
                                    Selecione
                                </option>

                                <option value="FRACO">
                                    Fraco
                                </option>

                                <option value="CORACAO_MOLE">
                                    Coração mole
                                </option>

                                <option value="CURIOSO">
                                    Curioso
                                </option>

                                <option value="DUPLA_PERSONALIDADE">
                                    Dupla personalidade
                                </option>

                                <option value="GULOSO">
                                    Guloso
                                </option>

                                <option value="AZARADO">
                                    Azarado
                                </option>

                                <option value="IGNORANTE">
                                    Ignorante
                                </option>

                                <option value="DESATENTO">
                                    Desatento
                                </option>

                                <option value="COVARDE">
                                    Covarde
                                </option>

                                <option value="LERDO">
                                    Lerdo
                                </option>

                                <option value="INGENUO">
                                    Ingênuo
                                </option>

                                <option value="VAIDOSO">
                                    Vaidoso
                                </option>

                                <option value="FURIOSO">
                                    Furioso
                                </option>

                                <option value="SOLITARIO">
                                    Solitário
                                </option>

                                <option value="FRIORENTO">
                                    Friorento
                                </option>

                                <option value="CALORENTO">
                                    Calorento
                                </option>

                                <option value="ORGULHOSO">
                                    Orgulhoso
                                </option>

                                <option value="NERVOSO">
                                    Nervoso
                                </option>

                                <option value="PREGUICOSO">
                                    Preguiçoso
                                </option>

                                <option value="RANZINZA">
                                    Ranzinza
                                </option>

                                <option value="EGOISTA">
                                    Egoísta
                                </option>

                                <option value="INCONSTANTE">
                                    Inconstante
                                </option>

                                <option value="PESSIMISTA">
                                    Pessimista
                                </option>

                                <option value="ATRAPALHADO">
                                    Atrapalhado
                                </option>

                                <option value="MENTIROSO">
                                    Mentiroso
                                </option>

                                <option value="GANANCIOSO">
                                    Ganancioso
                                </option>

                                <option value="IMPULSIVO">
                                    Impulsivo
                                </option>

                            </select>

                        </div>

                    </div>

                </section>

                <section className="ficha-secao">

                    <h2>Progressão</h2>

                    <div className="form-grid">

                        <div>

                            <label>Refinamento</label>

                            <input
                                type="number"
                                min="0"
                                name="refinamento"
                                value={form.refinamento}
                                onChange={alterarCampo}
                            />

                        </div>

                        <div>

                            <label>Maestria</label>

                            <input
                                type="number"
                                min="0"
                                name="maestria"
                                value={form.maestria}
                                onChange={alterarCampo}
                            />

                        </div>

                    </div>

                </section>

                <section className="ficha-secao">

                    <h2>Aparência</h2>

                    <div className="form-grid">

                        <div>

                            <label>Idade</label>

                            <input
                                type="number"
                                name="idade"
                                value={form.idade}
                                onChange={alterarCampo}
                            />

                        </div>

                        <div>

                            <label>Gênero</label>

                            <select
                                name="genero"
                                value={form.genero}
                                onChange={alterarCampo}
                            >
                                <option value="">
                                    Selecione
                                </option>

                                <option value="MASCULINO">
                                    Masculino
                                </option>

                                <option value="FEMININO">
                                    Feminino
                                </option>

                                <option value="OUTRO">
                                    Outro
                                </option>
                            </select>

                        </div>

                        <div>

                            <label>Cabelos</label>

                            <input
                                name="cabelos"
                                value={form.cabelos}
                                onChange={alterarCampo}
                            />

                        </div>

                        <div>

                            <label>Olhos</label>

                            <input
                                name="olhos"
                                value={form.olhos}
                                onChange={alterarCampo}
                            />

                        </div>

                        <div>

                            <label>Pele</label>

                            <input
                                name="pele"
                                value={form.pele}
                                onChange={alterarCampo}
                            />

                        </div>

                        <div>

                            <label>Marca</label>

                            <input
                                name="marca"
                                value={form.marca}
                                onChange={alterarCampo}
                            />

                        </div>

                    </div>

                    <label>Roupas</label>

                    <textarea
                        name="roupas"
                        value={form.roupas}
                        onChange={alterarCampo}
                    />

                </section>

                <section className="ficha-secao">

                    <h2>Personagem</h2>

                    <label>Ideias</label>

                    <textarea
                        name="ideias"
                        value={form.ideias}
                        onChange={alterarCampo}
                    />

                    <label>Ligações</label>

                    <textarea
                        name="ligacoes"
                        value={form.ligacoes}
                        onChange={alterarCampo}
                    />

                    <label>Complicações</label>

                    <textarea
                        name="complicacoes"
                        value={form.complicacoes}
                        onChange={alterarCampo}
                    />

                    <label>Anotações</label>

                    <textarea
                        name="anotacoes"
                        value={form.anotacoes}
                        onChange={alterarCampo}
                    />

                </section>

                {erro && (
                    <div className="mensagem-erro">
                        {erro}
                    </div>
                )}

                <button
                    className="botao-criar-personagem"
                    type="submit"
                    disabled={carregando}
                >
                    {carregando
                        ? "Criando..."
                        : "Criar personagem"}
                </button>

            </form>

        </div>
    );
}

export default NovoPersonagem;