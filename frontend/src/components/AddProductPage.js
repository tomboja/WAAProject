import axios from "axios"
import { useState } from "react"
import { useDispatch, useSelector } from "react-redux"
import { addproduct } from '../redux/product/productSlice'

const AddNewProduct = (props) => {
  const dispatch = useDispatch()

  const [productName, setName] = useState({ name: '' })
  const [productDescription, setDescription] = useState({ description: '' })
  const [productprice, setPrice] = useState({ price: '' })

  const seller_email = useSelector(state => state.user.email)

  const submitHandler = (e) => {
    e.preventDefault()
    const body = {
      name: productName.name,
      description: productDescription.description,
      price: productprice.price,
      isAvailable: true,
      seller_id: seller_email
    }
    axios.post('http://localhost:8080/api/products', body)
      .then((res) => {
        dispatch(addproduct(res.data))
        setProductName('')
        setProductDescription('')
        setProductPrice('')
      })
      .catch(error => {
        console.log('Error ', error)
      })
  }

  const setProductName = (val) => {
    setName({name: val})
  }

  const setProductDescription = (val) => {
    setDescription({description: val})
  }

  const setProductPrice = (val) => {
    setPrice({price: val})
  }

  return (<div>
    <h2>Login as seller to be able to add products</h2>
    <form onSubmit={(e) => submitHandler(e)} className="add-product">
      <div className="form-group">
        <label htmlFor="input-label-name">Product Name</label>
        <input
          onChange={(e) => setProductName(e.target.value)}
          type="text"
          className="form-control"
          id="input-label-name"
          value={productName.name}
          required
          placeholder="Enter product name" />
      </div>
      <div className="form-group">
        <label htmlFor="product-description">Description</label>
        <textarea
          onChange={(e) => setProductDescription(e.target.value)}
          className="form-control"
          id="product-description"
          rows="3"
          value={productDescription.description}
          required
          placeholder="Add product description"></textarea>
      </div>
      <div className="form-group">
        <label htmlFor="product-price">Product Price</label>
        <div className="input-group">
          <span className="input-group-text">$</span>
          <input
            onChange={(e) => setProductPrice(e.target.value)}
            type="text"
            className="form-control"
            id="product-price"
            value={productprice.price}
            required
            placeholder="Enter product price" />
        </div>
      </div>
      <button
        type="submit"
        className="btn btn-secondary add-product"
        disabled={seller_email === ''}
      >Submit</button>
    </form>
  </div>)
}

export default AddNewProduct