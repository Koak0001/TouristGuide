-- INSERT statements
-- Insert tags

INSERT INTO TagsTable (tag_name) VALUES 
('Family'), 
('Food'), 
('Outdoors'), 
('Art'), 
('History'), 
('Culture'), 
('Adventure'), 
('Scenic'), 
('Shopping');

-- Insert Cities

INSERT INTO `mydb`.`City` (`city_name`) VALUES
('Copenhagen'),
('Dragør'),
('Elsinore'),
('Glostrup'),
('Hellerup'),
('Helsingborg'),
('Helsingør'),
('Herlev'),
('Ishøj'),
('Humlebæk'),
('Kastrup'),
('Klampenborg'),
('Køge'),
('Malmö'),
('Roskilde'),
('Vallensbæk Strand');

-- Insert tourist attractions

INSERT INTO `mydb`.`TouristAttraction` (`attractionName`, `description`, `description_long`, `City`, `picture_file`)
VALUES
('The Blue Planet', 'Northern Europe’s largest aquarium showcasing stunning sea life in Copenhagen.', 'Experience the world under the sea as you discover majestic hammerhead sharks, secretive octopi and graceful rays at Northern Europe’s largest aquarium, Den Blå Planet (The Blue Planet) in Copenhagen.', 1, '/images/Den_Bl_Planet1.jpg'),
('GoBoat Copenhagen', 'Unique harbor exploration in Copenhagen with GoBoat rental.', 'Experience Copenhagen from a completely new perspective and explore the harbour at your own pace with GoBoat. You don’t need any certification or sailing experience to drive a boat - just come aboard!', 1, '/images/GoBoat_1.jpg'),
('Torvehallerne', 'Copenhagen''s culinary gem, offering global delicacies and fresh produce.', 'Torvehallerne is one of Copenhagen''s gems for locals and tourists alike. You can find speciality goods, fresh vegetables and exquisite little food bars where you can get specialities from all over the world.', 1, '/images/Torvehallen1.jpg'),
('Arken', 'Discover modern art at Arken, a must-visit museum near Copenhagen.', 'Immerse yourself in the vibrant world of contemporary art at Arken, showcasing innovative works from renowned Danish and international artists.', 10, NULL),
('Louisiana Museum of Modern Art', 'Immerse yourself in contemporary art at Louisiana, a renowned museum.', 'Explore the beautiful surroundings of Louisiana Museum of Modern Art while discovering a diverse collection of contemporary artworks from around the world.', 9, NULL);


-- INSERT JUNCTION table statements

INSERT INTO `mydb`.`AttractionTagsTable` (`attraction_id`, `tag_id`) VALUES 
(1, 1), -- Blue Planet
(1, 3), 
(2, 1),-- GoBoat
(2, 3),
(2, 7),
(2, 8),
(3, 1),-- Torvehallerne
(3, 2), 
(4, 4),-- Arken
(4, 6), 
(5, 4),-- Louisiana
(5, 6),
(5, 8); 

INSERT INTO `mydb`.`CityAttractions` (`city_id`, `attraction_id`) VALUES 
(1, 1), -- Blue Planet
(1, 2), -- GoBoat
(1, 3), -- Torvehallerne
(10, 4), -- Arken
(9, 5); -- Louisiana
