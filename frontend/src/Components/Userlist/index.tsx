import { Usuario } from "../../Utils/typesUtils";
import Usercard from "../Usercard";
import "./styles.css";

type Props = {
  usuarios: Usuario[];
};

const Userlist = ({ usuarios }: Props) => {
  return (
    <div className="userlist">
      {usuarios.map((usuario) => {
        return <Usercard usuario={usuario} key={usuario.id} />;
      })}
    </div>
  );
};

export default Userlist;
