import "./App.css";
import Formcard from "./Components/Formcard";
import Userlist from "./Components/Userlist";
import { Usuario } from "./Utils/typesUtils";

const usuarios: Usuario[] = [
  {
    id: 1,
    nome: "Fagner Cruz",
    cep: "58000-000",
    logradouro: "Rua Coronel Caetano Júlio, 64",
  },
  {
    id: 2,
    nome: "Vanda Cunha",
    cep: "58000-000",
    logradouro: "Rua Iaia Paiva, 123",
  },
  {
    id: 3,
    nome: "Ultimo usuário da lista",
    cep: "58000-000",
    logradouro: "Rua Sem saída, 171",
  },
];

function App() {
  return (
    <div className="App">
      <h1>CADASTRO DE CLIENTES</h1>
      <Formcard />
      <Userlist usuarios={usuarios} />
    </div>
  );
}

export default App;
