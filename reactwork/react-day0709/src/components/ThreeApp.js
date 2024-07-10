import React, {useState} from 'react';
import {Alert, Switch} from "@mui/material";
import img1 from '../image/17.jpg';
import img2 from '../image/12.jpg';

const ThreeApp = () => {
    const [show,setShow] = useState(true);
    const [visible,setVisible]=useState('visible');

    const photoStyle = {
        width:"200px",
        height:'200px',
        border:"1px solid gray",
        borderRadius:'100px'

    }
    const photoCheckEvent = (e) => setShow(e.target.checked);
    const photoSwitchEvent = (e) => setVisible(e.target.checked?"visible":"hidden");
    return (
        <div>
            <Alert>ThreeApp --- show/hide</Alert>
            <Alert severity='info'>ThreeApp --- show/hide</Alert>
            <Alert severity='error'>ThreeApp --- show/hide</Alert>
            <Alert severity='warning'>ThreeApp --- show/hide</Alert>
            <label>
                <input type='checkbox' defaultChecked onClick={photoCheckEvent}/>사진1 보이기
            </label>
            <br/>
            {
                show &&
            <img alt='img' src={img1} style={photoStyle}/>
            }
            <hr/>
            <Switch color='primary' defaultChecked onChange={photoSwitchEvent}/>사진 2 보이기
            <br/>
            <img alt='img' src={img2} style={{width:'200px',visibility:visible}}/>


        </div>
    );
};

export default ThreeApp;