import "./App.css";
import Formcard from "./Components/Formcard";
import Userlist from "./Components/Userlist";
import { LISTA_EM_MEMORIA } from "./Utils/globalMockData";
import { useState } from "react";
import { Usuario } from "./Utils/typesUtils";
import { CONSUMIR_API_EXTERNA } from "./Utils/configurations";

function App() {
  // useState para gerenciar o estado da lista em memória
  const [dados, setDados] = useState<Usuario[]>(LISTA_EM_MEMORIA);

  // função que adiciona um novo usuario na lista
  const adicionarUsuario = (novo: Usuario) => {
    setDados([...dados, novo]);
  };

  return (
    <div className="App">
      <h1>CADASTRO DE CLIENTES</h1>
      <h5>
        Modo de consumo:{" "}
        <span className={CONSUMIR_API_EXTERNA ? "green" : "red"}>
          {CONSUMIR_API_EXTERNA ? "API Externa" : "Em memória"}
        </span>
      </h5>
      <Formcard adicionarUsuario={adicionarUsuario} listaUsuarios={dados} />
      <Userlist usuarios={dados} />
    </div>
  );
}

export default App;
