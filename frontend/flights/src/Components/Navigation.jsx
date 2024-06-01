// import * as React from 'react';
// import AppBar from '@mui/material/AppBar';
// import Box from '@mui/material/Box';
// import Toolbar from '@mui/material/Toolbar';
// import IconButton from '@mui/material/IconButton';
// import Typography from '@mui/material/Typography';
// import Menu from '@mui/material/Menu';
// import MenuIcon from '@mui/icons-material/Menu';
// import Container from '@mui/material/Container';
// import Avatar from '@mui/material/Avatar';
// import Button from '@mui/material/Button';
// import Tooltip from '@mui/material/Tooltip';
// import MenuItem from '@mui/material/MenuItem';
// import AdbIcon from '@mui/icons-material/Adb';
// import { NavLink, useLocation } from 'react-router-dom';


// const pages = ['Search', 'Contact Us', 'Table'];
// const settings = ['Account', 'Logout'];

// function ResponsiveAppBar() {
//   const [anchorElNav, setAnchorElNav] = React.useState(null);
//   const [anchorElUser, setAnchorElUser] = React.useState(null);
//   const location = useLocation();
//   const handleOpenNavMenu = (event) => {
//     setAnchorElNav(event.currentTarget);
//   };
//   const handleOpenUserMenu = (event) => {
//     setAnchorElUser(event.currentTarget);
//   };

//   const handleCloseNavMenu = () => {
//     setAnchorElNav(null);
//   };

//   const handleCloseUserMenu = () => {
//     setAnchorElUser(null);
//   };

//   return (
//     <AppBar position="static">
//     <Container>
//       <Toolbar disableGutters>
//         <AdbIcon sx={{ display: { xs: 'none', md: 'flex' }, mr: 1 }} />
//         <Typography
//           variant="h6"
//           noWrap
//           component="a"
//           href="/"
//           sx={{
//             mr: 2,
//             display: { xs: 'none', md: 'flex' },
//             fontFamily: 'monospace',
//             fontWeight: 700,
//             letterSpacing: '.3rem',
//             color: 'inherit',
//             textDecoration: 'none',
//           }}
//         >
//           Travelling Assistant
//         </Typography>

//         <Box sx={{ flexGrow: 1 }} /> {/* This creates empty space to push content to the right */}

//         <Box sx={{ display: 'flex', alignItems: 'center' }}>
//         <Box sx={{ flexGrow: 1, display: { xs: 'none', md: 'flex' } }}>
//   <Button component={NavLink} to="/search" disableRipple  onClick={handleCloseNavMenu} activeClassName="active-link"  sx={(theme) => ({ 
//     my: 2,
//     color: 'white', 
//     display: 'block',
//     position: 'relative', // Add this line
//     '&::after': { // Add this block
//       content: '""',
//       position: 'absolute',
//       bottom: 0,
//       left: '50%',
//       width: location.pathname === '/search' ? '100%' : 0,
//       transform: location.pathname === '/search' ? 'translateX(-50%)' : 'translateX(0)',
//       borderBottom: '2px solid white',
//       transition: 'all 0.3s ease-in-out',
//     },
//   })}>
//     Search
//   </Button>
//   <Button component={NavLink} to="/contact-us" disableRipple onClick={handleCloseNavMenu} activeClassName="active-link" sx={(theme) => ({ 
//     my: 2,
//     color: 'white', 
//     display: 'block',
//     position: 'relative', // Add this line
//     '&::after': { // Add this block
//       content: '""',
//       position: 'absolute',
//       bottom: 0,
//       left: '50%',
//       width: location.pathname === '/contact-us' ? '100%' : 0,
//       transform: location.pathname === '/contact-us' ? 'translateX(-50%)' : 'translateX(0)',
//       borderBottom: '2px solid white',
//       transition: 'all 0.3s ease-in-out',
//     },
//   })}>
//   Contact Us
// </Button>
//   <Button component={NavLink} to="/table" disableRipple onClick={handleCloseNavMenu} activeClassName="active-link"  sx={(theme) => ({ 
//     my: 2,
//     color: 'white', 
//     display: 'block',
//     position: 'relative', // Add this line
//     '&::after': { // Add this block
//       content: '""',
//       position: 'absolute',
//       bottom: 0,
//       left: '50%',
//       width: location.pathname === '/table' ? '100%' : 0,
//       transform: location.pathname === '/table' ? 'translateX(-50%)' : 'translateX(0)',
//       borderBottom: '2px solid white',
//       transition: 'all 0.3s ease-in-out',
//     },
//   })}>
//     Table
//   </Button>
//   <Button component={NavLink} to="/login" disableRipple onClick={handleCloseNavMenu} activeClassName="active-link"  sx={(theme) => ({ 
//     my: 2,
//     color: 'white', 
//     display: 'block',
//     position: 'relative', // Add this line
//     '&::after': { // Add this block
//       content: '""',
//       position: 'absolute',
//       bottom: 0,
//       left: '50%',
//       width: location.pathname === '/login' ? '100%' : 0,
//       transform: location.pathname === '/login' ? 'translateX(-50%)' : 'translateX(0)',
//       borderBottom: '2px solid white',
//       transition: 'all 0.3s ease-in-out',
//     },
//   })}>
//     Login
//   </Button>
// </Box>

//           <Tooltip title="Open settings">
//             <IconButton onClick={handleOpenUserMenu} sx={{ p: 0 }}>
//             {/* <Avatar>{user.firstName[0]}{user.lastName[0]}</Avatar> */}
//             <Avatar>JD</Avatar>
//             </IconButton>
//           </Tooltip>
//           <Menu
//   id="menu-appbar"
//   anchorEl={anchorElUser}
//   anchorOrigin={{
//     vertical: 'top',
//     horizontal: 'right',
//   }}
//   keepMounted
//   transformOrigin={{
//     vertical: 'top',
//     horizontal: 'right',
//   }}
//   open={Boolean(anchorElUser)}
//   onClose={handleCloseUserMenu}
// >
//   <MenuItem component={NavLink} to="/account" onClick={handleCloseUserMenu}>
//     <Typography textAlign="center">Account</Typography>
//   </MenuItem>
//   <MenuItem onClick={handleCloseUserMenu}>
//     <Typography textAlign="center">Logout</Typography>
//   </MenuItem>
// </Menu>
//         </Box>
//       </Toolbar>
//     </Container>
//   </AppBar>
//   );
// }
// export default ResponsiveAppBar;
