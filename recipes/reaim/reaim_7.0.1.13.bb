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

SRC_URI[md5sum] = "925eb6675ce86cb011699f38468a1fd1"
SRC_URI[sha256sum] = "52d87bcb19fef6360d2e36274c2b5fe512e8427550eae04c5fa897ee77d34273"
