import logo from './logo.svg';
import './App.css';
import './index.css';
import { CssBaseline, ThemeProvider } from '@mui/material';
import { darkTheme } from './Theme/DarkTheme';
import { useDispatch, useSelector } from 'react-redux';
import { getUser } from './component/State/Authentication/Action';
import { findCart } from './component/State/Cart/Action';
import { useEffect } from 'react';
import Routers from './Routers/Routers';
import { getRestaurantByUserId } from './component/State/Restaurant/Action';

function App() {

  const dispatch = useDispatch();
  const jwt = localStorage.getItem("jwt");
  const {auth} = useSelector(store => store);
  

  useEffect(() => {
    dispatch(getUser(auth.jwt || jwt));

    dispatch(findCart(jwt))
  },[auth.jwt])

  useEffect(() => {
    dispatch(getRestaurantByUserId(auth.jwt || jwt));
  },[auth.user])
  return (
    <ThemeProvider theme={darkTheme}>
      <CssBaseline/>
         {/* <Navbar/> */}
      {/*  <Home/> */ }
      {/* <RestaurantDetails/> */}
      {/* <Cart/> */}
      {/* <Profile/> */}
      {/*<Footer/> */}
     <Routers/>
    </ThemeProvider>
  );
}

export default App;