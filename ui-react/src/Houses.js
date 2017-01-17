import React from 'react';
import {Table, Button, Glyphicon, Modal, Form, FormGroup, Col, FormControl, ControlLabel} from 'react-bootstrap'
import axios from 'axios'
var DateTimeField = require('react-bootstrap-datetimepicker');

const Houses = React.createClass({
  getInitialState(){
    return {
      houses: [],
      showCreateModal: false,
      showUpdateModal: false,
      id: 0,
      name: "",
      address: "",
      history: "",
      hauntingFrom: 0
    };
  },

  closeModal(){
    this.setState({showCreateModal: false, showUpdateModal: false});
  },

  openCreateModal(){
    this.setState({
      showCreateModal: true,
      name: "",
      address: "",
      history: "",
      hauntingFrom: 0
    });
  },

  openUpdateModal(house){
    this.setState({
      id: house.id,
      showUpdateModal: true,
      name: house.name,
      address: house.address,
      history: house.history,
      hauntingFrom: house.hauntingFrom
    });
  },

  createHouse(){
    axios.post(`http://localhost:8080/pa165/houses`, {
      name: this.state.name,
      address: this.state.address,
      history: this.state.history,
      hauntingFrom: this.state.hauntingFrom
    })
      .then(res => {
        console.log("House " + res.data.id + " was created");
        const object = this.state.houses;
        object.push(res.data);
        this.setState({houses: object});
      })
      .catch(error => {
        console.log(error)
      });
    this.closeModal();
  },

  removeHouse(houseId){
    axios.delete("http://localhost:8080/pa165/houses/" + houseId)
      .then(res => {
        console.log("House " + houseId + " was deleted");
        const object = this.state.houses.filter((house) => {
          return house.id !== houseId
        });
        this.setState({houses: object});
      })
      .catch(error => {
        console.log(error)
      });
  },

  updateHouse(){
    const house = {
      id: this.state.id,
      name: this.state.name,
      address: this.state.address,
      history: this.state.history,
      hauntingFrom: this.state.hauntingFrom
    };
    axios.put("http://localhost:8080/pa165/houses", house)
      .then(res => {
        console.log(res);
        console.log("House " + house.id + " was update");
        const object = this.state.houses.filter((h) => {
          return h.id !== house.id
        });
        object.push(house);
        this.setState({houses: object});
      })
      .catch(error => {
        console.log(error)
      });
    this.closeModal();
  },

  handleChange: function (field, e) {
    const object = {};
    object[field] = e.target.value;
    this.setState(object);
  },

  componentDidMount() {
    axios.get(`http://localhost:8080/pa165/houses`)
      .then(res => {
        // console.log(res.data);
        // const houses = res.data;
        this.setState({houses: res.data});
        // const posts = res.data.data.children.map(obj => obj.data);
        // this.setState({ posts });
      });
  },

  render() {
    let tableLines = [];
    this.state.houses.forEach(function (house, i) {
      tableLines.push(
        <tr key={i}>
          <th>{ house.id }</th>
          <th>{ house.name }</th>
          <th>{ house.address }</th>
          <th>{ house.history }</th>
          <th>{ new Date(house.hauntingFrom).toLocaleDateString() }</th>
          <th>
            <Button onClick={() => this.openUpdateModal(house)}><Glyphicon glyph="pencil"/></Button>
            <Button onClick={() => this.removeHouse(house.id)}><Glyphicon glyph="remove"/></Button>
          </th>
        </tr>
      )
    }.bind(this));
    return (
      <div>
        <Modal show={this.state.showCreateModal || this.state.showUpdateModal} onHide={this.closeModal}>
          <Modal.Header closeButton>
            <Modal.Title>Create House</Modal.Title>
          </Modal.Header>
          <Modal.Body>
            <Form horizontal>
              <FormGroup controlId="houseName">
                <Col componentClass={ControlLabel} sm={3}>
                  Name
                </Col>
                <Col sm={7}>
                  <FormControl type="text" placeholder="House name" value={this.state.name}
                               onChange={this.handleChange.bind(this, 'name')}/>
                </Col>
              </FormGroup>

              <FormGroup controlId="houseAddress">
                <Col componentClass={ControlLabel} sm={3}>
                  Address
                </Col>
                <Col sm={7}>
                  <FormControl type="text" placeholder="House address" value={this.state.address}
                               onChange={this.handleChange.bind(this, 'address')}/>
                </Col>
              </FormGroup>


              <FormGroup controlId="houseHistory">
                <Col componentClass={ControlLabel} sm={3}>
                  History
                </Col>
                <Col sm={7}>
                  <FormControl type="text" placeholder="House history" value={this.state.history}
                               onChange={this.handleChange.bind(this, 'history')}/>
                </Col>
              </FormGroup>

              <FormGroup controlId="houseHistory">
                <Col componentClass={ControlLabel} sm={3}>
                  Haunting from
                </Col>
                <Col sm={7}>
                  <DateTimeField id="datetimepicker" defaultText="Date when everything begin" mode="date"
                                 onChange={x => this.setState({hauntingFrom: x})}/>
                </Col>
              </FormGroup>
            </Form>
          </Modal.Body>
          <Modal.Footer>
            {
              this.state.showCreateModal ?
                <Button onClick={this.createHouse}>Create</Button> :
                <Button onClick={this.updateHouse}>Update</Button>
            }
            <Button onClick={this.closeModal}>Close</Button>
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
            <th><Button onClick={this.openCreateModal}>New <Glyphicon glyph="plus"/></Button></th>
          </tr>
          </thead>
          <tbody>
          {tableLines}
          </tbody>
        </Table>
      </div>
    );
  }
});

export default Houses;
