import "./styles.css";
import { Usuario } from "../../Utils/typesUtils";
import Usercard from "../Usercard";
import axios, { AxiosRequestConfig } from "axios";
import { BASE_URL } from "../../Utils/requests";
import { useEffect, useState } from "react";
import { CONSUMIR_API_EXTERNA } from "../../Utils/configurations";
import { DotWave } from "@uiball/loaders";

type Props = {
  usuarios: Usuario[];
};

const Userlist = ({ usuarios }: Props) => {
  const [users, setUsers] = useState<Usuario[]>();
  const [isLoading, setLoading] = useState<boolean>(false);

  useEffect(() => {
    //condicional para chavear entre usar dados do backend ou hardcode
    if (CONSUMIR_API_EXTERNA) {
      setLoading(true);
      const pp: AxiosRequestConfig = {
        method: "GET",
        baseURL: BASE_URL,
        url: "usuarios/all",
      };
      axios(pp)
        .then((retorno) => {
          setUsers(retorno.data);
          setLoading(false);
        })
        .catch(() => {
          setUsers(usuarios);
          setLoading(false);
        });
    } else {
      setUsers(usuarios);
    }
  }, [usuarios]);

  return (
    <div className="userlist">
      <div className="userlist-container">
        {isLoading && (
          <div className="loader">
            <DotWave size={50} speed={0.9} color="orange" />
          </div>
        )}
        {!isLoading &&
          users?.map((usuario) => {
            return <Usercard usuario={usuario} key={usuario.id} />;
          })}
      </div>
    </div>
  );
};

export default Userlist;
