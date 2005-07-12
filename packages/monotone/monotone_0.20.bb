# This package builds the devio program
DESCRIPTION = "monotone - an SCM"
HOMEPAGE = "http://www.venge.net/"
MAINTAINER = "John Bowler <jbowler@acm.org>"
SECTION = "devel"
PRIORITY = "optional"
LICENSE = "MIT"
PR = "r1"

#WARNING: monotone-0.20 uses a new netsync protocol, at present the
# OpenEmbedded monotone archives use monotone-0.19 as the server,
# therefore OE builds of 0.20 are disabled here.  The protocol version
# is checked, 0.19 has version 4, 0.20 has version 5, it is not
# possible to pull using 0.20 from a 0.19 server.
# The 0.20 and 0.19 databases (the files) are compatible, so it is
# possible to use 0.20 then swap back to 0.19 for netsync with the
# older server.
DEFAULT_PREFERENCE = "-1"

SRC_URI = "http://venge.net/monotone/downloads/monotone-${PV}.tar.gz \
	   file://txt2c-cross.patch;patch=1 \
	   file://cryptopp-endianness.patch;patch=1"
DEPENDS += "boost"
# Following may be required, not proved yet...
#TARGET_CFLAGS += "-fno-strict-aliasing"

PACKAGES = "${PN} ${PN}-doc ${PN}-testsuite"
tsd = "/home/monotone"
FILES_${PN}-testsuite = "${tsd}/testsuite ${tsd}/tests"
RDEPENDS_${PN}-testsuite += "bash sed grep cvs"
# The testsuite also requires the following - not yet available...
#RDEPENDS_${PN}-testsuite += "patch perl"

# no cross compile support - it tries to run the test program even with
# --enable_ipv6=yes
EXTRA_OECONF = "--disable-ipv6 \
		--disable-dependency-tracking \
		--disable-rpath \
		--disable-nls \
		--with-gnu-ld \
		"

inherit autotools

# This makes the testsuite as a package
do_install_append() {
	install -d ${D}${tsd}
	install -c -m 755 testsuite ${D}${tsd}/testsuite
	cp -a tests ${D}${tsd}/tests
}
