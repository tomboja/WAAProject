import axios from "axios"
import { useState, useEffect } from "react"
import { useDispatch } from "react-redux"
import { loadProducts } from '../redux/product/productSlice'

import { useNavigate, useParams } from "react-router-dom";

const ProductList = (props) => {
  const dispatch = useDispatch()
  const navigate = useNavigate()

  const [products, setProducts] = useState([])

  useEffect(() => {
    axios.get('http://localhost:8080/api/products')
      .then(res => {
        setProducts(res.data)
        dispatch(loadProducts(res.data))
      })
      .catch(error => {
        console.log(`Error loading products from database`)
      })
  }, [])

  const goToProductDetail = (product) => {
    console.log('Product ', product)
    navigate(`/products/${product.id}`)
  }

  return (<div>
    {products.map((product, index) => {
      return <div className="product" key={index} >
        <h3>{product.name}</h3>
        <span>{product.description}</span>
        <span>Price: ${product.price}</span>
        <span>Available: {product.available ? 'Yes' : 'No'} <button type="button" className="detail btn btn-light" onClick={() => goToProductDetail(product)}>details</button></span>
      </div>
    })}
  </div>)
}

export default ProductList
