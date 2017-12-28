conn /as sysdba
create user juyoung identified by juyoung;
GRANT resource, connect TO juyoung;

exp userid=trip/trip file='c:\trip.dmp'
imp userid=trip/trip file='c:\EXPDAT.DMP'