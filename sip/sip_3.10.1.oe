DESCRIPTION = "SIP - A Python Wrapper Generator"
SECTION = "devel"
PRIORITY = "optional"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
LICENSE = "GPL"
DEPENDS = "python-native"

SRC_URI = "http://www.vanille.de/mirror/sip-${PV}.tar.gz"
S = "${WORKDIR}/sip-${PV}/sipgen"

inherit qmake

QMAKE_PROFILES = "sipgen.pro.in"
EXTRA_QMAKEVARS_POST = "DESTDIR=${S}"

