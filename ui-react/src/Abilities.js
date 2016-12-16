import React from 'react';
import { Table, Button, Glyphicon, Modal, Form, FormGroup, Col, FormControl, ControlLabel } from 'react-bootstrap'
import axios from 'axios'

// class Abilities extends Component {
//   render() {
//     return (
//       <div>
//         abilities
//       </div>
//     );
//   }
// }

const Abilities = React.createClass({
    getInitialState(){
        return {
            abilities: [],
            showCreateModal: false,
            showUpdateModal: false,
            id: 0,
            name: "",
            description: ""
        };
    },

    closeModal(){
        this.setState({ showCreateModal: false, showUpdateModal: false });
    },

    openCreateModal(){
        this.setState({
            showCreateModal: true,
            name: "",
            description: ""
        });
    },

    openUpdateModal(ability){
        this.setState({
            id: ability.id,
            showUpdateModal: true,
            name: ability.name,
            description: ability.description
        });
    },

    createHouse(){
            axios.post(`http://localhost:8080/pa165/abilities`, {
            name: this.state.name,
            description: this.state.description
        })
            .then(res => {
                console.log("Ability " + res.data.id + " was created");
                const object = this.state.abilities;
                object.push(res.data);
                this.setState({abilities: object});
            })
            .catch(error => {
                console.log(error)
            });
        this.closeModal();
    },

    removeAbility(abilityID){
        axios.delete("http://localhost:8080/pa165/abilities/" + abilityID)
            .then(res => {
                console.log("Ability " + abilityID + " was deleted");
                const object = this.state.abilities.filter((ability) => {
                    return ability.id !== abilityID
                });
                this.setState({abilities: object});
            })
            .catch(error => {
                console.log(error)
            });
    },

    updateHouse(){
        const ability = {
            id: this.state.id,
            name: this.state.name,
            description: this.state.description,
        };
        axios.put("http://localhost:8080/pa165/abilities", ability)
            .then(res => {
                console.log(res);
                console.log("Ability " + ability.id + " was update");
                const object = this.state.abilities.filter((a) => {
                    return a.id !== ability.id
                });
                object.push(ability);
                this.setState({abilities: object});
            })
            .catch(error => {
                console.log(error)
            });
        this.closeModal();
    },

    handleChange: function(field, e) {
        const object = {};
        object[field] = e.target.value;
        this.setState(object);
    },

    componentDidMount() {
        axios.get(`http://localhost:8080/pa165/abilities`)
            .then(res => {
                console.log(res.data);
                // const houses = res.data;
                this.setState({ abilities: res.data });
                // const posts = res.data.data.children.map(obj => obj.data);
                // this.setState({ posts });
            });
    },


    render() {
        let tableLines = [];
        this.state.abilities.forEach(function (ability, i) {
            tableLines.push(
                <tr key={i}>
                    <th>{ ability.id }</th>
                    <th>{ ability.name }</th>
                    <th>{ ability.description }</th>
                    <th>
                        <Button onClick={() => this.openUpdateModal(ability)}><Glyphicon glyph="pencil"/></Button>
                        <Button onClick={() => this.removeAbility(ability.id)}><Glyphicon glyph="remove"/></Button>
                    </th>
                </tr>
            )
        }.bind(this));
        return (
            <div>
                <Modal show={this.state.showCreateModal || this.state.showUpdateModal} onHide={this.closeModal}>
                    <Modal.Header closeButton>
                        <Modal.Title>Create Ability</Modal.Title>
                    </Modal.Header>
                    <Modal.Body>
                        <Form horizontal>
                            <FormGroup controlId="abilityName">
                                <Col componentClass={ControlLabel} sm={3}>
                                    Name
                                </Col>
                                <Col sm={7}>
                                    <FormControl type="text" placeholder="Ability name" value={this.state.name}
                                                 onChange={this.handleChange.bind(this, 'name')}/>
                                </Col>
                            </FormGroup>

                            <FormGroup controlId="abilityDescription">
                                <Col componentClass={ControlLabel} sm={3}>
                                    Description
                                </Col>
                                <Col sm={7}>
                                    <FormControl type="text" placeholder="Ability Description" value={this.state.address}
                                                 onChange={this.handleChange.bind(this, 'description')}/>
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
                        <th>Description</th>
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
})

export default Abilities;
