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
  name: 'seller',
  initialState,
  reducers: {
    addSeller: (state) => {
    },
    decrement: (state) => {
      console.log('State: ', state)
    },
    incrementBy5: (state) => {
      console.log('State: ', state)
    }
  }
})

// Action creators are generated for each case reducer function
export const { increment, decrement, incrementBy5 } = sellerSlice.actions

export default sellerSlice.reducer
