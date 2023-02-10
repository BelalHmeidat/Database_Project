create schema Taxi_office_db;
# use Taxi_office_db;
create table Available_trips(
  pathID int primary key  AUTO_INCREMENT not null,
  source_name varchar(32)  ,
  destination_name varchar(32),
  path_cost float,
  expected_time time 
);   
create table driver(
   driverID int  AUTO_INCREMENT NOT NULL ,
    driver_name varchar(32),
   phone_number varchar(32),
   adderss varchar(32),
   email varchar(32),
   DOB date,
   shift_type varchar(32),
   driver_location varchar(32),
   isWorkingToday bool,
   isAvailableToTakeTrips bool,
     primary key(driverID)
	);
    
create table operator(
   operatorID int AUTO_INCREMENT NOT NULL,
   phone_number varchar(32),
   operator_name varchar(32),
   shift_type varchar(32),
   adderss varchar(32),
   email varchar(32),
   DOB date,
   salary float,
     primary key(operatorID) 
);
ALTER TABLE operator AUTO_INCREMENT=100;
create table DriverLicence(
     LicenceID int primary key NOT NULL,
    Expiration_Date date,
    Renewal_Date date,
    Valid bool,
    driverID int,
    foreign key (driverID) references driver(driverID)
);
create table driverInsurance(
   InsuranceID int primary key NOT NULL,
   Cost float ,
   renewal_date date,
   driverID int,
    foreign key (driverID) references driver(driverID)
);
create table car(
    carID int primary key AUTO_INCREMENT NOT NULL, 
    car_type varchar(32),
    YOM int,
    car_active bool
);
create table CarLicense(
    LicenceID int primary key NOT NULL,
    Cost float,
    Renewal_Date date,
    Expiration_Date date,
    Valid boolean,
    carID int,
    foreign key (carID) references car(carID)
   );
create table carInsurance(
   InsuranceID int primary key NOT NULL,
   Cost float ,
   renewal_date date,
   carID int,
    foreign key (carID) references car(carID)
);

create table driver_salary(
working_date date primary key,
salary float ,
driverID int ,
foreign key(driverID) references driver(driverID)
);
create table trip(
   tripID int AUTO_INCREMENT primary key,
   tripDate varchar(10),
   driverID int,
   carID int,
   operatorID int,
   pathID int,
   isStarted bool,
   isFinished bool,
   isCancelled bool,
   begin_time time,
   end_time time,
   numOFpassenger int,
   passenger_name varchar(32),
   passenger_phone varchar(32),
   foreign key(driverID) references driver(driverID),
   foreign key(carID) references car(carID),
   foreign key(operatorID) references operator(operatorID),
   foreign key (pathID) references Available_trips(pathID)

);

show tables;
insert into operator (phone_number, operator_name ,shift_type, address,email,DOB,salary) values
                      ('056832','Osama','day','Ramallah','Osama.taha@gmail.com','1984-2-8',1800),
                      ('0568297','Mohammad','night','Ramallah','Mohammad.h@gmail.com','1970-9-2',1800);
insert into driver(phone_number,shift_type,driver_location, driver_name , adderss,email,DOB,isWorkingToday,isAvailableToTakeTrips) VALUES 
                 ('0597653163','day','office','Ahmad','Rammalah','Ahmad.t@gmail.com','1977-11-3',true,true),
                 ('0597653187','night','office','Asad','Rammalah','Asad.t@gmail.com','1975-2-3',true,true),
                 ('0597653187','day','office','sami','Rammalah','sami.t@gmail.com','1975-2-3',true,true),
                 ('0597653187','night','office','samer','Rammalah','samer.samer@gmail.com','1975-2-3',true,true);
insert into DriverLicence (LicenceID, Expiration_Date , Renewal_Date,Valid,driverID) values 
                          (1245,'2023-8-9','2023-12-5',true,1),
                          (2567,'2023-5-12','2023-9-23',true,2),
                          (3985,'2023-3-28','2023-7-1',true,3),
						 (3983,'2023-9-28','2023-12-1',true,4);
insert into EmpInsurance (InsuranceID, Cost , renewal_date,driverID) values
                             (4785,500,'2024-6-11',1),
                             (4579,500,'2024-5-12',2),
                             (3578,500,'2024-9-22',3),
                             (8423,500,'2024-5-12',4);
insert into car (car_type, YOM , car_active) values 
                ('Toyota',2020,true),
                ('Hyundai',2019,true),
                ('Mercedes',2021,false),
				('Mercedes',2021,true),
                ('Hyundai',2020,true);
insert into car (car_type, YOM , car_active) values 
                ('ford',2013,false);
insert into CarLicense (LicenceID, Cost , Renewal_Date,Expiration_Date,Valid,carID) values 
                       (1234,1000,'2023-5-12','2023-10-18',true,1),
                       (3457,1000,'2023-5-12','2023-10-18',true,2),
                       (7996,1500,'2023-3-12','2022-8-18',false,3),
                       (4567,1200,'2023-5-12','2023-10-18',true,4),
                       (2356,1900,'2023-5-12','2023-10-18',true,5);
insert into carInsurance (InsuranceID, Cost , renewal_date,carID) values 
   (1456,2000,'2023-10-18',1),
    (3568,2050,'2023-10-18',2),
   (3564,3000,'2023-8-18',3),
   (5643,5000,'2023-10-18',4),
   (9807,3030,'2023-10-18',5);
insert into Available_trips (source_name, destination_name , path_cost) values 
                             ('emalsharaet','masion',10),
                             ('emalsharaet', 'ramallah center',10),
                             ('Ramallah','Hebrwon',70),
							('Ramallah','Jeneen',80),
							('Ramallah','Nablus',70),
							('Ramallah','Betlahem',70),
							('Ramallah','Tolkarem',70),
							('Kufar_Aqab','Ramallah',20),
							('Ramallah','OM_Alsharaiet',20),
							('Ramallah','Betonia',40);

insert into trip(tripDate,driverID,carID,operatorID,pathID,isStarted,isFinished,isCancelled,begin_time,end_time, passenger_name,passenger_phone)
               values ('2023-1-28',1,2,100,1,true,true,false,'12:00:00','12:30:00','areej','0587498328'),
                       ('2023-1-28',2,5,101,8,true,true,false,'12:00:00','12:30:00','noor','0587498328'),
                       ('2023-1-28',1,2,100,10,true,true,false,'13:00:00','13:30:00','ahmad','0587498328'),
                       ('2023-1-28',2,5,101,5,true,true,false,'13:05:00','14:00:00','majed','0587498328'),
                       ('2023-1-28',3,1,100,2,true,true,false,'12:00:00','12:30:00','nora','0587498328'),
                       ('2023-1-29',4,4,101,6,false,false,true,'','','','');
insert into trip(tripDate,driverID,carID,operatorID,pathID,isStarted,isFinished,isCancelled,begin_time,end_time, passenger_name,passenger_phone)
               values ('2023-1-29',1,2,100,1,true,true,false,'12:00:00','12:30:00','areej','0587498328');
insert into trip(tripDate,driverID,carID,operatorID,pathID,isStarted,isFinished,isCancelled,begin_time,end_time, passenger_name,passenger_phone)
               values ('2023-1-28',1,2,100,7,true,true,false,'12:00:00','12:30:00','sara','0587498328');
                      select * from trip; 
#drop database Taxi_office_db;

#5.list all drivers who worked as night shift.
select driverID ,driver_name from driver where shift_type='night'; 
#list all drivers who worked as day shift.
select driverID ,driver_name from driver where shift_type='Day'; 
 #6. calculate sami's salary in 2023-1-28
 #2. how many trips did driver (1) take out at 2023-1-28
 SELECT COUNT(*) FROM trip where driverID=1 AND tripDate = '2023-1-28'  ;
 #4. list all active cars asid, type and year. sort result based on car id.
 select carID, car_type, YOM from car where car_active=true
  ORDER BY 1;
#6.calculate driver salary

