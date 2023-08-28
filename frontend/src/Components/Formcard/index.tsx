import { useForm, SubmitHandler } from "react-hook-form";
import "./styles.css";
import { Usuario } from "../../Utils/typesUtils";
import { CONSUMIR_API_EXTERNA } from "../../Utils/configurations";
import axios, { AxiosRequestConfig } from "axios";
import { BASE_URL } from "../../Utils/requests";

type FormDados = {
  id: number;
  nome: string;
  cep: string;
  endereco: string;
};

interface FormcardProps {
  adicionarUsuario: (data: any) => void;
  listaUsuarios: Usuario[];
}

const Formcard = ({ adicionarUsuario, listaUsuarios }: FormcardProps) => {
  const { register, handleSubmit, reset } =
    useForm<FormDados>(); /* React Hook Form */

  // Captura os dados dos campos e faz algum processamento
  const onSubmit: SubmitHandler<FormDados> = (dados) => {
    if (CONSUMIR_API_EXTERNA) {
      const configs: AxiosRequestConfig = {
        method: "POST",
        url: "/usuarios",
        baseURL: BASE_URL,
        data: dados,
      };
      axios(configs).then((response) => {
        console.log("salvo.", response.data);
        adicionarUsuario(response.data);
        reset();
      });
    } else {
      console.log("Atualizando lista em memória");
      dados.id = listaUsuarios.length + 1;
      adicionarUsuario(dados);
      reset();
    }
  };

  return (
    <div className="formcard">
      <form onSubmit={handleSubmit(onSubmit)} autoComplete="off">
        <input {...register("id")} type="hidden" id="inputId" name="id" />
        <input
          {...register("nome")}
          type="text"
          id="inputNome"
          name="nome"
          placeholder="Digite seu nome"
          autoComplete="off"
        />
        <input
          {...register("cep")}
          type="text"
          id="inputCep"
          name="cep"
          placeholder="CEP"
        />
        <input
          {...register("endereco")}
          type="text"
          id="inputEndereco"
          name="endereco"
          placeholder="Endereço"
        />
        <button>Enviar</button>
      </form>
    </div>
  );
};

export default Formcard;
