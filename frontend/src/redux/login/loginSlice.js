import { createSlice } from '@reduxjs/toolkit'

const initialState = {
  access_token: null,
  refresh_token: null,
  email: '',
  role: ''
}

export const userSlice = createSlice({
  name: 'user',
  initialState,
  reducers: {
    setUserToken: (state, action) => {
      return action.payload
    },
    logout: (state, action) => {
      return {...action.payload}
    }
  }
})

// Action creators are generated for each case reducer function
export const { setUserToken, logout } = userSlice.actions

export default userSlice.reducer