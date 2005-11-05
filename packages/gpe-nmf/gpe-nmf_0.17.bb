LICENSE = "GPL"
inherit gpe pkgconfig

DESCRIPTION = "GPE audio player"
DEPENDS = "gtk+ libgpewidget gstreamer gst-plugins"
SECTION = "gpe"
PRIORITY = "optional"

SRC_URI += "file://fix_makefiles.patch;patch=1"
