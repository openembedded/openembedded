DESCRIPTION = "tsclient == a frontend for rdesktop and other remote desktop tool"
HOMEPAGE = "http://www.gnomepro.com/tsclient/"
MAINTAINER = "Koen Kooi <koen@handhelds.org>"
LICENSE = "GPL"
DEPENDS = "glib-2.0 gtk+ libpanelapplet rdesktop"
RDEPENDS = "rdesktop"

SRC_URI = "http://www.gnomepro.com/tsclient/${P}.tar.gz"

inherit autotools pkgconfig
FILES_${PN} += "${datadir}/application-registry/ ${datadir}/mime-info"

