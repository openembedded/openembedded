DESCRIPTION = "Utility scripts for internationalizing XML"
PRIORITY = "optional"
SECTION = "devel"
LICENSE = "GPLv2"
DEPENDS += "libxml-parser-perl-native"
INC_PR = "r5"

URLV="${@'.'.join(bb.data.getVar('PV',d,1).split('.')[0:2])}"
SRC_URI = "${GNOME_MIRROR}/intltool/${URLV}/intltool-${PV}.tar.bz2"
S = "${WORKDIR}/intltool-${PV}"

inherit autotools pkgconfig

