import { Link } from "react-router-dom";

function Cadastro() {
    return (
        <main className="auth-page">

            <section className="auth-side">

                <div className="brand">
                    <span className="brand-icon">◆</span>
                    <h1>AutoFicha</h1>
                </div>

                <div className="hero-content">
                    <h2>
                        Comece sua
                        <br />
                        próxima aventura.
                    </h2>

                    <p>
                        Crie sua conta e mantenha todas as suas
                        fichas organizadas.
                    </p>
                </div>

            </section>

            <section className="auth-form-area">

                <div className="auth-card">

                    <h2>Criar conta</h2>

                    <p className="subtitle">
                        Preencha seus dados para começar.
                    </p>

                    <form>

                        <div className="form-group">
                            <label>Nome</label>

                            <input
                                type="text"
                                placeholder="Seu nome"
                            />
                        </div>

                        <div className="form-group">
                            <label>Usuário</label>

                            <input
                                type="text"
                                placeholder="Escolha um usuário"
                            />
                        </div>

                        <div className="form-group">
                            <label>Senha</label>

                            <input
                                type="password"
                                placeholder="Escolha uma senha"
                            />
                        </div>

                        <button
                            className="primary-button"
                            type="submit"
                        >
                            Criar conta
                        </button>

                    </form>

                    <p className="auth-footer">
                        Já possui uma conta?{" "}
                        <Link to="/">
                            Entrar
                        </Link>
                    </p>

                </div>

            </section>

        </main>
    );
}

export default Cadastro;