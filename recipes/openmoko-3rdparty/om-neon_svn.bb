DESCRIPTION = "Simple image viewer"
HOMEPAGE = "http://neon.projects.openmoko.org/"
LICENSE = "GPLv3"
AUTHOR = "Valéry Febvre <vfebvre@easter-eggs.com>"
SECTION = "x11/applications"
PRIORITY = "optional"
DEPENDS = "edje-native python-native"

SRCREV = ${AUTOREV}
PV = "1.0.0+svn${SRCREV}"
PR = "r0"

S = "${WORKDIR}/trunk"

# Pure Python plus Edje interface
PACKAGE_ARCH = "all"

SRC_URI = "svn://svn.projects.openmoko.org/svnroot/neon;module=trunk"

inherit distutils

FILES_${PN} += "${datadir}/${PN} ${datadir}/applications/neon.desktop ${datadir}/pixmaps"

RDEPENDS += "python-textutils python-evas python-ecore python-edje"

do_compile_prepend() {
	sed -i "s/\/opt\/bin\/edje_cc -v/${@"${STAGING_BINDIR_NATIVE}".replace('/', '\/')}\/edje_cc/g" ${S}/build_edje.py 
}
