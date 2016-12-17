import React from 'react';
import { Table, Button, Glyphicon, Modal, Form, FormGroup, Col, FormControl, ControlLabel } from 'react-bootstrap'
import axios from 'axios'

var DateTimeField = require('react-bootstrap-datetimepicker');

const Hauntings = React.createClass({

    getInitialState(){
        return{
            hauntings: [],
            showCreateModal: false,
            showUpdateModal: false,
            id: 0,
            date: 0,
            numberOfPeoplePresent: 0,
            hauntedHouse: {},
            ghosts: []
        };
    },

    closeModal(){
        this.setState({ showCreateModal: false, showUpdateModal: false });
    },

    openCreateModal(){
        this.setState({
            showCreateModal: true,
            date: 0,
            numberOfPeoplePresent: 0,
            hauntedHouse: {},
            ghosts: []
        });
    },

    openUpdateModal(haunting){
        this.setState({
            id: haunting.id,
            showUpdateModal: true,
            date: haunting.date,
            numberOfPeoplePresent: haunting.numberOfPeoplePresent,
            hauntedHouse: haunting.hauntedHouse,
            ghosts: haunting.ghosts
        });
    },

    createHaunting(){
        axios.post(`http://localhost:8080/pa165/hauntings`, {
            date: this.state.date,
            numberOfPeoplePresent: this.state.numberOfPeoplePresent,
            hauntedHouse: this.state.hauntedHouse,
            ghosts: this.state.ghosts
        })
            .then(res => {
                console.log("Haunting " + res.data.id + " was created");
                const object = this.state.hauntings;
                object.push(res.data);
                this.setState({hauntings: object});
            })
            .catch(error => {
                console.log(error)
            });
        this.closeModal();
    },

    removeHaunting(hauntingId){
        axios.delete("http://localhost:8080/pa165/hauntings/" + hauntingId)
            .then(res => {
                console.log("Haunting " + hauntingId + " was deleted");
                const object = this.state.hauntings.filter((h) => {
                    return h.id !== hauntingId
                });
                this.setState({hauntings: object});
            })
            .catch(error => {
                console.log(error)
            });
    },

    updateHaunting(){
        const haunting = {
            id: this.state.id,
            date: this.state.date,
            numberOfPeoplePresent: this.state.numberOfPeoplePresent,
            hauntedHouse: this.state.hauntedHouse,
            ghosts: this.state.ghosts
        };
        axios.put("http://localhost:8080/pa165/hauntings", haunting)
            .then(res => {
                console.log(res);
                console.log("Haunting " + haunting.id + " was updated");
                const object = this.state.hauntings.filter((h) => {
                    return h.id !== haunting.id
                });
                object.push(haunting);
                this.setState({hauntings: object});
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
        axios.get(`http://localhost:8080/pa165/hauntings`)
            .then(res => {
                console.log(res.data);
                // const houses = res.data;
                this.setState({ hauntings: res.data });
                // const posts = res.data.data.children.map(obj => obj.data);
                // this.setState({ posts });
            });
    },


    render() {
        let tableLines = [];
        this.state.hauntings.forEach(function (haunting, i) {
            tableLines.push(
                <tr key={i}>
                    <th>{ haunting.id }</th>
                    <th>{ new Date(haunting.date).toLocaleDateString() }</th>
                    <th>{ haunting.numberOfPeoplePresent }</th>
                    <th>{ haunting.hauntedHouse.name }</th>
                    <th>{ haunting.ghosts[0].name}</th>

                    {/*<th>*/}
                        {/*<Button onClick={() => this.openUpdateModal(haunting)}><Glyphicon glyph="pencil"/></Button>*/}
                        {/*<Button onClick={() => this.removeHaunting(haunting.id)}><Glyphicon glyph="remove"/></Button>*/}
                    {/*</th>*/}
                </tr>
            )
        }.bind(this));
        return (
            <div>
                {/*<Modal show={this.state.showCreateModal || this.state.showUpdateModal} onHide={this.closeModal}>*/}
                    {/*<Modal.Header closeButton>*/}
                        {/*<Modal.Title>Create Haunting</Modal.Title>*/}
                    {/*</Modal.Header>*/}
                    {/*<Modal.Body>*/}
                        {/*<Form horizontal>*/}
                            {/*<FormGroup controlId="hauntingDate">*/}
                                {/*<Col componentClass={ControlLabel} sm={3}>*/}
                                    {/*Date*/}
                                {/*</Col>*/}
                                {/*<Col sm={7}>*/}
                                    {/*<DateTimeField id="datetimepicker" defaultText="Date of the haunting" mode="date"*/}
                                                   {/*onChange={x => this.setState({date: x})}/>*/}
                                {/*</Col>*/}
                            {/*</FormGroup>*/}

                            {/*<FormGroup controlId="hauntingNumberOfPeoplePresent">*/}
                                {/*<Col componentClass={ControlLabel} sm={3}>*/}
                                    {/*Number of people present*/}
                                {/*</Col>*/}
                                {/*<Col sm={7}>*/}
                                    {/*<FormControl type="text" placeholder="Haunting number of people present" value={this.state.numberOfPeoplePresent}*/}
                                                 {/*onChange={this.handleChange.bind(this, 'numberOfPeoplePresent')}/>*/}
                                {/*</Col>*/}
                            {/*</FormGroup>*/}


                            {/*/!*<FormGroup controlId="hauntingHauntedHouse">*!/*/}
                                {/*/!*<Col componentClass={ControlLabel} sm={3}>*!/*/}
                                    {/*/!*Haunted house*!/*/}
                                {/*/!*</Col>*!/*/}
                                {/*/!*<Col sm={7}>*!/*/}
                                    {/*/!*<FormControl type="text" placeholder="haunted house name" value={this.state.hauntedHouse}*!/*/}
                                                 {/*/!*onChange={this.handleChange.bind(this, 'hauntedHouse')}/>*!/*/}
                                {/*/!*</Col>*!/*/}
                            {/*/!*</FormGroup>*!/*/}

                            {/*/!*<FormGroup controlId="hauntingGhosts">*!/*/}
                                {/*/!*<Col componentClass={ControlLabel} sm={3}>*!/*/}
                                    {/*/!*Ghosts*!/*/}
                                {/*/!*</Col>*!/*/}
                                {/*/!*<Col sm={7}>*!/*/}
                                    {/*/!*<DateTimeField id="datetimepicker" defaultText="ghosts name" mode="date"*!/*/}
                                                   {/*/!*onChange={x => this.setState({hauntingFrom: x})}/>*!/*/}
                                {/*/!*</Col>*!/*/}
                            {/*/!*</FormGroup>*!/*/}
                        {/*</Form>*/}
                    {/*</Modal.Body>*/}
                    {/*<Modal.Footer>*/}
                        {/*{*/}
                            {/*this.state.showCreateModal ?*/}
                                {/*<Button onClick={this.createHaunting}>Create</Button> :*/}
                                {/*<Button onClick={this.updateHaunting}>Update</Button>*/}
                        {/*}*/}
                        {/*<Button onClick={this.closeModal}>Close</Button>*/}
                    {/*</Modal.Footer>*/}
                {/*</Modal>*/}

                <Table responsive>
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Date</th>
                        <th>Number of people present</th>
                        <th>Haunted house</th>
                        <th>Ghosts present</th>
                        {/*<th><Button onClick={this.openCreateModal}>New <Glyphicon glyph="plus"/></Button></th>*/}
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


export default Hauntings;