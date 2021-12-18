import { createSlice } from '@reduxjs/toolkit'

const initialState = {
  products: []
}

export const productSlice = createSlice({
  name: 'products',
  initialState,
  reducers: {
    loadProducts: (productsState, action) => {
      return [...action.payload]
    },
    addproduct: (productsState, action) => {
      productsState.push(action.payload)
    }
  }
})

// Action creators are generated for each case reducer function
export const { loadProducts, addproduct } = productSlice.actions

export default productSlice.reducer
