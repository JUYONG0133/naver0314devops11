import React, {useRef, useState} from 'react';
import {Alert, Button} from "@mui/material";

const ThreeApp = () => {
    const [count,setCount]=useState(1);
    const countRef = useRef(1);
    const countIncre = () => setCount(count+1);

    const countRefIncre = () => countRef.current=countRef.current+1; console.log("countRef.current="+countRef.current);
    return (
        <div>
            <Alert>ThreeApp-useRef</Alert>
            <h1>state 변수 : {count}</h1>
            <h1>Ref 변수 : {countRef.current}</h1>
            <hr/>
            <Button variant='contained' color='success' onClick={countIncre}>state +1</Button>
            <Button variant='contained' color='success' onClick={countRefIncre}>Ref +1</Button>
        </div>
    );
};

export default ThreeApp;

