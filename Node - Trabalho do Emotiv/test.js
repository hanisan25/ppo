var five = require("johnny-five");
var board = new five.Board();

var javaPort = 8080;
var javaServer = require('net').createServer();
var WebSocketServer = require('ws').Server
 , wss = new WebSocketServer({port: 90});

var fileData ;

	 console.log('=====================================================');
	 console.log('Node.js/Java Communication Module');
	 console.log('=====================================================');

 	board.on("ready", function() {
  		
  		var led = new five.Led(13);
  		
	

		javaServer.on('listening', function () {
			console.log('Server is listening on ' + javaPort);
		});

		javaServer.on('error', function (e) {
			console.log('Server error: ' + e.code);
		});

		javaServer.on('close', function () {
			console.log('Server closed');
		});

	  	javaServer.on('connection', function (javaSocket) {
		    var clientAddress = javaSocket.address().address + ':' + javaSocket.address().port;
		    // console.log('Java ' + clientAddress + ' connected');
		    console.log("Led on!");
		    led.on();

		    var firstDataListenner = function (data) {
		        fileData = data;
		    	// console.log('Received data: ' + data);
			}

			javaSocket.on('data', firstDataListenner);

		 	javaSocket.on('close', function() {
		        // console.log('Java ' + clientAddress + ' disconnected');
		 		// console.log("Light off.")
		 		led.off();
		 	});
		});

		this.wait(1000, function() {
   					led.stop().off();
  				});
	javaServer.listen(javaPort);
});