import axios from "axios"
import { useState, useEffect } from "react"
import { useDispatch } from "react-redux"
import { loadSellers } from '../redux/seller/sellerSclice'
import { useSelector } from "react-redux"
import { useNavigate, useParams } from "react-router"




const SellerList = (props) => {
  const user = useSelector(state => state.user)
  const navigate = useNavigate();


  const dispatch = useDispatch()
  const [sellers, setSellers] = useState([])
  const token = user.access_token

  const headers = { 
    'Authorization': `Bearer ${token}`
};

  const approve = (props) => {
    axios.put(`http://localhost:8080/api/admin/sellers/${props.id}`, { headers} )
    .then(res => {
      axios.get('http://localhost:8080/api/admin/sellers', { headers })
      .then(res => {
        setSellers(res.data)
        //dispatch(loadSellers(res.data))
      })
      .catch(error => {
        console.log(`Error loading sellers from database`)
      })
      
      navigate('/sellerList')
    })
    .catch(error => {
      console.log(`Error updating seller approval from database`, token)
    })

  } 

  useEffect(() => {
    axios.get('http://localhost:8080/api/admin/sellers', { headers })
      .then(res => {
        setSellers(res.data)
      })
      .catch(error => {
        console.log(`Error loading sellers from database`)
      })
  }, [])

  return (<div>
    {sellers.map((seller, index) => {
      return <div className="product" key={index}>
        <span>First Name: {seller.firstname}</span> 
        <span>Last Name: {seller.lastname}</span>   
        <span>Email: {seller.email}</span>     
        <span>Approved: {seller.approved ? 'Yes' : 'No'}</span>
        {
          seller.approved ? null : <button style={{height: '30px', width : '100px'}} size="1g" onClick={() => approve(seller)}>Approve</button>
        }
        
      </div>
    })}
  </div>)
}

export default SellerList
