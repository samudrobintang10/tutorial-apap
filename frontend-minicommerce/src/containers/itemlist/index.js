import React, { Component } from "react";
import Item from "../../components/Item";
import classes from "./styles.module.css";
import APIConfig from "../../api/APIConfig";
import Button from "../../components/Button";
import Modal from "../../components/modal";
import Search from "../../components/Search";

class ItemList extends Component {
  constructor(props) {
    super(props);
    this.state = {
      items: [],
      searchItems: [],
      isLoading: false,
      isCreate: false,
      isEdit: false,
      isSearch: false,
      id: "",
      title: "",
      price: 0,
      description: "",
      category: "",
      quantity: 0,
      search: "",
      qtyCart: 0,
    };
    this.handleClickLoading = this.handleClickLoading.bind(this);
    this.handleAddItem = this.handleAddItem.bind(this);
    this.handleCancel = this.handleCancel.bind(this);
    this.handleChangeField = this.handleChangeField.bind(this);
    this.handleSubmitItem = this.handleSubmitItem.bind(this);
    this.handleSubmitEditItem = this.handleSubmitEditItem.bind(this);
    this.handleSubmitItem = this.handleSubmitItem.bind(this);
    this.handleSearch = this.handleSearch.bind(this);
  }
  componentDidMount() {
    this.loadData();
  }
  async loadData() {
    try {
      const { data } = await APIConfig.get("/item");
      this.setState({ items: data.result, isSearch: false });
    } catch (error) {
      alert("Oops terjadi masalah pada server");
      console.log(error);
    }
  }

  handleAddItem() {
    this.setState({ isCreate: true });
    this.setState({isCheckout: !this.state.isCheckout});
  }

  async handleSearch(title) {
    try {
      let number = 0;
      for (let index = 0; index < this.state.items.length; index++) {
        const element = this.state.items[index];
        if (element.title == title) {
          number = element.id;
        }
      }
      const { data } = await APIConfig.get(`/item/${number}`);
      if (data.result != null) {
        this.setState({ searchItems: [data.result], isSearch: true });
      } else {
        this.setState({ searchItems: [], isSearch: true });
      }
      console.log(this.state.searchItems);
    } catch (error) {
      alert("Oops terjadi masalah pada server");
      console.log(error);
    }
  }

  handleCancel(event) {
    event.preventDefault();
    this.setState({ isCreate: false, isEdit: false });
  }

  handleChangeField(event) {
    const { name, value } = event.target;
    this.setState({ [name]: value });
    if (name == "search") {
      if (value != "") {
        this.handleSearch(value);
      } else {
        this.loadData();
      }
    }
  }

  async handleSubmitItem(event) {
    event.preventDefault();
    try {
      const data = {
        title: this.state.title,
        price: this.state.price,
        description: this.state.description,
        category: this.state.category,
        quantity: this.state.quantity,
      };
      await APIConfig.post("/item", data);
      this.setState({
        // Soal 1
        // Untuk Latihan nomor 1 masalah tersebut ditangani dibagian ini
        id: "",
        title: "",
        price: 0,
        description: "",
        category: "",
        quantity: 0,
      });
      this.loadData();
    } catch (error) {
      alert("Oops terjadi masalah pada server");
      console.log(error);
    }
    this.handleCancel(event);
  }

  handleEditItem(item) {
    this.setState({
      isEdit: true,
      id: item.id,
      title: item.title,
      price: item.price,
      description: item.description,
      category: item.category,
      quantity: item.quantity,
    });
  }

  async handleSubmitEditItem(event) {
    event.preventDefault();
    try {
      const data = {
        title: this.state.title,
        price: this.state.price,
        description: this.state.description,
        category: this.state.category,
        quantity: this.state.quantity,
      };
      await APIConfig.put(`/item/${this.state.id}`, data);
      this.setState({
        id: "",
        title: "",
        price: 0,
        description: "",
        category: "",
        quantity: 0,
      });
      this.loadData();
    } catch (error) {
      alert("Oops terjadi masalah pada server");
      console.log(error);
    }
    this.handleCancel(event);
  }

  // shouldComponentUpdate(nextProps, nextState) {
  //   console.log("shouldComponentUpdate()");
  //   return true;
  // }
  handleClickLoading() {
    const currentLoading = this.state.isLoading;
    this.setState({ isLoading: !currentLoading });
    console.log(this.state.isLoading);
  }

  async handleUpdateStokItem(item) {
    try {
      const data = {
        title: item.title,
        price: item.price,
        description: item.description,
        category: item.category,
        quantity: item.quantity - this.state.qtyCart,
      };
      await APIConfig.put(`/item/${item.id}`, data);
      this.loadData();
    } catch (error) {
      alert("Oops terjadi masalah pada server");
      console.log(error);
    }
  }

  async handleAddCart(item) {
    if (this.state.qtyCart < item.quantity) {
      this.handleUpdateStokItem(item);
      try {
        const data = {
          quantity: this.state.qtyCart,
          idItem: item.id,
        };
        await APIConfig.post("/cart", data);
      } catch (error) {
        alert("Oops terjadi masalah pada server");
        console.log(error);
      }
    } else {
      alert("stok tidak memenuhi");
    }
  }

  render() {
    return (
      <div className={classes.itemList}>
        <h1 className={classes.title}>All Items</h1>
        <div>
          <Search action={this.handleChangeField}></Search>
        </div>
        <Button action={this.handleAddItem}>Add Item</Button>
        <div>
          {this.state.isSearch &&
            this.state.searchItems.map((item) => (
              <Item
                key={item.id}
                id={item.id}
                title={item.title}
                price={item.price}
                description={item.description}
                category={item.category}
                quantity={item.quantity}
                handleEdit={() => this.handleEditItem(item)}
                handleInputQty={this.handleChangeField}
                handleAddCart={() => this.handleAddCart(item)}
              />
            ))}
          {!this.state.isSearch &&
            this.state.items.map((item) => (
              <Item
                key={item.id}
                id={item.id}
                title={item.title}
                price={item.price}
                description={item.description}
                category={item.category}
                quantity={item.quantity}
                handleEdit={() => this.handleEditItem(item)}
                handleInputQty={this.handleChangeField}
                handleAddCart={() => this.handleAddCart(item)}
              />
            ))}
        </div>
        <Modal
          show={this.state.isCreate || this.state.isEdit}
          handleCloseModal={this.handleCancel}
          modalTitle={
            this.state.isCreate ? "Add Item" : `Edit Item ID ${this.state.id}`
          }
        >
          <form>
            <input
              type="text"
              className={classes.textField}
              placeholder="Nama Item"
              name="title"
              value={this.state.title}
              onChange={this.handleChangeField}
            />
            <input
              type="number"
              className={classes.textField}
              placeholder="Harga"
              name="price"
              value={this.state.price}
              onChange={this.handleChangeField}
            />
            <textarea
              type="deskripsi"
              className={classes.textField}
              placeholder="Deskripsi"
              name="description"
              rows="4"
              value={this.state.description}
              onChange={this.handleChangeField}
            />
            <input
              type="text"
              className={classes.textField}
              placeholder="Kategori"
              name="category"
              value={this.state.category}
              onChange={this.handleChangeField}
            />
            <input
              type="number"
              className={classes.textField}
              placeholder="qty"
              name="quantity"
              value={this.state.quantity}
              onChange={this.handleChangeField}
            />
            <Button
              action={
                this.state.isCreate
                  ? this.handleSubmitItem
                  : this.handleSubmitEditItem
              }
            >
              Create
            </Button>
            <Button action={this.handleCancel}>Cancel</Button>
          </form>
        </Modal>
      </div>
    );
  }
}

export default ItemList;
