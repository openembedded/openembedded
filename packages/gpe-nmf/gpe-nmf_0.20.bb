LICENSE = "GPL"
inherit gpe pkgconfig

DESCRIPTION = "GPE audio player"
DEPENDS = "gtk+ libgpewidget gstreamer gst-plugins"
RDEPENDS = "esd \
	gst-plugins \
	gst-plugin-audio \
	gst-plugin-audioconvert \
	gst-plugin-audiofile \
	gst-plugin-esd \
	gst-plugin-typefindfunctions \
	gst-plugin-volume"
RRECOMMENDS = "gst-plugin-mad \
	gst-plugin-tagedit \
	gst-plugin-tcp"
SECTION = "gpe"
PRIORITY = "optional"
PR = "r1"

PARALLEL_MAKE=""
