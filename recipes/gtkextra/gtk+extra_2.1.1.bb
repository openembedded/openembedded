LICENSE		= "LGPL"
HOMEPAGE 	= "http://gtkextra.sourceforge.net/"
DESCRIPTION	= "Gtk+Extra is a set of custom widget for plots and images"

SRC_URI		= "${SOURCEFORGE_MIRROR}/scigraphica/gtk+extra-${PV}.tar.gz"
DEPENDS		= "gtk+"

inherit autotools


SRC_URI[md5sum] = "1a933ca1286829383a0554cc2deb9e04"
SRC_URI[sha256sum] = "82d179fd2eb3fd5acbc9fc4d74507c559c6bc3269c488dc8642f9bca47a5dbe4"
