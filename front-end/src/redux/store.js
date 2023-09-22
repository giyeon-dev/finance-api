// src/redux/store.js
import { combineReducers } from "@reduxjs/toolkit";
import userdataReducer from "./userdata.js";

import storage from 'redux-persist/lib/storage';
import { configureStore, getDefaultMiddleware } from "@reduxjs/toolkit";
import { persistReducer } from 'redux-persist';
import { FLUSH, REHYDRATE, PAUSE, PERSIST, PURGE, REGISTER } from 'redux-persist';
import persistStore from "redux-persist/es/persistStore";


const persistConfig = {
    key: 'root',
    storage,
};

const rootReducer = combineReducers({
    userdataReducer: userdataReducer.reducer,
});

const persistedReducer = persistReducer(persistConfig, rootReducer);

const store = configureStore({
    reducer: persistedReducer,
    middleware: getDefaultMiddleware({
      serializableCheck: {
        ignoredActions: [FLUSH, REHYDRATE, PAUSE, PERSIST, PURGE, REGISTER]
      },
    }),
});
  
// persistor를 export 합니다.
export const persistor = persistStore(store);
  
export default store;