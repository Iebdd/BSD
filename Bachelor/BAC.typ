#import "@preview/cetz:0.4.2"

#let draw_grid(size, rect_size) = {
 let x = size
 let y = size
 cetz.canvas({
  import cetz.draw: *
  rect((x, y), (0, 0), stroke: 0.5pt)
  while x > 0 and y > 0 {
  	while y > 0 {
  		rect((x, y), (x - rect_size, y - rect_size), stroke: 0.5pt)
  		y -= rect_size
  	}
  	x -= rect_size
  	y = size
  }
})
}

#let add_coords(arg1, arg2) = {
	return (arg1.at(0) + arg2.at(0), arg1.at(1) + arg2.at(1))
}

#let colour_line(start, length, vertical) = {
 return {

 }
}

#draw_grid(8, 0.8)
#add_coords((0, 1), (1, 1))
#colour_line((0, 0), 1, true)


