//------------------------------------------------------------------------
// NAME: Daniel Rusinov
// CLASS: XIb
// NUMBER: 06
// FILE NAME: star.cc
// FILE PURPOSE:
// програма, която рисува зелена шестоъгълна звезда, чрез обект от даден тип
//------------------------------------------------------------------------

#include <iostream>
#include "svg.hh"
#include "turtle.hh"

using namespace std;

int main(int argc, char const *argv[]) {

	string format = argv[1];
	int side = 200;

	Turtle* turtle;

	if(format.compare("svg") == 0) {
		turtle = new SVGTurtle(1000, 1000, cout);
	} else if(format.compare("eps") == 0) {
		turtle = new PSTurtle(1000, 1000, cout); 
	}

	Color* colorGreen = new Color(0,1,0);
		turtle->setup().pencolor(Color::gray(0.0)).pensize(2).set_pos(*(new Point(0.0, 500.0))).pendown().forward(1000)
		.penup().set_pos(*(new Point(500.0, 0.0))).pendown().left(90).forward(1000).set_heading(0.0)
		.penup().pencolor(*colorGreen).pensize(10.0).set_pos(*(new Point(500.0, 500.0))).forward(200).pendown()
															.right(60).forward(side)
															.right(120).forward(side)
															.left(60).forward(side)
															.right(120).forward(side)
															.left(60).forward(side)
															.right(120).forward(side)
															.left(60).forward(side)
															.right(120).forward(side)
															.left(60).forward(side)
															.right(120).forward(side)
															.left(60).forward(side)
															.right(120).forward(side);

	delete turtle;

	return 0;
}
