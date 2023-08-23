import "./App.css";
import Formcard from "./Components/Formcard";
import Userlist from "./Components/Userlist";
import { Usuario } from "./Utils/typesUtils";

const usuarios: Usuario[] = [
  {
    nome: "Fagner Cruz",
    cep: "58000-000",
    logradouro: "Rua Coronel Caetano Júlio, 64",
  },
  {
    nome: "Vanda Cunha",
    cep: "58000-000",
    logradouro: "Rua Iaia Paiva, 123",
  },
  {
    nome: "Ultimo usuário da lista",
    cep: "58000-000",
    logradouro: "Rua Sem saída, 171",
  },
];

function App() {
  return (
    <div className="App">
      <h2>CADASTRO DE CLIENTES</h2>
      <Formcard />
      <Userlist usuarios={usuarios} />
    </div>
  );
}

export default App;
