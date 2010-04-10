DESCRIPTION = "A frontend for rdesktop and other remote desktop tools"
HOMEPAGE = "http://www.gnomepro.com/tsclient/"
LICENSE = "GPL"
DEPENDS = "glib-2.0 gtk+ gnome-panel rdesktop"
RDEPENDS = "rdesktop"
PR = "r1"

SRC_URI = "http://www.gnomepro.com/tsclient/${P}.tar.gz"

inherit autotools pkgconfig

FILES_${PN} += "${datadir}/application-registry/ ${datadir}/mime-info"

SRC_URI[md5sum] = "c10a5a151a1ece653f62e07b11228534"
SRC_URI[sha256sum] = "4a94b68885e101dda429493caff18b5254c1240aafdb98a74ea0d775dd83b713"
