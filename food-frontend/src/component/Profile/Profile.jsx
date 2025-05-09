import React, { useState } from 'react'
import ProfileNavigation from './ProfileNavigation'
import { Route, Routes } from 'react-router-dom';
import Address from './Address';
import Favorites from './Favorite';
import Events from './Events';
import Orders from './Orders';
import Favorite from './Favorite';
import Notification from './Notification';
import Review from './Review';
import UserProfile from './UserProfile';

const Profile = () => {
  const [openSideBar, setOpenSideBar] = useState(false);
  return (
    <div className='lg:flex justify-between'>
        <div className='sticky h-[80vh] lg:w-[20%]'>
            <ProfileNavigation open={openSideBar}/>

        </div>
        <div className='lg:w-[80%]'>
          <Routes>
            <Route path='/' element={<UserProfile/>}/>
            <Route path='/orders' element={<Orders/>}/>
            <Route path='/address' element={<Address/>}/>
            <Route path='/favorite' element={<Favorite/>}/>
            <Route path='/events' element={<Events/>}/>
            <Route path='/notification' element={<Notification/>}/>
            <Route path='/reviews' element={<Review/>}/>
            
          </Routes>

        </div>

    </div>
  )
}

export default Profile