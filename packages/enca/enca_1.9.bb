DESCRIPTION = "Enca is an Extremely Naive Charset Analyser"
LICENSE = "GPL2"
SECTION = "libs"
PRIORITY = "optional"
HOMEPAGE = "http://trific.ath.cx/software/enca/"
MAINTAINER = "John Bloom <johnxx@gmail.com>"
PR = "r1"

SRC_URI = "http://trific.ath.cx/Ftp//enca/enca-${PV}.tar.bz2 \
	file://configure-hack.patch;patch=1 \
	file://dont-run-tests.patch;patch=1 "

inherit autotools 

do_compile() {
    cd ${S}/tools && oe_runmake CC="${BUILD_CC}"
    oe_runmake
}

do_stage () {
        autotools_stage_all
}
