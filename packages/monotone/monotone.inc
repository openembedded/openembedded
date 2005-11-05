DESCRIPTION = "Monotone is a distributed Source Control System"
HOMEPAGE = "http://www.venge.net/"
MAINTAINER = "John Bowler <jbowler@acm.org>"
SECTION = "devel"
PRIORITY = "optional"
LICENSE = "MIT"
DEPENDS = "boost"

# Following may be required, not proved yet...
#TARGET_CFLAGS += "-fno-strict-aliasing"

S = "${WORKDIR}/monotone-${PV}"

# no cross compile support - it tries to run the test program even with
# --enable_ipv6=yes
EXTRA_OECONF = "--disable-ipv6 \
		--disable-dependency-tracking \
		--disable-rpath \
		--disable-nls \
		--with-gnu-ld \
		--with-bundled-lua --with-bundled-sqlite"

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
	cp -pPR tests ${D}${tsd}/tests
	#
	mv ${D}${bindir}/monotone ${D}${bindir}/${PN}
}

PACKAGES = "${PN} ${PN}-doc ${PN}-testsuite"
tsd = "/home/monotone/${PN}"
FILES_${PN}-testsuite = "${tsd}/testsuite ${tsd}/tests"
RDEPENDS_${PN}-testsuite += "bash sed grep cvs patch perl perl-modules"
