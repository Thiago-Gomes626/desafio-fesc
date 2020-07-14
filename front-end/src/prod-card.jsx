import React from 'react';
import { Col } from 'reactstrap';

class ProdCard extends React.Component {
    constructor(props) {
        super(props);
    }

    render() {
        const { prods } = this.props;
        return (
            <Col className="prodCard">
                <table>
                    <thead>
                    <tr>
                        <th>Descricao</th>
                        <th>Tipo</th>
                        <th>Valor Forn.</th>
                        <th>Estoque</th>
                        <th>Ações</th>
                    </tr>
                    </thead>
                    <tbody>
                    {prods.length > 0 ? (
                        prods.map((prod) => (
                        <tr key={prod.codigo}>
                            <td>{prod.prodDescription}</td>
                            <td>{prod.prodType}</td>
                            <td>{prod.prodValue}</td>
                            <td>{prod.prodStock}</td>
                            <td>
                            <button className="button muted-button">Editar</button>
                            <button className="button muted-button">Deletar</button>
                            </td>
                        </tr>
                        ))
                    ) : (
                        <tr>
                        <td colSpan={3}>No users</td>
                        </tr>
                    )}
                    </tbody>
                </table>
            </Col>
        );
      }
}

export default ProdCard;