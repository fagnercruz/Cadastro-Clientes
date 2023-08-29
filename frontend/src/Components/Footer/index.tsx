import "./styles.css";
import { ReactComponent as Css } from "../../assets/img/css.svg";
import { ReactComponent as Html } from "../../assets/img/html.svg";
import { ReactComponent as JavaScript } from "../../assets/img/javascript.svg";
import { ReactComponent as React } from "../../assets/img/react.svg";
import { ReactComponent as Spring } from "../../assets/img/spring.svg";
import { ReactComponent as TypeScript } from "../../assets/img/typescript.svg";

const Footer = () => {
  return (
    <div className="footer-container">
      <p className="texto-copy">
        Desenvolvido por Fagner Cruz &copy; 2023 - Todos os direitos para a
        comunidade
      </p>
      <p className="texto-label-logos">Tecnologias empregadas:</p>
      <div className="logos-container">
        <Html />
        <Css />
        <JavaScript />
        <TypeScript />
        <React />
        <Spring />
      </div>
    </div>
  );
};

export default Footer;
