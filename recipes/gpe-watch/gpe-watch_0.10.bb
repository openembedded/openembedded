LICENSE = "GPL"
inherit gpe pkgconfig
PR = "r1"

DESCRIPTION = "GPE analog clock-watch"
DEPENDS = "gtk+ libgpewidget"
SECTION = "gpe"
PRIORITY = "optional"

SRC_URI += "file://fix_makefile.patch;patch=1 \
            file://fix_install.patch;patch=1 \
            file://no-render-h.patch;patch=1 \
           "

SRC_URI[md5sum] = "0c1cc9a5e7086194c1d2ff462759f135"
SRC_URI[sha256sum] = "4e3cc87dfde964eda9092f72f6a945765795d00dad5bb2368d9cb0a500f21fc8"
