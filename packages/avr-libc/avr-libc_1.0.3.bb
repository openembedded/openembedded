HOMEPAGE = "http://www.nongnu.org/avr-libc"
DESCRIPTION = "C library for use with GCC on Atmel AVR microcontrollers"
PROVIDES = "virtual/libc"
SECTION = "libs"
LICENSE = "BSD"

python __anonymous () {
    import bb, re
    if (re.match('avr', bb.data.getVar('TARGET_ARCH', d, 1)) == None):
        raise bb.parse.SkipPackage("incompatible with arch %s" %
                                   bb.data.getVar('TARGET_ARCH', d, 1))
}

SRC_URI = "http://savannah.nongnu.org/download/avr-libc/avr-libc-${PV}.tar.bz2 \
	   file://configure.patch;patch=1"
B = "${WORKDIR}/build.${BUILD_SYS}.${TARGET_SYS}"

inherit autotools

export tooldir = "${prefix}"
prefix = "${CROSS_DIR}"
exec_prefix = "${prefix}"

do_stage () {
# install into CROSS_DIR
	oe_runmake install
# install into STAGING_DIR
	oe_runmake "prefix=${STAGING_DIR}" "exec_prefix=${STAGING_DIR}" \
		   "bindir=${STAGING_BINDIR}" "libdir=${STAGING_LIBDIR}" \
		   "tooldir=${STAGING_DIR}" "toolibdir=${STAGING_LIBDIR}" \
		   install
}

do_install () {
# install into D
	oe_runmake "DESTDIR=${D}" "tooldir=/" install
}
