import React, {Component} from 'react';
import { Table } from 'react-bootstrap'
import axios from 'axios'

class Houses extends Component {

  constructor() {
    super();
    axios.get(`http://localhost:8080/houses`)
      .then(res => {
        console.log(res.data);
        // const houses = res.data;
        this.setState({ houses: res.data });
        // const posts = res.data.data.children.map(obj => obj.data);
        // this.setState({ posts });
      });
  }

  render() {
    let tableLines = [];
    console.log(this.state);
    this.state.houses.forEach(function (house) {
      console.log(house);
      tableLines.push(
        <tr>
          <th>house.id</th>
          <th>house.name</th>
          <th>house.address</th>
          <th>house.history</th>
          <th>house.hauntingFrom</th>
        </tr>
      )
    });
    return (
      <div>
        <Table responsive>
          <thead>
          <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Address</th>
            <th>History</th>
            <th>Haunting from</th>
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
