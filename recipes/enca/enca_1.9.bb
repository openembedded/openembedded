DESCRIPTION = "Enca is an Extremely Naive Charset Analyser"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "GPLv2"
HOMEPAGE = "http://trific.ath.cx/software/enca/"
PR = "r4"

SRC_URI = "http://www.sourcefiles.org/Networking/Tools/Miscellanenous/enca-${PV}.tar.bz2 \
	file://configure-hack.patch;patch=1 \
	file://dont-run-tests.patch;patch=1 \
	file://configure-remove-dumbness.patch;patch=1 \
	file://makefile-remove-tools.patch;patch=1 "

inherit autotools

EXTRA_OECONF="--with-libiconv-prefix=${STAGING_DIR_HOST}${layout_exec_prefix}"

do_configure_prepend() {
	# remove failing test which checks for something that isn't even used
	sed -i -e '/ye_FUNC_SCANF_MODIF_SIZE_T/d' configure.ac
}

do_configure_append() {
	sed -i s:-I/usr/include::g Makefile
	sed -i s:-I/usr/include::g */Makefile
}

do_compile() {
    cd ${S}/tools && ${BUILD_CC} -o make_hash make_hash.c
    cd ..
    oe_runmake
}

do_stage () {
        autotools_stage_all
}
