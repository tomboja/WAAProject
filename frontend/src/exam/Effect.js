import React, { useContext, useEffect } from "react";
import MyContext from '../components/RegistrationPage'

const Greeting = ({name}) => {
  const message = `Hello, ${name},`

  const value = useContext(MyContext)

  useEffect(() => {
    document.title = `${message} this is Flee Doro`
    console.log(message)
  }, [message, name])
  return (<>
    <p>{`Hello, ${value}`}</p>
  </>)
}

export default Greeting