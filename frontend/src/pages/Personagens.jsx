import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import api from "../api/api";

function Personagens() {

    const navigate = useNavigate();

    const [personagens, setPersonagens] = useState([]);
    const [carregando, setCarregando] = useState(true);
    const [erro, setErro] = useState("");

    useEffect(() => {
        carregarPersonagens();
    }, []);

    async function carregarPersonagens() {

        try {

            const response = await api.get("/personagens");

            setPersonagens(response.data);

        } catch (error) {

            console.error(error);

            if (
                error.response?.status === 401 ||
                error.response?.status === 403
            ) {

                localStorage.removeItem("token");
                navigate("/login");

                return;
            }

            setErro("Não foi possível carregar os personagens.");

        } finally {

            setCarregando(false);
        }
    }

    function logout() {

        localStorage.removeItem("token");

        navigate("/login");
    }

    return (
        <div className="personagens-page">

            <div className="personagens-header">

                <div>
                    <h1>Meus Personagens</h1>
                    <p>Escolha uma ficha ou crie um novo personagem.</p>
                </div>

                <div className="personagens-acoes">

                    <button
                        onClick={() => navigate("/personagens/novo")}
                    >
                        + Novo personagem
                    </button>

                    <button
                        className="botao-secundario"
                        onClick={logout}
                    >
                        Sair
                    </button>

                </div>

            </div>

            {carregando && (
                <p>Carregando personagens...</p>
            )}

            {erro && (
                <div className="mensagem-erro">
                    {erro}
                </div>
            )}

            {!carregando && personagens.length === 0 && (

                <div className="personagem-vazio">

                    <h2>Nenhuma ficha criada</h2>

                    <p>
                        Você ainda não possui nenhum personagem.
                    </p>

                    <button
                        onClick={() => navigate("/personagens/novo")}
                    >
                        Criar primeiro personagem
                    </button>

                </div>

            )}

            <div className="personagens-grid">

                {personagens.map((personagem) => (

                    <div
                        className="personagem-card"
                        key={personagem.id}
                    >

                        <h2>
                            {personagem.nome}
                        </h2>

                        <p>
                            <strong>Jogador:</strong>{" "}
                            {personagem.jogador || "-"}
                        </p>

                        <p>
                            <strong>Refinamento:</strong>{" "}
                            {personagem.refinamento ?? 0}
                        </p>

                        <p>
                            <strong>Antecedente:</strong>{" "}
                            {personagem.antecedente || "-"}
                        </p>

                        <button
                            onClick={() =>
                                navigate(`/personagens/${personagem.id}`)
                            }
                        >
                            Abrir ficha
                        </button>

                    </div>

                ))}

            </div>

        </div>
    );
}

export default Personagens;