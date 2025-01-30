-- Create schema for the Investment table
CREATE TABLE Investment (
    user_id BIGINT,
    year_of_investment INT,
    property_id INT,
    current_market_value DECIMAL(10, 2) DEFAULT 0.00,
    current_investments DECIMAL(10, 2) DEFAULT 0.00,
    roi DECIMAL(10, 2) DEFAULT 0.00
);

-- Insert sample data for every year (2020-2025) for all users
-- John Doe example
INSERT INTO Investment (user_id, year_of_investment, property_id, current_market_value, current_investments, roi)
VALUES
    (111, 2020, 1, 500000.00, 450000.00, 50000.00),  -- 2020
    (111, 2021, 2, 520000.00, 460000.00, 60000.00),  -- 2021
    (111, 2022, 3, 550000.00, 470000.00, 80000.00),  -- 2022
    (111, 2023, 4, 550000.00, 470000.00, 80000.00),  -- 2023 (No investment, market stays the same)
    (111, 2024, 5, 550000.00, 470000.00, 80000.00),  -- 2024 (No investment, market stays the same)
    (111, 2025, 6, 550000.00, 470000.00, 80000.00);  -- 2025 (No investment, market stays the same)

-- Jane Smith example
INSERT INTO Investment (user_id, year_of_investment, property_id, current_market_value, current_investments, roi)
VALUES
    (112, 2020, 7, 300000.00, 250000.00, 50000.00),  -- 2020
    (112, 2021, 8, 300000.00, 250000.00, 50000.00),  -- 2021 (No new investment, market stays the same)
    (112, 2022, 9, 300000.00, 250000.00, 50000.00),  -- 2022 (No new investment, market stays the same)
    (112, 2023, 10, 320000.00, 270000.00, 50000.00),  -- 2023 (Investment made)
    (112, 2024, 11, 320000.00, 270000.00, 50000.00),  -- 2024 (No new investment, market stays the same)
    (112, 2025, 12, 350000.00, 300000.00, 50000.00);  -- 2025 (Investment made)


