DESCRIPTION = "Emacs"
HOMEPAGE = "http://www.gnu.org/software/emacs/"
LICENSE = "GPLv2"
MAINTAINER = "Justin Patrin <papercrane@reversefold.com>"
SECTION = "editor"
DEPENDS = "qemu-native"
PR = "r0"

SRC_URI = "cvs://anoncvs:anonymous@cvs.savannah.gnu.org/sources/emacs;module=emacs"
#           http://fabrice.bellard.free.fr/qemu/qemu-gnemul-0.5.3.tar.gz"
S = "${WORKDIR}/emacs"

inherit autotools

# full X (non-diet) is needed for X support
EXTRA_OECONF = "--without-x"

#QEMU = "/usr/bin/qemu-arm -L ${WORKDIR}/usr/local/gnemul/qemu-arm -L ${STAGING_DIR}/${TARGET_SYS}"
QEMU = "qemu-arm -L ${STAGING_DIR}/${TARGET_SYS}"

LDFLAGS += "-L${CROSS_DIR}/${TARGET_SYS}/lib"

do_compile_prepend() {
    sed -i 's:/usr/lib:${STAGING_LIBDIR}:g' ${S}/src/s/gnu-linux.h

    find "${S}" -name Makefile | xargs sed -i 's:^RUN_TEMACS = ./temacs$:RUN_TEMACS = ${QEMU} ./temacs:'
    find "${S}" -name Makefile | xargs sed -i 's:EMACS=../src/bootstrap-emacs:EMACS="${QEMU} ../src/bootstrap-emacs":'

    # src-lib/Makefile
    find "${S}" -name Makefile | xargs sed -i 's:./test-distrib :${QEMU} ./test-distrib :'

    # src/Makefile
    find "${S}" -name Makefile | xargs sed -i 's:./prefix-args :${QEMU} ./prefix-args :'
    find "${S}" -name Makefile | xargs sed -i 's:$''{libsrc}make-docfile :${QEMU} $''{libsrc}make-docfile :'

    # leim/Makefile
    find "${S}" -name Makefile | xargs sed -i 's:BUILD-EMACS = :BUILT-EMACS = ${QEMU} :'

    find "${S}" -name Makefile | xargs sed -i 's:/usr/lib:${STAGING_LIBDIR}:g'
    cd ${S}
    make bootstrap
}