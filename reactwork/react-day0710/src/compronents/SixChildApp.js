import React from 'react';
import './Mystyle.css';
import {Button} from "@mui/material";
const SixChildApp = (props) => {
    let {carname,carphoto,carprice,onIncre}=props;
    return (
        <div className='box3'>
            차 량 명 : {carname}<br/>
            가    격 : {carprice}만원<br/>
            <img alt="" src={require(`../image/${carphoto}`)} className='small2'/>
            <br/>
            <Button variant='outlined' color='error' size='small' onClick={onIncre}>방문</Button>

        </div>
    );
};

export default SixChildApp;