DESCRIPTION = "Starling audio player for GPE"
SECTION = "gpe/multimedia"
PRIORITY = "optional"
LICENSE = "GPL"
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

PV = "0.2+svn${SRCDATE}"

inherit gpe autotools

SRC_URI = "${GPE_EXTRA_SVN}"

S = "${WORKDIR}/${PN}"
