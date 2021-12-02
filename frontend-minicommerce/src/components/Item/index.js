import React from "react";
import Button from "../Button";
import classes from "./styles.module.css";
const Item = (props) => {
  const {
    id,
    title,
    price,
    description,
    category,
    quantity,
    handleEdit,
    handleInputQty,
    handleAddCart,
    value,
    cart,
    total,
    handleDelete,
  } = props;
  return (
    <div className={classes.item}>
      {cart ? <h3>{`ID Cart ${id}`}</h3> : <h3>{`ID ${id}`}</h3>}
      <p>{`Nama Barang: ${title}`}</p>
      <p>{`Harga: ${price}`}</p>
      {cart && <p>{`Jumlah: ${quantity}`}</p>}
      <p>{`Deskripsi: ${description}`}</p>
      <p>{`Kategori: ${category}`}</p>
      {!cart && <p>{`stok: ${quantity}`}</p>}
      {!cart && <Button action={handleEdit}>Edit</Button>}
      <div>
        {!cart && 
        <input
          type="number"
          className={classes.textField}
          name="qtyCart"
          onChange={handleInputQty}
          value={value}
        />}
        {!cart ? 
        <Button action={handleAddCart}>Add to Cart</Button> : 
        <b><p>{`Total Harga: ${total}`}</p></b>}
      </div>
    </div>
  );
};
export default Item;
