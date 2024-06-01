import * as React from 'react';
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
import { addFlight, filterFlights, sortFlights } from '../Api';
import Fab from '@mui/material/Fab';
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
import { toast } from 'react-toastify';



  export function Row(props) {
    const { row , token, userId} = props;
    const price = row.price || { amount: 'Not defined', unit: 'Not defined' };
    const carriers = row.carriers || [{ name: 'Not defined', imageUrl: 'Not defined' }];
    const [open, setOpen] = React.useState(false);
    const [wishlistClicked, setWishlistClicked] = React.useState(false);
    const parseDateTime = (dateTimeStr) => {
      const [date, time] = dateTimeStr.split('T');
      const [year, month, day] = date.split('-').map(Number);
      const [hour, minute] = time.split(':').map(Number);
    
      return new Date(year, month - 1, day, hour, minute);
    };
    

    const handleWishlistClick = async () => {
      if (!row.departureDateTime || !row.arrivalDateTime) {
        toast.error("Departure or arrival date is not set");
        return;
      }

const rowData = {
  ...row,
  departureDateTime: {
      ...row.departureDateTime,
      hour: parseInt(row.departureDateTime.hour, 10),
  },
  arrivalDateTime: {
      ...row.arrivalDateTime,
      hour: parseInt(row.arrivalDateTime.hour, 10),
  },
  legs: row.legs.map(leg => ({
      ...leg,
      departureDateTime: {
          ...leg.departureDateTime,
          hour: parseInt(leg.departureDateTime.hour, 10),
      },
      arrivalDateTime: {
          ...leg.arrivalDateTime,
          hour: parseInt(leg.arrivalDateTime.hour, 10),
      },
  })),
};      

      try {
        if (!wishlistClicked) {
          const response = await addFlight(rowData, userId, token);
          if (response.status === 200) {
            toast.success("Flight added to wishlist successfully");
            toast.info("You can remove saved flights from your account page");
            setWishlistClicked(true);
            
            
          }
          else {
            toast.error("Failed to add  flight to wishlist");
          }
        }
      } catch (error) {
        if (error.status === 409) {
          toast.error("Flight already added to wishlist");
        } else {
          toast.error("Failed to add the flight to wishlist");
        }
      
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
          <TableCell align="center">{row.originPlace || 'Not defined'}</TableCell>
<TableCell align="center">{row.destinationPlace || 'Not defined'}</TableCell>
<TableCell align="center">
  {row.departureDateTime 
    ? parseDateTime(`${row.departureDateTime.year}-${row.departureDateTime.month}-${row.departureDateTime.day}T${row.departureDateTime.hour}:${row.departureDateTime.minute}`).toLocaleString() 
    : 'Not defined'}
</TableCell>
<TableCell align="center">
  {row.arrivalDateTime 
    ? parseDateTime(`${row.arrivalDateTime.year}-${row.arrivalDateTime.month}-${row.arrivalDateTime.day}T${row.arrivalDateTime.hour}:${row.arrivalDateTime.minute}`).toLocaleString() 
    : 'Not defined'}
</TableCell>
<TableCell align="center">{row.price ? `${row.price.amount} ${row.price.unit}` : 'Not defined'}</TableCell>
<TableCell align="center">
  <Button variant="contained" style={{ backgroundColor: '#0000A0' }} href={row.bookingLink || '#'}>
    Book
  </Button>
</TableCell>
  <TableCell align="center">
  <IconButton data-testid="wishlist-button" onClick={handleWishlistClick}>
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
                  {Array.isArray(row.legs) ? row.legs.map((leg, index) => (
  <TableRow key={index}>
    <TableCell>{leg.originPlace || 'Not defined'}</TableCell>
    <TableCell>{leg.destinationPlace || 'Not defined'}</TableCell>
    <TableCell>
  {leg.departureDateTime 
    ? parseDateTime(`${leg.departureDateTime.year}-${leg.departureDateTime.month}-${leg.departureDateTime.day}T${leg.departureDateTime.hour}:${leg.departureDateTime.minute}`).toLocaleString() 
    : 'Not defined'}
</TableCell>
<TableCell>
  {leg.arrivalDateTime 
    ? parseDateTime(`${leg.arrivalDateTime.year}-${leg.arrivalDateTime.month}-${leg.arrivalDateTime.day}T${leg.arrivalDateTime.hour}:${leg.arrivalDateTime.minute}`).toLocaleString() 
    : 'Not defined'}
</TableCell>
  </TableRow>
)) : <TableRow><TableCell colSpan={4}>No data available</TableCell></TableRow>}
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
                  {Array.isArray(row.carriers) ? row.carriers.map((carrier) => (
  <TableRow key={carrier.name || 'Not defined'}>
    <TableCell component="th" scope="row">
      {carrier.name || 'Not defined'}
    </TableCell>
    <TableCell>
      {carrier.imageUrl ? <img src={carrier.imageUrl} alt={carrier.name || 'Not defined'} style={{width: '50px', height: '50px'}} /> : 'Not defined'}
    </TableCell>
  </TableRow>
)) : <TableRow><TableCell colSpan={2}>No data available</TableCell></TableRow>}
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
                    {Array.isArray(row.agents) ? row.agents.map((agent) => (
  <TableRow key={agent.name || 'Not defined'}>
    <TableCell component="th" scope="row">
      {agent.name || 'Not defined'}
    </TableCell>
    <TableCell>
      {agent.imageUrl ? <img src={agent.imageUrl} alt={agent.name || 'Not defined'} style={{width: '50px', height: '50px'}} /> : 'Not defined'}
    </TableCell>
  </TableRow>
)) : <TableRow><TableCell colSpan={2}>No data available</TableCell></TableRow>}
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
  
  


export default function CollapsibleTable({ rows, userLoggedData }) {
  const { token, userId } = userLoggedData;
    const [page, setPage] = React.useState(0);
const [rowsPerPage, setRowsPerPage] = React.useState(5);
const validRows = rows.filter(row => row.departureDateTime && row.arrivalDateTime);
const [filteredFlights, setFilteredFlights] = React.useState(validRows);
const [price, setPrice] = React.useState('');

const [sortField, setSortField] = React.useState('');
const [sortOrder, setSortOrder] = React.useState('');
const [displayedRowsCount, setDisplayedRowsCount] = React.useState(validRows.length);
console.log(filteredFlights);

const handleSort = async (sortField, sortOrder) => {
  const formattedRows = validRows.map(row => {
    const departureDate = new Date(row.departureDateTime.year, row.departureDateTime.month - 1, row.departureDateTime.day, row.departureDateTime.hour, row.departureDateTime.minute);
    const arrivalDate = new Date(row.arrivalDateTime.year, row.arrivalDateTime.month - 1, row.arrivalDateTime.day, row.arrivalDateTime.hour, row.arrivalDateTime.minute);
    const formattedRow = {
      ...row,
      departureDateTime: {
        year: departureDate.getUTCFullYear(),
        month: departureDate.getUTCMonth() + 1,
        day: departureDate.getUTCDate(),
        hour: departureDate.getUTCHours(),
        minute: departureDate.getUTCMinutes(),
      },
      arrivalDateTime: {
        year: arrivalDate.getUTCFullYear(),
        month: arrivalDate.getUTCMonth() + 1,
        day: arrivalDate.getUTCDate(),
        hour: arrivalDate.getUTCHours(),
        minute: arrivalDate.getUTCMinutes(),
      },
      legs: row.legs.map(leg => {
        const legDepartureDate = new Date(leg.departureDateTime.year, leg.departureDateTime.month - 1, leg.departureDateTime.day, leg.departureDateTime.hour, leg.departureDateTime.minute);
        const legArrivalDate = new Date(leg.arrivalDateTime.year, leg.arrivalDateTime.month - 1, leg.arrivalDateTime.day, leg.arrivalDateTime.hour, leg.arrivalDateTime.minute);
        return {
          ...leg,
          departureDateTime: {
            year: legDepartureDate.getUTCFullYear(),
            month: legDepartureDate.getUTCMonth() + 1,
            day: legDepartureDate.getUTCDate(),
            hour: legDepartureDate.getUTCHours(),
            minute: legDepartureDate.getUTCMinutes(),
          },
          arrivalDateTime: {
            year: legArrivalDate.getUTCFullYear(),
            month: legArrivalDate.getUTCMonth() + 1,
            day: legArrivalDate.getUTCDate(),
            hour: legArrivalDate.getUTCHours(),
            minute: legArrivalDate.getUTCMinutes(),
          },
        };
      }),
    };

    return formattedRow;
  });

  const sortedFlights = await sortFlights(formattedRows, sortField, sortOrder);
  console.log(sortedFlights);

  setFilteredFlights(sortedFlights.body);
  setSortOrder(sortOrder);
};
const clearSort = () => {
  setSortOrder('');
    setSortField('');
    setFilteredFlights(filteredFlights);
};

const filterFlight = async () => {
  try {
    const formattedRows = validRows.map(row => {
      const departureDate = new Date(row.departureDateTime.year, row.departureDateTime.month - 1, row.departureDateTime.day, row.departureDateTime.hour, row.departureDateTime.minute, row.departureDateTime.second);
      const arrivalDate = new Date(row.arrivalDateTime.year, row.arrivalDateTime.month - 1, row.arrivalDateTime.day, row.arrivalDateTime.hour, row.arrivalDateTime.minute, row.arrivalDateTime.second);
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
          const legDepartureDate = new Date(leg.departureDateTime.year, leg.departureDateTime.month - 1, leg.departureDateTime.day, leg.departureDateTime.hour, leg.departureDateTime.minute, leg.departureDateTime.second);
          const legArrivalDate = new Date(leg.arrivalDateTime.year, leg.arrivalDateTime.month - 1, leg.arrivalDateTime.day, leg.arrivalDateTime.hour, leg.arrivalDateTime.minute, leg.arrivalDateTime.second);
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

    const response = await filterFlights(formattedRows, price);
    console.log(response);
    const formattedResponse = response.body.map(row => {
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
    setDisplayedRowsCount(response.body.length);
  } catch (error) {
    toast.error("Failed to filter flights");
  }
};

const clearFilters = () => {
  setFilteredFlights(filteredFlights);
  setDisplayedRowsCount(filteredFlights.length);
  setPrice('');
  
};

    return (
      <Grid container spacing={3} alignItems="center" justifyContent="center" sx={{ fontFamily: 'Oswald, sans-serif' }}>
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
      
      <Box display={'flex'} justifyContent={'center'} alignItems={'center'} mt={2}>
        <Box mr={1}>
        <Fab variant="extended" color="primary" size="small" onClick={async () => {
  try {
    await filterFlight(price);
  } catch (error) {
    console.error(error);
  }
}}>
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
    data-testid="accordion-summary"
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
          {filteredFlights.slice(page * rowsPerPage, page * rowsPerPage + rowsPerPage).map((row, index) => (
    <Row key={index} row={row} token={token} userId={userId} />
))}
          </TableBody>
        </Table>
        <TablePagination
  component="div"
  count={displayedRowsCount}
  page={page}
  onPageChange={(event, newPage) => setPage(newPage)}
  rowsPerPage={rowsPerPage}
  onRowsPerPageChange={(event) => setRowsPerPage(parseInt(event.target.value, 10))}
  rowsPerPageOptions={[rowsPerPage]} 
/>
      </TableContainer>
      </Grid>
    </Grid>
    );
  }
