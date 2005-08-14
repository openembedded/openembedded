DESCRIPTION =	"GNet is a simple network library. It is written in C, object-oriented, and built upon GLib."
LICENSE =	"LGPL"
HOMEPAGE =	"http://www.gnetlibrary.org/"

SRC_URI =	"http://www.gnetlibrary.org/src/gnet-2.0.7.tar.gz"
DEPENDS =	"glib-2.0"

EXTRA_OECONF =	"--disable-pthreads"

inherit pkgconfig autotools		
