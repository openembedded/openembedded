DESCRIPTION = "The AIM Multiuser Benchmark - Suite VII \
tests and measures the performance of Open System multiuser computers."
HOMEPAGE = "http://re-aim-7.sourceforge.net/"
SECTION = "console/tests"
LICENSE = "GPL"
DEPENDS = "libaio"

SRC_URI = "${SOURCEFORGE_MIRROR}/re-aim-7/osdl-aim-${PV}.tar.gz \
           file://makefile-fix.patch;patch=1"

S = "${WORKDIR}/osdl-aim-7/"

inherit autotools
