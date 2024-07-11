import React, {useState} from 'react';
import {Alert} from "@mui/material";
import {Delete} from "@mui/icons-material";

const OneApp = () => {
    const [msg,setMsg]=useState(["Happy","안녕","bitcamp"]);

    const addMessageEvent=(e)=>{
        if(e.key==='Enter'){
            setMsg(msg.concat(e.target.value));
            e.target.value="";
        }
    }
    const deleteMessage=(i)=>{
        //alert(i);
        // setMsg([
        //     ...msg.slice(0,1),
        //     ...msg.slice(i+1,msg.length)
        // ])

        setMsg(msg.filter((m,n)=>n!==i));
    }

    return (
        <div>
            <Alert>OneApp-배열에 데이터 추가, 삭제하기</Alert>
            <h4 style={{color:'burlywood'}}>배열 데이터 출력</h4>
            <Alert severity="info">총 {msg.length}개의 메세지가 있음</Alert>
            <hr/>
            <input type='text' className='form-control' style={{width:'300px'}} placeholder='메세지 입력 후 엔터'
                onKeyUp={addMessageEvent}
            />
            <hr/>
            {
                msg &&
                msg.map((m,i)=>
                    <h6 key={i}>{m}&nbsp;&nbsp;
                        <Delete style={{cursor:'pointer'}} onClick={()=>deleteMessage(i)}/>
                    </h6>
                )
            }
        </div>
    );
};

export default OneApp;