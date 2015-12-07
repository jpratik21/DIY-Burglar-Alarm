DIY Burglar Alarm
================================================

A microcontroller based burglar alarm that gives push notifications on Android phone
when an intrusion is detected by a magnetic sensor.

## Requirements

* [Arduino Board](http://amzn.com/B00D9M4BQU)
* [Raspberry Pi](http://amzn.com/B00MV6TAJI)
* [Magnetic door switch](http://www.adafruit.com/products/375#tutorials)
* Jumper wires (comes as a part of Arduino kit)
* [Bluetooth module for Arduino](http://amzn.com/B00TNOO438)
* [Bluetooth dongle for Raspberry Pi](http://amzn.com/B00L08NCPQ)
<br></br>

## Steps


i. Connect above hardware elements as shown in the wiring diagram below:

![DIYAlarm](https://github.com/jpratik21/DIY-Burglar-Alarm/blob/master/wiring_screenshot.png)

<br></br>
ii. Once the hardware is configured, upload Arduino [sketch](https://github.com/jpratik21/DIY-Burglar-Alarm/blob/master/arduinodata_pi.ino) to the board via USB.

<br></br>
iii. Find out the address of Arduino's BT module so that Raspberry Pi
can make use of it for pairing its Bluetooth dongle with Arduino's BT module. The 
guide for this pairing operation is located [here](https://docs.google.com/document/d/1CEWcO2-74MeTmmg9yCDIKneWpuAi-Mmci2GKPZPK37c/edit?usp=sharing). 

<br></br>
iv. Power up Raspberry Pi and install Raspbian OS on it. This should
come pre-configured but just in case it doesn't. [Here](http://www.makeuseof.com/tag/install-operating-system-raspberry-pi/) is the guide
for this.

<br></br>
v. After the OS boots on Pi, connect it to your local Wi-Fi network 
(your Pi should have a [Wi-Fi dongle](http://amzn.com/B003MTTJOY) plugged-in)

<br></br>
vi. ssh into Raspberry Pi via terminal:
``
ssh pi@<"ip address">
``

<br></br>
vii. Upload Python [script](https://github.com/jpratik21/DIY-Burglar-Alarm/blob/master/parsepush.py) on Pi and replace the APP_ID and REST_ID
keys with yours. You should be able to find these keys in your app when
you create one on parse.com. Keys are located in app's settings page.

<br></br>
viii. Run the modified Python script on Pi via:
``
python parsepush.py
``

<br></br>
ix. Once you run this script on Pi, Raspberry Pi's BT dongle finds the address 
of Arduino's BT module via Serial( ) method used in the script and connects to Arduido's BT module:
``
ser = serial.Serial('/dev/rfcomm1',9600,timeout=0)
``

where /dev/rfcomm1 = tty address that has Arduino's BT module address info. Please
refer to the guide in step iii for additional details.

<br></br>
x. Open the [switch](http://www.adafruit.com/products/375#tutorials) / seperate 2 parts of switch connected to Arduino.
This indicates opening of the door. Relevant data is sent by Arduino's BT
module to the Pi where BT dongle is the receiver.
``
Python script running on Pi will take this information and send it to
Parse app's cloud.
``

<br></br>
xi. Import [Android app](https://github.com/jpratik21/DIY-Burglar-Alarm/tree/master/Android%20App) in Android Studio and install it on your phone.

<br></br>
xii. Deploy [cloud code](https://github.com/jpratik21/DIY-Burglar-Alarm/blob/master/cloudcode.js) to the Parse. The step by step [guide](https://parse.com/docs/cloudcode/guide#command-line-a-simple-function) will help you in deploying.[Code acts a server that sends push notifications to the Android app installed in step xi]


<br></br>
## Overview of DIY Burglar Alarm

![Overview image](https://github.com/jpratik21/DIY-Burglar-Alarm/blob/master/Overview.png)

<br></br>
For any questions, send an email on <b>calpratik@gmail.com</b>

