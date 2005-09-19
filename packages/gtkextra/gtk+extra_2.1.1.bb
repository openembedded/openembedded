LICENSE		= "LGPL"
HOMEPAGE 	= "http://gtkextra.sourceforge.net/"
DESCRIPTION	= "Gtk+Extra is a set of custom widget for plots and images"

SRC_URI		= "${SOURCEFORGE_MIRROR}/scigraphica/gtk+extra-${PV}.tar.gz"
DEPENDS		= "gtk+"

inherit autotools
 
