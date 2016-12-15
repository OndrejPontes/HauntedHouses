import React, {Component} from 'react';
import { Table, Button, Glyphicon } from 'react-bootstrap'
import axios from 'axios'

class Houses extends Component {
  constructor(){
    super();
    this.state = {
      houses: [],
      showModal: false
    }
  }

  closeModal(){
    this.setState({ showModal: false });
  }

  openModal(){
    this.setState({ showModal: true });
  }

  componentDidMount() {
    axios.get(`http://localhost:8080/pa165/houses`)
      .then(res => {
        // console.log(res.data);
        // const houses = res.data;
        this.setState({ houses: res.data });
        // const posts = res.data.data.children.map(obj => obj.data);
        // this.setState({ posts });
      });
  }

  render() {
    let tableLines = [];
    this.state.houses.forEach(function (house, i) {
      tableLines.push(
        <tr key={i}>
          <th>{ house.id }</th>
          <th>{ house.name }</th>
          <th>{ house.address }</th>
          <th>{ house.history }</th>
          <th>{ house.hauntingFrom }</th>
          <th>
            <Button><Glyphicon glyph="pencil"/></Button>
            <Button><Glyphicon glyph="remove"/></Button>
          </th>
        </tr>
      )
    });
    return (
      <div>
        <Modal show={this.state.showModal} onHide={this.closeModal}>
          <Modal.Header closeButton>
            <Modal.Title>Modal heading</Modal.Title>
          </Modal.Header>
          <Modal.Body>
            <div>Modal content here </div>
          </Modal.Body>
          <Modal.Footer>
            <Button onClick={this.close}>Close</Button>
          </Modal.Footer>
        </Modal>

        <Table responsive>
          <thead>
          <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Address</th>
            <th>History</th>
            <th>Haunting from</th>
            <th><Button>New <Glyphicon glyph="plus"/></Button></th>
          </tr>
          </thead>
          <tbody>
          {tableLines}
          </tbody>
        </Table>
      </div>
    );
  }
}

export default Houses;
