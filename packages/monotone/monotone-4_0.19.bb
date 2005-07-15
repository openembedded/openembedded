# This package builds the devio program
DESCRIPTION = "monotone - an SCM"
HOMEPAGE = "http://www.venge.net/"
MAINTAINER = "John Bowler <jbowler@acm.org>"
SECTION = "devel"
PRIORITY = "optional"
LICENSE = "MIT"
SUBV = "1"
PR = "r0"

SRC_URI = "http://www.venge.net/monotone/downloads/monotone_${PV}-${SUBV}.tar.gz \
	   file://txt2c-cross.patch;patch=1 \
	   file://cryptopp-endianness.patch;patch=1"
DEPENDS += "boost"
# Following may be required, not proved yet...
#TARGET_CFLAGS += "-fno-strict-aliasing"

PACKAGES = "${PN} ${PN}-doc ${PN}-testsuite"
tsd = "/home/monotone/${PN}"
FILES_${PN}-testsuite = "${tsd}/testsuite ${tsd}/tests"
RDEPENDS_${PN}-testsuite += "bash sed grep cvs"
# The testsuite also requires the following - not yet available...
#RDEPENDS_${PN}-testsuite += "patch perl"

S = "${WORKDIR}/monotone-${PV}"

# no cross compile support - it tries to run the test program even with
# --enable_ipv6=yes
EXTRA_OECONF = "--disable-ipv6 \
		--disable-dependency-tracking \
		--disable-rpath \
		--disable-nls \
		--with-gnu-ld \
		"

inherit autotools update-alternatives

ALTERNATIVE_NAME = "monotone"
ALTERNATIVE_LINK = "${bindir}/monotone"
ALTERNATIVE_PATH = "${bindir}/${PN}"
ALTERNATIVE_PRIORITY = "40"


# This makes the testsuite as a package and renames the monotone executable
# to include the netsync suffix.
do_install_append() {
	install -d ${D}${tsd}
	install -c -m 755 testsuite ${D}${tsd}/testsuite
	cp -a tests ${D}${tsd}/tests
	#
	mv ${D}${bindir}/monotone ${D}${bindir}/${PN}
}
