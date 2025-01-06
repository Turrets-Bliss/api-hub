-- Create tables

-- Table: Location
CREATE TABLE Location (
    id SERIAL PRIMARY KEY,
    city VARCHAR(100),
    state VARCHAR(100),
    address VARCHAR(255),
    latitude DECIMAL(10, 6),
    longitude DECIMAL(10, 6)
);

-- Table: PropertyDetails
CREATE TABLE PropertyDetails (
    id SERIAL PRIMARY KEY,
    property_type VARCHAR(100),
    developer VARCHAR(100),
    total_towers INT,
    total_units INT,
    total_floors INT,
    possession_date DATE
);

-- Table: UnitVariants
CREATE TABLE UnitVariants (
    id SERIAL PRIMARY KEY,
    property_details_id INT,
    unit_type VARCHAR(50),
    size_sq_ft INT,
    price DECIMAL(15, 2),
    FOREIGN KEY (property_details_id) REFERENCES PropertyDetails(id)
);

-- Table: PricingDetails
CREATE TABLE PricingDetails (
    id SERIAL PRIMARY KEY,
    base_price_per_sq_ft DECIMAL(10, 2),
    maintenance_charges_per_month DECIMAL(10, 2),
    booking_amount DECIMAL(15, 2)
);

-- Table: PaymentPlans
CREATE TABLE PaymentPlans (
    id SERIAL PRIMARY KEY,
    pricing_details_id INT,
    plan_type VARCHAR(100),
    description TEXT,
    FOREIGN KEY (pricing_details_id) REFERENCES PricingDetails(id)
);

-- Table: Amenities
CREATE TABLE Amenities (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100)
);

-- Table: NearbyLandmarks
CREATE TABLE NearbyLandmarks (
    id SERIAL PRIMARY KEY,
    school VARCHAR(255),
    hospital VARCHAR(255),
    shopping_mall VARCHAR(255),
    metro_station VARCHAR(255),
    airport VARCHAR(255)
);

-- Table: LegalInformation
CREATE TABLE LegalInformation (
    id SERIAL PRIMARY KEY,
    rera_number VARCHAR(100),
    approvals TEXT
);

-- Table: AdditionalDetails
CREATE TABLE AdditionalDetails (
    id SERIAL PRIMARY KEY,
    furnished_status VARCHAR(50),
    green_rating VARCHAR(100),
    pet_friendly BOOLEAN,
    car_parking VARCHAR(100),
    total_car_parking_spaces INT
);

-- Insert data

-- Insert data for Location
INSERT INTO Location (city, state, address, latitude, longitude)
VALUES
('Noida', 'Uttar Pradesh', 'Sector 150, Noida', 28.4963, 77.4462),
('Delhi', 'Delhi', 'Connaught Place, New Delhi', 28.6358, 77.2245),
('Gurgaon', 'Haryana', 'MG Road, Gurgaon', 28.4595, 77.0266),
('Faridabad', 'Haryana', 'Sector 15, Faridabad', 28.4089, 77.3133),
('Lucknow', 'Uttar Pradesh', 'Hazratganj, Lucknow', 26.8467, 80.9462),
('Mumbai', 'Maharashtra', 'Andheri West, Mumbai', 19.0760, 72.8777),
('Bangalore', 'Karnataka', 'Koramangala, Bangalore', 12.9352, 77.6245),
('Chennai', 'Tamil Nadu', 'T Nagar, Chennai', 13.0827, 80.2707),
('Pune', 'Maharashtra', 'Kalyani Nagar, Pune', 18.5535, 73.9146),
('Kolkata', 'West Bengal', 'Salt Lake, Kolkata', 22.5726, 88.3639);

-- Insert data for PropertyDetails
INSERT INTO PropertyDetails (property_type, developer, total_towers, total_units, total_floors, possession_date)
VALUES
('Residential Apartment', 'Godrej Properties', 7, 500, 30, '2025-12-31'),
('Villa', 'DLF Ltd.', 5, 150, 2, '2024-10-01'),
('Office Space', 'Prestige Group', 10, 200, 15, '2025-05-15'),
('Commercial Complex', 'Oberoi Realty', 4, 100, 8, '2025-01-20'),
('Residential Apartment', 'Brigade Group', 6, 300, 25, '2024-12-15'),
('Luxury Apartments', 'Tata Housing', 3, 100, 20, '2026-03-01'),
('Townhouse', 'Mahindra Lifespace', 8, 250, 12, '2025-06-30'),
('Affordable Housing', 'Housing Development Finance Corporation', 12, 600, 18, '2024-11-30'),
('Studio Apartments', 'Sobha Limited', 5, 100, 10, '2024-07-15'),
('Mixed Use Development', 'Lodha Group', 9, 400, 30, '2025-02-10');

-- Insert data for UnitVariants
INSERT INTO UnitVariants (property_details_id, unit_type, size_sq_ft, price)
VALUES
(1, '2 BHK', 1250, 8500000),
(1, '3 BHK', 1600, 12000000),
(1, '4 BHK', 2200, 16000000),
(2, '3 BHK', 1800, 15000000),
(2, '4 BHK', 2500, 22000000),
(3, 'Office Suite', 1200, 5000000),
(3, 'Open Office', 1500, 6500000),
(4, 'Retail Space', 800, 4000000),
(5, '2 BHK', 1300, 9500000),
(6, '3 BHK', 2200, 25000000);

-- Insert data for PricingDetails
INSERT INTO PricingDetails (base_price_per_sq_ft, maintenance_charges_per_month, booking_amount)
VALUES
(6800, 4000, 500000),
(7500, 4500, 600000),
(5000, 3000, 400000),
(8000, 5000, 700000),
(6500, 3500, 550000),
(8500, 5000, 800000),
(7000, 4000, 600000),
(7800, 4700, 650000),
(7200, 4200, 500000),
(8900, 5500, 900000);

-- Insert data for PaymentPlans
INSERT INTO PaymentPlans (pricing_details_id, plan_type, description)
VALUES
(1, 'Construction Linked Plan', 'Pay in installments based on construction milestones.'),
(1, 'Down Payment Plan', 'Pay a lump sum upfront for a discount.'),
(2, 'Construction Linked Plan', 'Pay in installments based on construction milestones.'),
(2, 'Down Payment Plan', 'Pay a lump sum upfront for a discount.'),
(3, 'Possession Linked Plan', 'Pay after possession is granted.'),
(4, 'Down Payment Plan', 'Pay a lump sum upfront for a discount.'),
(5, 'Construction Linked Plan', 'Pay in installments based on construction milestones.'),
(6, 'Down Payment Plan', 'Pay a lump sum upfront for a discount.'),
(7, 'Flexible Payment Plan', 'Choose your own payment schedule.'),
(8, 'Possession Linked Plan', 'Pay after possession is granted.');

-- Insert data for Amenities
INSERT INTO Amenities (name)
VALUES
('Clubhouse'), ('Swimming Pool'), ('Gym'), ('Childrens Play Area'), ('Tennis Court'),
('Basketball Court'), ('Jogging Track'), ('24/7 Security'), ('Power Backup'),
('Landscaped Gardens');

-- Insert data for NearbyLandmarks
INSERT INTO NearbyLandmarks (school, hospital, shopping_mall, metro_station, airport)
VALUES
('Lotus Valley International School', 'Jaypee Hospital', 'Great India Place', 'Sector 148 Metro Station', 'Indira Gandhi International Airport'),
('The Heritage School', 'Max Super Speciality Hospital', 'Ambience Mall', 'MG Road Metro Station', 'IGI Airport'),
('Ryan International School', 'Fortis Hospital', 'Cyber Hub Mall', 'Sikandarpur Metro Station', 'Delhi Airport'),
('DAV Public School', 'Apollo Hospital', 'Sahara Mall', 'Gurgaon Metro Station', 'Indira Gandhi International Airport'),
('City Montessori School', 'Shree Krishna Hospital', 'Phoenix Marketcity', 'Vijay Nagar Metro Station', 'Chhatrapati Shivaji Maharaj International Airport'),
('National Institute of Fashion Technology', 'Fortis Healthcare', 'Express Avenue Mall', 'MGR Metro Station', 'Chennai International Airport'),
('St. Xaviers High School', 'Kokilaben Dhirubhai Ambani Hospital', 'PVR Cinemas', 'Andheri Metro Station', 'Chhatrapati Shivaji Maharaj International Airport'),
('Shiv Nadar School', 'Columbia Asia Hospital', 'The Leela Mall', 'Galleria Market Metro Station', 'Kempegowda International Airport'),
('Loreto Convent School', 'Kolkata Medical College', 'South City Mall', 'Park Street Metro Station', 'Netaji Subhas Chandra Bose International Airport'),
('Jai Hind College', 'Breach Candy Hospital', 'High Street Phoenix Mall', 'Lower Parel Metro Station', 'Chhatrapati Shivaji Maharaj International Airport');

-- Insert data for LegalInformation
INSERT INTO LegalInformation (rera_number, approvals)
VALUES
('UPRERAPRJ3251', 'Noida Development Authority, Fire Department, Environmental Clearance'),
('DLFRERA1234', 'DLF Authority, Fire Department, Environment Clearance'),
('MHREPRJ1256', 'Mumbai Development Authority, Fire Department'),
('HRRERA5678', 'Haryana Development Authority, Fire Department, Environment Clearance'),
('BRGH1234', 'Bangalore Development Authority, Fire Department, Environmental Clearance'),
('TATHOUS001', 'Tata Housing Authority, Fire Department, Environmental Clearance'),
('MHLS1234', 'Mahindra Lifespace Authority, Fire Department, Environmental Clearance'),
('HDFC123', 'Housing Finance Development Authority, Fire Department'),
('SOBHA1234', 'Sobha Housing Authority, Fire Department'),
('LHGROUP5678', 'Lodha Group Authority, Fire Department, Environmental Clearance');

-- Insert data for AdditionalDetails
INSERT INTO AdditionalDetails (furnished_status, green_rating, pet_friendly, car_parking, total_car_parking_spaces)
VALUES
('Semi-furnished', 'IGBC Certified Green Building', TRUE, 'Covered', 2),
('Fully-furnished', 'LEED Certified Green Building', FALSE, 'Open', 1),
('Unfurnished', 'None', TRUE, 'Covered', 3),
('Semi-furnished', 'BREEAM Certified', TRUE, 'Open', 4),
('Fully-furnished', 'IGBC Certified Green Building', FALSE, 'Covered', 2),
('Unfurnished', 'LEED Certified', TRUE, 'Open', 2),
('Semi-furnished', 'BREEAM Certified', TRUE, 'Covered', 1),
('Fully-furnished', 'None', FALSE, 'Covered', 3),
('Unfurnished', 'IGBC Certified Green Building', TRUE, 'Open', 5),
('Semi-furnished', 'LEED Certified Green Building', FALSE, 'Covered', 4);
