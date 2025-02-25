-- Create tables

-- Table: PropertyDetails
CREATE TABLE PropertyDetails (
    id SERIAL PRIMARY KEY,
    property_title VARCHAR(100),
    description VARCHAR(500),
    property_type VARCHAR(100),
    property_status VARCHAR(100),
    property_category VARCHAR(100),
    lot_size DECIMAL(10, 2),
    size_in_ft DECIMAL(10, 2),
    bedrooms INT,
    rooms INT,
    year_built INT,
    garages VARCHAR(100),
    available_from DATE,
    garage_size VARCHAR(100),
    extra_details VARCHAR(100),
    basement VARCHAR(100),
    exterior_material VARCHAR(100),
    roofing VARCHAR(100),
    structure_type VARCHAR(20),
    floors INT,
    owner_notes VARCHAR(100),
    energy_index DECIMAL(10,4),
    energy_class VARCHAR(5),
    possession_date DATE,
    city VARCHAR(100),
    country VARCHAR(100),
    state VARCHAR(100),
    zipcode VARCHAR(15),
    neighbourhood VARCHAR(100),
    address VARCHAR(255),
    street_view_angle DECIMAL(10, 6),
    latitude DECIMAL(10, 6),
    longitude DECIMAL(10, 6)
);

-- Table: AdditionalData
CREATE TABLE AdditionalData (
    id SERIAL PRIMARY KEY,
    property_id INT REFERENCES PropertyDetails(id) ON DELETE CASCADE ON UPDATE CASCADE,
    video_link VARCHAR(200),
    video_from VARCHAR(20),
    image_link TEXT[]
);

-- Table: PricingDetails
CREATE TABLE PricingDetails (
    id SERIAL PRIMARY KEY,
    property_id INT REFERENCES PropertyDetails(id) ON DELETE CASCADE ON UPDATE CASCADE,
    after_price_label VARCHAR(100),
    before_price_label VARCHAR(100),
    price INT,
    home_owners_association_fee INT,
    tax_rate DECIMAL(5, 2)

);

-- Table: Amenities
CREATE TABLE Amenities (
    id SERIAL PRIMARY KEY,
    property_id INT REFERENCES PropertyDetails(id) ON DELETE CASCADE ON UPDATE CASCADE,
    pool BOOLEAN DEFAULT FALSE,
    gym BOOLEAN DEFAULT FALSE,
    fireplace BOOLEAN DEFAULT FALSE,
    equipped_kitchen BOOLEAN DEFAULT FALSE,
    laundry BOOLEAN DEFAULT FALSE,
    media_room BOOLEAN DEFAULT FALSE,
    hot_bath BOOLEAN DEFAULT FALSE,
    basketball_court BOOLEAN DEFAULT FALSE,
    back_yard BOOLEAN DEFAULT FALSE,
    front_yard BOOLEAN DEFAULT FALSE,
    garage_attached BOOLEAN DEFAULT FALSE,
    heating BOOLEAN DEFAULT FALSE,
    water BOOLEAN DEFAULT FALSE,
    electricity BOOLEAN DEFAULT FALSE,
    ventilation BOOLEAN DEFAULT FALSE,
    central_air BOOLEAN DEFAULT FALSE,
    natural_gas BOOLEAN DEFAULT FALSE,
    elevator BOOLEAN DEFAULT FALSE,
    chair_accessible BOOLEAN DEFAULT FALSE,
    wifi BOOLEAN DEFAULT FALSE,
    washer_and_dryer BOOLEAN DEFAULT FALSE,
    smoke_detectors BOOLEAN DEFAULT FALSE
);



-- Insert data
-- Insert 10 properties into PropertyDetails
INSERT INTO PropertyDetails (
    property_title, description, property_type, property_status,
    property_category, lot_size, size_in_ft, bedrooms, rooms,
    year_built, garages, available_from, garage_size, extra_details,
    basement, exterior_material, roofing, structure_type, floors,
    owner_notes, energy_index, energy_class, possession_date,
    city, country, state, zipcode, neighbourhood, address,
    street_view_angle, latitude, longitude
) VALUES
('Sunny Hillside Villa', 'A beautiful villa with a stunning view of the hills.', 'Villa', 'For Sale', 'Active', 5000.00, 2500.50, 4, 7, 2015, '2-car garage', '2025-04-01', 'Large', 'Pool, Fireplace', 'Finished', 'Brick', 'Tile', 'Detached', 2, 'Well-maintained property.', 150.0000, 'A', '2025-05-15', 'Los Angeles', 'USA', 'California', '90001', 'Sunny Heights', '123 Hillview Ave', 30.123456, 34.052235, -118.243683),
('Modern Downtown Apartment', 'An upscale apartment in the heart of the city.', 'Apartment', 'For Rent', 'Active', 2000.00, 1200.00, 2, 4, 2020, 'Underground garage', '2025-06-01', 'Small', 'Smart home system', 'None', 'Concrete', 'Flat', 'Apartment', 1, 'Pet-friendly.', 200.0000, 'B', '2025-07-01', 'New York', 'USA', 'New York', '10001', 'Downtown', '456 City Rd', 45.654321, 40.712776, -74.005974),
('Cozy Suburban Home', 'A cozy home perfect for a small family.', 'House', 'For Sale', 'Active', 3500.00, 1800.00, 3, 5, 2010, '2-car garage', '2025-07-01', 'Medium', 'Garden, Backyard', 'Partially finished', 'Wood', 'Shingle', 'Detached', 1, 'Quiet neighborhood.', 120.0000, 'C', '2025-08-01', 'Chicago', 'USA', 'Illinois', '60601', 'West Side', '789 Oak St', 60.654321, 41.878113, -87.629799),
('Spacious Country Estate', 'A large country estate with expansive grounds.', 'Estate', 'For Sale', 'Active', 10000.00, 3500.00, 5, 10, 2000, '3-car garage', '2025-09-01', 'Large', 'Stable, Tennis Court', 'Full', 'Stone', 'Metal', 'Detached', 3, 'Private retreat.', 100.0000, 'A', '2025-10-01', 'Austin', 'USA', 'Texas', '73301', 'Country Hills', '101 Ranch Rd', 90.123456, 30.267153, -97.743060),
('Luxury Waterfront Condo', 'A high-end condo with breathtaking water views.', 'Condo', 'For Rent', 'Active', 2500.00, 1500.00, 2, 6, 2018, 'Underground parking', '2025-05-01', 'Medium', 'Concierge service', 'None', 'Glass', 'Slate', 'Condominium', 1, 'Exclusive amenities.', 180.0000, 'A', '2025-06-15', 'Miami', 'USA', 'Florida', '33101', 'Waterfront', '202 Ocean Blvd', 20.123456, 25.761680, -80.191790),
('Vintage Victorian Home', 'An old Victorian home with unique architectural features.', 'House', 'For Sale', 'Active', 6000.00, 2800.00, 4, 9, 1905, '1-car garage', '2025-08-01', 'Small', 'Original woodwork', 'Partial', 'Wood', 'Slate', 'Detached', 2, 'Historic charm.', 130.0000, 'B', '2025-09-01', 'San Francisco', 'USA', 'California', '94102', 'Nob Hill', '345 Victorian St', 10.654321, 37.774929, -122.419418),
('Contemporary Urban Loft', 'A sleek loft in the heart of the urban district.', 'Loft', 'For Rent', 'Active', 1200.00, 950.00, 1, 3, 2017, 'Street parking', '2025-04-01', 'Small', 'Modern appliances', 'None', 'Concrete', 'Flat', 'Loft', 1, 'City lifestyle.', 220.0000, 'A', '2025-05-01', 'Seattle', 'USA', 'Washington', '98101', 'Downtown', '678 Urban Ave', 35.123456, 47.606209, -122.332069),
('Rural Mountain Cabin', 'A rustic cabin nestled in the mountains.', 'Cabin', 'For Sale', 'Active', 8000.00, 2000.00, 2, 4, 2010, '1-car garage', '2025-06-01', 'Small', 'Wood-burning stove', 'Finished', 'Wood', 'Shingle', 'Detached', 1, 'Secluded retreat.', 140.0000, 'C', '2025-07-01', 'Denver', 'USA', 'Colorado', '80202', 'Rocky Mountains', '789 Pine Rd', 50.123456, 39.739236, -104.990251),
('High-End Penthouse', 'A luxurious penthouse with stunning views of the skyline.', 'Penthouse', 'For Sale', 'Active', 3500.00, 2200.00, 3, 8, 2015, 'Private garage', '2025-07-15', 'Large', 'Smart home, Gym', 'None', 'Glass', 'Metal', 'Penthouse', 2, 'Exclusive property.', 250.0000, 'A', '2025-08-15', 'Los Angeles', 'USA', 'California', '90015', 'Downtown', '123 Skyview Blvd', 25.123456, 34.052235, -118.243683),
('Suburban Family House', 'A large family house in a peaceful neighborhood.', 'House', 'For Rent', 'Active', 5000.00, 2300.00, 4, 6, 2015, '2-car garage', '2025-09-01', 'Medium', 'Deck, Fireplace', 'Finished', 'Wood', 'Asphalt', 'Detached', 2, 'Great for families.', 160.0000, 'B', '2025-10-01', 'Dallas', 'USA', 'Texas', '75201', 'Green Meadows', '890 Maple St', 70.654321, 32.776665, -96.796989),
('ATS Rhapsody', 'ATS Ready to Move in Apartments in Greater Noida West.', 'Apartment', 'For Sale', 'Active', 5000.00, 2500.50, 4, 7, 2015, '2-car garage', '2025-04-01', 'Large', 'Pool, Fireplace', 'Finished', 'Brick', 'Tile', 'Detached', 2, 'Well-maintained property.', 150.0000, 'A', '2025-05-15', 'Noida', 'India', 'UttarPradesh', '201301', 'Sunny Heights', 'Sector 1, Greater Noida West', 30.123456, 34.052235, -118.243683),
('ATS Allure', 'ATS Apartments in Greater Noida West.', 'Apartment', 'For Rent', 'Active', 2000.00, 1200.00, 2, 4, 2020, 'Underground garage', '2025-06-01', 'Small', 'Smart home system', 'None', 'Concrete', 'Flat', 'Apartment', 1, 'Pet-friendly.', 200.0000, 'B', '2025-07-01', 'Greater Noida', 'India', 'UttarPradesh', '201319', 'Downtown', 'Sector 22D, Yamuna Expressway, Greater Noida', 45.654321, 40.712776, -74.005974),
('ATS Kabana High', 'ATS Office & Retail Space in Greater Noida West.', 'Retail Space', 'For Sale', 'Active', 3500.00, 1800.00, 3, 5, 2010, '2-car garage', '2025-07-01', 'Medium', 'Garden, Backyard', 'Partially finished', 'Wood', 'Shingle', 'Detached', 1, 'Quiet neighborhood.', 120.0000, 'C', '2025-08-01', 'Greater Noida', 'India', 'UttarPradesh', '201301', 'West Side', 'Sector 4, Greater Noida West', 60.654321, 41.878113, -87.629799),
('ATS Destinaire', 'Ats destinaire is the newly launched residential property by ats group.', 'Residential', 'For Sale', 'Active', 10000.00, 3500.00, 5, 10, 2000, '3-car garage', '2025-09-01', 'Large', 'Stable, Tennis Court', 'Full', 'Stone', 'Metal', 'Detached', 3, 'Private retreat.', 100.0000, 'A', '2025-10-01', 'Greater Noida', 'India', 'UttarPradesh', '201301', 'West Noida Extension', 'Sector 1, Greater Noida West', 90.123456, 30.267153, -97.743060),
('ATS Homekraft Nobility', 'ATS Homekraft Luxury Apartments in Greater Noida West.', 'Apartments', 'For Sale', 'Active', 2500.00, 1500.00, 2, 6, 2018, 'Underground parking', '2025-05-01', 'Medium', 'Concierge service', 'None', 'Glass', 'Slate', 'Condominium', 1, 'Exclusive amenities.', 180.0000, 'A', '2025-06-15', 'Greater Noida', 'India', 'UttarPradesh', '201301', 'WestSide', ' Sector 4, Greater Noida West', 20.123456, 25.761680, -80.191790);

INSERT INTO AdditionalData (property_id, video_link, video_from, image_link) VALUES
(1, 'http://example.com/video1.mp4', 'YouTube', ARRAY['http://example.com/image1.jpg', 'http://example.com/image1_2.jpg']),
(2, 'http://example.com/video2.mp4', 'Vimeo', ARRAY['http://example.com/image2.jpg', 'http://example.com/image2_2.jpg']),
(3, 'http://example.com/video3.mp4', 'YouTube', ARRAY['http://example.com/image3.jpg']),
(4, 'http://example.com/video4.mp4', 'Vimeo', ARRAY['http://example.com/image4.jpg', 'http://example.com/image4_2.jpg']),
(5, 'http://example.com/video5.mp4', 'Dailymotion', ARRAY['http://example.com/image5.jpg']),
(6, 'http://example.com/video6.mp4', 'YouTube', ARRAY['http://example.com/image6.jpg', 'http://example.com/image6_2.jpg']),
(7, 'http://example.com/video7.mp4', 'Vimeo', ARRAY['http://example.com/image7.jpg']),
(8, 'http://example.com/video8.mp4', 'Vimeo', ARRAY['http://example.com/image8.jpg', 'http://example.com/image8_2.jpg']),
(9, 'http://example.com/video9.mp4', 'YouTube', ARRAY['http://example.com/image9.jpg']),
(10, 'http://example.com/video10.mp4', 'Vimeo', ARRAY['http://example.com/image10.jpg', 'http://example.com/image10_2.jpg']),
(11, 'http://example.com/video11.mp4', 'Dailymotion', ARRAY['http://example.com/image11.jpg']),
(12, 'http://example.com/video12.mp4', 'YouTube', ARRAY['http://example.com/image12.jpg', 'http://example.com/image12_2.jpg']),
(13, 'http://example.com/video13.mp4', 'Vimeo', ARRAY['http://example.com/image13.jpg']),
(14, 'http://example.com/video14.mp4', 'YouTube', ARRAY['http://example.com/image14.jpg', 'http://example.com/image14_2.jpg']),
(15, 'http://example.com/video15.mp4', 'Dailymotion', ARRAY['http://example.com/image15.jpg']);


-- Insert related data into PricingDetails
-- Use random price and fee data for each property

INSERT INTO PricingDetails (property_id, after_price_label, before_price_label, price, home_owners_association_fee, tax_rate) VALUES
(1, 'New Price', 'Old Price', 1500000, 300, 7.5),
(2, 'New Price', 'Old Price', 600000, 250, 8.0),
(3, 'New Price', 'Old Price', 3500000, 500, 6.5),
(4, 'New Price', 'Old Price', 1200000, 200, 7.0),
(5, 'New Price', 'Old Price', 2000000, 400, 7.8),
(6, 'New Price', 'Old Price', 4500000, 350, 7.2),
(7, 'New Price', 'Old Price', 1800000, 300, 7.0),
(8, 'New Price', 'Old Price', 950000, 200, 6.8),
(9, 'New Price', 'Old Price', 1200000, 250, 7.5),
(10, 'New Price', 'Old Price', 750000, 150, 6.9),
(11, 'New Price', 'Old Price', 2200000, 450, 7.6),
(12, 'New Price', 'Old Price', 1350000, 300, 7.3),
(13, 'New Price', 'Old Price', 2800000, 400, 7.1),
(14, 'New Price', 'Old Price', 900000, 250, 6.7),
(15, 'New Price', 'Old Price', 3200000, 500, 6.9);


INSERT INTO Amenities (
    property_id, pool, gym, fireplace, equipped_kitchen, laundry,
    media_room, hot_bath, basketball_court, back_yard, front_yard,
    garage_attached, heating, water, electricity, ventilation, central_air,
    natural_gas, elevator, chair_accessible, wifi, washer_and_dryer, smoke_detectors
) VALUES
(1, TRUE, TRUE, TRUE, TRUE, TRUE, TRUE, TRUE, TRUE, TRUE, TRUE, TRUE, TRUE, TRUE, TRUE, TRUE, TRUE, TRUE, TRUE, TRUE, TRUE, TRUE, TRUE),
(2, FALSE, TRUE, FALSE, TRUE, TRUE, FALSE, FALSE, FALSE, TRUE, FALSE, FALSE, TRUE, TRUE, TRUE, TRUE, FALSE, FALSE, TRUE, FALSE, TRUE, TRUE, FALSE),
(3, TRUE, TRUE, FALSE, FALSE, TRUE, FALSE, TRUE, TRUE, FALSE, TRUE, TRUE, TRUE, TRUE, TRUE, TRUE, FALSE, FALSE, FALSE, TRUE, TRUE, TRUE, TRUE),
(4, TRUE, FALSE, TRUE, TRUE, FALSE, TRUE, FALSE, FALSE, TRUE, TRUE, TRUE, FALSE, FALSE, TRUE, TRUE, TRUE, FALSE, TRUE, FALSE, FALSE, FALSE, TRUE),
(5, FALSE, FALSE, TRUE, TRUE, TRUE, FALSE, FALSE, TRUE, TRUE, FALSE, TRUE, FALSE, TRUE, TRUE, FALSE, TRUE, FALSE, FALSE, TRUE, TRUE, FALSE, TRUE),
(6, TRUE, TRUE, TRUE, FALSE, FALSE, TRUE, TRUE, TRUE, TRUE, FALSE, TRUE, TRUE, TRUE, FALSE, TRUE, TRUE, FALSE, TRUE, TRUE, FALSE, TRUE, TRUE),
(7, TRUE, TRUE, FALSE, TRUE, FALSE, TRUE, TRUE, TRUE, TRUE, FALSE, TRUE, FALSE, TRUE, TRUE, TRUE, TRUE, FALSE, FALSE, TRUE, TRUE, FALSE, TRUE),
(8, FALSE, FALSE, TRUE, TRUE, TRUE, TRUE, FALSE, FALSE, TRUE, TRUE, TRUE, FALSE, TRUE, TRUE, TRUE, FALSE, TRUE, TRUE, TRUE, FALSE, FALSE, TRUE),
(9, TRUE, TRUE, TRUE, TRUE, TRUE, TRUE, TRUE, TRUE, TRUE, FALSE, TRUE, TRUE, TRUE, TRUE, TRUE, TRUE, TRUE, TRUE, TRUE, TRUE, TRUE, TRUE),
(10, FALSE, FALSE, FALSE, TRUE, TRUE, FALSE, FALSE, TRUE, FALSE, TRUE, TRUE, TRUE, TRUE, TRUE, FALSE, TRUE, FALSE, TRUE, TRUE, TRUE, TRUE, FALSE),
(11, TRUE, TRUE, TRUE, TRUE, TRUE, TRUE, TRUE, TRUE, TRUE, TRUE, TRUE, TRUE, TRUE, TRUE, TRUE, TRUE, TRUE, TRUE, TRUE, TRUE, TRUE, TRUE),
(12, FALSE, TRUE, FALSE, TRUE, TRUE, FALSE, FALSE, FALSE, TRUE, FALSE, FALSE, TRUE, TRUE, TRUE, TRUE, FALSE, FALSE, TRUE, FALSE, TRUE, TRUE, FALSE),
(13, TRUE, TRUE, FALSE, FALSE, TRUE, FALSE, TRUE, TRUE, FALSE, TRUE, TRUE, TRUE, TRUE, TRUE, TRUE, FALSE, FALSE, FALSE, TRUE, TRUE, TRUE, TRUE),
(14, TRUE, FALSE, TRUE, TRUE, FALSE, TRUE, FALSE, FALSE, TRUE, TRUE, TRUE, FALSE, FALSE, TRUE, TRUE, TRUE, FALSE, TRUE, FALSE, FALSE, FALSE, TRUE),
(15, FALSE, FALSE, TRUE, TRUE, TRUE, FALSE, FALSE, TRUE, TRUE, FALSE, TRUE, FALSE, TRUE, TRUE, FALSE, TRUE, FALSE, FALSE, TRUE, TRUE, FALSE, TRUE);
