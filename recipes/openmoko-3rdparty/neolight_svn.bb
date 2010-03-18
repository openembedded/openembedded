DESCRIPTION = "An application to turn your mobile device into a flashlight"
HOMEPAGE = "http://code.google.com/p/neolight/"
LICENSE = "GPLv3"
AUTHOR = "Valéry Febvre <vfebvre@easter-eggs.com>"
SECTION = "x11/applications"
PRIORITY = "optional"

SRCREV = "16"
PV = "1.4.0+svnr${SRCPV}"

PACKAGE_ARCH = "all"

SRC_URI = "svn://neolight.googlecode.com/svn;module=trunk;proto=http"
S = "${WORKDIR}/trunk"

inherit distutils

FILES_${PN} += "${datadir}/neolight ${datadir}/applications/neolight.desktop ${datadir}/pixmaps/neolight.png"

RDEPENDS += "python-edbus python-elementary"

do_compile_prepend() {
	${STAGING_BINDIR_NATIVE}/edje_cc -id ${S}/data ${S}/data/neolight.edc
}
