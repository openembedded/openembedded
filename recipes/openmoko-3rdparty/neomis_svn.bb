DESCRIPTION = "A computer version of the well-known electronic game named Simon"
HOMEPAGE = "http://code.google.com/p/neomis/"
LICENSE = "GPLv3"
AUTHOR = "Valéry Febvre <vfebvre@easter-eggs.com>"
SECTION = "x11/applications"
PRIORITY = "optional"
DEPENDS = "python-native edje-native"

SRCREV = "8"
# actually it's 1.0.3 :/ but don't want to downgrade now/bump PE
PV = "1.1.0+svnr${SRCPV}"
PR = "r2"

S = "${WORKDIR}/trunk"

PACKAGE_ARCH = "all"

SRC_URI = "svn://neomis.googlecode.com/svn;module=trunk;proto=http"

inherit distutils

do_configure_prepend_shr() {
	sed -e 's,^Exec=,Exec=/usr/bin/fsoraw -r Display ,g' -i ${S}/data/neomis.desktop
}

FILES_${PN} += "${datadir}/neomis ${datadir}/applications/neomis.desktop ${datadir}/pixmaps"

RDEPENDS_${PN} += "python-audio python-pyalsaaudio python-elementary" 

do_compile_prepend() {
	${STAGING_BINDIR_NATIVE}/edje_cc -id ${S}/data ${S}/data/neomis.edc
}
