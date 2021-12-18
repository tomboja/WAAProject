import { configureStore } from '@reduxjs/toolkit'
import sellerReducer from './redux/seller/sellerSclice'
import productReducer from './redux/product/productSlice'
import userSlice from './redux/login/loginSlice'
import reviewSlice from './redux/review/reviewSclice'

export const store = configureStore({
  reducer: {
    sellers: sellerReducer,
    products: productReducer,
    user: userSlice,
    reviews: reviewSlice
  }
})
