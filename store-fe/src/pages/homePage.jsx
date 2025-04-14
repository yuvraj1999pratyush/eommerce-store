import React, { useState, useEffect } from "react";
import { toast } from "react-toastify";
import axios from "axios";

import "../styles/common.css";
import "../styles/homePage.css";
import ItemCard from "../components/itemCard";

const HomePage = () => {
  const [items, setItems] = useState([]);
  const [loading, setLoading] = useState(true);

  const handleAddItemToCart = async (theId, theName) => {
    try {
      await axios.post(
        `${import.meta.env.VITE_API_BASE_URL}/v1/store/cart/add`,
        {
          user_id: import.meta.env.VITE_USER_ID_1,
          id: theId,
        }
      );
      fetchAllItems();
      toast.success(`${theName} added to cart`);
    } catch (err) {
      if (err?.response?.data?.message) {
        toast.error(err?.response?.data?.message);
      } else {
        toast.error(`Failed to add ${theName} to cart`);
      }
    }
  };

  const fetchAllItems = async () => {
    setLoading(true);
    try {
      const res = await axios.get(
        `${import.meta.env.VITE_API_BASE_URL}/v1/store/items/all`
      );
      setItems(res?.data?.items || []);
    } catch (error) {
      console.error(error);
      toast.error("Failed to fetch items. Please try again.");
    } finally {
      setLoading(false);
    }
  };

  useEffect(() => {
    fetchAllItems();
  }, []);

  if (loading) return <p>Loading items...</p>;

  return (
    <div className="parent-cont homepage">
      {items?.map((item) => {
        return (
          <ItemCard data={item} handleAddItemToCard={handleAddItemToCart} />
        );
      })}
    </div>
  );
};

export default HomePage;
