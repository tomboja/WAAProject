import { createSlice } from '@reduxjs/toolkit'

const initialState = {
    id: '',
    firstName: '',
    lastName: '',
    email: '',
    approved: false,
    role: 'SELLER',
    followers: [],
    products: []
}

export const sellerSlice = createSlice({
  name: 'sellers',
  initialState,
  reducers: {
    loadSellers: (sellerState, action) => {
      return [...action.payload]
    },
    addSeller: (sellerState, action) => {
    },
    removeSeller: (sellerState, action) => {
    },
    approveSeller: (sellerState, action) => {}
  }
})

// Action creators are generated for each case reducer function
export const { addSeller, removeSeller, approveSeller, loadSellers } = sellerSlice.actions

export default sellerSlice.reducer
