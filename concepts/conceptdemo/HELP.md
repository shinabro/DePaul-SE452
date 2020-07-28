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
| **[VS Code](https://code.visualstudio.com) | Code Editor  

*needed for Windows only
**<i>Be sure to install it on WSL</I> if using WSL

### VSCode extensions
 <li>Java IDE Pack</li>
 <li>Lombok Annotation Support</li>
 <li>PostgreSQL Explorer</li>
 <li>MongoDB for VS Code</li>

### Docker commands
<li>docker run --name demo_postgres -p5432:5432 -e PGDATA=/var/lib/postgresql/data/pgdata -v /home/kyu/sandbox/postgres -e POSTGRES_PASSWORD=password -d postgres</li>
<li>docker exec -it demo_postgres sql -Upostgres<p>create database se452db;
<li>docker run --name demo_mongo -p27017:27017 -v /home/kyu/sandbox/mongo:/var/lib/postgresql/data -d mongo</li> 

 
