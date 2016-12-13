import React, {Component} from 'react';
import { Navbar, Nav, NavItem } from 'react-bootstrap'

class Header extends Component {
  render(){
    return(
      <Navbar>
        <Navbar.Header>
          <Navbar.Brand>
            <a href="#">Haunted Houses</a>
          </Navbar.Brand>
        </Navbar.Header>
        <Nav>
          <NavItem href="#houses" >Houses</NavItem>
          <NavItem href="#ghosts">Ghosts</NavItem>
          <NavItem href="#haunting">Haunting</NavItem>
          <NavItem href="#abilities">Abilities</NavItem>
        </Nav>
      </Navbar>
    );
  }
}

export default Header;



