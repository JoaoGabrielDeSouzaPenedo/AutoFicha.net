const BASE_URL = "http://localhost:8080";

async function request(endpoint, options = {}) {
    const token = localStorage.getItem("token");
    const tipoToken = localStorage.getItem("tipoToken") || "Bearer";

    const headers = {
        "Content-Type": "application/json",
        ...options.headers
    };

    if (token) {
        headers.Authorization = `${tipoToken} ${token}`;
    }

    try {
        const response = await fetch(`${BASE_URL}${endpoint}`, {
            ...options,
            headers
        });

        const contentType = response.headers.get("content-type");

        let data = null;

        if (contentType && contentType.includes("application/json")) {
            data = await response.json();
        }

        if (!response.ok) {
            const erro = new Error(
                data?.mensagem ||
                data?.message ||
                data?.erro ||
                `Erro ${response.status}`
            );

            erro.status = response.status;
            erro.data = data;

            throw erro;
        }

        return data;

    } catch (error) {

        console.error(
            `Erro na requisição ${BASE_URL}${endpoint}:`,
            error
        );

        throw error;
    }
}

const api = {
    get(endpoint) {
        return request(endpoint);
    },

    post(endpoint, body) {
        return request(endpoint, {
            method: "POST",
            body: JSON.stringify(body)
        });
    },

    put(endpoint, body) {
        return request(endpoint, {
            method: "PUT",
            body: JSON.stringify(body)
        });
    },

    delete(endpoint) {
        return request(endpoint, {
            method: "DELETE"
        });
    }
};

export default api;