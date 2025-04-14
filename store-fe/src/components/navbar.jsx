import React from 'react'
import '../styles/navbar.css';
import { Link } from 'react-router-dom';

const Navbar = () => {


  return (
    <div className='navbar-cont'>
      <div className='navbar'>
      <div className='navbar-left'><h1>LOGO</h1></div>
      <div className='navbar-right'>
      <Link to="/">HOME</Link>
  <Link to="/cart">CART</Link>
  <Link to="/about">ABOUT</Link>
      </div>
    </div>
    </div>
    
  )
}

export default Navbar