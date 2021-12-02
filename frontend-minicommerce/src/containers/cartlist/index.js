import React, { Component } from "react";
import Item from "../../components/Item";
import classes from "./styles.module.css";
import APIConfig from "../../api/APIConfig";

class CartList extends Component {
  constructor(props) {
    super(props);
    this.state = {
      cartItems: [],
    };

  }
  componentDidMount() {
    this.loadData();
  }
  componentDidUpdate() {
    this.loadData();
  }

  async loadData() {
    try {
      const { data } = await APIConfig.get("/cart");
      this.setState({ cartItems: data.result});
      console.log(data.result)
    } catch (error) {
      alert("Oops terjadi masalah pada server");
      console.log(error);
    }
  }

  render() {
    return (
      <div className={classes.itemList}>
        <h1 className={classes.title}>Cart Items</h1>
        <div>
          {this.state.cartItems.map((cart) => (
            <Item
              key={cart.id}
              id={cart.id}
              title={cart.item.title}
              price={cart.item.price}
              description={cart.item.description}
              category={cart.item.category}
              quantity={cart.quantity}
              cart={true}
              total={cart.item.price * cart.quantity}
            />
          ))}
        </div>
      </div>
    );
  }
}

export default CartList;
