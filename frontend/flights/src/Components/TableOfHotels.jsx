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
// import TextField from '@mui/material/TextField';
// import Fab from '@mui/material/Fab';
// import Card from '@mui/material/Card';
// import CardContent from '@mui/material/CardContent';
// import FormControl from '@mui/material/FormControl';
// import InputLabel from '@mui/material/InputLabel';
// import OutlinedInput from '@mui/material/OutlinedInput';
// import FavoriteIcon from '@mui/icons-material/Favorite';
// import FavoriteBorderIcon from '@mui/icons-material/FavoriteBorder';
// import { filterHotels, sortHotels } from '../Api.js';
// import Input from '@mui/material/Input';
// import InputAdornment from '@mui/material/InputAdornment';
// import Select from '@mui/material/Select';
// import MenuItem from '@mui/material/MenuItem';
// import Accordion from '@mui/material/Accordion';
// import AccordionSummary from '@mui/material/AccordionSummary';
// import AccordionDetails from '@mui/material/AccordionDetails';
// import ExpandMoreIcon from '@mui/icons-material/ExpandMore';





// import { addHotel } from '../Api.js';


// function Row(props) {
//   const { row } = props;
//   const [open, setOpen] = React.useState(false);

//   const [wishlistClicked, setWishlistClicked] = React.useState(false);

// const handleWishlistClick = async () => {
//   setWishlistClicked(!wishlistClicked);
//   const userId = '65e711c4bf88f66b8e00f03a'; // replace with actual user id
//   console.log(row)
//   try {
//     const response = await addHotel(row, userId);
//     console.log(response); // log the response or handle it as needed
//   } catch (error) {
//     console.error(error); // handle error as needed
//   }
// };

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
  
  

// Row.propTypes = {
//   row: PropTypes.shape({
//     id: PropTypes.string.isRequired,
//     name: PropTypes.string.isRequired,
//     city: PropTypes.string.isRequired,
//     country: PropTypes.string.isRequired,
//     address: PropTypes.string.isRequired,
//     starRating: PropTypes.string.isRequired,
//     minPrice: PropTypes.string.isRequired,
//     hotelRank: PropTypes.string.isRequired,
//     imageUrl: PropTypes.string.isRequired,
//   }).isRequired,
// };

// export default function CollapsibleTable({ rows }) {
//   const [page, setPage] = React.useState(0);
//   const [rowsPerPage, setRowsPerPage] = React.useState(5);
//   const [filteredHotels, setFilteredHotels] = React.useState(rows);
//   const [minPrice, setMinPrice] = React.useState('');
//   const [starRating, setStarRating] = React.useState('');
//   const [reviewRating, setReviewRating] = React.useState('');
//   const [sortOrder, setSortOrder] = React.useState('');
//   const [sortField, setSortField] = React.useState('');

//   const handleSort = async (sortField, sortOrder) => {
//     const sortedHotels = await sortHotels(rows, sortField, sortOrder);
//     setFilteredHotels(sortedHotels);
//     setSortOrder(sortOrder);
//   };

//   const clearSort = () => {
//     setSortOrder('');
//     setSortField('');
//     setFilteredHotels(rows);
//   };

//   const filterHotel = async (minPrice, starRating, reviewRating) => {
//     // If all parameters are empty strings, return immediately
//     if (minPrice === '' && starRating === '' && reviewRating === '') {
//       return;
//     }
  
//     try {
//       const response = await filterHotels(filteredHotels, minPrice, starRating, reviewRating);
//       console.log(response);
//       setFilteredHotels(response);
//     } catch (error) {
//       console.error(error);
//     }
//   };

//   const clearFilters = () => {
//     setFilteredHotels(rows);
//     setMinPrice('');
//     setStarRating('');
//     setReviewRating('');
//   };

//   return (
//     <Grid container spacing={3} alignItems="center" justifyContent="center">
//     <Grid item xs={3}>
//     <Accordion>
//   <AccordionSummary
//     expandIcon={<ExpandMoreIcon />}
//     aria-controls="panel1a-content"
//     id="panel1a-header"
//   >
//     <Typography>Filters</Typography>
//   </AccordionSummary>
//   <AccordionDetails>
//     <Box display="flex" flexDirection="column">
//     <Box mb={1}>
//       <Input
//         id="min-price"
//         startAdornment={<InputAdornment position="start">Min Price</InputAdornment>}
//         value={minPrice}
//         onChange={e => setMinPrice(e.target.value)}
//         disableUnderline
//       />
//       </Box>
//       <Box mb={1}>
//       <Input
//         id="star-rating"
//         startAdornment={<InputAdornment position="start">Star Rating</InputAdornment>}
//         value={starRating}
//         onChange={e => setStarRating(e.target.value)}
//         disableUnderline
//       />
//       </Box>
//       <Box mb={1}>
//       <Input
//         id="review-rating"
//         startAdornment={<InputAdornment position="start">Review Rating</InputAdornment>}
//         value={reviewRating}
//         onChange={e => setReviewRating(e.target.value)}
//         disableUnderline
//       />
//       </Box>
//       <Box display={'flex'} justifyContent={'center'} alignItems={'center'} mt={2}>
//       <Box mr={1}>
//         <Fab variant="extended" size="small" color="primary" onClick={() => filterHotel(minPrice, starRating, reviewRating)}>
//           Apply
//         </Fab>
//       </Box>
//       <Box mr={1}>
//         <Fab variant="extended" size="small" color="secondary" onClick={clearFilters}>
//           Clear
//         </Fab>
//       </Box>
//     </Box>
//     </Box>
//   </AccordionDetails>
// </Accordion>

// <Accordion>
//   <AccordionSummary
//     expandIcon={<ExpandMoreIcon />}
//     aria-controls="panel2a-content"
//     id="panel2a-header"
//   >
//     <Typography>Sort By</Typography>
//   </AccordionSummary>
//   <AccordionDetails>
//     <Box display="flex" flexDirection="column">
//       <FormControl variant="outlined" size="small" style={{ minWidth: 120, marginBottom: 5 }}>
//         <InputLabel id="sort-field-label" size="small">Sort By</InputLabel>
//         <Select
//           labelId="sort-field-label"
//           id="sort-field"
//           value={sortField}
//           onChange={e => setSortField(e.target.value)}
//           label="Sort By"
//           size="small"
//         >
//           <MenuItem value={'price'}>Price</MenuItem>
//           <MenuItem value={'starRating'}>Star Rating</MenuItem>
//           <MenuItem value={'reviewRating'}>Review Rating</MenuItem>
//         </Select>
//       </FormControl>
//       <Box display={'flex'} justifyContent={'center'} alignItems={'center'}>
//       <Box mr={1}>
//         <Fab variant="extended" size="small" color="primary" onClick={() => handleSort(sortField, 'asc')}>
//           Asc
//         </Fab>
//       </Box>
//       <Box mr={1}>
//         <Fab variant="extended" size="small" color="primary" onClick={() => handleSort(sortField, 'desc')}>
//           Desc
//         </Fab>
//       </Box>
//       <Box mr={1}>
//         <Fab variant="extended" size="small" color="secondary" onClick={clearSort}>
//           Clear
//         </Fab>
//       </Box>
//     </Box>
//     </Box>
//   </AccordionDetails>
// </Accordion>
//       </Grid>
//       <Grid item xs={9}>
//     <TableContainer component={Paper} style={{ width: '700px' }}>  
//       <Table aria-label="collapsible table">
//         <TableHead>
//           <TableRow>
//             <TableCell />
//             <TableCell align="center">Image</TableCell>
//             <TableCell align="center">Name</TableCell>
//             <TableCell align="center">City</TableCell>
//             <TableCell align="center">Country</TableCell>
//             <TableCell align="center">Star Rating</TableCell>
//           </TableRow>
//         </TableHead>
//         <TableBody>
//           {filteredHotels.slice(page * rowsPerPage, page * rowsPerPage + rowsPerPage).map((row) => (
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
//       </TableContainer>
//       </Grid>
//     </Grid>

//   );
// }

// CollapsibleTable.propTypes = {
//   rows: PropTypes.arrayOf(
//     PropTypes.shape({
//       id: PropTypes.string.isRequired,
//       name: PropTypes.string.isRequired,
//       city: PropTypes.string.isRequired,
//       country: PropTypes.string.isRequired,
//       address: PropTypes.string.isRequired,
//       starRating: PropTypes.string.isRequired,
//       minPrice: PropTypes.string.isRequired,
//       hotelRank: PropTypes.string.isRequired,
//       imageUrl: PropTypes.string.isRequired,
//     }),
//   ).isRequired,
// };