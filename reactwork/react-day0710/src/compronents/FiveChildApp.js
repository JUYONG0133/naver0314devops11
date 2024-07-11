import React from 'react';
import './Mystyle.css';
const FiveChildApp = (props) => {
    return (
        <div>
            <div className='box1'>
                이 름 : {props.irum},
                나 이 : {props.age},
                주 소 :{props.addr},
            </div>
        </div>
    );
};

export default FiveChildApp;