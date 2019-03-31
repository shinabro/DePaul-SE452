create table github_project (
    id identity not null primary key,
    org_name varchar(50) not null,
    repo_name varchar(50) not null unique,
);

create index idx_repo_name
    on github_project(repo_name);