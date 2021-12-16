import { createContext } from 'react'
import Greeting from '../exam/Effect'

const MyContext = createContext({ fName: 'Jason', lName: 'Gregory' })

const RegistrationPage = (props) => {
  const val = { fname: 'Georgina', lName: 'Tarek' }
  return (<div>
    <h1>This is title</h1>
    <MyContext.Provider value={val}>
      <Greeting name='James' />
      <Greeting name='saloo' />
      <Greeting name='gobaa' />
      <Greeting name='nilson' />
    </MyContext.Provider>

  </div>)
}

export default RegistrationPage

export { MyContext }