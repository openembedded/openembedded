DESCRIPTION = "Various benchmarking tests for X"
HOMEPAGE = "http://www.o-hand.com"
SECTION = "devel"
LICENSE = "GPL"
PR = "r1"

inherit autotools

SRC_URI = \
    "svn://svn.o-hand.com/repos/misc/trunk;module=fstests;proto=http \
    file://compile-fix.patch;patch=0"

S = "${WORKDIR}/fstests/tests"

do_install() {
    install -d ${D}${bindir}
    find . -name "test-*" -type f -perm -755 -exec install -m 0755 {} ${D}${bindir} \;   
}
