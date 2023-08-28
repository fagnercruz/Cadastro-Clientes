import { useForm, SubmitHandler } from "react-hook-form";
import "./styles.css";

type FormDados = {
  nome: string;
  cep: string;
  endereco: string;
};

const Formcard = () => {
  const { register, handleSubmit } = useForm<FormDados>(); /* React Hook Form */

  // Captura os dados dos campos e faz algum processamento
  const onSubmit: SubmitHandler<FormDados> = (data) => {
    console.log(data);
  };

  return (
    <div className="formcard">
      <form onSubmit={handleSubmit(onSubmit)}>
        <input
          {...register("nome")}
          type="text"
          id="inputNome"
          name="nome"
          placeholder="Digite seu nome"
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
