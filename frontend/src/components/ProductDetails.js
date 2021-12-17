import {useNavigate, useParams} from "react-router-dom";
import {useEffect, useState} from "react";
import axios from "axios";

const ProductDetailsPage =()=>{

    const prodAPI = 'http://localhost:8080/api/products';

    const param = useParams();
    const navigate = useNavigate();

    const headers = {
        'Access-Control-Allow-Origin': '*',
        'Content-Type': 'application/json',
    }

    const [prodState, setProdState] = useState({});

    useEffect(() => {
        if (param.id !== undefined){
            axios(prodAPI + param.id, { headers })
                .then(response => {
                    setProdState(response.data);
                })
                .catch(err =>
                    console.log("DATA IS NOT FETCHED " + err.message))
        }
    }, [param.id]);

    const getProductList = () => {
        axios.get(prodAPI, { headers })
            .then(response => {
                navigate('/ProductList');
                console.log(response);
            })
            .catch(error => console.log(error.message))
    };

    return( <div className="product">
        <div><h4> Title:</h4> <label>{prodState.name}</label></div>
        <div><h4> Description:</h4><label>{prodState.description}</label></div>
        <div><h4> Price:</h4><label>{prodState.price}</label></div>
        <div><h4> isAvailable:</h4><label>{prodState.isAvailable}</label></div>
        <div><button onClick={getProductList}>back</button></div>
        {/*<div><button onClick={updateProduct}>update</button></div>*/}
        {/*<div><button onClick={getProductList}>delete</button></div>*/}
        </div>)
}

export default ProductDetailsPage
