import React, { useEffect, useState } from "react";
import axios from "axios";
import { toast } from "react-toastify";

import "../styles/cartPage.css";
import CartCard from "../components/cartCard";

const CartPage = () => {
  const [cartItems, setCartItems] = useState([]);
  const [loading, setLoading] = useState(true);

  console.log("CART ITEMS:", cartItems);

  const handleAddItemToCard = async (theId, theName) => {
    try {
      await axios.post(
        `${import.meta.env.VITE_API_BASE_URL}/v1/store/cart/add`,
        {
          user_id: import.meta.env.VITE_USER_ID_1,
          id: theId,
        }
      );
      fetchCartItems();
      toast.success(`${theName} added to cart`);
    } catch (err) {
      if (err?.response?.data?.message) {
        toast.error(err?.response?.data?.message);
      } else {
        toast.error(`Failed to add ${theName} to cart`);
      }
    }
  };

  const handleRemoveItemFromCart = async (theId, theName) => {
    try {
      await axios.post(
        `${import.meta.env.VITE_API_BASE_URL}/v1/store/cart/remove`,
        {
          user_id: import.meta.env.VITE_USER_ID_1,
          id: theId,
        }
      );
      fetchCartItems();
      toast.success(`${theName} removed from cart`);
    } catch (err) {
      if (err?.response?.data?.message) {
        toast.error(err?.response?.data?.message);
      } else {
        toast.error(`Failed to remove ${theName} to cart`);
      }
    }
  };

  const fetchCartItems = async () => {
    setLoading(true);
    try {
      const res = await axios.get(
        `${import.meta.env.VITE_API_BASE_URL}/v1/store/cart/all?user_id=${
          import.meta.env.VITE_USER_ID_1
        }`
      );
      setCartItems(res.data.cart_items || []);
    } catch (error) {
      console.error(error);
      toast.error("Failed to fetch cart items.");
    } finally {
      setLoading(false);
    }
  };

  useEffect(() => {
    fetchCartItems();
  }, []);

  if (loading) return <p>Loading items...</p>;

  return (
    <div className="cart parent-cont">
      <h1 className="cart-title">YOUR CART</h1>
      {cartItems?.map((item, idx) => {
        return (
          <CartCard
            key={idx}
            data={item}
            handleAddItemToCard={handleAddItemToCard}
            handleRemoveItemFromCart={handleRemoveItemFromCart}
          />
        );
      })}
      <button className="cart-checkout">Checkout</button>
    </div>
  );
};

export default CartPage;
