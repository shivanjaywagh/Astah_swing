A Java GUI software for drawing class diagrams. Loosely inspired by Astah. 

**Features implemented**
A box appears on the screen when the user clicks on the panel.
The code updates on the left based on the number of boxes/classes created on the right.
Three relationships, namely Association, Inheritance and Composition, are implemented.
On clicking two classes one after the other, a pop-up window appears that asks the user which relationship needs to connect the two classes.
Based on the selected option, a line connects the two classes with an appropriate arrowhead.
Drag and drop functionality.
Creating a new file.
Save the code to a file. 
Load the diagram and code from a file.
 A status bar.


The design patterns implemented, along with the classes involved, are as follows-
**Observer Pattern**:
Observer.java
Observable.java
LeftPanel.java
RightPanel.java

**Decorator Pattern**:
AssociationDecorator.java
InheritanceDecorator.java
CompositionDecorator.java
JustLine.java
JustLineDecorator.java

**Singleton Pattern**:
RightPanel.java
Blackboard.java

**Chain of Responsibility Pattern**:
AssociationChain.java
Chain.java
CompositionChain.java
InheritanceChain.java
