// src/redux/userdata.js

import { configureStore, createSlice } from '@reduxjs/toolkit';

export let userdataReducer = createSlice({
    name: 'userdataReducer',
    initialState: {
        userdata: {
            apiToken: '',
        },
    },
    reducers: {
        getCurrentUserdata: (state, action) => {
            state.userdata = {
                ...state.userdata,
                ...action.payload,
            };
        },
        logout: (state) => {
            state.userdata = null;
        },
    },
});

export let { getCurrentUserdata, logout } = userdataReducer.actions;

export default userdataReducer;
