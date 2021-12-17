import axios from "axios"
import { useEffect, useState } from "react"
import { useDispatch, useSelector } from "react-redux"

import { addBuyer, removeBuyer, loadBuyer } from '../redux/buyer/buyerSclice'
import { addSeller, removeSeller, loadSeller, approveSeller } from '../redux/seller/sellerSclice'

const RegistrationPage = (props) => {
  const [firstname, setFirstname] = useState('')
  const [lastname, setLastname] = useState('')
  const [email, setEmail] = useState('')
  const [password, setPassword] = useState('')
  const [role, setRole] = useState('')

  const dispatch = useDispatch()

  const baseUrl = 'http://localhost:8080/api'

  const submitHandler = (e) => {
    e.preventDefault()
    const path = role === 'BUYER' ? `${baseUrl}/buyers` : `${baseUrl}/sellers`
    const body = {
      firstname, 
      lastname,
      email,
      password
    }

    axios.post(path, body).then((res) => {
      role === 'BUYER'
        ? dispatch(addBuyer(res.data))
        : dispatch(addSeller(res.data))
      
      // Cleanup form
      setFirstname('')
      setLastname('')
      setEmail('')
      setPassword('')
    })
    // console.log('message ', firstname, lastname, email, password, role)
  }

  return (<div>
    <h2>Create an account</h2>
    <form 
    onSubmit={(e) => submitHandler(e)} 
    className="input-name">
      <div className="form-group">
        <label htmlFor="input-firstname">First Name</label>
        <input
          onChange={(e) => setFirstname(e.target.value)}
          type="text"
          className="form-control"
          id="input-firstname"
          value={firstname}
          placeholder="Enter first name" />
      </div>
      <div className="form-group">
        <label htmlFor="input-flastname">Last Name</label>
        <input
          onChange={(e) => setLastname(e.target.value)}
          type="text"
          className="form-control"
          id="input-lasttname"
          value={lastname}
          placeholder="Enter last name" />
      </div>
      <div className="form-group">
        <label htmlFor="input-email">Email</label>
        <input
          onChange={(e) => setEmail(e.target.value)}
          type="text"
          className="form-control"
          id="input-email"
          value={email}
          placeholder="Enter email" />
      </div>
      <div className="form-group">
        <label htmlFor="input-password">Password</label>
        <input
          onChange={(e) => setPassword(e.target.value)}
          type="password"
          className="form-control"
          id="input-password"
          value={password}
          placeholder="Enter password" />
      </div>


      <div className="form-group">
        <label htmlFor="role">Select Role</label>
        <select 
          onChange={(e) => setRole(e.target.value)}
          name="role"
          value={role} 
          id="role">
            <option value="SELLER">Seller</option>
            <option value="BUYER">Buyer</option>
        </select>
      </div>
      <div className="form-group">
        <label htmlFor="product-price">Address</label>
        {/* <div className="input-group">
          <span className="input-group-text">$</span>
          <input
            // onChange={(e) => setProductPrice(e.target.value)}
            type="text"
            className="form-control"
            id="product-price"
            placeholder="Enter product price" />
        </div> */}
      </div>
      <button
        type="submit"
        className="btn btn-secondary input-name"
      >Submit</button>
    </form>
  </div>)
}

export default RegistrationPage
