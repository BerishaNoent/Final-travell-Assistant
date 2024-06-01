const express = require('express');
const cors = require('cors');
const path = require('path'); // Add this line
const app = express();

app.use(cors()); // Enable All CORS Requests

// your existing routes...
app.use(express.static(path.join(__dirname, 'public')));

app.listen(3001, () => console.log('Server running on port 3001'));