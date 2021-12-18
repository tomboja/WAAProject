import axios from "axios"
import { useState } from "react"
import { useDispatch } from "react-redux"
import { addBuyer } from '../redux/buyer/buyerSclice'
import { addSeller } from '../redux/seller/sellerSclice'

const BUYER = 'BUYER'

const RegistrationPage = (props) => {
  const [firstname, setFirstname] = useState('')
  const [lastname, setLastname] = useState('')
  const [email, setEmail] = useState('')
  const [password, setPassword] = useState('')
  const [role, setRole] = useState('')
  const [status, setStatus] = useState({
    error: false,
    message: 'Error occured. check if email is duplicate or other fields are wrong'
  })

  const emptyAddressFormat = { city: '', street: '', zipcode: '', state: '', country: '' }

  const [billingAddress, setBillingAddress] = useState({ ...emptyAddressFormat, address_type: 'BILLING_ADDRESS' })
  const [shippingAddress, setShippingAddress] = useState({ ...emptyAddressFormat, address_type: 'SHIPPING_ADDRESS' })

  const dispatch = useDispatch()

  const baseUrl = 'http://localhost:8080/api/register'

  const submitHandler = (e) => {
    e.preventDefault()
    const path = role === BUYER ? `${baseUrl}/buyers` : `${baseUrl}/sellers`
    const addressTosave = BUYER ? [billingAddress, shippingAddress] : []

    const body = {
      firstname,
      lastname,
      email,
      password,
      addresses: addressTosave
    }
    axios.post(path, body).then((res) => {
      role === BUYER
        ? dispatch(addBuyer(res.data))
        : dispatch(addSeller(res.data))

      // Cleanup form
      setFirstname('')
      setLastname('')
      setEmail('')
      setPassword('')
      setBillingAddress(emptyAddressFormat)
      setShippingAddress(emptyAddressFormat)
      setStatus({ ...status, error: false })
    }).catch((value) => {
      setStatus({...status, error: true})
    })
  }

  const addFirstname = val => setFirstname(val)
  const addLastname = val => setLastname(val)
  const addEmail = email => setEmail(email)
  const addPassword = password => setPassword(password)
  const addRole = role => setRole(role)

  const addBillingAddress = (name, value) => {
    console.log('Name, value ', name, value)
    setBillingAddress({ ...billingAddress, [name]: value })
  }

  const addShippingAddress = (name, value) => {
    console.log('Shipping name value, ', name, value)
    setShippingAddress({ ...shippingAddress, [name]: value })
  }

  return (<div>
    <h2>Create an account</h2>
    <form
      onSubmit={(e) => submitHandler(e)}
      className="input-name">
      <div className="form-group">
        <label htmlFor="input-firstname">First Name</label>
        <input
          onChange={(e) => addFirstname(e.target.value)}
          type="text"
          className="form-control"
          id="input-firstname1"
          value={firstname}
          placeholder="Enter first name" />
      </div>
      <div className="form-group">
        <label htmlFor="input-flastname">Last Name</label>
        <input
          onChange={(e) => addLastname(e.target.value)}
          type="text"
          className="form-control"
          id="input-lasttname1"
          value={lastname}
          placeholder="Enter last name" />
      </div>
      <div className="form-group">
        <label htmlFor="input-email">Email</label>
        <input
          onChange={(e) => addEmail(e.target.value)}
          type="text"
          className="form-control"
          id="input-email1"
          value={email}
          placeholder="Enter email" />
      </div>
      <div className="form-group">
        <label htmlFor="input-password">Password</label>
        <input
          onChange={(e) => addPassword(e.target.value)}
          type="password"
          className="form-control"
          id="input-password1"
          value={password}
          placeholder="Enter password" />
      </div>
      {status.error !== false ? <div className='status'>{status.message}</div> : null}

      <div className="form-group">
        <label htmlFor="role">Select Role</label>
        <select
          onChange={(e) => addRole(e.target.value)}
          name="role"
          value={role}
          id="role">
          <option selected='selected' value="SELLER">Seller</option>
          <option value="BUYER">Buyer</option>
        </select>
      </div>
      {role === BUYER &&
        <div>
          <div className="address">
            <h3>Billing address</h3>
            <div className="form-group">
              <label htmlFor="input-firstname">City</label>
              <input
                onChange={(e) => addBillingAddress('city', e.target.value)}
                type="text"
                className="form-control"
                id="input-firstname8"
                value={billingAddress.city}
                placeholder="Enter City" />
            </div>
            <div className="form-group">
              <label htmlFor="input-firstname">Street</label>
              <input
                onChange={(e) => addBillingAddress('street', e.target.value)}
                type="text"
                className="form-control"
                id="input-firstname78"
                value={billingAddress.street}
                placeholder="Enter Street" />
            </div>
            <div className="form-group">
              <label htmlFor="input-firstname">Zip Code</label>
              <input
                onChange={(e) => addBillingAddress('zipcode', e.target.value)}
                type="text"
                className="form-control"
                id="input-firstname2"
                value={billingAddress.zipcode}
                placeholder="Enter Zipcode" />
            </div>
            <div className="form-group">
              <label htmlFor="input-firstname">State</label>
              <input
                onChange={(e) => addBillingAddress('state', e.target.value)}
                type="text"
                className="form-control"
                id="input-firstname7"
                value={billingAddress.state}
                placeholder="Enter State" />
            </div>
            <div className="form-group">
              <label htmlFor="input-firstname">Country</label>
              <input
                onChange={(e) => addBillingAddress('country', e.target.value)}
                type="text"
                className="form-control"
                id="input-firstname12"
                value={billingAddress.country}
                placeholder="Enter Country" />
            </div>
          </div>

          <div className="address2">
            <h3>Shipping address</h3>
            <div className="form-group">
              <label htmlFor="input-firstname">City</label>
              <input
                onChange={(e) => addShippingAddress('city', e.target.value)}
                type="text"
                className="form-control"
                id="input-firstnamec"
                value={shippingAddress.city}
                placeholder="Enter City" />
            </div>
            <div className="form-group">
              <label htmlFor="input-firstname">Street</label>
              <input
                onChange={(e) => addShippingAddress('street', e.target.value)}
                type="text"
                className="form-control"
                id="input-firstnamegh"
                value={shippingAddress.street}
                placeholder="Enter Street" />
            </div>
            <div className="form-group">
              <label htmlFor="input-firstname">Zipcode</label>
              <input
                onChange={(e) => addShippingAddress('zipcode', e.target.value)}
                type="text"
                className="form-control"
                id="input-firstnamegr"
                value={shippingAddress.zipcode}
                placeholder="Enter Zipcode" />
            </div>
            <div className="form-group">
              <label htmlFor="input-firstname">State</label>
              <input
                onChange={(e) => addShippingAddress('state', e.target.value)}
                type="text"
                className="form-control"
                id="input-firstnamehg"
                value={shippingAddress.state}
                placeholder="Enter State" />
            </div>
            <div className="form-group">
              <label htmlFor="input-firstname">Country</label>
              <input
                onChange={(e) => addShippingAddress('country', e.target.value)}
                type="text"
                className="form-control"
                id="input-firstname10"
                value={shippingAddress.country}
                placeholder="Enter Country" />
            </div>
          </div>
        </div>}

      <button
        type="submit"
        className="btn btn-secondary input-name"
      >Submit</button>
    </form>
  </div>)
}

export default RegistrationPage
