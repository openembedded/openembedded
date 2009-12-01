DESCRIPTION = "Gksu authorization library"
LICENSE = "LGPLv2"

DEPENDS = "gtk+ gconf startup-notification gnome-keyring libgtop"

SRC_URI = "http://people.debian.org/~kov/gksu/libgksu-${PV}.tar.gz"

inherit autotools lib_package

FILES_${PN}-bin += "${datadir}/applications/gksu-properties.desktop \
                      ${datadir}/pixmaps/gksu.png \
"

