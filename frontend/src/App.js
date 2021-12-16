import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css'
import Dashboard from './components/Dashboard';
import { BrowserRouter } from 'react-router-dom'

function App() {
  return (
    <BrowserRouter>
      <div className='app container'>
        <Dashboard />
      </div>
    </BrowserRouter>

  );
}

export default App;
