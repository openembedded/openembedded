DESCRIPTION = "A frontend for rdesktop and other remote desktop tools"
HOMEPAGE = "http://www.gnomepro.com/tsclient/"
LICENSE = "GPL"
DEPENDS = "glib-2.0 gtk+ gnome-panel rdesktop"
RDEPENDS = "rdesktop"
PR = "r1"

SRC_URI = "http://www.gnomepro.com/tsclient/${P}.tar.gz"

inherit autotools pkgconfig

FILES_${PN} += "${datadir}/application-registry/ ${datadir}/mime-info"
