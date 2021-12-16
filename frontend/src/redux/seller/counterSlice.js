import { createSlice } from '@reduxjs/toolkit'

const initialState = {
  counter: {
    value: 0
  }
}

export const counterSlice = createSlice({
  name: 'counter',
  initialState,
  reducers: {
    increment: (state) => {
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
export const { increment, decrement, incrementBy5 } = counterSlice.actions

export default counterSlice.reducer
