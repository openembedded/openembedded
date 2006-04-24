DESCRIPTION = "SIP - A Python Wrapper Generator"
SECTION = "base"
PRIORITY = "optional"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
LICENSE = "GPL"

SRC_URI = "http://www.vanille.de/mirror/sip-${PV}.tar.gz"
S = "${WORKDIR}/sip-${PV}/sipgen"

inherit qmake native

QMAKE_PROFILES = "sipgen.pro.in"
EXTRA_QMAKEVARS_POST += "DESTDIR=${STAGING_BINDIR}"
