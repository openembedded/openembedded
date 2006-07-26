DESCRIPTION = "Emacs"
HOMEPAGE = "http://www.gnu.org/software/emacs/"
LICENSE = "GPLv2"
MAINTAINER = "Justin Patrin <papercrane@reversefold.com>"
SECTION = "editor"
# full X (non-diet) is needed for X support
#DEPENDS = "libx11"
# and it needs to run some generated binaries..
DEPENDS += "qemu-native"
PR = "r2"

SRC_URI = "cvs://anoncvs:anonymous@cvs.savannah.gnu.org/sources/emacs;module=emacs \
           file://use-qemu.patch;patch=1"
#           http://fabrice.bellard.free.fr/qemu/qemu-gnemul-0.5.3.tar.gz"
S = "${WORKDIR}/emacs"

inherit autotools

EXTRA_OECONF = "--without-x"

#QEMU = "/usr/bin/qemu-arm -L ${WORKDIR}/usr/local/gnemul/qemu-arm -L ${STAGING_DIR}/${TARGET_SYS}"
QEMU = "qemu-arm -L ${STAGING_DIR}/${TARGET_SYS}"

LDFLAGS += "-L${CROSS_DIR}/${TARGET_SYS}/lib"

do_compile_prepend() {
    export QEMU="${QEMU}"

    sed -i 's:/usr/lib:${STAGING_LIBDIR}:g' ${S}/src/s/gnu-linux.h
    find "${S}" -name Makefile | xargs sed -i 's:/usr/lib:${STAGING_LIBDIR}:g'

    cd "${S}"
    make bootstrap
}
