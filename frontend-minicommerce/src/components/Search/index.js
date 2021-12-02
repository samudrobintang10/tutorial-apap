import React from "react";
import classes from "./styles.module.css";

const Search = (props) => {
  const {value, action, children} = props;
  return (
    <input name="search" value={value} onChange={action} className={classes.search}>
    </input>
)
};

export default Search;
