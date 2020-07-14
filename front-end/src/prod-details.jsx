import React from 'react';
import { Col } from 'reactstrap';

class ProdDetails extends React.Component {
    constructor(props) {
        super(props);
    }

    updateProd() {
        
    }

    render() {
        const { prodDescription, prodType, prodValue, prodStock } = this.props;
        return (
            <Col className="prodDetails">
                <p className="prodDescription">{prodDescription}</p>
                <p className="prodType">{prodType}</p>
                <div className="prodNumbers">
                    <div className="prodValue">Valor Forn. <br/>R${prodValue}</div>
                    <div className="prodStock">Estoque:<br/> {prodStock}</div>
                </div>
                <div className="prodActions">
                    <button>Alterar</button>
                </div>
            </Col>
        );
      }
}

export default ProdDetails;