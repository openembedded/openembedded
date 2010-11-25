DESCRIPTION = "A classic Memory game for mobile devices"
HOMEPAGE = "http://code.google.com/p/minneo/"
LICENSE = "GPLv3"
AUTHOR = "Valéry Febvre <vfebvre@easter-eggs.com>"
SECTION = "x11/applications"
PRIORITY = "optional"

SRCREV = "6"
PV = "1.0.2+svnr${SRCPV}"

PACKAGE_ARCH = "all"

SRC_URI = "svn://minneo.googlecode.com/svn;module=trunk;proto=http \
           file://setup.py.patch"
S = "${WORKDIR}/trunk"

inherit distutils

FILES_${PN} += "${datadir}/minneo ${datadir}/applications/minneo.desktop ${datadir}/pixmaps/minneo.png"

RDEPENDS_${PN} += "python-audio python-pyalsaaudio python-elementary"
DEPENDS = "edje-native"

do_compile_append() {
        cd ${S}/data/themes
        ${STAGING_BINDIR_NATIVE}/edje_cc -id ${S}/data/themes/default ${S}/data/themes/default/minneo.edc
}
