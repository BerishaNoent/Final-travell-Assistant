// import * as React from 'react';
// import PropTypes from 'prop-types';
// import Box from '@mui/material/Box';
// import Collapse from '@mui/material/Collapse';
// import IconButton from '@mui/material/IconButton';
// import Table from '@mui/material/Table';
// import TableBody from '@mui/material/TableBody';
// import TableCell from '@mui/material/TableCell';
// import TableContainer from '@mui/material/TableContainer';
// import TableHead from '@mui/material/TableHead';
// import TableRow from '@mui/material/TableRow';
// import Typography from '@mui/material/Typography';
// import Paper from '@mui/material/Paper';
// import KeyboardArrowDownIcon from '@mui/icons-material/KeyboardArrowDown';
// import KeyboardArrowUpIcon from '@mui/icons-material/KeyboardArrowUp';
// import Button from '@mui/material/Button';
// import Grid from '@mui/material/Grid';
// import TablePagination from '@mui/material/TablePagination';
// import FavoriteBorderIcon from '@mui/icons-material/FavoriteBorder';
// import FavoriteIcon from '@mui/icons-material/Favorite';
// import { addCarRental, filterCarRentals, sortCars } from '../Api.js';
// import Fab from '@mui/material/Fab';
// import Card from '@mui/material/Card';
// import CardContent from '@mui/material/CardContent';
// import Input from '@mui/material/Input';
// import InputAdornment from '@mui/material/InputAdornment';
// import Select from '@mui/material/Select';
// import MenuItem from '@mui/material/MenuItem';
// import Accordion from '@mui/material/Accordion';
// import AccordionSummary from '@mui/material/AccordionSummary';
// import AccordionDetails from '@mui/material/AccordionDetails';
// import ExpandMoreIcon from '@mui/icons-material/ExpandMore';


// function Row(props) {
//   const { row } = props;
//   const [open, setOpen] = React.useState(false);

//   const [wishlistClicked, setWishlistClicked] = React.useState(false);
  

//   const handleWishlistClick = async () => {
//     setWishlistClicked(!wishlistClicked);
    
//     const userId = '65e711c4bf88f66b8e00f03a'; // replace with actual user id
//     console.log(row)
//     try {
//       const response = await addCarRental(row, userId);
//       console.log(response); // log the response or handle it as needed
//     } catch (error) {
//       console.error(error); // handle error as needed
//     }
//   };

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
//         <TableCell component="th" scope="row" style={{display: 'none'}}>
//           {row.id}
//         </TableCell>
//         <TableCell align="center">
//           <img src={row.carImage} alt={row.carName} style={{width: '50px', height: '50px'}} />
//         </TableCell>
//         <TableCell align="center">{row.carName}</TableCell>
//         <TableCell align="center">{row.price}</TableCell>
//         <TableCell align="center">{row.currency}</TableCell>
//         <TableCell align="center">{row.rating}</TableCell>
//         <TableCell align="center">
//   <IconButton onClick={handleWishlistClick}>
//     {wishlistClicked ? <FavoriteIcon /> : <FavoriteBorderIcon />}
//   </IconButton>
// </TableCell>
//       </TableRow>
//       <TableRow>
//         <TableCell style={{ paddingBottom: 0, paddingTop: 0 }} colSpan={6}>
//           <Collapse in={open} timeout="auto" unmountOnExit>
//             <Box sx={{ margin: 1 }}>
//               <Typography variant="h6" gutterBottom component="div">
//                 Car Rental Details
//               </Typography>
//               <Table size="small" aria-label="purchases">
//                 <TableHead>
//                   <TableRow>
//                     <TableCell align="center">Supplier Name</TableCell>
//                     <TableCell align="center">Supplier Image</TableCell>
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
//                     <TableCell align="center">{row.badges.join(', ')}</TableCell>
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
//     </React.Fragment>
//   );
// }

// Row.propTypes = {
//   row: PropTypes.shape({
//     id: PropTypes.string.isRequired,
//     supplierName: PropTypes.string.isRequired,
//     supplierImage: PropTypes.string.isRequired,
//     supplierAddress: PropTypes.string.isRequired,
//     rating: PropTypes.number.isRequired,
//     badges: PropTypes.arrayOf(PropTypes.string).isRequired,
//     carName: PropTypes.string.isRequired,
//     transmission: PropTypes.string.isRequired,
//     seats: PropTypes.number.isRequired,
//     carImage: PropTypes.string.isRequired,
//     price: PropTypes.string.isRequired,
//     currency: PropTypes.string.isRequired,
//     baseDeposit: PropTypes.string.isRequired,
//   }).isRequired,
// };

// CollapsibleTable.propTypes = {
//   rows: PropTypes.arrayOf(
//     PropTypes.shape({
//       id: PropTypes.string.isRequired,
//       supplierName: PropTypes.string.isRequired,
//       supplierImage: PropTypes.string.isRequired,
//       supplierAddress: PropTypes.string.isRequired,
//       rating: PropTypes.number.isRequired,
//       badges: PropTypes.arrayOf(PropTypes.string).isRequired,
//       carName: PropTypes.string.isRequired,
//       transmission: PropTypes.string.isRequired,
//       seats: PropTypes.number.isRequired,
//       carImage: PropTypes.string.isRequired,
//       price: PropTypes.string.isRequired,
//       currency: PropTypes.string.isRequired,
//       baseDeposit: PropTypes.string.isRequired,
//     }),
//   ).isRequired,
// };

// export default function CollapsibleTable({ rows }) {
//   const [page, setPage] = React.useState(0);
//   const [rowsPerPage, setRowsPerPage] = React.useState(5);
//   const [filteredCarRentals, setFilteredCarRentals] = React.useState(rows);
//   const [rating, setRating] = React.useState('');
//   const [price, setPrice] = React.useState('');
//   const [transmission, setTransmission] = React.useState('');
//   const [seats, setSeats] = React.useState('');
//   const [sortOrder, setSortOrder] = React.useState('');
  

//   const handleSort = async (sortOrder) => {
//     const sortedCars = await sortCars(rows, sortOrder);
//     setFilteredCarRentals(sortedCars);
//     setSortOrder(sortOrder);
//   };

//   const clearSort = () => {
//     setSortOrder('');
//     setFilteredCarRentals(rows);
//   };



//   const filterCarRental = async () => {
//     try {
//       const response = await filterCarRentals(rows, rating, transmission, seats, price);
//       console.log(response);
//       setFilteredCarRentals(response);
//     } catch (error) {
//       console.error(error);
//     }
//   };

//   const clearFilters = () => {
//     setFilteredCarRentals(rows);
//     setRating('');
//     setPrice('');
//     setTransmission('');
//     setSeats('');
//   };

//   return (
//     <Grid container spacing={3} alignItems="center" justifyContent="center">
//     <Grid item xs={3}>
//       <Accordion>
//         <AccordionSummary
//           expandIcon={<ExpandMoreIcon />}
//           aria-controls="panel1a-content"
//           id="panel1a-header"
//         >
//           <Typography>Filters</Typography>
//         </AccordionSummary>
//         <AccordionDetails>
//           <Box display="flex" flexDirection="column">
//           <Box mb={1}>
//         <Input
//           id="rating"
//           startAdornment={<InputAdornment position="start">Rating</InputAdornment>}
//           value={rating}
//           onChange={e => setRating(e.target.value)}
//           disableUnderline
//         />
//       </Box>
//       <Box mb={1}>
//         <Input
//           id="transmission"
//           startAdornment={<InputAdornment position="start">Transmission</InputAdornment>}
//           value={transmission}
//           onChange={e => setTransmission(e.target.value)}
//           disableUnderline
//         />
//       </Box>
//       <Box mb={1}>
//         <Input
//           id="seats"
//           startAdornment={<InputAdornment position="start">Seats</InputAdornment>}
//           value={seats}
//           onChange={e => setSeats(e.target.value)}
//           disableUnderline
//         />
//       </Box><Box mb={1}>
//         <Input
//           id="price"
//           startAdornment={<InputAdornment position="start">Price</InputAdornment>}
//           value={price}
//           onChange={e => setPrice(e.target.value)}
//           disableUnderline
//         />
//       </Box>
//       <Box display={'flex'} justifyContent={'center'} alignItems={'center'} mt={2}>
//       <Box mr={1}>
//         <Fab variant="extended" color="primary" onClick={() => filterCarRental(rating, transmission, seats, price)}>
//           Apply
//         </Fab>
//       </Box>
//       <Box mr={1}>
//         <Fab variant="extended" color="secondary" onClick={clearFilters}>
//           Clear
//         </Fab>
//       </Box>
//     </Box>
//           </Box>
//         </AccordionDetails>
//       </Accordion>
  
//       <Accordion>
//         <AccordionSummary
//           expandIcon={<ExpandMoreIcon />}
//           aria-controls="panel2a-content"
//           id="panel2a-header"
//         >
//           <Typography>Sort By</Typography>
//         </AccordionSummary>
//         <AccordionDetails>
//         <Box display={'flex'} justifyContent={'center'} alignItems={'center'}>
            
//             <Box mr={1}>
//               <Fab variant="extended" size="small" color="primary" onClick={() => handleSort( 'asc')}>
//                 Asc
//               </Fab>
//             </Box>
//             <Box mr={1}>
//               <Fab variant="extended" size="small" color="primary" onClick={() => handleSort('desc')}>
//                 Desc
//               </Fab>
//             </Box>
//             <Box mr={1}>
//               <Fab variant="extended" size="small" color="secondary" onClick={clearSort}>
//                 Clear
//               </Fab>
//             </Box>
//           </Box>
//         </AccordionDetails>
//       </Accordion>
//     </Grid>
//     <Grid item xs={9}>
      
//     <TableContainer component={Paper} style={{ width: '700px' }}>
//       <Table aria-label="collapsible table">
//         <TableHead>
//           <TableRow>
//             <TableCell />
            
//             <TableCell align="center">Car Image</TableCell>
//             <TableCell align="center">Car Name</TableCell>
//             <TableCell align="center">Price</TableCell>
//             <TableCell align="center">Currency</TableCell>
//             <TableCell align="center">Rating</TableCell>
//           </TableRow>
//         </TableHead>
//         <TableBody>
//           {filteredCarRentals.slice(page * rowsPerPage, page * rowsPerPage + rowsPerPage).map((row) => (
//             <Row key={row.id} row={row} />
//           ))}
//         </TableBody>
//       </Table>
//       <TablePagination
//         component="div"
//         count={rows.length}
//         page={page}
//         onPageChange={(event, newPage) => setPage(newPage)}
//         rowsPerPage={rowsPerPage}
//         onRowsPerPageChange={(event) => setRowsPerPage(parseInt(event.target.value, 10))}
//         rowsPerPageOptions={[rowsPerPage]} // Add this line
//       />
//     </TableContainer>
//     </Grid>
//     </Grid>
   
//   );
// }

