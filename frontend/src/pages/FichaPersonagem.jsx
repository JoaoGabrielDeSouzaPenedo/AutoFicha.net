import { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import api from "../api/api";

function FichaPersonagem() {

    const { id } = useParams();
    const navigate = useNavigate();

    const [personagem, setPersonagem] = useState(null);
    const [erro, setErro] = useState("");

    useEffect(() => {
        carregarPersonagem();
    }, [id]);

    async function carregarPersonagem() {

        try {

            const response = await api.get(
                `/personagens/${id}`
            );

            setPersonagem(response.data);

        } catch (error) {

            console.error(error);

            setErro("Não foi possível carregar a ficha.");
        }
    }

    if (erro) {

        return (
            <div className="ficha-page">

                <div className="mensagem-erro">
                    {erro}
                </div>

            </div>
        );
    }

    if (!personagem) {

        return (
            <div className="ficha-page">
                Carregando ficha...
            </div>
        );
    }

    return (
        <div className="ficha-page">

            <div className="pagina-cabecalho">

                <button
                    className="botao-secundario"
                    onClick={() => navigate("/personagens")}
                >
                    ← Voltar
                </button>

            </div>

            <section className="ficha-topo">

                <div>

                    <span className="ficha-legenda">
                        PERSONAGEM
                    </span>

                    <h1>
                        {personagem.nome}
                    </h1>

                    <p>
                        Jogador: {personagem.jogador || "-"}
                    </p>

                </div>

                <div className="refinamento-box">

                    <span>
                        Refinamento
                    </span>

                    <strong>
                        {personagem.refinamento ?? 0}
                    </strong>

                </div>

            </section>

            <div className="ficha-grid">

                <section className="ficha-card">

                    <h2>Origem</h2>

                    <p>
                        <strong>Antecedente:</strong>{" "}
                        {personagem.antecedente || "-"}
                    </p>

                    <p>
                        <strong>Família:</strong>{" "}
                        {personagem.familiaNobre || "-"}
                    </p>

                    <p>
                        <strong>Defeito:</strong>{" "}
                        {personagem.defeito || "-"}
                    </p>

                    <p>
                        <strong>Profissão:</strong>{" "}
                        {personagem.profissao || "-"}
                    </p>

                </section>

                <section className="ficha-card">

                    <h2>Progressão</h2>

                    <p>
                        <strong>Refinamento:</strong>{" "}
                        {personagem.refinamento ?? 0}
                    </p>

                    <p>
                        <strong>Maestria:</strong>{" "}
                        {personagem.maestria ?? 0}
                    </p>

                    <p>
                        <strong>PT gastos:</strong>{" "}
                        {personagem.ptGastos ?? 0}
                    </p>

                </section>

                <section className="ficha-card">

                    <h2>Atributos</h2>

                    {personagem.atributos ? (

                        <pre>
                            {JSON.stringify(
                                personagem.atributos,
                                null,
                                2
                            )}
                        </pre>

                    ) : (

                        <p>
                            Atributos ainda não cadastrados.
                        </p>

                    )}

                </section>

                <section className="ficha-card">

                    <h2>Recursos</h2>

                    {personagem.recursos ? (

                        <pre>
                            {JSON.stringify(
                                personagem.recursos,
                                null,
                                2
                            )}
                        </pre>

                    ) : (

                        <p>
                            Recursos ainda não cadastrados.
                        </p>

                    )}

                </section>

                <section className="ficha-card">

                    <h2>Perícias</h2>

                    <pre>
                        {JSON.stringify(
                            personagem.pericias || [],
                            null,
                            2
                        )}
                    </pre>

                </section>

                <section className="ficha-card">

                    <h2>Resistências</h2>

                    <pre>
                        {JSON.stringify(
                            personagem.testesResistencia || [],
                            null,
                            2
                        )}
                    </pre>

                </section>

                <section className="ficha-card">

                    <h2>Ataques</h2>

                    <pre>
                        {JSON.stringify(
                            personagem.ataques || [],
                            null,
                            2
                        )}
                    </pre>

                </section>

                <section className="ficha-card">

                    <h2>Dons</h2>

                    <pre>
                        {JSON.stringify(
                            personagem.dons || [],
                            null,
                            2
                        )}
                    </pre>

                </section>

                <section className="ficha-card">

                    <h2>Inventário</h2>

                    <pre>
                        {JSON.stringify(
                            personagem.inventario || [],
                            null,
                            2
                        )}
                    </pre>

                </section>

                <section className="ficha-card">

                    <h2>Totens</h2>

                    <pre>
                        {JSON.stringify(
                            personagem.totens || [],
                            null,
                            2
                        )}
                    </pre>

                </section>

                <section className="ficha-card">

                    <h2>Pactos</h2>

                    <pre>
                        {JSON.stringify(
                            personagem.pactos || [],
                            null,
                            2
                        )}
                    </pre>

                </section>

                <section className="ficha-card">

                    <h2>Anotações</h2>

                    <p>
                        {personagem.anotacoes || "Nenhuma anotação."}
                    </p>

                </section>

            </div>

        </div>
    );
}

export default FichaPersonagem;