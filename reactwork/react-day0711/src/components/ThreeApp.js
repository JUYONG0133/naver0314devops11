import React, {useRef} from 'react';
import {Alert} from "@mui/material";
import cate from '../data/CateData.json';
import './MyStyle.css';
import errorImg from '../shop/1.jpg';

const ThreeApp = () => {
    // json 데이터 가져오기
    const navData = cate.navData;
    const categoryDate = cate.categoryData;

    // 이미지 ref
    const mainPhotoRef = useRef(null);

    return (
        <div>
            <Alert variant='filled' color='error'>Json 데이터 출력</Alert>
            <div className='nav_container'>
                <ul className='nav_category'>
                    {
                        navData.map((item, i) =>
                            <li key={i}>
                                <div>
                                    <img alt='' src={item.img} className='imgcategory'
                                         onClick={(e) => mainPhotoRef.current.src = e.target.src}
                                    />
                                </div>
                                <div>
                                    {item.title}
                                </div>
                            </li>
                        )
                    }
                </ul>
            </div>
            <div className='nav_container'>
                <ul className='nav_category'>
                    {
                        categoryDate.map((item, i) =>
                            <li key={i}>
                                <div>
                                    <img alt='' src={item.img} className='imgcategory'
                                         onMouseOver={(e) => mainPhotoRef.current.src = e.target.src}
                                    />
                                </div>
                                <div>
                                    {item.title}
                                </div>
                            </li>
                        )
                    }
                </ul>
            </div>
            <div>
                <img ref={mainPhotoRef} alt='' src={errorImg} style={{
                    width: '300px', height: '300px', border: '5px inset gray', margin: '10px 200px'
                }} onError={errorImg}
                />
            </div>
        </div>
    );
};

export default ThreeApp;
