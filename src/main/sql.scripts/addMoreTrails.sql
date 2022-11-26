insert all
    into Trail_level(distance, difficulty, duration)
values (1.3, 'A', 0.4)
into Trail_level(distance, difficulty, duration)
values (14.0, 'C', 5.7)
select *
from dual;

insert all
    into Trail_info(trail_name, park_id, difficulty, distance, trail_description)
values ('Takakkaw Falls Trail', 103, 'A', 1.3,
        'A very popular area for birding, snowshoeing, and running, so you''ll likely encounter other people while exploring.')
into Trail_info(trail_name, park_id, difficulty, distance, trail_description)
values ('Iceline Summit', 103, 'C', 14.0,
        'Generally considered a challenging route, it takes an average of 5 h 42 min to complete.')
select *
from dual;

insert all
    into Trail_Season(trail_name, season_name, park_id, difficulty)
values ('Stawamus Chief Trail', 'SPRING', 101, 'C')
into Trail_Season(trail_name, season_name, park_id, difficulty)
values ('Stawamus Chief Trail', 'FALL', 101, 'C')
into Trail_Season(trail_name, season_name, park_id, difficulty)
values ('Stawamus Chief Trail', 'WINTER', 101, 'C')
into Trail_Season(trail_name, season_name, park_id, difficulty)
values ('Wapta Falls Trail', 'SPRING', 102, 'A')
into Trail_Season(trail_name, season_name, park_id, difficulty)
values ('Wapta Falls Trail', 'WINTER', 102, 'A')
into Trail_Season(trail_name, season_name, park_id, difficulty)
values ('Lighthouse Loop', 'SUMMER', 201, 'A')
into Trail_Season(trail_name, season_name, park_id, difficulty)
values ('Lighthouse Loop', 'FALL', 201, 'A')
into Trail_Season(trail_name, season_name, park_id, difficulty)
values ('Lighthouse Loop', 'WINTER', 201, 'A')
into Trail_Season(trail_name, season_name, park_id, difficulty)
values ('Emerald Lake Loop', 'FALL', 103, 'B')
into Trail_Season(trail_name, season_name, park_id, difficulty)
values ('Iceline Summit', 'SPRING', 103, 'C')
into Trail_Season(trail_name, season_name, park_id, difficulty)
values ('Iceline Summit', 'SUMMER', 103, 'C')
into Trail_Season(trail_name, season_name, park_id, difficulty)
values ('Iceline Summit', 'FALL', 103, 'C')
into Trail_Season(trail_name, season_name, park_id, difficulty)
values ('Iceline Summit', 'WINTER', 103, 'C')
into Trail_Season(trail_name, season_name, park_id, difficulty)
values ('Takakkaw Falls Trail', 'SPRING', 103, 'A')
into Trail_Season(trail_name, season_name, park_id, difficulty)
values ('Takakkaw Falls Trail', 'SUMMER', 103, 'A')
into Trail_Season(trail_name, season_name, park_id, difficulty)
values ('Takakkaw Falls Trail', 'FALL', 103, 'A')
into Trail_Season(trail_name, season_name, park_id, difficulty)
values ('Takakkaw Falls Trail', 'WINTER', 103, 'A')
select *
from dual;

insert all
    into Trail_Image(trail_name, park_id, difficulty, image_url)
values ('Dog Mountain Trail', 101, 'A', 'https://images.alltrails.com/eyJidWNrZXQiOiJhc3NldHMuYWxsdHJhaWxzLmNvbSIsImtleSI6InVwbG9hZHMvcGhvdG8vaW1hZ2UvMjI4NzMyNTQvMjA1YjJkMDY2OTA5ODhmMGZiNDEyYmEwYmI0OGI0MDcuanBnIiwiZWRpdHMiOnsidG9Gb3JtYXQiOiJqcGVnIiwicmVzaXplIjp7IndpZHRoIjoyMDQ4LCJoZWlnaHQiOjIwNDgsImZpdCI6Imluc2lkZSJ9LCJyb3RhdGUiOm51bGwsImpwZWciOnsidHJlbGxpc1F1YW50aXNhdGlvbiI6dHJ1ZSwib3ZlcnNob290RGVyaW5naW5nIjp0cnVlLCJvcHRpbWlzZVNjYW5zIjp0cnVlLCJxdWFudGlzYXRpb25UYWJsZSI6M319fQ==')
into Trail_Image(trail_name, park_id, difficulty, image_url)
values ('Stawamus Chief Trail', 101, 'C', 'https://images.alltrails.com/eyJidWNrZXQiOiJhc3NldHMuYWxsdHJhaWxzLmNvbSIsImtleSI6InVwbG9hZHMvcGhvdG8vaW1hZ2UvMjgzNDE2OTcvMTg1MWQ5MjNjMzg1YzY5YjIxZDQzMDk1NDFjNmM0OGUuanBnIiwiZWRpdHMiOnsidG9Gb3JtYXQiOiJqcGVnIiwicmVzaXplIjp7IndpZHRoIjoyMDQ4LCJoZWlnaHQiOjIwNDgsImZpdCI6Imluc2lkZSJ9LCJyb3RhdGUiOm51bGwsImpwZWciOnsidHJlbGxpc1F1YW50aXNhdGlvbiI6dHJ1ZSwib3ZlcnNob290RGVyaW5naW5nIjp0cnVlLCJvcHRpbWlzZVNjYW5zIjp0cnVlLCJxdWFudGlzYXRpb25UYWJsZSI6M319fQ==')
into Trail_Image(trail_name, park_id, difficulty, image_url)
values ('Wapta Falls Trail', 102, 'A', 'https://images.alltrails.com/eyJidWNrZXQiOiJhc3NldHMuYWxsdHJhaWxzLmNvbSIsImtleSI6InVwbG9hZHMvcGhvdG8vaW1hZ2UvMjQxMTczMTUvNDFjODY2MjNiNzMxZmJjMjAwZjgxMTAyNTQwNjU2MGIuanBnIiwiZWRpdHMiOnsidG9Gb3JtYXQiOiJqcGVnIiwicmVzaXplIjp7IndpZHRoIjoyMDQ4LCJoZWlnaHQiOjIwNDgsImZpdCI6Imluc2lkZSJ9LCJyb3RhdGUiOm51bGwsImpwZWciOnsidHJlbGxpc1F1YW50aXNhdGlvbiI6dHJ1ZSwib3ZlcnNob290RGVyaW5naW5nIjp0cnVlLCJvcHRpbWlzZVNjYW5zIjp0cnVlLCJxdWFudGlzYXRpb25UYWJsZSI6M319fQ==')
into Trail_Image(trail_name, park_id, difficulty, image_url)
values ('Lighthouse Loop', 201, 'A', 'https://images.alltrails.com/eyJidWNrZXQiOiJhc3NldHMuYWxsdHJhaWxzLmNvbSIsImtleSI6InVwbG9hZHMvcGhvdG8vaW1hZ2UvNTM1ODQyOTQvNWNjNjU5ODYzMGNkYjY3NzJjZTM3MTEyYjM0MTFhZjUuanBnIiwiZWRpdHMiOnsidG9Gb3JtYXQiOiJqcGVnIiwicmVzaXplIjp7IndpZHRoIjoyMDQ4LCJoZWlnaHQiOjIwNDgsImZpdCI6Imluc2lkZSJ9LCJyb3RhdGUiOm51bGwsImpwZWciOnsidHJlbGxpc1F1YW50aXNhdGlvbiI6dHJ1ZSwib3ZlcnNob290RGVyaW5naW5nIjp0cnVlLCJvcHRpbWlzZVNjYW5zIjp0cnVlLCJxdWFudGlzYXRpb25UYWJsZSI6M319fQ==')
into Trail_Image(trail_name, park_id, difficulty, image_url)
values ('Emerald Lake Loop', 103, 'B', 'https://images.alltrails.com/eyJidWNrZXQiOiJhc3NldHMuYWxsdHJhaWxzLmNvbSIsImtleSI6InVwbG9hZHMvcGhvdG8vaW1hZ2UvMjg3NzkxODgvZDAyNGRmZmVhNzA1MGMyMTliMTc1ODNhNDEyMjZmNjEuanBnIiwiZWRpdHMiOnsidG9Gb3JtYXQiOiJqcGVnIiwicmVzaXplIjp7IndpZHRoIjoyMDQ4LCJoZWlnaHQiOjIwNDgsImZpdCI6Imluc2lkZSJ9LCJyb3RhdGUiOm51bGwsImpwZWciOnsidHJlbGxpc1F1YW50aXNhdGlvbiI6dHJ1ZSwib3ZlcnNob290RGVyaW5naW5nIjp0cnVlLCJvcHRpbWlzZVNjYW5zIjp0cnVlLCJxdWFudGlzYXRpb25UYWJsZSI6M319fQ==')
into Trail_Image(trail_name, park_id, difficulty, image_url)
values ('Takakkaw Falls Trail', 103, 'A', 'https://images.alltrails.com/eyJidWNrZXQiOiJhc3NldHMuYWxsdHJhaWxzLmNvbSIsImtleSI6InVwbG9hZHMvcGhvdG8vaW1hZ2UvMjg4ODYwOTcvMTZkM2I0ODEyYzBkOWE3NmNlMzI4YTZiYTFkNmEwNDMuanBnIiwiZWRpdHMiOnsidG9Gb3JtYXQiOiJqcGVnIiwicmVzaXplIjp7IndpZHRoIjoyMDQ4LCJoZWlnaHQiOjIwNDgsImZpdCI6Imluc2lkZSJ9LCJyb3RhdGUiOm51bGwsImpwZWciOnsidHJlbGxpc1F1YW50aXNhdGlvbiI6dHJ1ZSwib3ZlcnNob290RGVyaW5naW5nIjp0cnVlLCJvcHRpbWlzZVNjYW5zIjp0cnVlLCJxdWFudGlzYXRpb25UYWJsZSI6M319fQ==')
into Trail_Image(trail_name, park_id, difficulty, image_url)
values ('Iceline Summit', 103, 'C', 'https://images.alltrails.com/eyJidWNrZXQiOiJhc3NldHMuYWxsdHJhaWxzLmNvbSIsImtleSI6InVwbG9hZHMvcGhvdG8vaW1hZ2UvNTI2MTQyNTUvOTQ3M2UyNzY4ZTdkZmFjODQ2MTJlODczM2M0NmE4MDkuanBnIiwiZWRpdHMiOnsidG9Gb3JtYXQiOiJqcGVnIiwicmVzaXplIjp7IndpZHRoIjoyMDQ4LCJoZWlnaHQiOjIwNDgsImZpdCI6Imluc2lkZSJ9LCJyb3RhdGUiOm51bGwsImpwZWciOnsidHJlbGxpc1F1YW50aXNhdGlvbiI6dHJ1ZSwib3ZlcnNob290RGVyaW5naW5nIjp0cnVlLCJvcHRpbWlzZVNjYW5zIjp0cnVlLCJxdWFudGlzYXRpb25UYWJsZSI6M319fQ==')
select *
from dual;