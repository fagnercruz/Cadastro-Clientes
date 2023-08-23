import { Usuario } from "../../Utils/typesUtils";
import "./styles.css";

type Props = {
  usuario: Usuario;
};

const Usercard = ({ usuario }: Props) => {
  return (
    <div className="usercard-container">
      <p>Nome: {usuario.nome}</p>
      <p>CEP: {usuario.cep}</p>
      <p>End: {usuario.logradouro}</p>
    </div>
  );
};

export default Usercard;
