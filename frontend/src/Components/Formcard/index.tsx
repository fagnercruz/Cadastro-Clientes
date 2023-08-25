import "./styles.css";

const Formcard = () => {
  return (
    <div className="formcard">
      <form>
        <input type="text" id="inputNome" placeholder="Digite seu nome" />
        <input type="text" id="inputCep" placeholder="CEP" />
        <input type="text" id="inputEndereco" placeholder="Endereço" />
        <button>Enviar</button>
      </form>
    </div>
  );
};

export default Formcard;
