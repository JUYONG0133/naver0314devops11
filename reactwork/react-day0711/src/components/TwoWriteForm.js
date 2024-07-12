import React, {useState} from 'react';
import {Button} from "@mui/material";

const TwoWriteForm = ({onSave}) => {
    const [irum,setIrum]=useState('');
    const [age,setAge]=useState('');
    const [blood,setBlood]=useState('A');

    const addDataEvent = (e)=>{
        onSave({
            irum,age,blood
        })
        setIrum("");
        setAge("");
        setBlood('A');
    }

    return (

        <div className='input-group' style={{width:'450px'}}>
            <h6>이름</h6>
            <input type='text' className='form-control' style={{width:'80px'}} value={irum} onChange={(e)=>setIrum((e.target.value))}/>
            <h6>이름</h6>
            <input type='text' className='form-control' style={{width:'50px'}} value={age} onChange={(e)=>setAge((e.target.value))}/>
            <h6>혈액형</h6>
            <select className='form-select' onChange={(e)=>setBlood(e.target.value)}>
                <option>A</option>
                <option>AB</option>
                <option>O</option>
                <option>B</option>
            </select>
            <Button variant='contained' color='inherit' onClick={addDataEvent}>추가</Button>
        </div>
    );
};

export default TwoWriteForm;