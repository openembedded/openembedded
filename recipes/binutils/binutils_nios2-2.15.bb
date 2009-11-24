INC_PR = "r2"
PR = "${INC_PR}.1"

require binutils.inc
LICENSE = "GPLv3"

FILESPATHPKG =. "binutils-2.15.94.0.1:"


SRCREV = "49396897843c932623b775168c5e6e1f2a43c3c8"

#SRC_URI = "git://sopc.et.ntust.edu.tw/git/binutils.git;protocol=git"
SRC_URI = "git://sopc.et.ntust.edu.tw/git/binutils.git;protocol=http"

SRC_URI += "\
     file://ld_makefile.patch;patch=1 \
     file://better_file_error.patch;patch=1 \
     file://signed_char_fix.patch;patch=1 \
     file://objdump_fix.patch;patch=1 \
     file://binutils-100_cflags_for_build.patch;patch=1 \
     file://binutils-2.15-allow-gcc-4.0.patch;patch=1"

#     file://binutils-2.15.91.0.1-uclibc-100-conf.patch;patch=1 \
#     file://binutils-2.15.90.0.3-uclibc-200-build_modules.patch;patch=1 \


S = "${WORKDIR}/git"
