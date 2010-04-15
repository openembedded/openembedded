DESCRIPTION = "GNOME editor plugins"
SECTION = "x11/gnome"
LICENSE = "GPL"

DEPENDS = "gedit"

inherit gnome
SRC_URI[archive.md5sum] = "f1200605247b3ece1212c363f0b04c1d"
SRC_URI[archive.sha256sum] = "8a177f2455ee5c58bc4a19df013d5698b14ae6a3f31ed48347904cf467a79509"

FILES_${PN} += " \
                ${libdir}/gedit-2/plugins \
                ${datadir}/gedit-2/plugins \
               "

FILES_${PN}-dbg += " \
                ${libdir}/gedit-2/plugins/.debug \
               "

