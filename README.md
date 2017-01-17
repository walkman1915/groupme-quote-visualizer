### Requirements
To use this, you'll need a text file of GroupMe messages in a specific format.  
format: &nbsp;&nbsp;&nbsp;&nbsp;DayOfWeek, Day Month Year: Message  
example: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Saturday, 05 March 2016: "I feel like I'm going to regret everything I said" - Jason

You can use any GroupMe message scraper to get this .txt file.

### Using The Graph
After you have that file, simply open LineChartGrapher.java and enter the name of the text file (with extension)
where it says to, on the line of File file = new File(<your file here>).

In the code below, you can change the title of the program window and the graph to whatever you'd like. You can also name the x- and y-axis labels.

To run it, simply use terminal to navigate to the directory where your .txt file and LineChartGrapher.java are saved, type "javac LineChartGrapher.java", and then type "java LineChartGrapher" to view it!