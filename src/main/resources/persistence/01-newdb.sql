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
(5, 'http://example.com/video5.mp4', 'Vimeo', ARRAY['http://example.com/image5.jpg']);



-- Insert related data into PricingDetails
-- Use random price and fee data for each property

INSERT INTO PricingDetails (property_id, after_price_label, before_price_label, price, home_owners_association_fee, tax_rate) VALUES
(1, 'New Price', 'Old Price', 1500000, 300, 7.5),
(2, 'New Price', 'Old Price', 600000, 250, 8.0),
(3, 'New Price', 'Old Price', 3500000, 500, 6.5),
(4, 'New Price', 'Old Price', 1200000, 200, 7.0),
(5, 'New Price', 'Old Price', 2000000, 400, 7.8);



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
(5, FALSE, FALSE, TRUE, TRUE, TRUE, FALSE, FALSE, TRUE, TRUE, FALSE, TRUE, FALSE, TRUE, TRUE, FALSE, TRUE, FALSE, FALSE, TRUE, TRUE, FALSE, TRUE);
