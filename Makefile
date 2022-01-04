test : TimeCapsule.class JFramePrinc.class JPanelEcrire.class JPanelLire.class JPanelChoix.class
	echo yeaaah
TimeCapsule.class : TimeCapsule.java
	javac -encoding UTF8 TimeCapsule.java
JFramePrinc.class : JFramePrinc.java
	javac -encoding UTF8 JFramePrinc.java
JPanelEcrire.class : JPanelEcrire.java
	javac -encoding UTF8 JPanelEcrire.java
JPanelLire.class : JPanelLire.java
	javac -encoding UTF8 JPanelLire.java
JPanelChoix.class : JPanelChoix.java
	javac -encoding UTF8 JPanelChoix.java
