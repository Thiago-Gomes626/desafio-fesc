import React from 'react';
import MenuList from './menu-list';
import ProdCard from './prod-card';
import { Container, Row, Col } from 'reactstrap';
import API from './apicall';
import 'bootstrap/dist/css/bootstrap.min.css';
import './css/main.css'

class Initial extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            prods: API('/produtos'),
            prodis: [
                {
                    prodCode: 1,
                    prodDescription: 'Produto',
                    prodType: 'Eletrodomestico',
                    prodValue: 300.00,
                    prodStock: 5
                },
                {
                    prodCode: 2,
                    prodDescription: 'Produto 2',
                    prodType: 'Eletrodomestico',
                    prodValue: 150.00,
                    prodStock: 2
                },
            ]
        };
    }

    componentDidMount() {
        fetch('http://localhost:8080/api/v1/produtos')
        .then(response => response.json())
        .then(data => console.log(data));
    }
    

    render() {
        const { prods } = this.state;
        console.log(prods);
        return (
            <Container className="main-container">
                <Row>
                    <Col sm={3} className="menu-container"><MenuList/></Col>
                    <Col>
                        <Row>
                            <ProdCard
                                prods={prods}
                            />
                        </Row>
                    </Col>
                </Row>
            </Container>
        );
      }
}

export default Initial;