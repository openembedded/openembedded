LICENSE = "GPL"
inherit gpe pkgconfig

DESCRIPTION = "GPE audio Recorder"
DEPENDS = "gtk+ libgpewidget libglade libgsm gpe-soundserver"
SECTION = "gpe"
PRIORITY = "optional"
LDFLAGS_append = "-Wl,--export-dynamic"
