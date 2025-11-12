import {configureStore} from '@reduxjs/toolkit'
import authReducer from './authSlice'


export const store = configureStore({
  reducer: {
    // Add your reducers here
    auth: authReducer ,
  },
})