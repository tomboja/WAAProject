
import axios from "axios"
import React, { useEffect, useState } from "react"
import { useDispatch } from "react-redux"
import { loadProducts } from '../redux/product/productSlice'

const HomePage = (props) => {

  const [products, setProducts] = useState([])
  const dispatch = useDispatch()

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
    <div className="mt-4 p-5 bg-light rounded">
      <h1 className="display-4">Welcome to minimarket</h1>
      <p className="lead">Login to the system to be able to place an order for a product, or to be able to sell your products to the world. If you don't have an account yet, click on the <strong>Create account</strong> button above</p>
      <hr className="my-4" />
      <p>You can browse the minimarket products and place an order. Or as a seller, you can register as a seller and sell your products to the world.</p>
      <p className="lead">
        <a className="btn btn-secondary btn-md" href="/products" role="button">View All Products</a>
      </p>
    </div>

    <br />
    <h4>Featured products</h4>
    {
      products.map((product, index) => {
        if (index < 4) {
          return <div className="product" key={index}>
            <h3>{product.name}</h3>
            <span>{product.description}</span>
            <span>Price: ${product.price}</span>
            <span>Available: {product.available ? 'Yes' : 'No'}</span>
          </div>
        }
      })
    }
  </div>)
}

export default HomePage