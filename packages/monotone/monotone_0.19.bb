# This package builds the devio program
DESCRIPTION = "monotone - an SCM"
HOMEPAGE = "http://www.venge.net/"
MAINTAINER = "John Bowler <jbowler@acm.org>"
SECTION = "devel"
PRIORITY = "optional"
LICENSE = "MIT"
SUBV = "1"
PR = "r1"

SRC_URI = "http://www.venge.net/monotone/downloads/monotone_${PV}-${SUBV}.tar.gz \
	   file://txt2c-cross.patch;patch=1 \
	   file://cryptopp-endianness.patch;patch=1"
DEPENDS += "boost"
# Following may be required, not proved yet...
#TARGET_CFLAGS += "-fno-strict-aliasing"

PACKAGES = "${PN} ${PN}-doc ${PN}-testsuite"
tsd = "/home/monotone"
FILES_${PN}-testsuite = "${tsd}/testsuite ${tsd}/tests"

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
