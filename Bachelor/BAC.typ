#import "@preview/cetz:0.4.2"

#let draw_grid(size, rect_size, line_args, square_args) = {
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
  if(line_args != none) {
    for line in line_args {
        let x = line_args.at("x")
        let y = line_args.at("y")
        let length = line_args.at("line")
        let unit = line_args.at("unit")
        let colour = line_args.at("colour")
        let vertical = line_args.at("vertical")
        while(length > 0) {
            rect((x, y), (x - unit, y - unit), fill: colour)
            if(vertical) {
                
            }
        }
    }
  }
    })
}

#let add_coords(arg1, arg2) = {
	return (arg1.at(0) + arg2.at(0), arg1.at(1) + arg2.at(1))
}


#let line_dict = (
    x: 8,
    y: 1,
    length: 7,
    unit: 1,
    colour: red,
    vertical: false
)
#draw_grid(8, 1, none, ())
#add_coords((0, 1), (1, 1))


