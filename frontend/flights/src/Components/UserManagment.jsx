// import React, { useState, useEffect } from 'react';
// import Avatar from '@mui/material/Avatar';
// import { Typography, Box, Grid, Paper, Table, TableBody, TableCell, TableContainer, TableHead, TableRow } from '@mui/material';
// import { createTheme, ThemeProvider } from '@mui/material/styles';
// import Collapse from '@mui/material/Collapse';
// import IconButton from '@mui/material/IconButton';
// import KeyboardArrowDownIcon from '@mui/icons-material/KeyboardArrowDown';
// import KeyboardArrowUpIcon from '@mui/icons-material/KeyboardArrowUp';
// import Button from '@mui/material/Button';
// import CustomControlsExample from './ChangeUsername';
// import { Flex, Spacer} from "@chakra-ui/react";
// import {fetchSavedFlights, fetchSavedHotels, fetchSavedRecentSearches, fetchSavedCarRentals} from '../Api.js';
// const theme = createTheme({
//   palette: {
//     primary: {
//       main: '#3f51b5',
//     },
//     secondary: {
//       main: '#f44336',
//     },
//   },
// });


// function formatDate(dateTimeObject) {
//   if (!dateTimeObject || typeof dateTimeObject !== 'object') {
//     console.error('Invalid date object');
//     return 'N/A';
//   }

//   const { year, month, day, hour, minute } = dateTimeObject;

//   // Ensure all values are defined and are numbers or can be converted to numbers
//   if (![year, month, day, hour, minute].every(val => val !== undefined && !isNaN(Number(val)))) {
//     console.error('Invalid date object');
//     return 'N/A';
//   }

//   return `${year}/${String(month).padStart(2, '0')}/${String(day).padStart(2, '0')} ${String(hour).padStart(2, '0')}:${String(minute).padStart(2, '0')}`;
// }


// function UserManagement({ user }) {
//   const { username, name, surname, phoneNumber, email } = user;

 
//   const [savedFlights, setSavedFlights] = useState([]);
//   const [savedHotels, setSavedHotels] = useState([]);
//   const [savedCarRentals, setSavedCarRentals] = useState([]);
//   const [recentSearches, setRecentSearches] = useState([]);

//   useEffect(() => {
//     const userId = "65e711c4bf88f66b8e00f03a"; // replace with actual user id

//     const fetchFlights = async () => {
//       try {
//         const response = await fetchSavedFlights(userId);
//         setSavedFlights(response);
//       } catch (error) {
//         console.error(error); // handle error as needed
//       }
//     };

//     const fetchHotels = async () => {
//       fetchSavedHotels(userId)
//         .then(response => {
//           console.log(response);
//           setSavedHotels(response);
//         })
//         .catch(error => {
//           console.error(error); // handle error as needed
//         });
//     };

//     const fetchRecentSearches = async () => {
//       fetchSavedRecentSearches(userId)
//         .then(response => {
//           // console.log(response);
//           setRecentSearches(response);
//         })
//         .catch(error => {
//           console.error(error); // handle error as needed
//         });
//     };

//     const fetchCarRentals = async () => {
//       fetchSavedCarRentals(userId)
//         .then(response => {
//           // console.log(response);
//           setSavedCarRentals(response);
//         })
//         .catch(error => {
//           console.error(error); // handle error as needed
//         });
//     };

//     fetchFlights();
//     fetchHotels();
//     fetchRecentSearches();
//     fetchCarRentals();
//   }, []);

  
  
//   const avatarLetter = `${name[0]}${surname[0]}`;
//   const [changeUsername, setChangeUsernamee] = useState(user.username);
//   return (
//     <ThemeProvider theme={theme}>
//       <Grid container justifyContent="center">
//         <Grid item xs={12} sm={8} md={8}>
//           <Paper elevation={3} sx={{ p: 2, mt: 2 }}>
//           <Box sx={{ display: 'flex', flexDirection: 'column', alignItems: 'center', mb: 2 }}>
//           <Avatar sx={{ width: 100, height: 100, fontSize: 40 }}>{avatarLetter.toUpperCase()}</Avatar>
//   <CustomControlsExample changeUsername={changeUsername} setChangeUsername={setChangeUsernamee} />
// </Box>
// <Flex as="p" align="center" mb={4}>
//   <Box as="span">Name: </Box>
//   <Box ml ={'5px'} as="span" fontWeight="bold">{name}</Box>
// </Flex>
// <Flex as="p" align="center" mb={4}>
//   <Box as="span">Surname: </Box>
//   <Box ml ={'5px'} as="span" fontWeight="bold">{surname}</Box>
// </Flex>
// <Flex as="p" align="center" mb={4}>
//   <Box as="span">Phone Number: </Box>
//   <Box ml ={'5px'} as="span" fontWeight="bold">{phoneNumber}</Box>
// </Flex>
// <Flex as="p" align="center" mb={4}>
//   <Box as="span">Email: </Box>
//   <Box ml ={'5px'} as="span" fontWeight="bold">{email}</Box>
// </Flex>

// <Typography variant="h6" color="primary" mt={4}>Saved Flights</Typography>
//             <TableContainer component={Paper} sx={{ maxHeight: 200, overflowX: 'hidden', '&::-webkit-scrollbar': { width: '0.4em' }, '&::-webkit-scrollbar-track': { boxShadow: 'inset 0 0 6px rgba(0,0,0,0.00)', webkitBoxShadow: 'inset 0 0 6px rgba(0,0,0,0.00)' }, '&::-webkit-scrollbar-thumb': { backgroundColor: 'rgba(0,0,0,.1)', outline: '1px solid slategrey' } }}>
//               <Table sx={{ minWidth: 650 }} aria-label="simple table">
//               <TableHead>
//       <TableRow>
//         <TableCell />
//         <TableCell>Origin</TableCell>
//         <TableCell>Destination</TableCell>
//         <TableCell>Departure</TableCell>
//         <TableCell>Arrival</TableCell>
//         <TableCell>Price</TableCell>
//         <TableCell>Booking Link</TableCell>
//       </TableRow>
//     </TableHead>
//                 <TableBody>
//                 {savedFlights && savedFlights.map((flight, index) => (
//   <Row key={index} row={flight} />
// ))}
//                 </TableBody>
//               </Table>
//             </TableContainer>

//             <Typography variant="h6" color="primary" mt={4}>Saved Hotels</Typography>
//             <TableContainer component={Paper} sx={{ maxHeight: 200, overflowX: 'hidden', '&::-webkit-scrollbar': { width: '0.4em' }, '&::-webkit-scrollbar-track': { boxShadow: 'inset 0 0 6px rgba(0,0,0,0.00)', webkitBoxShadow: 'inset 0 0 6px rgba(0,0,0,0.00)' }, '&::-webkit-scrollbar-thumb': { backgroundColor: 'rgba(0,0,0,.1)', outline: '1px solid slategrey' } }}>
//               <Table sx={{ minWidth: 650 }} aria-label="simple table">
//               <TableHead>
//           <TableRow>
//             <TableCell />
//             <TableCell align="center">Image</TableCell>
//             <TableCell align="center">Name</TableCell>
//             <TableCell align="center">City</TableCell>
//             <TableCell align="center">Country</TableCell>
//             <TableCell align="center">Star Rating</TableCell>
//           </TableRow>
//         </TableHead>

//                 <TableBody>
//                   {savedHotels.map((hotel, index) => (
//                     <Hotel key={index} row={hotel} />
//                   ))}
//                 </TableBody>
//               </Table>
//             </TableContainer>

//             <Typography variant="h6" color="primary" mt={4}>Recent Searches</Typography>
//             <TableContainer component={Paper} sx={{ maxHeight: 200, overflowX: 'hidden', '&::-webkit-scrollbar': { width: '0.4em' }, '&::-webkit-scrollbar-track': { boxShadow: 'inset 0 0 6px rgba(0,0,0,0.00)', webkitBoxShadow: 'inset 0 0 6px rgba(0,0,0,0.00)' }, '&::-webkit-scrollbar-thumb': { backgroundColor: 'rgba(0,0,0,.1)', outline: '1px solid slategrey' } }}>
//               <Table sx={{ minWidth: 650 }} aria-label="simple table">
//               <TableHead>
//   <TableRow>
//     <TableCell />
    
//     <TableCell align="center">Origin</TableCell>
//     <TableCell align="center">Destination</TableCell>
//     <TableCell align="center">Date</TableCell>
//     <TableCell align="center">Return Ticket</TableCell>
//     <TableCell align="center">Return Origin</TableCell>
//     <TableCell align="center">Return Destination</TableCell>
//     <TableCell align="center">Return Date</TableCell>
//     <TableCell align="center">Adults</TableCell>
//     <TableCell align="center">Children</TableCell>
//   </TableRow>
// </TableHead>
// <TableBody>
// {recentSearches !== null && recentSearches !== undefined && recentSearches.map((recentSearch, index) => (
//   <RecentSearches key={index} row={recentSearch} />
// ))}
//                 </TableBody>

//               </Table>
//             </TableContainer>

//             <Typography variant="h6" color="primary" mt={4}>Saved Car Rentals</Typography>
//             <TableContainer component={Paper} sx={{ maxHeight: 200, overflowX: 'hidden', '&::-webkit-scrollbar': { width: '0.4em' }, '&::-webkit-scrollbar-track': { boxShadow: 'inset 0 0 6px rgba(0,0,0,0.00)', webkitBoxShadow: 'inset 0 0 6px rgba(0,0,0,0.00)' }, '&::-webkit-scrollbar-thumb': { backgroundColor: 'rgba(0,0,0,.1)', outline: '1px solid slategrey' } }}>
//               <Table sx={{ minWidth: 650 }} aria-label="simple table">
//               <TableHead>
//           <TableRow>
//             <TableCell />
//             <TableCell >Car Image</TableCell>
//             <TableCell >Car Name</TableCell>
//             <TableCell >Price</TableCell>
//             <TableCell >Currency</TableCell>
//             <TableCell >Rating</TableCell>
//           </TableRow>
//         </TableHead>
//               <TableBody>
//               {savedCarRentals && savedCarRentals.map((savedCarRental, index) => (
//   <CarRental key={index} row={savedCarRental} />
// ))}
// </TableBody>
//               </Table>
//             </TableContainer>
//           </Paper>
//         </Grid>
//       </Grid>
//     </ThemeProvider>
//   );
// }

// function Row(props) {
//     const { row } = props;
//     const [open, setOpen] = React.useState(false);
  
//     return (
//         <React.Fragment>
//       <TableRow sx={{ '& > *': { borderBottom: 'unset' } }}>
//         <TableCell>
//           <IconButton aria-label="expand row" size="small" onClick={() => setOpen(!open)}>
//             {open ? <KeyboardArrowUpIcon /> : <KeyboardArrowDownIcon />}
//           </IconButton>
//         </TableCell>
//         <TableCell>{row.originPlace}</TableCell>
//         <TableCell>{row.destinationPlace}</TableCell>
//         <TableCell>{formatDate(row.departureDateTime)}</TableCell>
// <TableCell>{formatDate(row.arrivalDateTime)}</TableCell>
//         <TableCell>{row.price ? row.price.amount : 'N/A'}</TableCell>
//         <TableCell><Button variant="contained" style={{ backgroundColor: '#0000A0' }} href={row.bookingLink}>
//     Book Now
//   </Button></TableCell>
//       </TableRow>
//       <TableRow>
//           <TableCell style={{ paddingBottom: 0, paddingTop: 0 }} colSpan={7}>
//             <Collapse in={open} timeout="auto" unmountOnExit>
//               <Box sx={{ margin: 1 }}>
//                 <Typography variant="h6" gutterBottom component="div">
//                   Legs
//                 </Typography>
//                 <Table size="small" aria-label="purchases">
//                   <TableHead>
//                     <TableRow>
//                       <TableCell>Origin Place</TableCell>
//                       <TableCell>Destination Place</TableCell>
//                       <TableCell>Departure DateTime</TableCell>
//                       <TableCell>Arrival DateTime</TableCell>
//                     </TableRow>
//                   </TableHead>
//                   <TableBody>
//                   {row.legs && row.legs.map((leg, index) => (
//   <TableRow key={index}>
//     <TableCell>{leg.originPlace}</TableCell>
//     <TableCell>{leg.destinationPlace}</TableCell>
//     <TableCell>{formatDate(leg.departureDateTime)}</TableCell>
//     <TableCell>{formatDate(leg.arrivalDateTime)}</TableCell>
//   </TableRow>
// ))}
//                   </TableBody>
//                 </Table>
//                 <Grid container spacing={10}>
//                 <Grid item xs={6}>
//                   <Typography variant="h6" gutterBottom component="div" style={{ marginTop: '20px' }}>
//                     Carriers
//                   </Typography>
//                   <Table size="small" aria-label="purchases">
//                   <TableHead>
//                     <TableRow>
//                       <TableCell>Name</TableCell>
//                       <TableCell>Image</TableCell>
//                     </TableRow>
//                   </TableHead>
//                   <TableBody>
//                   {row.carriers && row.carriers.map((carrier) => (
//   <TableRow key={carrier.name}>
//     <TableCell component="th" scope="row">
//       {carrier.name}
//     </TableCell>
//     <TableCell>
//       <img src={carrier.imageUrl} alt={carrier.name} style={{width: '50px', height: '50px'}} />
//     </TableCell>
//   </TableRow>
// ))}
//                   </TableBody>
//                 </Table>
//                 </Grid>
//                 <Grid item xs={6}>
//                   <Typography variant="h6" gutterBottom component="div" style={{ marginTop: '20px' }}>
//                     Agents
//                   </Typography>
//                   <Table size="small" aria-label="purchases">
//                     <TableHead>
//                       <TableRow>
//                         <TableCell>Name</TableCell>
//                         <TableCell>Image</TableCell>
//                       </TableRow>
//                     </TableHead>
//                     <TableBody>
//                     {row.agents && row.agents.map((agent) => (
//   <TableRow key={agent.name}>
//     <TableCell component="th" scope="row">
//       {agent.name}
//     </TableCell>
//     <TableCell>
//       <img src={agent.imageUrl} alt={agent.name} style={{width: '50px', height: '50px'}} />
//     </TableCell>
//   </TableRow>
// ))}
//                     </TableBody>
//                   </Table>
//                 </Grid>
//               </Grid>
//               </Box>
//             </Collapse>
//           </TableCell>
//         </TableRow>
//     </React.Fragment>
//     );
// }

// function Hotel(props) {
//   const { row } = props;
//   const [open, setOpen] = React.useState(false);

//   return (
//     <React.Fragment>
//       <TableRow sx={{ '& > *': { borderBottom: 'unset' } }}>
//         <TableCell>
//           <IconButton
//             aria-label="expand row"
//             size="small"
//             onClick={() => setOpen(!open)}
//           >
//             {open ? <KeyboardArrowUpIcon /> : <KeyboardArrowDownIcon />}
//           </IconButton>
//         </TableCell>
//         <TableCell align="center" component="th" scope="row" style={{display: 'none'}}>
//           {row.id}
//         </TableCell>
//         <TableCell align="center">
//           <img src={row.imageUrl} alt={row.name} style={{width: '50px', height: '50px'}} />
//         </TableCell>
//         <TableCell align="center">{row.name}</TableCell>
//         <TableCell align="center">{row.city}</TableCell>
//         <TableCell align="center">{row.country}</TableCell>
//         <TableCell align="center">{row.starRating}</TableCell>
//       </TableRow>
//       <TableRow>
//         <TableCell style={{ paddingBottom: 0, paddingTop: 0 }} colSpan={6}>
//           <Collapse in={open} timeout="auto" unmountOnExit>
//             <Box sx={{ margin: 1 }}>
//               <Typography variant="h6" gutterBottom component="div">
//                 Hotel Details
//               </Typography>
//               <Table size="small" aria-label="purchases">
//                 <TableHead>
//                   <TableRow>
//                     <TableCell align="center">Address</TableCell>
//                     <TableCell align="center">Minimum Price</TableCell>
//                     <TableCell align="center">Hotel Rank</TableCell>
//                   </TableRow>
//                 </TableHead>
//                 <TableBody>
//                   <TableRow>
//                     <TableCell align="center">{row.address}</TableCell>
//                     <TableCell align="center">{row.minPrice}</TableCell>
//                     <TableCell align="center">{row.hotelRank}</TableCell>
//                   </TableRow>
//                 </TableBody>
//               </Table>
//               <Button variant="contained" style={{ backgroundColor: '#0000A0', marginTop: '20px' }}>
//                 See More
//               </Button>
//             </Box>
//           </Collapse>
//         </TableCell>
//       </TableRow>
//     </React.Fragment>
//   );
// }

// function RecentSearches(props) {
//   const { row } = props;
//   const [open, setOpen] = React.useState(false);

//   return (
//     <React.Fragment>
//       <TableRow sx={{ '& > *': { borderBottom: 'unset' } }}>
//         <TableCell>
//           <IconButton
//             aria-label="expand row"
//             size="small"
//             onClick={() => setOpen(!open)}
//           >
//             {open ? <KeyboardArrowUpIcon /> : <KeyboardArrowDownIcon />}
//           </IconButton>
//         </TableCell>
//         <TableCell align="center" component="th" scope="row" style={{display: 'none'}}>
//           {row.id}
//         </TableCell>
        
//         <TableCell align="center">{row.origin}</TableCell>
//         <TableCell align="center">{row.destination}</TableCell>
//         <TableCell align="center">{row.date}</TableCell>
//         <TableCell align="center">{row.returnTicket ? 'Yes' : 'No'}</TableCell>
//         <TableCell align="center">{row.returnOrigin ? row.returnOrigin : 'N/A'}</TableCell>
//         <TableCell align="center">{row.returnDestination ? row.returnDestination : 'N/A'}</TableCell>
//         <TableCell align="center">{row.returnDate ? row.returnDate : 'N/A'}</TableCell>
//         <TableCell align="center">{row.adults}</TableCell>
//         <TableCell align="center">{row.children}</TableCell>
//       </TableRow>
//       <TableRow>
//         <TableCell style={{ paddingBottom: 0, paddingTop: 0 }} colSpan={6}>
//           <Collapse in={open} timeout="auto" unmountOnExit>
//             <Box sx={{ margin: 1 }}>
//               <Typography variant="h6" gutterBottom component="div">
//                 Search Details
//               </Typography>
              
//             </Box>
//           </Collapse>
//         </TableCell>
//       </TableRow>
//     </React.Fragment>
//   );
// }

// function CarRental(props) {
//   const { row } = props;
//   const [open, setOpen] = React.useState(false);

//   return (
//       <React.Fragment>
//     <TableRow sx={{ '& > *': { borderBottom: 'unset' } }}>
//       <TableCell>
//         <IconButton aria-label="expand row" size="small" onClick={() => setOpen(!open)}>
//           {open ? <KeyboardArrowUpIcon /> : <KeyboardArrowDownIcon />}
//         </IconButton>
//       </TableCell>
//       <TableCell component="th" scope="row" style={{display: 'none'}}>
//           {row.id}
//         </TableCell>
//         <TableCell >
//           <img src={row.carImage} alt={row.carName} style={{width: '50px', height: '50px'}} />
//         </TableCell>
//         <TableCell >{row.carName}</TableCell>
//         <TableCell >{row.price}</TableCell>
//         <TableCell >{row.currency}</TableCell>
//         <TableCell >{row.rating}</TableCell>
//     </TableRow>
//     <TableRow>
//         <TableCell style={{ paddingBottom: 0, paddingTop: 0 }} colSpan={7}>
//           <Collapse in={open} timeout="auto" unmountOnExit>
//           <Box sx={{ margin: 1 }}>
//               <Typography variant="h6" gutterBottom component="div">
//                 Car Rental Details
//               </Typography>
//               <Table size="small" aria-label="purchases">
//                 <TableHead>
//                   <TableRow>
//                     <TableCell align="center">Supplier Name</TableCell>
//                     <TableCell >Supplier Image</TableCell>
//                     <TableCell align="center">Supplier Address</TableCell>
//                     <TableCell align="center">Badges</TableCell>
//                     <TableCell align="center">Transmission</TableCell>
//                     <TableCell align="center">Seats</TableCell>
//                     <TableCell align="center">Base Deposit</TableCell>
//                   </TableRow>
//                 </TableHead>
//                 <TableBody>
//                   <TableRow>
//                     <TableCell align="center">{row.supplierName}</TableCell>
//                     <TableCell align="center"><img src={row.supplierImage} alt={row.supplierName} style={{width: '50px', height: '50px'}} /></TableCell>
//                     <TableCell align="center">{row.supplierAddress}</TableCell>
//                     <TableCell align="center">{row.badges ? row.badges.join(', ') : ''}</TableCell>
//                     <TableCell align="center">{row.transmission}</TableCell>
//                     <TableCell align="center">{row.seats}</TableCell>
//                     <TableCell align="center">{row.baseDeposit}</TableCell>
//                   </TableRow>
//                 </TableBody>
//               </Table>
//               <Button variant="contained" style={{ backgroundColor: '#0000A0', marginTop: '20px' }}>
//                 See More
//               </Button>
//             </Box>
//           </Collapse>
//         </TableCell>
//       </TableRow>
//   </React.Fragment>
//   );
// }

// export default UserManagement;