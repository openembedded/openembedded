DESCRIPTION = "A gtk based image viewer"
SECTION = "x11/graphics"
DEPENDS = "gtk+"
LICENSE = "GPL"
HOMEPAGE = "http://gqview.sourceforge.net/"
MAINTAINER = "Graeme Gregory <dp@xora.org.uk>"
RRECOMMENDS = "gdk-pixbuf-loader-jpeg gdk-pixbuf-loader-png gdk-pixbuf-loader-gif"
PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/gqview/gqview-2.1.1.tar.gz \
	   file://include-path-fix.patch;patch=1"

inherit autotools

