import React from 'react';
import { Route, Switch, Redirect } from 'react-router-dom';
import Card from './containers/Card';

export const AppRoutes = () => {
    return (
        <div>
            <Switch>
                <Route exact path="/" component={Card} />
            </Switch>
        </div>
    )
}