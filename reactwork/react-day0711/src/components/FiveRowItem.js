import React from 'react';

const FiveRowItem = ({mycar}) => {
    const storage = "https://kr.object.ncloudstorage.com/bitcamp-bucket132/mycar/";
    return (
        <>
            <tr>
                <td style={{width: '150px'}} align='center' rowSpan={5}>
                    <img alt='' style={{width: '130px'}} src={`${storage}${mycar.carphoto}`}/>
                </td>
                <td>자동차명 : {mycar.carname}</td>
            </tr>
            <tr>
                <td>가격 : {mycar.carprice}</td>
            </tr>
            <tr>
                <td>구입일 : {mycar.carguip}</td>
            </tr>
            <tr>
                <td style={{backgroundColor:mycar.carcolor}}>차량색 : {mycar.carcolor}</td>
            </tr>
            <tr>
                <td>등록일 : {mycar.writeday}</td>
            </tr>
        </>
    );
};

export default FiveRowItem;