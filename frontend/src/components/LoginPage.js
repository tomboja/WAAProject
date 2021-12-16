import Form from 'react-bootstrap/Form'
import Button from '@mui/material/Button';
import HomePage from './HomePage'
import TextField from '@mui/material/TextField';
import React, { useState } from 'react'
import { useDispatch } from 'react-redux'
import axios from 'axios'
import { setUserToken } from '../redux/login/loginSlice'

const LoginPage = (props) => {
  const [username, setUsername] = useState({ email: '' })
  const [password, setPassword] = useState({ password: '' })
  const [status, setError] = useState({success: null, error: null})

  const dispatch = useDispatch()

  const passwordSetter = (password) => {
    setPassword({ password: password })
  }

  const usernameSetter = (username) => {
    setUsername({ email: username })
  }

  const handleSubmit = (e) => {
    e.preventDefault()
    axios.post(`http://localhost:8080/login?username=${username.email}&password=${password.password}`)
      .then(res => {
        // Set authentication token and refresh token in state + EMAIL AND ROLE
        dispatch(setUserToken({
          access_token: res.data.access_token,
          refresh_token: res.data.refresh_token,
          email: res.data.email,
          role: res.data.role
        }))

        // Cleanup form after login
        usernameSetter('')
        passwordSetter('')
        setError({ error: null, success: true})
      }).catch(error => {
        setError({error: `Unable to login user with email ${ username.email }.`, success: false})
        console.log(`Unable to login user with email ${username.email}. `, error)
      })
  }

  const validateForm = () => {
    const { email } = username
    if (email === '' || password.password === '')
      return false
    return true

  }

  if (status.error === null && status.success) {
    return <HomePage />
  }

  return (<div className='Login'>
    <Form onSubmit={(e) => handleSubmit(e)}>
      <TextField
        className='signin'
        label='Email'
        variant='standard'
        fullWidth
        autoFocus
        type='email'
        value={username.email}
        onChange={(e) => usernameSetter(e.target.value)}
      />
      <TextField
        className='signin'
        label='Password'
        variant='standard'
        fullWidth
        type='password'
        value={password.password}
        onChange={(e) => passwordSetter(e.target.value)}
      />
      {status.error !== null ? <div className='status'>{status.error}</div> : null}
      <br />
      <Button
        className='signin'
        variant='contained'
        type='submit'
        disabled={!validateForm()}>
        Login
      </Button>
    </Form>
  </div>)
}

export default LoginPage
