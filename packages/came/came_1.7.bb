DESCRIPTION = "camE is a rewrite of the xawtv webcam app, which adds imlib2 \
support and additional features."
MAINTAINER = "Chris Larson <kergoth@handhelds.org>"
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
