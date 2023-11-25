const express = require('express');
const app = express();
const port = 3000;
const getRandomDate = require('./random_date');

app.get('/interview/:employee_name', (req, res) => {
  const employeeName = req.params.employee_name;

  const startDate = new Date();
  const endDate = new Date('2023-12-31');
  const randomDate = getRandomDate(startDate, endDate);

  res.send(`Interviewing employee ${employeeName} on ${randomDate}`);
});

app.get('/', (req, res) => {
  res.send('Hello, Express!');
});

app.listen(port, () => {
  console.log(`Server is running at http://localhost:${port}`);
});
