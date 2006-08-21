LICENSE = "GPL"
SECTION = "gpe"
PRIORITY = "optional"
PR = "r0"
MAINTAINER = "Florian Boor <fb@kernelconcepts.de>

inherit gpe autotools

DESCRIPTION = "Starling audio player for GPE"
DEPENDS = "gtk+ libgpewidget gstreamer gst-plugins-good gst-plugins-bad esound-gpe"
RDEPENDS = "esd \
	gst-plugins \
	gst-plugin-audio \
	gst-plugin-audioconvert \
	gst-plugin-audiofile \
	gst-plugin-esd \
	gst-plugin-typefindfunctions \
        gst-plugin-decodebin \
	gst-plugin-volume"

RRECOMMENDS = "gst-plugin-mad \
	gst-plugin-tagedit \
	gst-plugin-ivorbis \
	gst-plugin-tcp"

SRC_URI = "http://handhelds.org/~skyhusker/${P}.tar.bz2"
