//------------------------------------------------------------------------
// NAME: Daniel Rusinov
// CLASS: XIb
// NUMBER: 06
// FILE NAME: svg.cc
// FILE PURPOSE:
// Имплементация на класа SVGTurtle,
// позволяващ използването на Turtle за SVG формат
//------------------------------------------------------------------------

#include "svg.hh"
#include "turtle.hh"
#include <cmath>

using namespace std;

SVGTurtle::SVGTurtle(double width, double height, ostream& out)
 	:	Turtle(width, height), out_(out) {}

SVGTurtle::~SVGTurtle() {
	out_ << "</svg>" << endl;
	out_ << "</body>" << endl;
	out_ << "</html>" << endl;
}

Turtle& SVGTurtle::pencolor(const Color& c) {
	Turtle::pencolor(c);
	return *this;
}

Turtle& SVGTurtle::pensize(double width) {
	Turtle::pensize(width);
	return *this;
}

Turtle& SVGTurtle::set_pos(const Point& pos) {
	return Turtle::set_pos(pos);
}

Turtle& SVGTurtle::setup(){
	out_ << "<html>" << endl;
	out_ << "<body>" << endl;
	out_ << "<h1>SVG Turtle Graphics</h1>" << endl;
	out_ << "<svg width=\"" << get_width() << "\" height=\"" << get_width() << "\">" << endl;
	Turtle::setup();

	return *this;
}

Turtle& SVGTurtle::moveto(const Point& next_pos) {
	assert(is_setup());
	assert(inside(next_pos));
	if (is_pendown()) { 
		out_ << "<line x1 =\"" << get_pos().get_x() << "\" y1=\"" << get_pos().get_y()
		<< "\" x2=\"" << next_pos.get_x() << "\" y2=\"" << next_pos.get_y()
		<< "\" style=\"stroke:rgb(" << (get_color().red())*255 << "," << (get_color().green())*255 << "," << (get_color().blue())*255
		<< ");stroke-width:" << get_pensize() << "\"/>" << endl;
	} 
	Turtle::moveto(next_pos);
	return *this;
}

