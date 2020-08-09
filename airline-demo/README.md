# Read Me First
The following is intended to be used with DePaul CDM's SE452 - Object Oriented Enterprise Computing (https://www.cdm.depaul.edu/academics/pages/courseinfo.aspx?crseId=006591)

### Setup details
For those using Windows, recommendation is to use WSL 

#WSL installation details
* [WSL](https://docs.microsoft.com/en-us/windows/wsl/install-win10)
Using WSL to enable Linux to keep similar commands as those using Apple machines.

#Development OS - Linux/Ubuntu
* [Ubuntu from Windows Store](https://www.microsoft.com/en-us/p/ubuntu/9nblggh4msv6)
Using Linux since commands as similar for those using Apple machines.

#Java Long Term Support (LTS)
* [JDK 11](https://openjdk.java.net/)
Using JDK 11 since it is long term support and as such would not change as frequently for each quarter

#Build
* [Gradle](https://gradle.org/)
Base for Spring Boot

#Editor - While not the best Java development experience, this seems to have best integration with WSL.
* [VSCode](https://code.visualstudio.com/)
* [WSL2] (https://marketplace.visualstudio.com/items?itemName=ms-vscode-remote.remote-wsl)
* [JavaIDEPack] (https://marketplace.visualstudio.com/items?itemName=pverest.java-ide-pack)
* [SQLextension] (https://marketplace.visualstudio.com/items?itemName=mtxr.sqltools)
* [Lombok] (https://marketplace.visualstudio.com/items?itemName=GabrielBB.vscode-lombok)
Be sure to install it on WSL and not local

#Postsgres
* [Postgres](https://www.postgresql.org/)
* [Helpful] (https://itsfoss.com/install-postgresql-ubuntu/)

* installation instructions
https://www.postgresql.org/download/linux/ubuntu/

* check status
service postgresql status
* start database
sudo service postgresql start
* stop database
sudo service postgresql stop

* create the database using
create database [dbname]
\c [dbname]


