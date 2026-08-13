function Dashboard() {
    return (
        <main className="dashboard">

            <header className="dashboard-header">

                <div className="brand">
                    <span className="brand-icon">◆</span>
                    <h1>AutoFicha</h1>
                </div>

                <div className="user-area">
                    <span>Olá, aventureiro</span>

                    <button className="secondary-button">
                        Sair
                    </button>
                </div>

            </header>

            <section className="dashboard-content">

                <div className="dashboard-title">

                    <div>
                        <h2>Minhas fichas</h2>

                        <p>
                            Gerencie seus personagens e aventuras.
                        </p>
                    </div>

                    <button className="primary-button small">
                        + Criar personagem
                    </button>

                </div>

                <section className="empty-state">

                    <div className="empty-icon">
                        ◇
                    </div>

                    <h3>
                        Nenhuma ficha criada
                    </h3>

                    <p>
                        Crie seu primeiro personagem para começar.
                    </p>

                    <button className="primary-button small">
                        Criar primeira ficha
                    </button>

                </section>

            </section>

        </main>
    );
}

export default Dashboard;