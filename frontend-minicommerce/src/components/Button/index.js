import React from "react";
import classes from './styles.module.css';

const Button = (props) => {
    const {action, children} = props;
    return (
        <button onClick={action} className={classes.button}>
            {children}
        </button>
    )
}

export default Button;