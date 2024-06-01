import * as React from 'react';
import PropTypes from 'prop-types';
import Box from '@mui/material/Box';
import Collapse from '@mui/material/Collapse';
import IconButton from '@mui/material/IconButton';
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Typography from '@mui/material/Typography';
import Paper from '@mui/material/Paper';
import KeyboardArrowDownIcon from '@mui/icons-material/KeyboardArrowDown';
import KeyboardArrowUpIcon from '@mui/icons-material/KeyboardArrowUp';
import Button from '@mui/material/Button';
import Grid from '@mui/material/Grid';
import TablePagination from '@mui/material/TablePagination';
import FavoriteBorderIcon from '@mui/icons-material/FavoriteBorder';
import FavoriteIcon from '@mui/icons-material/Favorite';
import { addFlight, filterFlights } from '../Api';
import Fab from '@mui/material/Fab';
import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';
import Input from '@mui/material/Input';
import InputAdornment from '@mui/material/InputAdornment';
import Accordion from '@mui/material/Accordion';
import AccordionSummary from '@mui/material/AccordionSummary';
import AccordionDetails from '@mui/material/AccordionDetails';
import ExpandMoreIcon from '@mui/icons-material/ExpandMore';
import Select from '@mui/material/Select';
import MenuItem from '@mui/material/MenuItem';
import FormControl from '@mui/material/FormControl';
import InputLabel from '@mui/material/InputLabel';



function Row(props) {
    const { row , rowKey} = props;
    const [open, setOpen] = React.useState(false);
    const [wishlistClicked, setWishlistClicked] = React.useState(false);

   const handleWishlistClick = async () => {
  setWishlistClicked(!wishlistClicked);
  const departureDate = new Date(row.departureDateTime);
  const arrivalDate = new Date(row.arrivalDateTime);
  const rowData = {
    Id: rowKey,
    ...row,
    
    departureDateTime: {
      year: departureDate.getUTCFullYear(),
      month: departureDate.getUTCMonth() + 1, // getUTCMonth returns a zero-based month, so add 1
      day: departureDate.getUTCDate(),
      hour: departureDate.getUTCHours(),
      minute: departureDate.getUTCMinutes(),
      second: departureDate.getUTCSeconds(),
    },
    arrivalDateTime: {
      year: arrivalDate.getUTCFullYear(),
      month: arrivalDate.getUTCMonth() + 1,
      day: arrivalDate.getUTCDate(),
      hour: arrivalDate.getUTCHours(),
      minute: arrivalDate.getUTCMinutes(),
      second: arrivalDate.getUTCSeconds(),
    },
    legs: row.legs.map(leg => {
      const legDepartureDate = new Date(leg.departureDateTime);
      const legArrivalDate = new Date(leg.arrivalDateTime);
      return {
        ...leg,
        departureDateTime: {
          year: legDepartureDate.getUTCFullYear(),
          month: legDepartureDate.getUTCMonth() + 1,
          day: legDepartureDate.getUTCDate(),
          hour: legDepartureDate.getUTCHours(),
          minute: legDepartureDate.getUTCMinutes(),
          second: legDepartureDate.getUTCSeconds(),
        },
        arrivalDateTime: {
          year: legArrivalDate.getUTCFullYear(),
          month: legArrivalDate.getUTCMonth() + 1,
          day: legArrivalDate.getUTCDate(),
          hour: legArrivalDate.getUTCHours(),
          minute: legArrivalDate.getUTCMinutes(),
          second: legArrivalDate.getUTCSeconds(),
        },
      };
    }),
  };
console.log(rowData);
  // addFlight(rowData, "65e711c4bf88f66b8e00f03a");
  const userId = 'your-user-id'; // replace with actual user id
  try {
    const response = await addFlight(rowData, "65e711c4bf88f66b8e00f03a");
    console.log(response); // log the response or handle it as needed
  } catch (error) {
    console.error(error); // handle error as needed
  }
};
  
    return (
      <React.Fragment>
        <TableRow sx={{ '& > *': { borderBottom: 'unset' } }}>
          <TableCell>
            <IconButton
              aria-label="expand row"
              size="small"
              onClick={() => setOpen(!open)}
            >
              {open ? <KeyboardArrowUpIcon /> : <KeyboardArrowDownIcon />}
            </IconButton>
          </TableCell>
          <TableCell component="th" scope="row">
            
          </TableCell>
          <TableCell align="center">{row.originPlace}</TableCell>
          <TableCell align="center">{row.destinationPlace}</TableCell>
          <TableCell align="center">{new Date(row.departureDateTime).toLocaleString()}</TableCell>
          <TableCell align="center">{new Date(row.arrivalDateTime).toLocaleString()}</TableCell>
          <TableCell align="center">{`${row.price.amount} ${row.price.unit}`}</TableCell>
          <TableCell align="center"> <Button variant="contained" style={{ backgroundColor: '#0000A0' }} href={row.bookingLink}>
    Book Now
  </Button></TableCell>
  <TableCell align="center">
  <IconButton onClick={handleWishlistClick}>
    {wishlistClicked ? <FavoriteIcon /> : <FavoriteBorderIcon />}
  </IconButton>
</TableCell>
        </TableRow>
        <TableRow>
          <TableCell style={{ paddingBottom: 0, paddingTop: 0 }} colSpan={7}>
            <Collapse in={open} timeout="auto" unmountOnExit>
              <Box sx={{ margin: 1 }}>
                <Typography variant="h6" gutterBottom component="div">
                  Legs
                </Typography>
                <Table size="small" aria-label="purchases">
                  <TableHead>
                    <TableRow>
                      <TableCell>Origin Place</TableCell>
                      <TableCell>Destination Place</TableCell>
                      <TableCell>Departure DateTime</TableCell>
                      <TableCell>Arrival DateTime</TableCell>
                    </TableRow>
                  </TableHead>
                  <TableBody>
                    {row.legs.map((leg, index) => (
                      <TableRow key={index}>
                        <TableCell>{leg.originPlace}</TableCell>
                        <TableCell>{leg.destinationPlace}</TableCell>
                        <TableCell>{new Date(leg.departureDateTime).toLocaleString()}</TableCell>
                        <TableCell>{new Date(leg.arrivalDateTime).toLocaleString()}</TableCell>
                      </TableRow>
                    ))}
                  </TableBody>
                </Table>
                <Grid container spacing={10}>
                <Grid item xs={6}>
                  <Typography variant="h6" gutterBottom component="div" style={{ marginTop: '20px' }}>
                    Carriers
                  </Typography>
                  <Table size="small" aria-label="purchases">
                  <TableHead>
                    <TableRow>
                      <TableCell>Name</TableCell>
                      <TableCell>Image</TableCell>
                    </TableRow>
                  </TableHead>
                  <TableBody>
                    {row.carriers.map((carrier) => (
                      <TableRow key={carrier.name}>
                        <TableCell component="th" scope="row">
                          {carrier.name}
                        </TableCell>
                        <TableCell><img src={carrier.imageUrl} alt={carrier.name} style={{width: '50px', height: '50px'}} /></TableCell>
                      </TableRow>
                    ))}
                  </TableBody>
                </Table>
                </Grid>
                <Grid item xs={6}>
                  <Typography variant="h6" gutterBottom component="div" style={{ marginTop: '20px' }}>
                    Agents
                  </Typography>
                  <Table size="small" aria-label="purchases">
                    <TableHead>
                      <TableRow>
                        <TableCell>Name</TableCell>
                        <TableCell>Image</TableCell>
                      </TableRow>
                    </TableHead>
                    <TableBody>
                      {row.agents.map((agent) => (
                        <TableRow key={agent.name}>
                          <TableCell component="th" scope="row">
                            {agent.name}
                          </TableCell>
                          <TableCell><img src={agent.imageUrl} alt={agent.name} style={{width: '50px', height: '50px'}} /></TableCell>
                        </TableRow>
                      ))}
                    </TableBody>
                  </Table>
                </Grid>
              </Grid>
              </Box>
            </Collapse>
          </TableCell>
        </TableRow>
      </React.Fragment>
    );
  }
  
  

Row.propTypes = {
  row: PropTypes.shape({
    price: PropTypes.shape({
      amount: PropTypes.number.isRequired,
      unit: PropTypes.string.isRequired,
    }).isRequired,
    originPlace: PropTypes.string.isRequired,
    destinationPlace: PropTypes.string.isRequired,
    departureDateTime: PropTypes.string.isRequired,
    arrivalDateTime: PropTypes.string.isRequired,
    carriers: PropTypes.arrayOf(
      PropTypes.shape({
        name: PropTypes.string.isRequired,
        imageUrl: PropTypes.string.isRequired,
      }),
    ).isRequired,
  }).isRequired,
};

export default function CollapsibleTable({ rows }) {
    const [page, setPage] = React.useState(0);
const [rowsPerPage, setRowsPerPage] = React.useState(5);
const [filteredFlights, setFilteredFlights] = React.useState(rows);
const [price, setPrice] = React.useState('');
const [maxDuration, setMaxDuration] = React.useState('');
const [sortField, setSortField] = React.useState('');
const [sortOrder, setSortOrder] = React.useState('');

const handleSort = async (sortField, sortOrder) => {
  const sortedFlights = await sortHotels(rows, sortField, sortOrder);
  setFilteredFlights(sortedFlights);
  setSortOrder(sortOrder);
};

const clearSort = () => {
  setSortOrder('');
  setFilteredFlights(rows);
};

const filterFlight = async () => {
  try {
    const formattedRows = rows.map(row => {
      const departureDate = new Date(row.departureDateTime);
      const arrivalDate = new Date(row.arrivalDateTime);
      return {
        ...row,
        departureDateTime: {
          year: departureDate.getUTCFullYear(),
          month: departureDate.getUTCMonth() + 1,
          day: departureDate.getUTCDate(),
          hour: departureDate.getUTCHours(),
          minute: departureDate.getUTCMinutes(),
          second: departureDate.getUTCSeconds(),
        },
        arrivalDateTime: {
          year: arrivalDate.getUTCFullYear(),
          month: arrivalDate.getUTCMonth() + 1,
          day: arrivalDate.getUTCDate(),
          hour: arrivalDate.getUTCHours(),
          minute: arrivalDate.getUTCMinutes(),
          second: arrivalDate.getUTCSeconds(),
        },
        legs: row.legs.map(leg => {
          const legDepartureDate = new Date(leg.departureDateTime);
          const legArrivalDate = new Date(leg.arrivalDateTime);
          return {
            ...leg,
            departureDateTime: {
              year: legDepartureDate.getUTCFullYear(),
              month: legDepartureDate.getUTCMonth() + 1,
              day: legDepartureDate.getUTCDate(),
              hour: legDepartureDate.getUTCHours(),
              minute: legDepartureDate.getUTCMinutes(),
              second: legDepartureDate.getUTCSeconds(),
            },
            arrivalDateTime: {
              year: legArrivalDate.getUTCFullYear(),
              month: legArrivalDate.getUTCMonth() + 1,
              day: legArrivalDate.getUTCDate(),
              hour: legArrivalDate.getUTCHours(),
              minute: legArrivalDate.getUTCMinutes(),
              second: legArrivalDate.getUTCSeconds(),
            },
          };
        }),
      };
    });

    const response = await filterFlights(formattedRows, price, maxDuration);
    console.log(response);
    const formattedResponse = response.map(row => {
      const departureDateTimeString = `${row.departureDateTime.year}-${row.departureDateTime.month}-${row.departureDateTime.day} ${row.departureDateTime.hour}:${row.departureDateTime.minute}:${row.departureDateTime.second}`;
      const arrivalDateTimeString = `${row.arrivalDateTime.year}-${row.arrivalDateTime.month}-${row.arrivalDateTime.day} ${row.arrivalDateTime.hour}:${row.arrivalDateTime.minute}:${row.arrivalDateTime.second}`;
      return {
        ...row,
        departureDateTime: departureDateTimeString,
        arrivalDateTime: arrivalDateTimeString,
        legs: row.legs.map(leg => {
          const legDepartureDateTimeString = `${leg.departureDateTime.year}-${leg.departureDateTime.month}-${leg.departureDateTime.day} ${leg.departureDateTime.hour}:${leg.departureDateTime.minute}:${leg.departureDateTime.second}`;
          const legArrivalDateTimeString = `${leg.arrivalDateTime.year}-${leg.arrivalDateTime.month}-${leg.arrivalDateTime.day} ${leg.arrivalDateTime.hour}:${leg.arrivalDateTime.minute}:${leg.arrivalDateTime.second}`;
          return {
            ...leg,
            departureDateTime: legDepartureDateTimeString,
            arrivalDateTime: legArrivalDateTimeString,
          };
        }),
      };
    });
  
    setFilteredFlights(formattedResponse);
  } catch (error) {
    console.error(error);
  }
};

const clearFilters = () => {
  setFilteredFlights(rows);
  setMaxDuration('');
  setPrice('');
  
};

    return (
      <Grid container spacing={3} alignItems="center" justifyContent="center">
      <Grid item xs={2}>
  <Accordion>
    <AccordionSummary
      expandIcon={<ExpandMoreIcon />}
      aria-controls="panel1a-content"
      id="panel1a-header"
    >
      <Typography variant="h6" gutterBottom component="div">
        Filters
      </Typography>
    </AccordionSummary>
    <AccordionDetails>
      <Box display="flex" flexDirection="column">
      <Box mb={1}>
        <Input
          id="price"
          startAdornment={<InputAdornment position="start">Max Price</InputAdornment>}
          value={price}
          onChange={e => setPrice(e.target.value)}
          disableUnderline
          sx={{ '& input': { border: '1px solid #000', borderRadius: '4px', padding: '2px' } }}
        />
      </Box>
      <Box mb={1}>
        <Input
          id="maxDuration"
          startAdornment={<InputAdornment position="start">Max Duration</InputAdornment>}
          value={maxDuration}
          onChange={e => setMaxDuration(e.target.value)}
          disableUnderline
          sx={{ '& input': { border: '1px solid #000', borderRadius: '4px', padding: '2px' } }}
        />
      </Box>
      <Box display={'flex'} justifyContent={'center'} alignItems={'center'} mt={2}>
        <Box mr={1}>
          <Fab variant="extended" color="primary" size="small" onClick={() => filterFlight(price, maxDuration)}>
            Apply
          </Fab>
        </Box>
          <Fab variant="extended" color="secondary" size="small" onClick={clearFilters}>
            Clear
          </Fab>
        </Box>
      </Box>
    </AccordionDetails>
  </Accordion>
  <Accordion>
  <AccordionSummary
    expandIcon={<ExpandMoreIcon />}
    aria-controls="panel2a-content"
    id="panel2a-header"
  >
    <Typography>Sort By</Typography>
  </AccordionSummary>
  <AccordionDetails>
    <Box display="flex" flexDirection="column">
      <FormControl variant="outlined" size="small" style={{ minWidth: 120, marginBottom: 5 }}>
        <InputLabel id="sort-field-label" size="small">Sort By</InputLabel>
        <Select
          labelId="sort-field-label"
          id="sort-field"
          value={sortField}
          onChange={e => setSortField(e.target.value)}
          label="Sort By"
          size="small"
        >
          <MenuItem value={'price'}>Price</MenuItem>
          <MenuItem value={'duration'}>Duration</MenuItem>
        </Select>
      </FormControl>
      <Box display={'flex'} justifyContent={'center'} alignItems={'center'}>
      <Box mr={1}>
        <Fab variant="extended" size="small" color="primary" onClick={() => handleSort(sortField, 'asc')}>
          Asc
        </Fab>
      </Box>
      <Box mr={1}>
        <Fab variant="extended" size="small" color="primary" onClick={() => handleSort(sortField, 'desc')}>
          Desc
        </Fab>
      </Box>
      <Box mr={1}>
        <Fab variant="extended" size="small" color="secondary" onClick={clearSort}>
          Clear
        </Fab>
      </Box>
      </Box>
    </Box>
  </AccordionDetails>
</Accordion>
</Grid>
        <Grid item xs={9} >
      <TableContainer component={Paper}>
        <Table aria-label="collapsible table">
          <TableHead>
            <TableRow>
                <TableCell />
                <TableCell />
              <TableCell align="center">Origin Place</TableCell>
              <TableCell align="center">Destination Place</TableCell>
              <TableCell align="center">Departure DateTime</TableCell>
              <TableCell align="center">Arrival DateTime</TableCell>
              <TableCell align="center">Price</TableCell>
              <TableCell align="center">Booking Link</TableCell>
            </TableRow>
          </TableHead>
          <TableBody>
          {filteredFlights.slice(page * rowsPerPage, page * rowsPerPage + rowsPerPage).map((row, index) => {
  const rowId = page * rowsPerPage + index;
  return (
    <Row key={rowId} row={row} rowKey={rowId}/>
  );
})}
          </TableBody>
        </Table>
        <TablePagination
  component="div"
  count={rows.length}
  page={page}
  onPageChange={(event, newPage) => setPage(newPage)}
  rowsPerPage={rowsPerPage}
  onRowsPerPageChange={(event) => setRowsPerPage(parseInt(event.target.value, 10))}
  rowsPerPageOptions={[rowsPerPage]} // Add this line
/>
      </TableContainer>
      </Grid>
    </Grid>
    );
  }

CollapsibleTable.propTypes = {
  rows: PropTypes.array.isRequired,
};