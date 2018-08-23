Anleitung

TODO: Setup für node-App
  * Initialize
	  npm init -y
	* Webpack und Babel
	  npm install webpack-cli --save
		npm install webpack webpack-dev-server babel-cli babel-core babel-loader babel-polyfill babel-preset-env babel-preset-stage-0 html-webpack-plugin mini-css-extract-plugin css-loader style-loader --save-dev
  TODO: Welche Packages werden wirklich benötigt?
	* Test Framework Mocha
	  npm install mocha --save-dev
  * Parser 
	  npm install csv-parse --save
	

0. Repository auschecken

  git clone https://github.com/Pascal-M-Humbert/oc-expert-camp-aws-hackathon

A. java

B. nodejs

  B.1 AWS-SDK für nodejs installieren

		cd nodejs_app
		
		* https://aws.amazon.com/sdk-for-node-js/
		* Schritte "Install" und "Configure" ausführen
		* Schritt "Run" wird nicht benötigt
		
	B.2 Projekt initialisieren
	  
		npm init
	
  B.3 Test Framework Mocha
	
	  npm install --save-dev mocha
	
	B.4 CSV-Parser installieren
	
	  npm install csv-parse
		