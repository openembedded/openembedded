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

