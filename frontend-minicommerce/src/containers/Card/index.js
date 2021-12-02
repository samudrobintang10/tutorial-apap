import React from "react";
import "./index.css";
import { Badge } from "@mui/material";
import Fab from "@mui/material/Fab";
import ShoppingCartIcon from "@mui/icons-material/ShoppingCart";
import ViewStreamIcon from "@mui/icons-material/ViewStream";
import ItemList from "../itemlist";
import CartList from "../cartlist";
import APIConfig from "../../api/APIConfig";

export default class Card extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      cartItems: [],
      cartHidden: true,
      isCheckout: false,
    };
    this.handleDeleteCart = this.handleDeleteCart.bind(this);
    this.handleDeleteCartButton = this.handleDeleteCartButton.bind(this);
  }

  componentDidMount() {
    this.loadData();
  }

//   handleChangeField(event) {
//     const { name, value } = event.target;
//     this.setState({ [name]: value });
//   }

  async loadData() {
    try {
      const { data } = await APIConfig.get("/cart");
      this.setState({ cartItems: data.result });
    } catch (error) {
      alert("Oops terjadi masalah pada server");
      console.log(error);
    }
  }

  componentDidUpdate() {
    this.loadData();
  }

  async handleDeleteCartButton(event) {
    event.preventDefault();
    this.handleDeleteCart(event);
  }

  async handleDeleteCart(event) {
    event.preventDefault();
    try {
      await APIConfig.get("/cart/checkout");
    } catch (error) {
      alert("Oops terjadi masalah pada server");
      console.log(error);
    }
    this.loadData();
  }

  handleToggle = () => {
    const cartHidden = this.state.cartHidden;
    this.setState({ cartHidden: !cartHidden });
  };

  render() {
    return (
      <div className="container-fluid">
        {!this.state.cartHidden ? (
          <div style={{ position: "fixed", top: 25, left: 25 }}>
            <Fab variant="extended" onClick={this.handleToggle} color="primary">
              <p>BACK</p>
            </Fab>
          </div>
        ) : (
          <div style={{ position: "fixed", top: 25, right: 25 }}>
            <Fab variant="extended" onClick={this.handleToggle}>
              {this.state.cartHidden ? (
                <Badge
                  color="secondary"
                  badgeContent={this.state.cartItems.length}
                >
                  <ShoppingCartIcon />
                </Badge>
              ) : (
                <ViewStreamIcon />
              )}
            </Fab>
          </div>
        )}
        {!this.state.cartHidden && (
          <div style={{ position: "fixed", top: 25, right: 25 }}>
            {!this.state.isCheckout && (
              <Fab
                variant="extended"
                onClick={this.handleDeleteCartButton}
                color="primary"
              >
                <p>Checkout</p>
              </Fab>
            )}
          </div>
        )}
        {!this.state.cartHidden && <CartList />}
        {this.state.cartHidden && <ItemList updateBadge={this.updateBadge} />}
      </div>
    );
  }
}
