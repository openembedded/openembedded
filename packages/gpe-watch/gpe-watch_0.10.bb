LICENSE = "GPL"
inherit gpe pkgconfig

DESCRIPTION = "GPE analog clock-watch"
DEPENDS = "gtk+ libgpewidget"
SECTION = "gpe"
PRIORITY = "optional"

SRC_URI += "file://fix_makefile.patch;patch=1 \
            file://no-render-h.patch;patch=1"
