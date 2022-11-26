SELECT p.id, trail_info.trail_name, trail_info.difficulty, lvl.duration,
       trail_info.distance, trail_info.trail_description, img.image_url
FROM trail_info
         LEFT JOIN trail_image img on trail_info.trail_name = img.trail_name
         LEFT JOIN trail_level lvl on trail_info.distance =
                                      lvl.distance AND trail_info.difficulty = lvl.difficulty
         LEFT JOIN parks p on p.id = trail_info.park_id
WHERE NOT EXISTS
--                 ((SELECT s.season_name
--                 FROM Seasons s)
--                 EXCEPT
--                     (SELECT ts.season_name
--                     FROM trail_season ts
--                     WHERE ts.trail_name = trail_info.trail_name AND
--                     ts.park_id = trail_info.park_id));

--                 (SELECT s.season_name
--                 FROM Seasons s
--                 WHERE NOT EXISTS
--                     (SELECT ts.season_name
--                     FROM trail_season ts
--                     WHERE ts.trail_name = trail_info.trail_name AND
--                     ts.park_id = trail_info.park_id));

--                 (SELECT s.season_name
--                 FROM seasons s
--                 WHERE NOT EXISTS (SELECT ts.TRAIL_NAME
--                                     FROM trail_season ts
--                                     WHERE s.season_name = ts.season_name AND
--                                           s.season_name <> 'ALL' AND
--                                           ts.trail_name = trail_info.trail_name));

SELECT p.id,
       trail_info.trail_name,
       trail_info.difficulty,
       lvl.duration,
       trail_info.distance,
       trail_info.trail_description,
       img.image_url
FROM trail_info
         LEFT JOIN trail_image img on trail_info.trail_name =
                                      img.trail_name
         LEFT JOIN trail_level lvl on trail_info.distance =
                                      lvl.distance AND trail_info.difficulty = lvl.difficulty
         LEFT JOIN parks p on p.id = trail_info.park_id
WHERE p.id=101


-- SELECT count(*)
-- FROM trail_info
--          LEFT JOIN huts h on h.trail_name = trail_info.trail_name AND
--                              h.park_id = trail_info.park_id
-- WHERE h.trail_name = trail_info.trail_name AND
--         h.park_id = trail_info.park_id