int sensorPin = 3;
int magnetSensor;  
int LED = 13;

void setup(){
  Serial.begin(9600);
  pinMode(sensorPin, INPUT);
  digitalWrite(sensorPin, HIGH);
}

void loop() {
  magnetSensor = digitalRead(sensorPin);  
  // find out switch state by reading input pin
  if(magnetSensor == HIGH){
    Serial.print("open");
    digitalWrite(LED, HIGH);
  }
  else{
    Serial.print("close");
    digitalWrite(LED, LOW);
  }
  delay(10000);
}
