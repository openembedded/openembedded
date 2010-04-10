DESCRIPTION = "camE is a rewrite of the xawtv webcam app, which adds imlib2 \
support and additional features."
DEPENDS = "curl giblib"
SECTION = "x11/utils"
LICENSE = "GPLv2"

SRC_URI = "http://linuxbrit.co.uk/downloads/camE-${PV}.tar.gz \
           file://make.patch;patch=1 \
           file://compile.patch;patch=1"
S = "${WORKDIR}/camE-${PV}"

do_install () {
	oe_runmake 'DESTDIR=${D}' \
		   'prefix=${prefix}' \
		   'exec_prefix=${exec_prefix}' \
		   'bindir=${bindir}' \
		   'mandir=${mandir}' \
		   'docdir=${docdir}/${P}' \
		   install
}

SRC_URI[md5sum] = "afdab327ca50ee15197d2d9e19491df7"
SRC_URI[sha256sum] = "e29b73e0bf763dead4a6ed80e648aaaea683f1a5865e5c21fed31fb9428e9430"
