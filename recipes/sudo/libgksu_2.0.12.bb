DESCRIPTION = "Gksu authorization library"
LICENSE = "LGPLv2"
DEPENDS = "gtk+ gconf startup-notification gnome-keyring libgtop"
RRECOMMENDS_${PN} = "gksu"
PR = "r1"

SRC_URI = "http://people.debian.org/~kov/gksu/libgksu-${PV}.tar.gz"

inherit autotools lib_package

EXTRA_OECONF += " \
  --disable-gtk-doc \ 
"

FILES_${PN}-bin += "${datadir}/applications/gksu-properties.desktop \
                      ${datadir}/pixmaps/gksu.png \
"
