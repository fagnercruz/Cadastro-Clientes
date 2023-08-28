import "./styles.css";
import { Usuario } from "../../Utils/typesUtils";
import Usercard from "../Usercard";
import axios, { AxiosRequestConfig } from "axios";
import { BASE_URL } from "../../Utils/requests";
import { useEffect, useState } from "react";
import { CONSUMIR_API_EXTERNA } from "../../Utils/configurations";

type Props = {
  usuarios: Usuario[];
};

const Userlist = ({ usuarios }: Props) => {
  const [users, setUsers] = useState<Usuario[]>();

  useEffect(() => {
    //condicional para chavear entre usar dados do backend ou hardcode
    if (CONSUMIR_API_EXTERNA) {
      const pp: AxiosRequestConfig = {
        method: "GET",
        baseURL: BASE_URL,
        url: "usuarios/all",
      };
      axios(pp)
        .then((retorno) => {
          setUsers(retorno.data);
        })
        .catch(() => {
          setUsers(usuarios);
        });
    } else {
      setUsers(usuarios);
    }
  }, [usuarios]);

  return (
    <div className="userlist">
      {users?.map((usuario) => {
        return <Usercard usuario={usuario} key={usuario.id} />;
      })}
    </div>
  );
};

export default Userlist;
