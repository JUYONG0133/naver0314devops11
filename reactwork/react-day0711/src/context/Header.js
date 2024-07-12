import React, {useContext} from 'react';
import {ThemeContext} from "./ThemeContext";
import {UserContext} from "./UserContext";

const Header = () => {
    const {isDark} =useContext(ThemeContext);
    const username = useContext(UserContext);

    return (
        <div>
            <header className='header' style={{backgroundColor:isDark?'black':'lightgray'}}>
                <h1>{username}</h1>
            </header>
        </div>
    );
};

export default Header;