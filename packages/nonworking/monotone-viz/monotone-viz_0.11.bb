DESCRIPTION =	"Monotone-viz is a small GTK+ application that visualizes monotone ancestry graphs."
DEPENDS =	"gtk+ libgnomecanvas lablgtk sqlite3 ocaml-cross"
RDEPENDS =	"graphviz"
MAINTAINER =	"Koen Kooi <koen@handhelds.org>"


SRC_URI =	"http://oandrieu.nerim.net/monotone-viz/monotone-viz-0.11.tar.gz"

inherit autools

do_compile() {
	make world.opt
}
