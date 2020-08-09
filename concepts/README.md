# Getting Started
Demo of concept specific points for [DePaul-SE 452](https://www.cdm.depaul.edu/academics/pages/classinfo.aspx?Term=20201&ClassNbr=12606&fid=273369), see package-info.java for details of each of the concepts.

## Tools

| Tool | Used for 
| ----------- | ----------- 
| *[WSL2](https://docs.microsoft.com/en-us/windows/wsl/install-win10) | To enable Linux toolset on Windows 
| *[Ubuntu](https://www.microsoft.com/en-us/p/ubuntu/9nblggh4msv6) | Linux environment to keep Windows and Mac with similar tools 
| *[Terminal](https://www.microsoft.com/en-us/p/windows-terminal/9n0dx20hk701) | Real Terminal for Windows 
| [SDKMan](https://sdkman.io/) | Simplifies switching between JDKs and SDKs | sdk install java 11.0.7-open 
| [Docker](https://www.docker.com/products/docker-desktop) | Containerization to ease database setup
| [VS Code](https://code.visualstudio.com) | Code Editor  

*needed for Windows only
**<i>Be sure to install it on WSL</I> if using WSL

### VSCode extensions
| Extension | Used for 
| ----------- | ----------- 
| [Remote Development](https://marketplace.visualstudio.com/items?itemName=ms-vscode-remote.vscode-remote-extensionpack) | To work with WSL
| [Java IDE Pack](https://marketplace.visualstudio.com/items?itemName=pverest.java-ide-pack) | To work with Java
| [Lombok Annotation Support](https://marketplace.visualstudio.com/items?itemName=GabrielBB.vscode-lombok) | Lombok support
| [PostgresSQL Explorer](https://marketplace.visualstudio.com/items?itemName=ckolkman.vscode-postgres) | Client for Postgres
| [MongoDB](https://marketplace.visualstudio.com/items?itemName=mongodb.mongodb-vscode) | Client for Mongo

### Docker commands
<li>start: docker-compose up -d
<li>stop: docker-compose down
<li><i>Need to create database first time</i> docker exec -it demo-postgres psql -Upostgres<p>create database se452db;

 
