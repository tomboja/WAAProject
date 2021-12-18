import { Link } from "react-router-dom";
import HomePage from './HomePage'
import ProductListPage from './ProductListPage'
import Registration from './RegistrationPage'
import AddNewProductPage from './AddProductPage'
import LoginPage from './LoginPage'
import ErrorPage from './ErrorPage'
import { Route, Routes, useNavigate } from 'react-router'
import { useSelector, useDispatch } from "react-redux";
import { logout } from '../redux/login/loginSlice'
import SellerList from "./SellersListPage";
import ProductDetailsPage from "./ProductDetails";
const Dashboard = (props) => {
  const dispatch = useDispatch()
  const navigate = useNavigate()
  const user = useSelector(state => state.user)

  const logoutUser = (e) => {
    e.preventDefault()
    dispatch(logout({
      access_token: null,
      refresh_token: null,
      email: '',
      role: ''
    }))
    navigate('/')
  }

  return (
    <div>
      <nav>
        <ul className="dashboard">
          <li><Link to='/'>Home</Link></li> 
          { user.role == 'ADMIN' ?
            <li><Link to='/sellerList'>Seller List</Link> </li> : null
               
          }
          <li><Link to='/products'>Products</Link></li>
          { user.role !== 'BUYER' ?
            <li><Link to='/newProduct'>Add New Product</Link></li> : null
          }

          {user.email === '' ? <li><Link to='/account'>Create Account</Link></li> : null }
          <li>
            {user.email === '' ?
              <Link to='/signin'>Login</Link> :
              <button
                type="button"
                onClick={(e) => logoutUser(e)}
                className="logout">Logout</button>
            }
          </li>
        </ul>
      </nav>

      <Routes>
        <Route path='/' element={<HomePage />} />
        <Route path='/products' element={<ProductListPage />} />
        <Route path='/sellerList' element={<SellerList />} />        
        <Route path='/account' element={<Registration />} />
        <Route path='/newProduct' element={<AddNewProductPage />} />
        <Route path='/products/:id' element={<ProductDetailsPage />} />
        <Route path='/signin' element={<LoginPage />} />
        <Route path='*' element={<ErrorPage />} />
      </Routes>

    </div>)
}

export default Dashboard
