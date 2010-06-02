DESCRIPTION = "GPE audio player"
SECTION = "gpe/multimedia"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "gtk+ libgpewidget gstreamer gst-plugins"
RDEPENDS_${PN} = "esd gst-plugins gst-plugin-audio gst-plugin-audioconvert gst-plugin-audiofile gst-plugin-esd gst-plugin-typefindfunctions gst-plugin-volume"
RRECOMMENDS_${PN} = "gst-plugin-mad gst-plugin-tagedit"

inherit gpe pkgconfig


PARALLEL_MAKE=""
