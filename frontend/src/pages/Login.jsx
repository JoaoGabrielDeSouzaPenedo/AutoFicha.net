import { useState } from "react";
import { Link, useNavigate } from "react-router-dom";

import api from "../api/api";

function Login() {

    const navigate = useNavigate();

    const [username, setUsername] = useState("");
    const [senha, setSenha] = useState("");

    const [erro, setErro] = useState("");
    const [carregando, setCarregando] = useState(false);

    async function handleSubmit(event) {

        event.preventDefault();

        setErro("");
        setCarregando(true);

        try {

            const response = await api.post("/auth/login", {
                username,
                senha
            });

            if (!response?.token) {
                throw new Error(
                    "O servidor não retornou o token."
                );
            }

            localStorage.setItem(
                "token",
                response.token
            );

            localStorage.setItem(
                "tipoToken",
                response.tipo || "Bearer"
            );

            navigate("/dashboard");

        } catch (error) {

            console.error("Erro no login:", error);

            localStorage.removeItem("token");
            localStorage.removeItem("tipoToken");

            if (error.message === "Failed to fetch") {

                setErro(
                    "Não foi possível conectar ao servidor. Verifique se o backend está ligado."
                );

            } else {

                setErro(
                    error?.data?.mensagem ||
                    error?.data?.message ||
                    error?.message ||
                    "Usuário ou senha inválidos."
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
                        Todas as suas fichas em um só lugar.
                    </p>

                </div>

            </div>

            <div className="auth-right">

                <div className="auth-form-container">

                    <h1>Entrar</h1>

                    <p>
                        Acesse sua conta para continuar.
                    </p>

                    <form onSubmit={handleSubmit}>

                        <label>Usuário</label>

                        <input
                            type="text"
                            placeholder="Seu usuário"
                            value={username}
                            onChange={(event) =>
                                setUsername(event.target.value)
                            }
                            required
                        />

                        <label>Senha</label>

                        <input
                            type="password"
                            placeholder="Sua senha"
                            value={senha}
                            onChange={(event) =>
                                setSenha(event.target.value)
                            }
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
                                ? "Entrando..."
                                : "Entrar"}
                        </button>

                    </form>

                    <p className="auth-footer">
                        Ainda não possui conta?{" "}
                        <Link to="/cadastro">
                            Criar conta
                        </Link>
                    </p>

                </div>

            </div>

        </div>
    );
}

export default Login;