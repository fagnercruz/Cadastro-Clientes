import "./styles.css";

const Formcard = () => {
  return (
    <div className="formcard">
      <form>
        <input type="text" id="inputNome" placeholder="Digite seu nome" />
        <button>Enviar</button>
      </form>
    </div>
  );
};

export default Formcard;
