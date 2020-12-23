const express = require('express');
const bodyParser = require('body-parser');
const fs = require('fs');
const port = 3000; // Port to listen to

let app = express();

app.use(bodyParser.json());

// See all tasks
app.get('/tasks', (req, res) => {
	let dataFromJSON = JSON.parse(fs.readFileSync('data-tasks.json', 'utf8'));
	
	// Send data to user
	res.send(dataFromJSON);
});

// Add a new tasks
app.get('/tasks/new', (req, res) => {
	let taskId = parseInt(req.query.id);
	let task = req.query.task;
	
	let dataFromJSON = JSON.parse(fs.readFileSync('data-tasks.json', 'utf8'));
	
	// Add the task
	dataFromJSON.tasks.push({'id': taskId, 'content': task});
	fs.writeFileSync('data-tasks.json', JSON.stringify(dataFromJSON), 'utf8');
	
	// Send data to user
	res.send(dataFromJSON);
});

// Delete added tasks
app.get('/tasks/remove', (req, res) => {
	let taskId = parseInt(req.query.id);

	let dataFromJSON = JSON.parse(fs.readFileSync('data-tasks.json', 'utf8'));

	// Find task by ID
	let index = dataFromJSON.tasks.findIndex(x => x.id == taskId);
	
	// If found (returned value is different than -1) -> remove and update file.
	if (index != -1) {
		dataFromJSON.tasks.splice(index, 1);
		fs.writeFileSync('data-tasks.json', JSON.stringify(dataFromJSON), 'utf8');
	}
	
	// Send data to user
	res.send(dataFromJSON);
});

app.listen(port, () => {
	console.log(`Listening at http://localhost:${port}`);
});
	
	
