import time,serial
from parse_rest.connection import register # import parse in python
from parse_rest.datatypes import Object

# APP_ID and REST_KEY can be found on 
# parse.com app’s page (app/settings/keys) [9.H]

APP_ID  = “##”   
REST_ID = “##“   

register(APP_ID,REST_ID) # Register App

ser = serial.Serial('/dev/rfcomm1',9600,timeout=0)  # [9.F]

class SwitchState(Object):  # object is a simple parse object                         
        pass

interval=20   # time interval 

while 1 :
 try:
  state = ser.readline()    # reading state value from PORT/Arduino
  print 'Magnetic Switch State = '+state+"   "    
  switchState = SwitchState(states=state)  # saving state to states column 
  switchState.save()                       # final value commit to Parse
  time.sleep(interval)                     # sleep interval
 except IOError:
  print("Waiting for sensor data, wait! ”) #if there anything IO error occur




