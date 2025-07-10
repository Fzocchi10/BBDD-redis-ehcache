-- Tabla Aeropuerto
CREATE TABLE IF NOT EXISTS aeropuerto (
    id UUID PRIMARY KEY,
    nombre TEXT NOT NULL,
    ciudad TEXT NOT NULL,
    pais TEXT NOT NULL,
    UNIQUE(nombre, ciudad, pais),
    version INT DEFAULT 0;
);

-- Tabla Avion
CREATE TABLE IF NOT EXISTS avion (
    id UUID PRIMARY KEY,
    nombre TEXT NOT NULL,
    total_de_asientos INT
);


INSERT INTO Aeropuerto (id,nombre, ciudad, pais) VALUES
('d8793998-6abc-4cb7-9931-a25bc4cc3d9f','Aeropuerto Internacional Maiquetía', 'Caracas', 'Venezuela'),
('c1512958-aeae-4162-b26f-45284b7c27ae','Aeropuerto La Carlota', 'Caracas', 'Venezuela'),
('ecb2b2bd-a3f4-480e-97ad-11c6beddfd43','Aeropuerto Internacional Maracaibo', 'Maracaibo', 'Venezuela'),
('2e8586b8-b880-4e08-9ac5-7f39c92c02ad','Aeropuerto Internacional Valencia', 'Valencia', 'Venezuela'),
('ff7a34a1-2040-453c-a682-27e1659f3a04','Aeropuerto Internacional El Dorado', 'Bogotá', 'Colombia'),
('da1435af-5191-49bd-aff4-3ac1941f0dff','Aeropuerto Internacional José María Córdova', 'Medellín', 'Colombia'),
('3180d859-a87f-4131-9c16-17ec21f2881c','Aeropuerto Internacional Rafael Núñez', 'Cartagena', 'Colombia'),
('5e33084d-74d5-47f7-a266-cc82c20a9399','Aeropuerto Internacional Jorge Chávez', 'Lima', 'Perú'),
('90eb8d7d-484f-4d73-86db-55408936deb0','Aeropuerto Internacional El Tepual', 'Puerto Montt', 'Chile'),
('1fec94ff-2a1e-4185-9ceb-7a2f35e6b6c8','Aeropuerto Internacional Comodoro Arturo Merino Benítez', 'Santiago', 'Chile'),
('82372d14-678c-4886-bd59-45ccc7a8b874','Aeropuerto Internacional Ezeiza', 'Buenos Aires', 'Argentina'),
('71e802dc-541e-450f-ba32-95c79b9f30d1','Aeropuerto Aeroparque Jorge Newbery', 'Buenos Aires', 'Argentina'),
('9d4e1099-dcd9-4f83-a329-5f7975435b8c','Aeropuerto Internacional Córdoba', 'Córdoba', 'Argentina'),
('71647d17-0b1c-47f8-9dbc-8096f43d81a0','Aeropuerto Internacional Mendoza', 'Mendoza', 'Argentina'),
('0591ac19-fe19-4168-a65d-e5295e4d51e8','Aeropuerto Internacional Mariscal Sucre', 'Quito', 'Ecuador'),
('23c64648-b435-4c68-9770-3378ea104ef1','Aeropuerto Internacional José Joaquín de Olmedo', 'Guayaquil', 'Ecuador'),
('d9159f7e-fee6-4240-b336-7cbfe36f1548','Aeropuerto Internacional Simón Bolívar', 'Santa Marta', 'Colombia'),
('6e32d5a1-4494-477b-820e-57aea75c2111','Aeropuerto Internacional La Aurora', 'Ciudad de Guatemala', 'Guatemala'),
('2aef6a06-e337-4394-80ed-741392f1d6de','Aeropuerto Internacional Juan Santamaría', 'San José', 'Costa Rica'),
('28fe62b4-de32-4272-87a9-33a804ec1226','Aeropuerto Internacional El Salvador', 'San Salvador', 'El Salvador'),
('1ed80c2e-f0c3-4086-bb45-c95b2acdb777','Aeropuerto Internacional Augusto C. Sandino', 'Managua', 'Nicaragua'),
('006be0e3-805b-4ffc-967b-f9b7d4d19124','Aeropuerto Internacional Tocumen', 'Ciudad de Panamá', 'Panamá'),
('b54b10f5-0b8e-4b87-aa77-0ce05d0e0531','Aeropuerto Internacional La Habana', 'La Habana', 'Cuba'),
('95a81ebc-05a3-47b2-a640-791549dbe32e','Aeropuerto Internacional José Martí', 'La Habana', 'Cuba'),
('b2352e52-3eff-4165-a703-a650d4ef8801','Aeropuerto Internacional Punta Cana', 'Punta Cana', 'República Dominicana'),
('fa5c95d3-e180-44ff-b697-65829f09da66','Aeropuerto Internacional Cancún', 'Cancún', 'México'),
('247126b1-73c2-4232-b557-17ce9778c486','Aeropuerto Internacional Benito Juárez', 'Ciudad de México', 'México'),
('148ff1e7-8a9b-4122-82b2-ac25e60c5fd6','Aeropuerto Internacional Toronto Pearson', 'Toronto', 'Canadá'),
('a8d3d103-f60d-4970-94f2-0e171c7a06ad','Aeropuerto Internacional John F. Kennedy', 'Nueva York', 'Estados Unidos');


INSERT INTO Avion (id, nombre, total_de_asientos) VALUES
('7abff9ee-d79f-4863-b1c8-5d2a4592dae9', 'Boeing 737-800', 251),
('70a139ce-9b4c-4cb9-9591-3eff2f933940', 'Airbus A320neo', 244),
('31abfbc7-273c-4037-bbc5-27d1c782984b', 'Embraer E195-E2', 210),
('2b8616ea-f503-47b2-aa80-d1bfbf453621', 'Bombardier CRJ900', 189);


