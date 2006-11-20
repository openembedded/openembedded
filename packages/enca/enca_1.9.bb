DESCRIPTION = "Enca is an Extremely Naive Charset Analyser"
LICENSE = "GPL2"
SECTION = "libs"
PRIORITY = "optional"
HOMEPAGE = "http://trific.ath.cx/software/enca/"
PR = "r1"

SRC_URI = "http://trific.ath.cx/Ftp//enca/enca-${PV}.tar.bz2 \
	file://configure-hack.patch;patch=1 \
	file://dont-run-tests.patch;patch=1 "

inherit autotools 

do_configure_append() {
	sed -i s:-I/usr/include::g Makefile
	sed -i s:-I/usr/include::g */Makefile
}

do_compile() {
    cd ${S}/tools && make CC="${BUILD_CC}" CFLAGS="-O2" CPPFLAGS=""
    oe_runmake
}

do_stage () {
        autotools_stage_all
}
