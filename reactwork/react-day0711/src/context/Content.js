import React, {useContext} from 'react';
import {ThemeContext} from "./ThemeContext";
import {UserContext} from "./UserContext";

const Content = () => {
    const {isDark} = useContext(ThemeContext);
    const myname = useContext(UserContext);

    return (
        <div className='content' style={{backgroundColor:isDark?'gold':'wheat'}}>
            <h1>{myname} :  공부</h1>
        </div>
    );
};

export default Content;