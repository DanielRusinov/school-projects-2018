//------------------------------------------------------------------------
// NAME: Daniel Rusinov
// CLASS: XIb
// NUMBER: 06
// FILE NAME: svg.hh
// FILE PURPOSE:
// Дефиниране на клас SVGTurtle, който наследява класа Turtle
//------------------------------------------------------------------------

#ifndef SVG_HH_
#define SVG_HH_

#include <iostream>
#include <cassert>
#include "turtle.hh"


class SVGTurtle: public Turtle{
	std::ostream& out_;

public:
	SVGTurtle(double width, double height, std::ostream& out);
	~SVGTurtle();
	
	Turtle& setup();
	Turtle& moveto(const Point& pos);
	Turtle& pencolor(const Color& c);
	Turtle& pensize(double width);
	Turtle& set_pos(const Point& pos);
	
};

#endif