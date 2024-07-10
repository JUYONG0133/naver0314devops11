import React from 'react';
import {Alert} from "@mui/material";

const EigthApp = () => {
    const personArray=[
        {pname:"전지현",photo:"8.jpg",addr:"제주도 애월읍",age:45},
        {pname:"설현",photo:"15.jpg",addr:"부산 해운대구",age:26},
        {pname:"신민아",photo:"17.jpg",addr:"서울시 강남구",age:31},
        {pname:"수지",photo:"19.jpg",addr:"서울시 여의도",age:29},
        {pname:"강동원",photo:"9.jpg",addr:"경기도 용인시",age:41},
    ]
    return (
        <div>
            <Alert>EightApp-table 을 이용해서 출력</Alert>
            {
                personArray.map((item,idx)=>
                    <table className="table table-bordered" style={{width: '400px'}}>
                        <tr>
                            <th>이름 :</th>
                            <td>{item.pname}</td>
                        </tr>
                        <tr>
                            <th>사진 :</th>
                            <td>
                                <img alt="" src={require(`../image/${item.photo}`)} className='smallphoto'/>
                            </td>
                        </tr>
                        <tr>
                            <th>주소 : </th>
                            <td>{item.addr}</td>
                        </tr>
                        <tr>
                            <th>나이</th>
                            <td>{item.age}</td>
                        </tr>
                    </table>
                )
            }
        </div>
    );
};

export default EigthApp;