let express = require('express');
let app = express();
let cors = require('cors');
app.use(cors());

app.get('/hello/:name', (req, res) => {
    res.send(`Hello ${req.params.name}`);
});

app.post('/bye/:name', (req, res) => {
    let message = {
        data: `Bye ${req.params.name}`
    };
    res.send(JSON.stringify(message));
});

app.listen(3000, () => {
    console.log('Server running at port 3000');
});