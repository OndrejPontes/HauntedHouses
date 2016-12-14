  import React from 'react';
import ReactDOM from 'react-dom';
import App from './App';
import './index.css';
import {Router, Route, hashHistory}from 'react-router'
import Header from './Header'
import Haunting from './Haunting'
import Abilities from './Abilities'
import Ghosts from './Ghosts'
import Houses from "./Houses";

ReactDOM.render(
  <div>
    <Header/>
    <div className="container">
      <Router history={hashHistory}>
        <Route path='/' component={App}/>
        <Route path='/houses' component={Houses}/>
        <Route path='/ghosts' component={Ghosts}/>
        <Route path='/haunting' component={Haunting}/>
        <Route path='/abilities' component={Abilities}/>
      </Router>
    </div>
  </div>,
  document.getElementById('root')
);
