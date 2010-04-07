DESCRIPTION = "Multiple cat utility"
AUTHOR = "Michael 'Mickey' Lauer <mlauer@vanille-media.de>"
HOMEPAGE = "http://www.freesmartphone.org"
SECTION = "console"
LICENSE = "GPLv2"
SRCREV = "${FSO_PYTHONHELPERS_SRCREV}"
PV = "0.0.0+gitr${SRCREV}"
PR = "r1"

SRC_URI = "${FREESMARTPHONE_GIT}/python-helpers.git;protocol=git;branch=master"
S = "${WORKDIR}/git"

do_install() {
	install -d ${D}${bindir}
	install -m 0755 multicat/multicat ${D}${bindir}
}

RDEPENDS_${PN} = "\
  python-core \
"

PACKAGE_ARCH_${PN} = "all"
