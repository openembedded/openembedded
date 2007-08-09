DESCRIPTION = "GPE audio player"
SECTION = "gpe"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "gtk+ libgpewidget gstreamer gst-plugins"
RDEPENDS = "esd gst-plugins gst-plugin-audio gst-plugin-audioconvert gst-plugin-audiofile gst-plugin-esd gst-plugin-typefindfunctions gst-plugin-volume"
RRECOMMENDS = "gst-plugin-mad gst-plugin-tagedit"

inherit gpe pkgconfig


PARALLEL_MAKE=""
