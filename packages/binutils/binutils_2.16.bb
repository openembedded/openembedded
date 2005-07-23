DESCRIPTION = "A GNU collection of binary utilities"
HOMEPAGE = "http://www.gnu.org/software/binutils/"
SECTION = "devel"
LICENSE = "GPL"
MAINTAINER = "Gerald Britton <gbritton@doomcom.org>"
PR = "r1"

DEFAULT_PREFERENCE_linux-uclibc = "-1"

SRC_URI = \
    "http://ftp.gnu.org/gnu/binutils/binutils-${PV}.tar.bz2 \
     file://ld_makefile.patch;patch=1 \
     file://better_file_error.patch;patch=1 \
     file://signed_char_fix.patch;patch=1 \
     file://binutils-100_cflags_for_build.patch;patch=1"
# bit-rotten uclibc patches not yet updated to this version:
#    file://binutils-2.15.91.0.1-uclibc-100-conf.patch;patch=1
#    file://binutils-2.15.90.0.3-uclibc-200-build_modules.patch;patch=1

S = "${WORKDIR}/binutils-${PV}"
B = "${S}/build.${HOST_SYS}.${TARGET_SYS}"

include binutils.inc

do_configure_prepend() {
	for dir in bfd gas ld; do ( cd $dir; autoreconf ); done
}

