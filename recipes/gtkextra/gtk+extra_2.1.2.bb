LICENSE		= "LGPL"
HOMEPAGE 	= "http://gtkextra.sourceforge.net/"
DESCRIPTION	= "Gtk+Extra is a set of custom widget for plots and images"

SRC_URI		= "${SOURCEFORGE_MIRROR}/gtkextra/gtk+extra-${PV}.tar.gz \
		   file://auto-lossage.patch"
DEPENDS		= "gtk+"

inherit autotools

SRC_URI[md5sum] = "10779394f39d39115fa3fd0f3dea4436"
SRC_URI[sha256sum] = "bfc9603e2023ea071f2661ecc29e52c94b1beed6b69deae45b466df7f5b2ce55"
