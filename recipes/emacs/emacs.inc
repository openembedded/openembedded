DESCRIPTION = "Emacs"
HOMEPAGE = "http://www.gnu.org/software/emacs/"
LICENSE = "GPLv2"
SECTION = "editor"
# and it needs to run some generated binaries..
DEPENDS += "qemu-native"

inherit autotools

PACKAGES =+ "${PN}-el"

FILES_${PN}-el = "${datadir}/emacs/*/*/*.el.gz \
                  ${datadir}/emacs/*/*/*/*.el.gz"

FILES_${PN} += "${datadir}/emacs"

FILES_${PN}-dbg += "${libexecdir}/emacs/*/*/.debug ${datadir}/emacs/*/*/.debug"

# Large stack is required at least on x86_64 host, otherwise random segfaults appear:
QEMU = "qemu-${TARGET_ARCH} ${QEMU_OPTIONS} -s 1048576 -L ${STAGING_DIR_TARGET}"

do_compile_prepend() {
	sed -i ':1;s:\(START.* \|LIB_STANDARD.* \|LIBES.* \)/usr/lib:\1${STAGING_LIBDIR}:;t1' ${S}/src/s/gnu-linux.h `find "${S}" -name Makefile`
	export LD_LIBRARY_PATH="$LD_LIBRARY_PATH:${CROSS_DIR}/${TARGET_SYS}/lib"
# Ugly hack, see files/use-qemu.patch for more:
	ln -sf ../src/emacs lisp/emacs
	ln -sf ../src/emacs lib-src/emacs
	ln -sf ../src/emacs leim/emacs
}

EXTRA_OEMAKE += 'QEMU="${QEMU}"'
