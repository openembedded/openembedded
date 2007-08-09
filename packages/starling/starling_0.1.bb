LICENSE = "GPL"
SECTION = "gpe/multimedia"
PRIORITY = "optional"
PR = "r1"

inherit gpe autotools

DESCRIPTION = "Starling audio player for GPE"
DEPENDS = "gtk+ libgpewidget gstreamer gst-plugins-good gst-plugins-bad esound sqlite3 libsoup"
RDEPENDS = "esd \
	gst-plugin-audioconvert \
	gst-plugin-esd \
	gst-plugin-typefindfunctions \
        gst-plugin-decodebin \
	gst-plugin-volume"

RRECOMMENDS = "gst-plugin-mad \
	gst-plugin-modplug \
	gst-plugin-ivorbis \
	gst-plugin-tcp"

SRC_URI = "http://handhelds.org/~skyhusker/${P}.tar.bz2"
