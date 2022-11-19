create TABLE Countries
(
    country_name VARCHAR2(50) PRIMARY KEY
);

create TABLE Provinces
(
    id            INT PRIMARY KEY,
    province_name VARCHAR2(50) NOT NULL,
    country_name  VARCHAR2(50) NOT NULL,
    FOREIGN KEY (country_name)
        references Countries (country_name)
            ON delete CASCADE
);

create TABLE Parks
(
    id           INT PRIMARY KEY,
    province_id  INT NOT NULL,
    park_name    VARCHAR2(100) NOT NULL,
    park_address VARCHAR2(200),
    open_hour    VARCHAR2(50),
    close_hour   VARCHAR2(50),
    FOREIGN KEY (province_id)
        references Provinces (id)
            ON delete CASCADE
);

create TABLE Public_parks
(
    id           INT PRIMARY KEY,
    camping_site NUMBER(1) DEFAULT 0,
    FOREIGN KEY (id)
        references Parks (id)
            ON delete CASCADE
);

create TABLE Restricted_parks
(
    id             INT PRIMARY KEY,
    daily_capacity INT,
    permit_type    VARCHAR2(10),
    FOREIGN KEY (id)
        references Parks (id)
            ON delete CASCADE
);

create TABLE Seasons
(
    season_name VARCHAR2(30) PRIMARY KEY
);

create TABLE Visitor_centers
(
    id             INT PRIMARY KEY,
    park_id        INT NOT NULL UNIQUE,
    center_name    VARCHAR2(200),
    email          VARCHAR2(100),
    center_address VARCHAR2(200),
    FOREIGN KEY (park_id)
        references Parks (id)
            ON delete CASCADE
);

create TABLE Trail_level
(
    distance   FLOAT,
    difficulty VARCHAR2(50),
    duration   float,
    PRIMARY KEY (distance, difficulty)
);

create TABLE Trail_info
(
    trail_name        VARCHAR2(200),
    park_id           INT,
    difficulty        VARCHAR2(50),
    distance          FLOAT NOT NULL,
    trail_description VARCHAR2(300),
    PRIMARY KEY (trail_name, park_id, difficulty),
    FOREIGN KEY (park_id)
        references Parks (id)
            ON delete CASCADE,
    FOREIGN KEY (distance, difficulty)
        references trail_level (distance, difficulty)
            ON delete CASCADE
);

create TABLE Trail_Image
(
    trail_name VARCHAR2(200),
    park_id    INT,
    difficulty VARCHAR2(50),
    image_url   VARCHAR2(200),
    PRIMARY KEY (trail_name, park_id, difficulty, image_url),
    FOREIGN KEY (trail_name, park_id, difficulty) REFERENCES Trail_info (trail_name, park_id, difficulty)
        ON delete CASCADE
);

create TABLE Huts
(
    id         INT PRIMARY KEY,
    trail_name VARCHAR2(200) NOT NULL,
    park_id    INT       NOT NULL,
    difficulty VARCHAR2(50) NOT NULL,
    beds       INT,
    FOREIGN KEY (trail_name, park_id, difficulty)
        references trail_info (trail_name, park_id, difficulty)
            ON delete CASCADE,
    FOREIGN KEY (park_id)
        references Parks (id)
            ON delete CASCADE
);

create TABLE Trail_season
(
    trail_name  VARCHAR2(200),
    season_name VARCHAR2(30),
    park_id     INT,
    difficulty  VARCHAR2(50),
    PRIMARY KEY (trail_name, park_id, difficulty, season_name),
    FOREIGN KEY (trail_name, park_id, difficulty)
        references Trail_info (trail_name, park_id, difficulty)
            ON delete CASCADE,
    FOREIGN KEY (season_name)
        references seasons (season_name)
            ON delete CASCADE
);

create TABLE Managers
(
    id           INT PRIMARY KEY,
    manager_name VARCHAR2(100)
);

create TABLE Program_info
(
    id                INT       PRIMARY KEY,
    visitor_center_id INT       NOT NULL,
    program_name      VARCHAR2(200) NOT NULL,
    capacity          INT       DEFAULT 10,
    description       VARCHAR2(4000),
    program_image     VARCHAR2(1000),
    FOREIGN KEY (visitor_center_id) references Visitor_centers (id)
        ON delete CASCADE
);

create TABLE Program_manager
(
    program_id INT,
    manager_id INT,
    PRIMARY KEY (program_id, manager_id),
    FOREIGN KEY (program_id)
        references Program_info (id)
            ON delete CASCADE,
    FOREIGN KEY (manager_id)
        references managers (id)
            ON delete CASCADE
);

create table program_reservation (
    id INT PRIMARY KEY,
    reservation_number varchar2(100) NOT NULL UNIQUE,
    program_id Number NOT NULL,
    email varchar2(100) NOT NULL,
    ppl INTEGER DEFAULT 1,
    FOREIGN KEY (program_id) REFERENCES program_info (id) ON DELETE CASCADE
);

CREATE SEQUENCE program_reservation_seq;

CREATE OR REPLACE TRIGGER program_reservation_TRG
    BEFORE INSERT ON program_reservation
    FOR EACH ROW
BEGIN
    SELECT program_reservation_seq.NEXTVAL
    INTO   :new.id
    FROM   dual;
END;

insert all
    into Countries(Country_name)
values ('CANADA')
into Countries(Country_name)
values ('MEXICO')
into Countries(Country_name)
values ('KOREA')
into Countries(Country_name)
values ('US')
into Countries(Country_name)
values ('FRANCE')
select *
from dual;

insert all
    into Provinces(id, Province_Name, Country_name)
values (11, 'BC', 'CANADA')
into Provinces(id, Province_Name, Country_name)
values (21, 'CA', 'US')
into Provinces(id, Province_Name, Country_name)
values (12, 'AB', 'CANADA')
into Provinces(id, Province_Name, Country_name)
values (13, 'ON', 'CANADA')
into Provinces(id, Province_Name, Country_name)
values (14, 'QC','CANADA')
select *
from dual;

insert all
    into Parks(id, province_id, park_name, park_address, open_hour, close_hour)
values (101, 11, 'Strathcona Provincial Park', '857 Malkin Ave, Vancouver, BC V6A 2K5', '09', '17')
into Parks(id, province_id, park_name, park_address, open_hour, close_hour)
values (102, 11, 'Cypress Provincial Park', 'West Vancouver, BC V0N 1G0', '09', '17')
into Parks(id, province_id, park_name, park_address, open_hour, close_hour)
values (103, 11, 'Simson Provincial Park', 'Halfmoon Bay, BC V0N 1Y0', '08', '16')
into Parks(id, province_id, park_name, park_address, open_hour, close_hour)
values (201, 21, 'Death Valley National Park', 'CA 190 from Death Valley Junction, CA', '08', '17')
into Parks(id, province_id, park_name, park_address, open_hour, close_hour)
values (202, 21, 'Channel Islands National Park', 'Ventura, CA 93001, United States', '08', '17')
into Parks(id, province_id, park_name, park_address, open_hour, close_hour)
values (104, 11, 'Beaver Creek Provincial Park', '8801 BC-22A, Trail, BC V1R 4W6', '07', '17')
into Parks(id, province_id, park_name, park_address, open_hour, close_hour)
values (105, 11, 'Cedar Point Provincial Park', 'Cariboo F, BC V0L 1N0', '08', '16')
into Parks(id, province_id, park_name, park_address, open_hour, close_hour)
values (106, 11, 'Ferry Island Provincial Park', 'Fraser Valley, BC V0X 1X0', '07', '18')
into Parks(id, province_id, park_name, park_address, open_hour, close_hour)
values (203, 21, 'Caspar Headlands State Natural Reserve', '14260 Headlands Dr, Mendocino, CA 95460, United States',
        '10', '17')
into Parks(id, province_id, park_name, park_address, open_hour, close_hour)
values (107, 11, 'Gibson River Provincial Park', 'S Gibson Lake Rd, Severn, ON L0K 1S0', '06', '16')
select *
from dual;

insert all
into Public_Parks(id, camping_site)
values (101, 1)
into Public_Parks(id, camping_site)
values (102, 1)
into Public_Parks(id, camping_site)
values (103, 1)
into Public_Parks(id, camping_site)
values (201, 0)
into Public_Parks(id, camping_site) values (202, 0)
into Public_Parks(id, camping_site) values (203, 1)
select *
from dual;


insert all
    into Restricted_Parks(id, daily_capacity, permit_type)
values (104, 80, 'A')
into Restricted_Parks(id, daily_capacity, permit_type)
values (105, 120, 'A')
into Restricted_Parks(id, daily_capacity, permit_type)
values (106, 60, 'B')
into Restricted_Parks(id, daily_capacity, permit_type)
values (203, 80, 'B')
into Restricted_Parks(id, daily_capacity, permit_type)
values (107, 100, 'A')
select *
from dual;


insert all
    into Seasons(season_name)
values ('SPRING')
into Seasons(season_name)
values ('SUMMER')
into Seasons(season_name)
values ('FALL')
into Seasons(season_name)
values ('WINTER')
into Seasons(season_name)
values ('ALL')
select *
from dual;

insert all
    into Visitor_centers(id, park_id, center_name, email, center_address)
values (1001, 101, 'Strathcona Wilderness Institute', 'strathconawilderness@gmail.com', 'Courtenay, British Columbia
V9N 5N5')
into Visitor_centers(id, park_id, center_name, email, center_address)
values (1002, 102, 'Cypress Provincial Park visitor center', 'contact@cypressmountain.com',
        'West Vancouver, BC V0N 1G0')
into Visitor_centers(id, park_id, center_name, email, center_address)
values (1004, 104, 'Beaver Creek Institute', 'beavercreekp@gmail.com', '8801 BC-22A, Trail, BC V1R 4W6 CANADA')
into Visitor_centers(id, park_id, center_name, email, center_address)
values (2001, 201, 'Death Valley National Park Visitor Center', 'deathvalleyvs@gmail.com',
        'P.O. Box 579 Death Valley CA 92328 US')
into Visitor_centers(id, park_id, center_name, email, center_address)
values (2003, 203, 'Caspar Headlands State Natural Reserve Visitor Center', 'casparheadlandsmanage@gmail.com',
        '14261 Headlands Dr Mendocino, CA 95460 US')
select *
from dual;

insert all
    into Trail_level(distance, difficulty, duration)
values (5.6, 'A', '4')
into Trail_level(distance, difficulty, duration)
values (6.0, 'C', '7')
into Trail_level(distance, difficulty, duration)
values (4.8, 'A', '3')
into Trail_level(distance, difficulty, duration)
values (2.9, 'A', '2')
into Trail_level(distance, difficulty, duration)
values (5.1, 'B', '6')
select *
from dual;

insert all
    into Trail_info(trail_name, park_id, difficulty, distance, trail_description)
values ('Dog Mountain Trail', 101, 'A', 5.6,
        'Discover this 5.6-km out-and-back trail near North Vancouver, British Columbia. Generally considered a moderately challenging route')
into Trail_info(trail_name, park_id, difficulty, distance, trail_description)
values ('Stawamus Chief Trail', 101, 'C', 6.0,
        'Experience this 6.0-km loop trail near Squamish, British Columbia. Generally considered a challenging route, it takes an average of 3 h 20 min to complete.')
into Trail_info(trail_name, park_id, difficulty, distance, trail_description)
values ('Wapta Falls Trail', 102, 'A', 4.8,
        'Try this 4.8-km out-and-back trail near Field, British Columbia. Generally considered an easy route, it takes an average of 1 h 17 min to complete.')
into Trail_info(trail_name, park_id, difficulty, distance, trail_description)
values ('Lighthouse Loop', 201, 'A', 2.9,
        'Generally considered an easy route, it takes an average of 44 min to complete.')
into Trail_info(trail_name, park_id, difficulty, distance, trail_description)
values ('Emerald Lake Loop', 103, 'B', 5.1,
        'Generally considered an easy route, it takes an average of 1 h 20 min to complete.')
select *
from dual;

insert all
    into Huts(id, trail_name, park_id, difficulty, beds)
values (1, 'Dog Mountain Trail', 101, 'A', 2)
into Huts(id, trail_name, park_id, difficulty, beds)
values (2, 'Stawamus Chief Trail', 101, 'C', 2)
into Huts(id, trail_name, park_id, difficulty, beds)
values (3, 'Wapta Falls Trail', 102, 'A', 1)
into Huts(id, trail_name, park_id, difficulty, beds)
values (4, 'Lighthouse Loop', 201, 'A', 2)
into Huts(id, trail_name, park_id, difficulty, beds)
values (5, 'Emerald Lake Loop', 103, 'B', 5)
select *
from dual;

insert all
    into Trail_Season(trail_name, season_name, park_id, difficulty)
values ('Dog Mountain Trail', 'ALL', 101, 'A')
into Trail_Season(trail_name, season_name, park_id, difficulty)
values ('Stawamus Chief Trail', 'SUMMER', 101, 'C')
into Trail_Season(trail_name, season_name, park_id, difficulty)
values ('Wapta Falls Trail', 'FALL', 102, 'A')
into Trail_Season(trail_name, season_name, park_id, difficulty)
values ('Lighthouse Loop', 'SPRING', 201, 'A')
into Trail_Season(trail_name, season_name, park_id, difficulty)
values ('Emerald Lake Loop', 'SUMMER', 103, 'B')
select *
from dual;

insert all
    into Managers(id, manager_name)
values (1, 'Jenny')
into Managers(id, manager_name)
values (2, 'Olivia')
into Managers(id, manager_name)
values (3, 'Emma')
into Managers(id, manager_name)
values (4, 'Jean')
into Managers(id, manager_name)
values (5, 'Jhon')
select *
from dual;

insert all
    into Program_info(id, visitor_center_id, program_name)
values (1, 1001, 'Places of Wonder and Discovery')
into Program_info(id, visitor_center_id, program_name)
values (2, 1002, 'Kicking Horse')
into Program_info(id, visitor_center_id, program_name)
values (3, 1004, 'Coastal Carnivores')
into Program_info(id, visitor_center_id, program_name)
values (4, 2001, 'Habitat Conservation')
into Program_info(id, visitor_center_id, program_name)
values (5, 2003, 'Junior Ranger Angler')
select *
from dual;

insert all
    into Program_Manager(program_id, manager_id)
values (1, 1)
into Program_Manager(program_id, manager_id)
values (2, 2)
into Program_Manager(program_id, manager_id)
values (3, 3)
into Program_Manager(program_id, manager_id)
values (4, 4)
into Program_Manager(program_id, manager_id)
values (5, 5)
select *
from dual;