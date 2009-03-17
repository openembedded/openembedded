LICENSE = "GPL"
inherit gpe pkgconfig

SRC_URI += "file://makefile-fix.patch;patch=1"

DESCRIPTION = "GPE audio Recorder"
DEPENDS = "gtk+ libgpewidget libglade libgsm gpe-soundserver"
SECTION = "gpe/multimedia"
PRIORITY = "optional"
LDFLAGS_append = " -Wl,--export-dynamic"
