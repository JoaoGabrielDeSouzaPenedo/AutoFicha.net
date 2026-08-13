import { Link } from "react-router-dom";

function Login() {
    return (
        <main className="auth-page">

            <section className="auth-side">
                <div className="brand">
                    <span className="brand-icon">◆</span>
                    <h1>AutoFicha</h1>
                </div>

                <div className="hero-content">
                    <h2>
                        Suas fichas.
                        <br />
                        Suas aventuras.
                    </h2>

                    <p>
                        Crie, organize e automatize suas fichas de RPG
                        em um único lugar.
                    </p>
                </div>
            </section>

            <section className="auth-form-area">

                <div className="auth-card">

                    <h2>Bem-vindo de volta</h2>

                    <p className="subtitle">
                        Entre na sua conta para continuar.
                    </p>

                    <form>

                        <div className="form-group">
                            <label>Usuário</label>

                            <input
                                type="text"
                                placeholder="Digite seu usuário"
                            />
                        </div>

                        <div className="form-group">
                            <label>Senha</label>

                            <input
                                type="password"
                                placeholder="Digite sua senha"
                            />
                        </div>

                        <button
                            className="primary-button"
                            type="submit"
                        >
                            Entrar
                        </button>

                    </form>

                    <p className="auth-footer">
                        Ainda não possui uma conta?{" "}
                        <Link to="/cadastro">
                            Criar conta
                        </Link>
                    </p>

                </div>

            </section>

        </main>
    );
}

export default Login;