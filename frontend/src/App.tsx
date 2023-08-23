import "./App.css";
import Formcard from "./Components/Formcard";
import Userlist from "./Components/Userlist";

function App() {
  return (
    <div className="App">
      <h2>CADASTRO DE CLIENTES</h2>
      <Formcard />
      <Userlist />
    </div>
  );
}

export default App;
