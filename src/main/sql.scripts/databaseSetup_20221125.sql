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

create TABLE Public_park
(
    id           INT PRIMARY KEY,
    camping_site NUMBER(1) DEFAULT 0,
    FOREIGN KEY (id)
        references Parks (id)
            ON delete CASCADE
);

create TABLE Restricted_park
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
    image_url   VARCHAR2(1500),
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
                                     id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                                     reservation_number varchar2(100) NOT NULL UNIQUE,
                                     program_id Number NOT NULL,
                                     email varchar2(100) NOT NULL,
                                     ppl INTEGER DEFAULT 1,
                                     FOREIGN KEY (program_id) REFERENCES program_info (id) ON DELETE CASCADE
);

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
    into Public_park(id, camping_site)
values (101, 1)
into Public_park(id, camping_site)
values (102, 1)
into Public_park(id, camping_site)
values (103, 1)
into Public_park(id, camping_site)
values (201, 0)
into Public_park(id, camping_site) values (202, 0)
into Public_park(id, camping_site) values (203, 1)
select *
from dual;


insert all
    into Restricted_park(id, daily_capacity, permit_type)
values (104, 80, 'A')
into Restricted_park(id, daily_capacity, permit_type)
values (105, 120, 'A')
into Restricted_park(id, daily_capacity, permit_type)
values (106, 60, 'B')
into Restricted_park(id, daily_capacity, permit_type)
values (203, 80, 'B')
into Restricted_park(id, daily_capacity, permit_type)
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
into Managers(id, manager_name)
values (6, 'William')
into Managers(id, manager_name)
values (7, 'Josh')
into Managers(id, manager_name)
values (8, 'Atom')
into Managers(id, manager_name)
values (9, 'Sophia')
select *
from dual;

insert all
    into Program_info(id, visitor_center_id, program_name, description, program_image)
values (1, 1001, 'Wildlife', 'National parks offer unparalleled opportunities to watch wildlife. Birds, otters, and bison are fascinating, and watching wildlife is both exciting and relaxing at the same time.', 'https://www.nps.gov/articles/000/images/wildlife-moose-DENA-NPS-Photo-Kent-Miller.jpg')
into Program_info(id, visitor_center_id, program_name, description, program_image)
values (2, 1002, 'Horseback Riding', 'Miles of wooded hills, and there essentially are two ways to explore them: on foot or by horse. For families who prefer the latter choice, saddle up and follow rangers on 2.5-hour guided horseback tours from Skyland Stables in the center of the park', 'https://travel.home.sndimg.com/content/dam/images/travel/fullrights/2016/05/9/0/iStock_AppalachianViews_Shenandoah-National-Park.jpg.rend.hgtvcom.966.644.suffix/1491593672963.jpeg')
into Program_info(id, visitor_center_id, program_name, description, program_image)
values (3, 1004, 'Pollinators', 'More than 75 percent of the Earth flowering plants depend on bees, butterflies, birds, bats, and other pollinators. In fact, they are responsible for 1 out of 3 bites we take each day!', 'https://www.nps.gov/articles/000/images/monarch-on-yellow-flower-NPS-Daniel-Peterson_1.jpg')
into Program_info(id, visitor_center_id, program_name, description, program_image)
values (4, 2001, 'Dinosaur Bones', 'Pretty much every child goes through a dinosaur phase. Some never grow out of it! Why? Because they’re awesome! Fossils, such as dinosaur bones, are evidence of ancient life. They are irreplaceable pieces of America’s geologic heritage and tell the stories of America long before the United States existed.', 'https://www.nps.gov/articles/000/images/DINO-quarry-exhibit-hall-NPS.jpg')
into Program_info(id, visitor_center_id, program_name, description, program_image)
values (5, 2003, 'Junior Ranger Angler', 'Enjoy spending time outdoors in national parks with your kids. A park ranger describes his experience exploring national parks with his own young children and offers advice to help you get started.', 'https://www.nps.gov/common/uploads/grid_builder/kids/crop16_9/2390AA8E-F544-A3A3-7982967D4A9B0CDF.jpg')
into Program_info(id, visitor_center_id, program_name, description, program_image)
values (6, 1002, 'Stargazing', 'Ever wondered what makes the Northern Lights so colorful and spectacular? Get a crash-course in astrophysics this summer During 2- and 3-night programs titled Curtains of Light, Neal Brown, space expert and acting director of the Alaska Space Grant Program, will explain the magnetic forces', 'https://travel.home.sndimg.com/content/dam/images/travel/fullrights/2016/05/9/0/iStock_andyKRAKOVSKI_Denali-National-Park-Northern-Lights.jpg.rend.hgtvcom.966.644.suffix/1491593672948.jpeg')
into Program_info(id, visitor_center_id, program_name, description, program_image)
values (7, 1002, 'Beetlemania" Lectures', 'Media outlets from all over the world have documented the alarming rate at which the mountain pine beetle has ravaged a majority of pine forests, but as part of this free family-friendly lecture series, rangers explain the situation in a way kids can understand. At least one interpreter dresses up in a full-body beetle costume; others lead the crowd in a sing-along to tunes from the Beatles (of course).', 'https://travel.home.sndimg.com/content/dam/images/travel/fullrights/2016/05/9/0/iStock_DavidParsons_Rocky-Mountain-National-Park-Beetle.jpg.rend.hgtvcom.966.725.suffix/1491593672990.jpeg')
into Program_info(id, visitor_center_id, program_name, description, program_image)
values (8, 1002, 'Cruise the Shoreline', 'With more shoreline than any other national park, Acadia is a perfect place to explore by boat. Park rangers offer a number of different boat cruises inside the park, but the most popular is the 3-hour "Dive-In Theater." On this tour of Frenchman Bay, families can look out for seals and porpoises, and watch in real-time (on video monitors) as a diver scours the ocean floor for marine life to bring back aboard the boat for further hands-on exploration.', 'https://travel.home.sndimg.com/content/dam/images/travel/fullrights/2016/05/9/0/iStock_AtlanticAdv_Pelagic-Bird-Acadia-National-Park.jpg.rend.hgtvcom.966.644.suffix/1491593672969.jpeg')
into Program_info(id, visitor_center_id, program_name, description, program_image)
values (9, 1002, 'Sing About Animals', 'Parents of young children (6 and under) often complain that family programs are too sophisticated for their tots. Classes themselves include a lot of singing. Also on the agenda: reading books, playing games and making crafts--all of which pertains to animals native to the park (such as hawks, bears and big horn sheep). All participating children must be accompanied by an adult', 'https://travel.home.sndimg.com/content/dam/images/travel/fullrights/2016/05/9/0/iStock_Bartfett_Yosemite-National-Park.jpg.rend.hgtvcom.966.644.suffix/1491593672975.jpeg')
into Program_info(id, visitor_center_id, program_name, description, program_image)
values (10, 1002, 'Rock-Climbing','Full-day classes are available from April through October in Curry Village or Tuolumne Meadows, while specialized programs like Girls on Granite cater to women looking to scramble and scale up the rocks.','https://travel.home.sndimg.com/content/dam/images/travel/fullrights/2016/01/14/national-park-activities/national-park-activities-rock-climbing.jpg.rend.hgtvcom.966.725.suffix/1491593018670.jpeg')
into Program_info(id, visitor_center_id, program_name, description, program_image)
values (11, 1001, 'Orienteering', 'Set off on a modern-day treasure hunt. Leave the GPS system at home for an orienteering adventure using just a map and compass to follow clues around one of the parks 30 courses. You can choose to set your own pace, whether it is a slowpoke family stroll while the kids master the compass or a competitive jaunt to race to the final clue.', 'https://travel.home.sndimg.com/content/dam/images/travel/fullrights/2016/01/14/national-park-activities/national-park-activities-orienteering.jpg.rend.hgtvcom.966.725.suffix/1491593018644.jpeg')
into Program_info(id, visitor_center_id, program_name, description, program_image)
values (12, 1001, 'Hiking: Great Smoky Mountains', 'Hikers can set off on a great adventure on foot any time of year.  With more than 800 miles of trails, there are plenty of options including scenic strolls through fields of wildflowers and strenuous climbs to the top of the parks glorious waterfalls.', 'https://travel.home.sndimg.com/content/dam/images/travel/fullrights/2016/01/14/national-park-activities/national-park-activities-hiking.jpg.rend.hgtvcom.966.725.suffix/1491593018613.jpeg')
into Program_info(id, visitor_center_id, program_name, description, program_image)
values (13, 1001, 'Wildlife Viewing', 'Enjoy a wild safari a bit closer to home. more than 60 types of mammals and 318 species of birds. Black bears and grizzlies make their home in forests while coyotes, gray wolves and bobcats frolic in the meadows. Bald eagles soar overhead and trumpeter swans make their nests alongside the rivers. Bring a pair of binoculars and a camera, and join a ranger tour to learn more about these fascinating residents.', 'https://travel.home.sndimg.com/content/dam/images/travel/fullrights/2016/01/14/national-park-activities/national-park-actvities-wildlife-viewing.jpg.rend.hgtvcom.966.725.suffix/1491593018717.jpeg')
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
into Program_Manager(program_id, manager_id)
values (6, 6)
into Program_Manager(program_id, manager_id)
values (7, 7)
into Program_Manager(program_id, manager_id)
values (8, 8)
into Program_Manager(program_id, manager_id)
values (9, 9)
into Program_Manager(program_id, manager_id)
values (10, 6)
into Program_Manager(program_id, manager_id)
values (11, 7)
into Program_Manager(program_id, manager_id)
values (12, 8)
into Program_Manager(program_id, manager_id)
values (13, 9)
select *
from dual;