DESCRIPTION =	"Monotone-viz is a small GTK+ application that visualizes monotone ancestry graphs."
DEPENDS =	"gtk+ libgnomecanvas lablgtk sqlite3 ocaml-cross"
RDEPENDS =	"graphviz"


SRC_URI =	"http://oandrieu.nerim.net/monotone-viz/archive/monotone-viz-0.11.tar.gz"

SRC_URI[md5sum] = "d5eef4097084e003205b205658fa03e3"
SRC_URI[sha256sum] = "0f76050669250b8ee2fe650048d6482f4549ec571a4689a391047bb4a04586f7"

inherit autotools

do_compile() {
	make world.opt
}
