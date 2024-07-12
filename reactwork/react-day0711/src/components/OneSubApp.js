import React from 'react';
import {CloseSharp} from "@mui/icons-material";

const OneSubApp = ({idx,item,deleteSangpum}) => {
    return (
        <>
            <tr>
                <td style={{width:'200px',backgroundColor:'#cff'}} rowSpan={4} align='center'>
                    <img alt="" src={require(`../shop/${item.sphoto}`)} style={{width:'120px',height:'130px',border:'1px solid gray'}}/>
                    <br/>
                    <CloseSharp style={{cursor:'pointer'}} onClick={()=>{
                        let a = window.confirm("삭제해?");
                        if(a)
                            deleteSangpum(idx)}

                    }/>


                </td>
                <td>상품번호 : {idx+1}번</td>
            </tr>
            <tr>
                <td>상품명 : {item.sname}</td>
            </tr>
            <tr>
                <td>색 상 : <b style={{backgroundColor:item.scolor}}>{item.scolor}</b></td>
            </tr>
            <tr>
                <td>가 격 : {item.sprice}원</td>
            </tr>

        </>
    );
};

export default OneSubApp;