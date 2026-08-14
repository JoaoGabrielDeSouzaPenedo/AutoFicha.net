import {
    Navigate,
    Route,
    Routes
} from "react-router-dom";

import Login from "./pages/Login";
import Cadastro from "./pages/Cadastro";
import Dashboard from "./pages/Dashboard";
import Personagens from "./pages/Personagens";
import NovoPersonagem from "./pages/NovoPersonagem";
import FichaPersonagem from "./pages/FichaPersonagem";
import RotaProtegida from "./components/RotaProtegida";

function App() {
    return (
        <Routes>

            <Route
                path="/"
                element={<Navigate to="/login" replace />}
            />

            <Route
                path="/login"
                element={<Login />}
            />

            <Route
                path="/cadastro"
                element={<Cadastro />}
            />

            <Route
                path="/dashboard"
                element={
                    <RotaProtegida>
                        <Dashboard />
                    </RotaProtegida>
                }
            />

            <Route
                path="/personagens"
                element={
                    <RotaProtegida>
                        <Personagens />
                    </RotaProtegida>
                }
            />

            <Route
                path="/personagens/novo"
                element={
                    <RotaProtegida>
                        <NovoPersonagem />
                    </RotaProtegida>
                }
            />

            <Route
                path="/personagens/:id"
                element={
                    <RotaProtegida>
                        <FichaPersonagem />
                    </RotaProtegida>
                }
            />

        </Routes>
    );
}

export default App;