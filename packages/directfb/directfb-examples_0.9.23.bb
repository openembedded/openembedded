DESCRIPTION = "DirectFB examples"
DEPENDS = "directfb"
SECTION = "devel/examples"
LICENSE = "GPL"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de"

SRC_URI = "http://www.directfb.org/downloads/Extras/DirectFB-examples-${PV}.tar.gz"
S = "${WORKDIR}/DirectFB-examples-${PV}"

inherit autotools

