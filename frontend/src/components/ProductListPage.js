import axios from "axios"
import { useState, useEffect } from "react"
import { useDispatch } from "react-redux"
import { loadProducts } from '../redux/product/productSlice'

const ProductList = (props) => {
  const dispatch = useDispatch()
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

  return (<div>
    {products.map((product, index) => {
      return <div className="product" key={index}>
        <h3>{product.name}</h3>
        <span>{product.description}</span>
        <span>Price: ${product.price}</span>
        <span>Available: {product.available ? 'Yes' : 'No'}</span>
      </div>
    })}
  </div>)
}

export default ProductList
