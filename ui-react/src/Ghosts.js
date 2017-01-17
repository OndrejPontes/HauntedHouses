import React from 'react';
import {Table, Button, Glyphicon, Modal, Form, FormGroup, Col, FormControl, ControlLabel, option} from 'react-bootstrap'
import axios from 'axios'
import $ from 'jquery'
var DateTimeField = require('react-bootstrap-datetimepicker');
var DateTimeField2 = require('react-bootstrap-datetimepicker');

const Ghosts = React.createClass({

  getDefaultProps: function () {
    return {
      ajaxApi: ['http://localhost:8080/pa165/ghosts', 'http://localhost:8080/pa165/houses']
    };
  },

  getInitialState(){
    return {
      ghosts: [],
      hauntedHouses: [],
      showCreateModal: false,
      showUpdateModal: false,
      id: 0,
      name: "",
      description: "",
      hauntsFrom: 0,
      hauntsTo: 0,
      hauntedHouse: {},
      abilities: []
    };
  },

  closeModal(){
    this.setState({showCreateModal: false, showUpdateModal: false});
  },

  openCreateModal(){
    this.setState({
      showCreateModal: true,
      name: "",
      description: "",
      hauntsFrom: 0,
      hauntsTo: 0,
      hauntedHouse: {},
      abilities: []
    });
  },

  openUpdateModal(ghost){
    this.setState({
      id: ghost.id,
      showUpdateModal: true,
      name: ghost.name,
      description: ghost.description,
      hauntsFrom: ghost.hauntsFrom,
      hauntsTo: ghost.hauntsTo,
      hauntedHouse: ghost.hauntedHouse,
      abilities: ghost.abilities
    });
  },

  createGhost(){
    axios.post(`http://localhost:8080/pa165/ghosts`, {
      name: this.state.name,
      description: this.state.description,
      hauntsFrom: this.state.hauntsFrom,
      hauntsTo: this.state.hauntsTo,
      hauntedHouse: this.state.hauntedHouse,
      abilities: this.state.abilities
    })
      .then(res => {
        console.log("Ghost " + res.data.id + " was created");
        const object = this.state.ghosts;
        object.push(res.data);
        this.setState({ghosts: object});
      })
      .catch(error => {
        console.log(error)
      });
    this.closeModal();
  },

  removeGhost(ghostId){
    axios.delete("http://localhost:8080/pa165/ghosts/" + ghostId)
      .then(res => {
        console.log("Ghost " + ghostId + " was deleted");
        const object = this.state.ghosts.filter((g) => {
          return g.id !== ghostId
        });
        this.setState({ghosts: object});
      })
      .catch(error => {
        console.log(error)
      });
  },

  updateGhost(){
    const ghost = {
      id: this.state.id,
      name: this.state.name,
      hauntsTo: this.state.hauntsTo,
      hauntsFrom: this.state.hauntsFrom,
      description: this.state.description,
      hauntedHouse: this.state.hauntedHouse,
      abilities: this.state.abilities
    };
    axios.put("http://localhost:8080/pa165/ghosts", ghost)
      .then(res => {
        console.log(res);
        console.log("Ghost " + ghost.id + " was update");
        const object = this.state.ghosts.filter((g) => {
          return g.id !== ghost.id
        });
        object.push(ghost);
        this.setState({ghosts: object});
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
  /*
   componentDidMount() {
   axios.all(this.props.ajaxApi.map(function(api) {
   axios.get(api)
   })).then(axios.spread(function(req1, req2) {
   this.setState({
   ghosts: req1,
   hauntedHouses: req2
   })
   }));
   },
   */
  componentDidMount: function () {
    $.ajax({
      url: 'http://localhost:8080/pa165/ghosts',
      dataType: 'json',
      cache: false,
      success: function (data) {
        this.setState({ghosts: data});
      }.bind(this),
      error: function (xhr, status, err) {
        console.error('http://localhost:8080/pa165/ghosts', status, err.toString());
      }.bind(this)
    });
    $.ajax({
      url: 'http://localhost:8080/pa165/houses',
      dataType: 'json',
      cache: false,
      success: function (data) {
        this.setState({hauntedHouses: data});
      }.bind(this),
      error: function (xhr, status, err) {
        console.error(this.props.url, status, err.toString());
      }.bind(this)
    });
  },

  /*
   componentDidMount() {
   axios.get(`http://localhost:8080/pa165/ghosts`)
   .then(res => {
   this.setState({ghosts: res.data});
   console.log("component ghosts did mount");
   // const posts = res.data.data.children.map(obj => obj.data);
   // this.setState({ posts });
   });
   axios.get(`http://localhost:8080/pa165/houses`)
   .then(result => {
   this.setState({hauntedHouses: result.data});
   console.log("component houses did mount");
   // const posts = res.data.data.children.map(obj => obj.data);
   // this.setState({ posts });
   });
   },
   */

  handleSelectChange: function (event) {
    this.setState({value: event.target.value});
    this.setState({hauntedHouse: event.target.value});
    console.log(this.state.hauntedHouse.name);
    console.log(event.target.value.name);
  },


  render() {
    let tableLines = [];
    this.state.ghosts.forEach(function (ghost, i) {
      var abilitiesOfGhost = ghost.abilities;
      tableLines.push(
        <tr key={i}>
          <th>{ ghost.id } </th>
          <th>{ ghost.name }</th>
          <th>{ ghost.description}</th>
          <th>{ new Date(ghost.hauntsFrom).toLocaleTimeString('en-GB') }</th>
          <th>{ new Date(ghost.hauntsTo).toLocaleTimeString('en-GB') }</th>
          <th> {ghost.hauntedHouse.name}</th>
          <th> {abilitiesOfGhost.map(function (ability, index) {
            return <div key={index}> {ability.name} </div>;
          })}
          </th>
          <th>
            <Button onClick={() => this.openUpdateModal(ghost)}><Glyphicon glyph="pencil"/></Button>
            <Button onClick={() => this.removeGhost(ghost.id)}><Glyphicon glyph="remove"/></Button>
          </th>
        </tr>
      )
    }.bind(this));
    return (
      <div>
        <Modal show={this.state.showCreateModal || this.state.showUpdateModal} onHide={this.closeModal}>
          <Modal.Header closeButton>
            <Modal.Title>Create Ghost</Modal.Title>
          </Modal.Header>
          <Modal.Body>
            <Form horizontal>
              <FormGroup controlId="ghostName">
                <Col componentClass={ControlLabel} sm={3}>
                  Name
                </Col>
                <Col sm={7}>
                  <FormControl type="text" placeholder="Ghost Name" value={this.state.name}
                               onChange={this.handleChange.bind(this, 'name')}/>
                </Col>
              </FormGroup>

              <FormGroup controlId="ghostDescription">
                <Col componentClass={ControlLabel} sm={3}>
                  Description
                </Col>
                <Col sm={7}>
                  <FormControl type="text" placeholder="Ghost Description" value={this.state.description}
                               onChange={this.handleChange.bind(this, 'description')}/>
                </Col>
              </FormGroup>


              <FormGroup controlId="ghosthauntsFrom">
                <Col componentClass={ControlLabel} sm={3}>
                  Haunting from
                </Col>
                <Col sm={7}>
                  <DateTimeField id="datetimepicker" defaultText="Time a ghost haunts from" mode="time"
                                 onChange={x => this.setState({hauntsFrom: x})}/>
                </Col>
              </FormGroup>

              <FormGroup controlId="ghosthauntsTo">
                <Col componentClass={ControlLabel} sm={3}>
                  Haunting to
                </Col>
                <Col sm={7}>
                  <DateTimeField2 id="datetimepicker2" defaultText="Time a ghost haunts to" mode="time"
                                  onChange={x => this.setState({hauntsTo: x})}/>
                </Col>
              </FormGroup>

              <FormGroup controlId="ghostHauntedHouse">
                <Col componentClass={ControlLabel} sm={3}>
                  Haunted house
                </Col>
                <Col sm={7}>
                  <FormControl componentClass="select" placeholder="Select a house for ghost"
                               onChange={x => {
                                 console.log(x);
                                 this.setState({hauntedHouse: x})}}>
                    {this.state.hauntedHouses.map(function (house, index) {
                      return <option value={house} key={index}>{house.name}</option>;
                    })}
                    <option value="a">bka</option>
                  </FormControl>
                </Col>
              </FormGroup>


            </Form>
          </Modal.Body>
          <Modal.Footer>
            {
              this.state.showCreateModal ?
                <Button onClick={this.createGhost}>Create</Button> :
                <Button onClick={this.updateGhost}>Update</Button>
            }
            <Button onClick={this.closeModal}>Close</Button>
          </Modal.Footer>
        </Modal>

        <Table responsive>
          <thead>
          <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Description</th>
            <th>Haunting from</th>
            <th>Haunting to</th>
            <th>Haunted house</th>
            <th>Abilities</th>
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


export default Ghosts;
