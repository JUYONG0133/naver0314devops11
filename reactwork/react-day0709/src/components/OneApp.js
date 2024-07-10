import React from 'react';
import styled from 'styled-components';
import {AccessAlarm, BookmarkAdd} from "@mui/icons-material";
import {Button} from "@mui/material";


const OneApp = () => {
    const Title = styled.h1`
        font-size: 1.5em;
        text-align: center;
        color: orange;
    `;
    const Title2 = styled(Title)`
        width: 200px;
        height: 200px;
        line-height: 200px;
        background-color: tomato;
        border: 3px solid green;
    `;
    const Mybutton = styled.button`
        color: orange;
        width: 200px;
        height: 60px;
        border: 1px solid hotpink;
        border-radius: 30px;
        margin-top: 10px;
    `;
    const Mybutton2 = styled(Mybutton)`
        color: blue;
        background-color: yellow;
        border: 2px solid gray;
    `;

    return (
        <div>
            <h3 className='alert alert-danger'>
                <AccessAlarm/>
                <BookmarkAdd/>
                OneApp --- styled-components</h3>

            <h1>Hello H1</h1>
            <Title>Hello title</Title>
            <hr/>
            <Button variant='outlined' color='success'>Hello Button</Button>
            <Button variant='contained' color='success'>Hello Button</Button>
            <br/>
            <Mybutton>MyButton Style</Mybutton>
            <Mybutton2>MyButton Style</Mybutton2>
            <Title2>Hello Title2</Title2>
        </div>
    );
};

export default OneApp;