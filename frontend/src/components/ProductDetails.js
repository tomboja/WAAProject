import { useParams } from "react-router-dom";
import { useEffect, useState } from "react";
import axios from "axios";
import { useSelector, useDispatch } from "react-redux";
import { addReview, loadReviews } from '../redux/review/reviewSclice'
import { useNavigate } from 'react-router'

const BUYER = 'BUYER'

const ProductDetailsPage = () => {
    const user = useSelector(state => state.user)
    const dispatch = useDispatch()
    const navigate = useNavigate()

    const prodAPI = 'http://localhost:8080/api/products/'
    const reviewApi = 'http://localhost:8080/api/reviews/'

    const param = useParams();

    const headers = {
        'Access-Control-Allow-Origin': '*',
        'Content-Type': 'application/json',
    }

    const [prodState, setProdState] = useState({});
    const [review, setReview] = useState('')
    const [reviews, setAllReviews] = useState([])

    useEffect(() => {
        if (param.id !== undefined) {
            axios(prodAPI + param.id, { headers })
                .then(response => {
                    setProdState(response.data);
                    dispatch(loadReviews(response.data))
                })
                .catch(err =>
                    console.log("DATA IS NOT FETCHED " + err.message))
        }
    }, [param.id]);

    useEffect(() => {
        // Fetch all reviews for this particular product 
        axios.get(`${prodAPI}${param.id}/reviews`)
            .then(res => {
                setAllReviews(res.data)
            })
    }, [reviews.length])

    const setProductReview = (content) => {
        setReview(content)
    }

    const submitHandler = (e) => {
        e.preventDefault()
        const body = {
            content: review,
            approved: false,
            product_id: param.id,
            buyer_id: user.email,
        }
        axios.post(reviewApi, body)
            .then((res) => {
                dispatch(addReview(res.data))
                setProductReview('')
            }) // Save to redux store
            .catch((error) => console.log('Error saving product review'))
    }

    const deleteProductItem = () => {
        axios.delete(prodAPI + param.id, { headers })
            .then(response => {

                setProdState(response.data);
                navigate('/products')
                console.log(response);
            })
            .catch(error => console.log(error.message))
    };

    return (<div>
        <div className='productDetail'>
            <div><strong> Title:</strong> <label>{prodState.name}</label></div>
            <div><strong> Description:</strong><label>{prodState.description}</label></div>
            <div><strong> Price:</strong><label>{prodState.price}</label></div>
            <div><strong> Available:</strong><label>{prodState.available ? 'Yes' : 'No'}</label></div>
            <div>
                <button type="button" onClick={deleteProductItem}> Delete</button>
            </div>
        </div>

        <div className="comments">
            {reviews.map((review, index) => {
                return (<div key={index} className="review">
                    <div><strong> Reviewer:</strong> <label>{review.reviewer}</label></div>
                    <div><strong> Comment:</strong> <label>{review.content}</label></div>
                </div>)
            })}
        </div>

        {
            (user.role === BUYER || user.role === 'ADMIN') &&
            <div className='comments'>
                <hr></hr>
                <p><strong>Add Reviews</strong></p>
                <form
                    onSubmit={(e) => submitHandler(e)}
                    className="add-product">

                    <div className="form-group">
                        <label htmlFor="product-description">Write Review</label>
                        <textarea
                            onChange={(e) => setProductReview(e.target.value)}
                            className="form-control"
                            id="product-description"
                            rows="3"
                            required
                            value={review}
                            placeholder="Add product description"></textarea>
                    </div>
                    <button
                        type="submit"
                        className="btn btn-secondary add-product"
                    >Send comment</button>
                </form>

            </div>}
    </div>)
}

export default ProductDetailsPage
