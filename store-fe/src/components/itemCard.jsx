import React from "react";

const ItemCard = ({ data, handleAddItemToCard = () => {} }) => {
  return (
    <div className="homepage-card">
      <img className="homepage-card-image" src={data?.image} alt={data?.name} />
      <div className="homepage-card-content">
        <div className="homepage-card-info">
          <h2 className="homepage-card-name">{data?.name}</h2>
          <p className="homepage-card-description">{data?.description}</p>
          <p className="homepage-card-price">
            {data?.price} /- <span>INR only</span>
          </p>
        </div>

        <div className="homepage-card-footer">
          <button
            onClick={() => {
              handleAddItemToCard(data?.id, data?.name);
            }}
          >
            Add to cart
          </button>
          <p>{`hurry only ${data?.quantity} left`}</p>
        </div>
      </div>
    </div>
  );
};

export default ItemCard;
