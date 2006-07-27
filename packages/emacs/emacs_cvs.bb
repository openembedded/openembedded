DESCRIPTION = "Emacs"
HOMEPAGE = "http://www.gnu.org/software/emacs/"
LICENSE = "GPLv2"
MAINTAINER = "Justin Patrin <papercrane@reversefold.com>"
SECTION = "editor"
# full X (non-diet) is needed for X support
DEPENDS = "libx11"
# and it needs to run some generated binaries..
DEPENDS += "qemu-native"
#NOTE: I have found that this only works with qemu-0.8.0. If I use 0.8.1 or 0.8.2
# the build gets hung up on compiling certain .el files

PR = "r3"

SRC_URI = "cvs://anoncvs:anonymous@cvs.savannah.gnu.org/sources/emacs;module=emacs \
           file://use-qemu.patch;patch=1"
S = "${WORKDIR}/emacs"

inherit autotools

PACKAGES = "emacs emacs-el"

FILES_emacs-el = "${datadir}/emacs/22.0.50/*/*.el.gz \
                  ${datadir}/emacs/22.0.50/*/*/*.el.gz"

QEMU = "qemu-arm -L ${STAGING_DIR}/${TARGET_SYS}"

LDFLAGS += "-L${CROSS_DIR}/${TARGET_SYS}/lib"

do_bootstrap() {
    cp "${CROSS_DIR}/${TARGET_SYS}/lib/libgcc_s.so.1" "${S}"
    export LD_LIBRARY_PATH="$LD_LIBRARY_PATH:${S}"
    export QEMU="${QEMU}"

    sed -i 's:/usr/lib:${STAGING_LIBDIR}:g' ${S}/src/s/gnu-linux.h
    find "${S}" -name Makefile | xargs sed -i 's:/usr/lib:${STAGING_LIBDIR}:g'

    cd "${S}"
    make bootstrap
}

addtask bootstrap before do_compile after do_configure

do_compile_prepend() {
    cp "${CROSS_DIR}/${TARGET_SYS}/lib/libgcc_s.so.1" "${S}"
    export LD_LIBRARY_PATH="$LD_LIBRARY_PATH:${S}"
    export QEMU="${QEMU}"
}