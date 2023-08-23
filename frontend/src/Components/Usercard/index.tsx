import { Usuario } from "../../Utils/typesUtils";
import "./styles.css";

type Props = {
  usuario: Usuario;
};

const Usercard = ({ usuario }: Props) => {
  return (
    <div className="usercard-container">
      <h3>{usuario.nome}</h3>
      <p>CEP: {usuario.cep}</p>
      <p>End: {usuario.logradouro}</p>
    </div>
  );
};

export default Usercard;
