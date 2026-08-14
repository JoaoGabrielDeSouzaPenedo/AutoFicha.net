import { useState } from "react";
import { Link, useNavigate } from "react-router-dom";

import api from "../api/api";

function Cadastro() {

    const navigate = useNavigate();

    const [nome, setNome] = useState("");
    const [username, setUsername] = useState("");
    const [senha, setSenha] = useState("");

    const [erro, setErro] = useState("");
    const [carregando, setCarregando] = useState(false);

    async function handleSubmit(event) {

        event.preventDefault();

        setErro("");
        setCarregando(true);

        try {

            await api.post("/auth/register", {
                nome,
                username,
                senha
            });

            navigate("/login");

        } catch (error) {

            console.error("Erro no cadastro:", error);

            if (error.message === "Failed to fetch") {
                setErro(
                    "Não foi possível conectar ao servidor. Verifique se o backend está ligado."
                );
            } else {
                setErro(
                    error?.data?.mensagem ||
                    error?.data?.message ||
                    error?.message ||
                    "Não foi possível criar a conta."
                );
            }

        } finally {

            setCarregando(false);
        }
    }

    return (
        <div className="auth-page">

            <div className="auth-left">

                <div className="auth-hero">

                    <h1>
                        Sua história.<br />
                        Sua aventura.
                    </h1>

                    <p>
                        Crie e gerencie todas as suas fichas.
                    </p>

                </div>

            </div>

            <div className="auth-right">

                <div className="auth-form-container">

                    <h1>Criar conta</h1>

                    <p>
                        Preencha seus dados para começar.
                    </p>

                    <form onSubmit={handleSubmit}>

                        <label>Nome</label>

                        <input
                            type="text"
                            placeholder="Seu nome"
                            value={nome}
                            onChange={(event) =>
                                setNome(event.target.value)
                            }
                            maxLength={100}
                            required
                        />

                        <label>Usuário</label>

                        <input
                            type="text"
                            placeholder="Escolha um usuário"
                            value={username}
                            onChange={(event) =>
                                setUsername(event.target.value)
                            }
                            minLength={3}
                            maxLength={50}
                            required
                        />

                        <label>Senha</label>

                        <input
                            type="password"
                            placeholder="Escolha uma senha"
                            value={senha}
                            onChange={(event) =>
                                setSenha(event.target.value)
                            }
                            minLength={6}
                            maxLength={100}
                            required
                        />

                        {erro && (
                            <div className="auth-error">
                                {erro}
                            </div>
                        )}

                        <button
                            type="submit"
                            disabled={carregando}
                        >
                            {carregando
                                ? "Criando conta..."
                                : "Criar conta"}
                        </button>

                    </form>

                    <p className="auth-footer">
                        Já possui uma conta?{" "}
                        <Link to="/login">
                            Entrar
                        </Link>
                    </p>

                </div>

            </div>

        </div>
    );
}

export default Cadastro;