CREATE TABLE Countries
(
    country_name CHAR(50) PRIMARY KEY
);

CREATE TABLE Provinces
(
    id            INT PRIMARY KEY,
    province_name CHAR(50),
    country_name  CHAR(50) NOT NULL,
    FOREIGN KEY (country_name)
        references Countries (country_name)
            ON DELETE CASCADE
);

CREATE TABLE Parks
(
    id           INT PRIMARY KEY,
    province_id  INT NOT NULL,
    park_name    CHAR(100),
    park_address CHAR(200),
    open_hour    CHAR(50),
    close_hour   CHAR(50),
    FOREIGN KEY (province_id)
        references Provinces (id)
            ON DELETE CASCADE
);

CREATE TABLE Public_parks
(
    id           INT PRIMARY KEY,
    camping_site NUMBER(1) DEFAULT 0,
    FOREIGN KEY (id)
        references Parks (id)
            ON DELETE CASCADE
);

CREATE TABLE Restricted_parks
(
    id             INT PRIMARY KEY,
    daily_capacity INT,
    permit_type    CHAR(10),
    FOREIGN KEY (id)
        references Parks (id)
            ON DELETE CASCADE
);

CREATE TABLE Seasons
(
    season_name CHAR(30) PRIMARY KEY
);

CREATE TABLE Visitor_centers
(
    id             INT PRIMARY KEY,
    park_id        INT NOT NULL UNIQUE,
    center_name    CHAR(200),
    email          CHAR(100),
    center_address CHAR(200),
    FOREIGN KEY (park_id)
        references Parks (id)
            ON DELETE CASCADE
);

CREATE TABLE Trail_level
(
    distance   FLOAT,
    difficulty CHAR(50),
    duration   float,
    PRIMARY KEY (distance, difficulty)
);

CREATE TABLE Trail_info
(
    trail_name        CHAR(200),
    park_id           INT,
    difficulty        CHAR(50),
    distance          FLOAT NOT NULL,
    trail_description CHAR(300),
    PRIMARY KEY (trail_name, park_id, difficulty),
    FOREIGN KEY (park_id)
        references Parks (id)
            ON DELETE CASCADE,
    FOREIGN KEY (distance, difficulty)
        references trail_level (distance, difficulty)
            ON DELETE CASCADE
);

CREATE TABLE Trail_Image
(
    trail_name CHAR(200),
    park_id    INT,
    difficulty CHAR(50),
    image_url   CHAR(200),
    PRIMARY KEY (trail_name, park_id, difficulty, image_url),
    FOREIGN KEY (trail_name, park_id, difficulty) REFERENCES Trail_info (trail_name, park_id, difficulty)
        ON DELETE CASCADE
);

CREATE TABLE Huts
(
    id         INT PRIMARY KEY,
    trail_name CHAR(200) NOT NULL,
    park_id    INT       NOT NULL,
    difficulty CHAR(50) NOT NULL,
    beds       INT,
    FOREIGN KEY (trail_name, park_id, difficulty)
        references trail_info (trail_name, park_id, difficulty)
            ON DELETE CASCADE,
    FOREIGN KEY (park_id)
        references Parks (id)
            ON DELETE CASCADE
);

CREATE TABLE Trail_season
(
    trail_name  CHAR(200),
    season_name CHAR(30),
    park_id     INT,
    difficulty  CHAR(50),
    PRIMARY KEY (trail_name, park_id, difficulty, season_name),
    FOREIGN KEY (trail_name, park_id, difficulty)
        references Trail_info (trail_name, park_id, difficulty)
            ON DELETE CASCADE,
    FOREIGN KEY (season_name)
        references seasons (season_name)
            ON DELETE CASCADE
);

CREATE TABLE Managers
(
    id           INT PRIMARY KEY,
    manager_name CHAR(100)
);

CREATE TABLE Program_info
(
    id                INT       PRIMARY KEY,
    visitor_center_id INT       NOT NULL,
    program_name      CHAR(200) NOT NULL,
    capacity          INT       DEFAULT 10,
    FOREIGN KEY (visitor_center_id) references Visitor_centers (id)
        ON DELETE CASCADE
);

CREATE TABLE Program_manager
(
    program_id INT,
    manager_id INT,
    PRIMARY KEY (program_id, manager_id),
    FOREIGN KEY (program_id)
        references Program_info (id)
            ON DELETE CASCADE,
    FOREIGN KEY (manager_id)
        references managers (id)
            ON DELETE CASCADE
);



INSERT ALL
    INTO Countries(Country_name)
VALUES ('CANADA')
INTO Countries(Country_name)
VALUES ('MEXICO')
INTO Countries(Country_name)
VALUES ('KOREA')
INTO Countries(Country_name)
VALUES ('US')
INTO Countries(Country_name)
VALUES ('FRANCE')
SELECT *
FROM dual;

INSERT ALL
    INTO Provinces(id, Provinc_Name, Country_name)
VALUES (11, 'BC', 'CANADA')
INTO Provinces(id, Provinc_Name, Country_name)
VALUES (21, 'CA', 'US')
INTO Provinces(id, Provinc_Name, Country_name)
VALUES (12, 'AB', 'CANADA')
INTO Provinces(id, Provinc_Name, Country_name)
VALUES (13, 'ON', 'CANADA')
INTO Provinces(id, Provinc_Name, Country_name)
VALUES (14, 'QC','CANADA')
SELECT *
FROM dual;

INSERT ALL
    INTO Parks(id, province_id, park_name, park_address, open_hour, close_hour)
VALUES (101, 11, 'Strathcona Provincial Park', '857 Malkin Ave, Vancouver, BC V6A 2K5', '09', '17')
INTO Parks(id, province_id, park_name, park_address, open_hour, close_hour)
VALUES (102, 11, 'Cypress Provincial Park', 'West Vancouver, BC V0N 1G0', '09', '17')
INTO Parks(id, province_id, park_name, park_address, open_hour, close_hour)
VALUES (103, 11, 'Simson Provincial Park', 'Halfmoon Bay, BC V0N 1Y0', '08', '16')
INTO Parks(id, province_id, park_name, park_address, open_hour, close_hour)
VALUES (201, 21, 'Death Valley National Park', 'CA 190 from Death Valley Junction, CA', '08', '17')
INTO Parks(id, province_id, park_name, park_address, open_hour, close_hour)
VALUES (202, 21, 'Channel Islands National Park', 'Ventura, CA 93001, United States', '08', '17')
INTO Parks(id, province_id, park_name, park_address, open_hour, close_hour)
VALUES (104, 11, 'Beaver Creek Provincial Park', '8801 BC-22A, Trail, BC V1R 4W6', '07', '17')
INTO Parks(id, province_id, park_name, park_address, open_hour, close_hour)
VALUES (105, 11, 'Cedar Point Provincial Park', 'Cariboo F, BC V0L 1N0', '08', '16')
INTO Parks(id, province_id, park_name, park_address, open_hour, close_hour)
VALUES (106, 11, 'Ferry Island Provincial Park', 'Fraser Valley, BC V0X 1X0', '07', '18')
INTO Parks(id, province_id, park_name, park_address, open_hour, close_hour)
VALUES (203, 21, 'Caspar Headlands State Natural Reserve', '14260 Headlands Dr, Mendocino, CA 95460, United States',
        '10', '17')
INTO Parks(id, province_id, park_name, park_address, open_hour, close_hour)
VALUES (107, 11, 'Gibson River Provincial Park', 'S Gibson Lake Rd, Severn, ON L0K 1S0', '06', '16')
SELECT *
FROM dual;

INSERT ALL
INTO Public_Parks(id, camping_site)
VALUES (101, 1)
INTO Public_Parks(id, camping_site)
VALUES (102, 1)
INTO Public_Parks(id, camping_site)
VALUES (103, 1)
INTO Public_Parks(id, camping_site)
VALUES (201, 0)
INTO Public_Parks(id, camping_site) VALUES (202, 0)
INTO Public_Parks(id, camping_site) VALUES (203, 1)
SELECT *
FROM dual;


INSERT ALL
    INTO Restricted_Parks(id, daily_capacity, permit_type)
VALUES (104, 80, 'A')
INTO Restricted_Parks(id, daily_capacity, permit_type)
VALUES (105, 120, 'A')
INTO Restricted_Parks(id, daily_capacity, permit_type)
VALUES (106, 60, 'B')
INTO Restricted_Parks(id, daily_capacity, permit_type)
VALUES (203, 80, 'B')
INTO Restricted_Parks(id, daily_capacity, permit_type)
VALUES (107, 100, 'A')
SELECT *
FROM dual;


INSERT ALL
    INTO Seasons(season_name)
VALUES ('SPRING')
INTO Seasons(season_name)
VALUES ('SUMMER')
INTO Seasons(season_name)
VALUES ('FALL')
INTO Seasons(season_name)
VALUES ('WINTER')
INTO Seasons(season_name)
VALUES ('ALL')
SELECT *
FROM dual;

INSERT ALL
    INTO Visitor_centers(id, park_id, center_name, email, center_address)
VALUES (1001, 101, 'Strathcona Wilderness Institute', 'strathconawilderness@gmail.com', 'Courtenay, British Columbia
V9N 5N5')
INTO Visitor_centers(id, park_id, center_name, email, center_address)
VALUES (1002, 102, 'Cypress Provincial Park visitor center', 'contact@cypressmountain.com',
        'West Vancouver, BC V0N 1G0')
INTO Visitor_centers(id, park_id, center_name, email, center_address)
VALUES (1004, 104, 'Beaver Creek Institute', 'beavercreekp@gmail.com', '8801 BC-22A, Trail, BC V1R 4W6 CANADA')
INTO Visitor_centers(id, park_id, center_name, email, center_address)
VALUES (2001, 201, 'Death Valley National Park Visitor Center', 'deathvalleyvs@gmail.com',
        'P.O. Box 579 Death Valley CA 92328 US')
INTO Visitor_centers(id, park_id, center_name, email, center_address)
VALUES (2003, 203, 'Caspar Headlands State Natural Reserve Visitor Center', 'casparheadlandsmanage@gmail.com',
        '14261 Headlands Dr Mendocino, CA 95460 US')
SELECT *
FROM dual;

INSERT ALL
    INTO Trail_level(distance, difficulty, duration)
VALUES (5.6, 'A', '4')
INTO Trail_level(distance, difficulty, duration)
VALUES (6.0, 'C', '7')
INTO Trail_level(distance, difficulty, duration)
VALUES (4.8, 'A', '3')
INTO Trail_level(distance, difficulty, duration)
VALUES (2.9, 'A', '2')
INTO Trail_level(distance, difficulty, duration)
VALUES (5.1, 'B', '6')
SELECT *
FROM dual;

INSERT ALL
    INTO Trail_info(trail_name, park_id, difficulty, distance, trail_description)
VALUES ('Dog Mountain Trail', 101, 'A', 5.6,
        'Discover this 5.6-km out-and-back trail near North Vancouver, British Columbia. Generally considered a moderately challenging route')
INTO Trail_info(trail_name, park_id, difficulty, distance, trail_description)
VALUES ('Stawamus Chief Trail', 101, 'C', 6.0,
        'Experience this 6.0-km loop trail near Squamish, British Columbia. Generally considered a challenging route, it takes an average of 3 h 20 min to complete.')
INTO Trail_info(trail_name, park_id, difficulty, distance, trail_description)
VALUES ('Wapta Falls Trail', 102, 'A', 4.8,
        'Try this 4.8-km out-and-back trail near Field, British Columbia. Generally considered an easy route, it takes an average of 1 h 17 min to complete.')
INTO Trail_info(trail_name, park_id, difficulty, distance, trail_description)
VALUES ('Lighthouse Loop', 201, 'A', 2.9,
        'Generally considered an easy route, it takes an average of 44 min to complete.')
INTO Trail_info(trail_name, park_id, difficulty, distance, trail_description)
VALUES ('Emerald Lake Loop', 103, 'B', 5.1,
        'Generally considered an easy route, it takes an average of 1 h 20 min to complete.')
SELECT *
FROM dual;

INSERT ALL
    INTO Huts(id, trail_name, park_id, difficulty, beds)
VALUES (1, 'Dog Mountain Trail', 101, 'A', 2)
INTO Huts(id, trail_name, park_id, difficulty, beds)
VALUES (2, 'Stawamus Chief Trail', 101, 'C', 2)
INTO Huts(id, trail_name, park_id, difficulty, beds)
VALUES (3, 'Wapta Falls Trail', 102, 'A', 1)
INTO Huts(id, trail_name, park_id, difficulty, beds)
VALUES (4, 'Lighthouse Loop', 201, 'A', 2)
INTO Huts(id, trail_name, park_id, difficulty, beds)
VALUES (5, 'Emerald Lake Loop', 103, 'B', 5)
SELECT *
FROM dual;

INSERT ALL
    INTO Trail_Season(trail_name, season_name, park_id, difficulty)
VALUES ('Dog Mountain Trail', 'ALL', 101, 'A')
INTO Trail_Season(trail_name, season_name, park_id, difficulty)
VALUES ('Stawamus Chief Trail', 'SUMMER', 101, 'C')
INTO Trail_Season(trail_name, season_name, park_id, difficulty)
VALUES ('Wapta Falls Trail', 'FALL', 102, 'A')
INTO Trail_Season(trail_name, season_name, park_id, difficulty)
VALUES ('Lighthouse Loop', 'SPRING', 201, 'A')
INTO Trail_Season(trail_name, season_name, park_id, difficulty)
VALUES ('Emerald Lake Loop', 'SUMMER', 103, 'B')
SELECT *
FROM dual;

INSERT ALL
    INTO Managers(id, manager_name)
VALUES (1, 'Jenny')
INTO Managers(id, manager_name)
VALUES (2, 'Olivia')
INTO Managers(id, manager_name)
VALUES (3, 'Emma')
INTO Managers(id, manager_name)
VALUES (4, 'Jean')
INTO Managers(id, manager_name)
VALUES (5, 'Jhon')
SELECT *
FROM dual;

INSERT ALL
    INTO Program_info(id, visitor_center_id, program_name)
VALUES (1, 1001, 'Places of Wonder and Discovery')
INTO Program_info(id, visitor_center_id, program_name)
VALUES (2, 1002, 'Kicking Horse')
INTO Program_info(id, visitor_center_id, program_name)
VALUES (3, 1004, 'Coastal Carnivores')
INTO Program_info(id, visitor_center_id, program_name)
VALUES (4, 2001, 'Habitat Conservation')
INTO Program_info(id, visitor_center_id, program_name)
VALUES (5, 2003, 'Junior Ranger Angler')
SELECT *
FROM dual;

INSERT ALL
    INTO Program_Manager(program_id, manager_id)
VALUES (1, 1)
INTO Program_Manager(program_id, manager_id)
VALUES (2, 2)
INTO Program_Manager(program_id, manager_id)
VALUES (3, 3)
INTO Program_Manager(program_id, manager_id)
VALUES (4, 4)
INTO Program_Manager(program_id, manager_id)
VALUES (5, 5)
SELECT *
FROM dual;