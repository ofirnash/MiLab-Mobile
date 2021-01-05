const express = require('express');
const fs = require('fs');
const port = 3000; // Port to listen to

let app = express();
app.use(express.static('./files'));

// Serve files from custom url of format: https://server/files/fileName (Defined it like this - didn't know if there is a special requirement).
app.get('/server/files/:fileName', (req, res) => {
	let fileName = req.params.fileName;
	
	if (!fileName){
		// fileName passed is Null
		 return res.send("No fileName param passed!");
	}
	
	// Hardcoded path: server/files/...
	let filePath = "./files/" + fileName;
	
	// Check that file exists
	if (fs.existsSync(filePath)){
		// File exists - stream through res.
		const readStream = fs.createReadStream(filePath);
		readStream.pipe(res);
	}
	else {
		return res.send("File doesn't exist in the path!");
	}
});

app.listen(port, () => {
	console.log(`Listening at http://localhost:${port}`);
});
	
