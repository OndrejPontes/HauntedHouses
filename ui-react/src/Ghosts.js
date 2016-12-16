import React from 'react';
import {Table, Button, Glyphicon, Modal, Form, FormGroup, Col, FormControl, ControlLabel} from 'react-bootstrap'
import axios from 'axios'
var DateTimeField = require('react-bootstrap-datetimepicker');
var DateTimeField2 = require('react-bootstrap-datetimepicker');

const Ghosts = React.createClass({
    getInitialState(){
        return {
            ghosts: [],
            showCreateModal: false,
            showUpdateModal: false,
            id: 0,
            name: "",
            description: "",
            hauntsFrom: 0,
            hauntsTo: 0,
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
            abilities: []
        });
    },

    createGhost(){
        axios.post(`http://localhost:8080/pa165/ghosts`, {
            name: this.state.name,
            description: this.state.description,
            hauntsFrom: this.state.hauntsFrom,
            hauntsTo: this.state.hauntsTo,
            abilities: []
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

    removeGhost(ghost){
        axios.delete("http://localhost:8080/pa165/ghosts/" + ghost)
            .then(res => {
                console.log("Ghost " + ghost.id + " was deleted");
                const object = this.state.ghosts.filter((g) => {
                    return g !== ghost
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
            abilities: []
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

    componentDidMount() {
        axios.get(`http://localhost:8080/pa165/ghosts`)
            .then(res => {
                this.setState({ghosts: res.data});
                console.log("component did mount");
                // const posts = res.data.data.children.map(obj => obj.data);
                // this.setState({ posts });
            });
    },


    render() {
        let tableLines = [];
        this.state.ghosts.forEach(function (ghost, i) {
            tableLines.push(
                <tr key={i}>
                    <th>{ ghost.id }</th>
                    <th>{ ghost.name }</th>
                    <th>{ ghost.description}</th>
                    <th>{ ghost.hauntsFrom }</th>
                    <th>{ ghost.hauntsTo }</th>
                    <th>
                        <Button onClick={() => this.openUpdateModal(ghost)}><Glyphicon glyph="pencil"/></Button>
                        <Button onClick={() => this.removeGhost(ghost)}><Glyphicon glyph="remove"/></Button>
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
                <DateTimeField id="datetimepicker" defaultText="Date when everything begin" mode="date" onChange={x => this.setState({hauntsFrom: x})}/>
                </Col>
                </FormGroup>

                <FormGroup controlId="ghosthauntsTo">
                <Col componentClass={ControlLabel} sm={3}>
                Haunting to
                </Col>
                <Col sm={7}>
                <DateTimeField2 id="datetimepicker2" defaultText="Date when everything ended" mode="date" onChange={x => this.setState({hauntsTo: x})}/>
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
