DESCRIPTION = "Emacs"
HOMEPAGE = "http://www.gnu.org/software/emacs/"
LICENSE = "GPLv2"
SECTION = "editor"
# and it needs to run some generated binaries..
DEPENDS += "qemu-native"
#NOTE: I have found that this only works with qemu-0.8.0. If I use 0.8.1 or 0.8.2
# the build gets hung up on compiling certain .el files

PV = "22.0.50+cvs${SRCDATE}" 
PE = "1"
PR = "r9"

DEFAULT_PREFERENCE = "-1"

SRC_URI = "cvs://anoncvs:anonymous@cvs.savannah.gnu.org/sources/emacs;module=emacs \
           file://use-qemu.patch;patch=1"
S = "${WORKDIR}/emacs"

inherit autotools

PACKAGES =+ "${PN}-el"

FILES_${PN}-el = "${datadir}/emacs/*/*/*.el.gz \
                  ${datadir}/emacs/*/*/*/*.el.gz"

FILES_${PN} += "${datadir}/emacs"

QEMU = "qemu-${TARGET_ARCH} -L ${STAGING_DIR_TARGET}"
LDFLAGS += "-L${CROSS_DIR}/${TARGET_SYS}/lib"

EXTRA_OECONF = "--without-sound --without-x"

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
