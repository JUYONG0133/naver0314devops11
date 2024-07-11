import React, { useState } from 'react';
import { Alert } from "@mui/material";

const TwoApp = () => {
    const [names, setNames] = useState(["한가인", "캔디", "테리우스"]);
    const [inputValue, setInputValue] = useState('');

    const handleInputChange = (e) => {
        setInputValue(e.target.value);
    };

    const addMessageEvent = () => {
        if (inputValue.trim() !== '') {
            setNames([...names, inputValue]);
            setInputValue('');
        }
    };

    const handleKeyPress = (e) => {
        if (e.key === 'Enter') {
            addMessageEvent();
        }
    };

    const removeName = (index) => {
        setNames(names.filter((_, i) => i !== index));
    };

    return (
        <div>
            <Alert>TwoApp-배열 추가, 삭제 문제</Alert>

            <div className='input-group' style={{width: "300px"}}>
                <h4>이름 입력 :</h4>
                <input
                    type='text'
                    className='form-control'
                    value={inputValue}
                    onChange={handleInputChange}
                    onKeyUp={handleKeyPress}
                />
                <button
                    type='button'
                    className='btn btn-outline-danger btn-sm'
                    onClick={addMessageEvent}
                >추가
                </button>
            </div>
            <hr/>
            {names.map((name, index) => (
                <h4 key={index}>
                    {name}&nbsp;&nbsp;
                    <button
                        type='button'
                        className='btn btn-success btn-sm'
                        onClick={() => removeName(index)}
                    >삭제
                    </button>
                </h4>
            ))}
        </div>
    );
};

export default TwoApp;
