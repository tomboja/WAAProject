import { createSlice, current } from '@reduxjs/toolkit'

const initialState = {
  products: []
}

export const productSlice = createSlice({
  name: 'products',
  initialState,
  reducers: {
    loadProducts: (productsState, action) => {
      console.log('state: ', current(productsState))
      console.log('Action: ', action)
      return [...action.payload]
    },
    addproduct: (productsState, action) => {
      productsState.push(action.payload)
    },
    incrementBy5: (productsState) => {
      console.log('State: ', productsState)
    }
  }
})

// Action creators are generated for each case reducer function
export const { loadProducts, addproduct, incrementBy5 } = productSlice.actions

export default productSlice.reducer
