import React from "react";

const CartCard = ({
  data,
  handleAddItemToCard = () => {},
  handleRemoveItemFromCart = () => {},
}) => {
  return (
    <div className="cart-card">
      <div className="cart-card-top">
        <section>
          <img className="cart-card-image" src={data?.image} alt={data?.name} />
          <h3 className="cart-card-name">{data?.name}</h3>
        </section>
        <div className="cart-card-action">
          <p
            className="cart-card-btn"
            onClick={() => {
              handleRemoveItemFromCart(data?.id, data?.name);
            }}
          >
            -
          </p>
          <p className="cart-card-count">{data?.count}</p>
          <p
            className="cart-card-btn"
            onClick={() => {
              handleAddItemToCard(data?.id, data?.name);
            }}
          >
            +
          </p>
        </div>
      </div>
      <div className="cart-card-description">{data?.description}</div>
    </div>
  );
};

export default CartCard;
