import React from 'react';
import './Mystyle.css';
// const FiveChild2App = ({photo,msg}) => {
const FiveChild2App = (props) => {
    let {photo,msg} = props;
    return (
        <div className='box2'>
            <img alt="" src={require(`../image/${photo}`)} className='small'/>
            {msg}
        </div>
    );
};

export default FiveChild2App;