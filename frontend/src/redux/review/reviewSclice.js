import { createSlice } from '@reduxjs/toolkit'

const initialState = {
  reviews: []
}

export const reviewSlice = createSlice({
  name: 'reviews',
  initialState,
  reducers: {
    loadReviews: (reviewState, action) => {
      return [...action.payload]
    },
    addReview: (reviewState, action) => {
      reviewState.push(action.payload)
    },
    removeReview: (reviewState, action) => { 
      // TODO
    },
    approveReview: (reviewState, action) => { 
      // TODO
    },
    updateReview: (reviewState, action) => {
      // TODO
     }
  }
})

// Action creators are generated for each case reducer function
export const { addReview, removeReview, loadReviews, approveReview, updateReview } = reviewSlice.actions

export default reviewSlice.reducer
