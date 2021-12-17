import { createSlice } from '@reduxjs/toolkit'

const initialState = {
    id: '',
    firstName: '',
    lastName: '',
    email: '',
    role: 'BUYER',
    shoppingCart: '',
    address: '',
    points: 0,
    reviews: [],
    followingSellers: []
}

export const sellerSlice = createSlice({
  name: 'buyers',
  initialState,
  reducers: {
    loadBuyer: (buyerState, action) => {
      return [...action.payload]
    },
    addBuyer: (buyerState) => {
    },
    removeBuyer: (buyerState) => {

    }
  }
})

// Action creators are generated for each case reducer function
export const { addBuyer, removeBuyer, loadBuyer } = sellerSlice.actions

export default sellerSlice.reducer
