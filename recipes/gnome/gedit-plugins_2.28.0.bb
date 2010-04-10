DESCRIPTION = "GNOME editor plugins"
SECTION = "x11/gnome"
LICENSE = "GPL"

DEPENDS = "gedit"

inherit gnome pkgconfig

FILES_${PN} += " \
                ${libdir}/gedit-2/plugins \
                ${datadir}/gedit-2/plugins \
               "

FILES_${PN}-dbg += " \
                ${libdir}/gedit-2/plugins/.debug \
               "


SRC_URI[archive.md5sum] = "7a0068ef250f2cfe8d60a5cf0e7a7c93"
SRC_URI[archive.sha256sum] = "d615d2f26e66d7a23f37205089096a60faa2cb6e9108f9034cf2e66b940bf2ca"
