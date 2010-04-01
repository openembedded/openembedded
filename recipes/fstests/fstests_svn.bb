DESCRIPTION = "Various benchmarking tests for X"
HOMEPAGE = "http://www.o-hand.com"
SECTION = "devel"
LICENSE = "GPL"

SRCREV = "204"
PV = "0.0+svn${SRCDATE}"
PR = "r2"

DEPENDS = "gtk+"

inherit autotools

SRC_URI = \
    "svn://svn.o-hand.com/repos/misc/trunk;module=fstests;proto=http"

S = "${WORKDIR}/fstests/tests"

do_install() {
    install -d ${D}${bindir}
    find . -name "test-*" -type f -perm -755 -exec install -m 0755 {} ${D}${bindir} \;
}
