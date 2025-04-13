import { Routes, Route } from 'react-router'
import HomePage from './pages/homePage'

export default function App() {
  return (
    <Routes>
      <Route path="/" element={<HomePage />} />
      <Route path="/cart" element={<p>CART</p>} />
      <Route path="/checkout" element={<p>CHECKOUT</p>} />
    </Routes>
  )
}