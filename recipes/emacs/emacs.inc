DESCRIPTION = "Emacs"
HOMEPAGE = "http://www.gnu.org/software/emacs/"
LICENSE = "GPLv2"
SECTION = "editor"
# and it needs to run some generated binaries..
DEPENDS += "qemu-native"

DEPENDS +=" liblockfile"

inherit autotools

PACKAGES =+ "${PN}-el"

FILES_${PN}-el = "${datadir}/emacs/*/*/*.el.gz \
                  ${datadir}/emacs/*/*/*/*.el.gz"

FILES_${PN} += "${datadir}/emacs"

FILES_${PN}-dbg += "${libexecdir}/emacs/*/*/.debug ${datadir}/emacs/*/*/.debug"

TREEDIR = "${WORKDIR}/qemu-treedir"

QEMUARCH= "${TARGET_ARCH}"
QEMUARCH_i486 = "i386"
QEMUARCH_i586 = "i386"
QEMUARCH_i686 = "i386"

# Large stack is required at least on x86_64 host, otherwise random segfaults appear:
QEMU = "qemu-${QEMUARCH} ${QEMU_OPTIONS} -s 1048576 -L ${TREEDIR} "

export LOGNAME = "$(whoami)"

do_compile_prepend() {
	sed -i ':1;s:\(START.* \|LIB_STANDARD.* \|LIBES.* \)/usr/lib:\1${STAGING_LIBDIR}:;t1' ${S}/src/s/gnu-linux.h `find "${S}" -name Makefile`
	export LD_LIBRARY_PATH="$LD_LIBRARY_PATH:${CROSS_DIR}/${TARGET_SYS}/lib"
# Ugly hack, see files/use-qemu.patch for more:
	ln -sf ../src/emacs lisp/emacs
	ln -sf ../src/emacs lib-src/emacs
	ln -sf ../src/emacs leim/emacs
#copy STAGING_DIR_TARGET and libgcc_s.so* to WORKDIR/qemu-treedir #copied code from glibc-package.bbclass
	treedir=${TREEDIR}
	if [ -e $treedir ];then
		rm -rf $treedir
	fi
	mkdir $treedir
	cp -pPR ${STAGING_DIR_TARGET}/* $treedir
	if [ -f ${CROSS_DIR}/${TARGET_SYS}/lib/libgcc_s.so ]; then
                cp -pPR ${CROSS_DIR}/${TARGET_SYS}/lib/libgcc_s.so $treedir/lib
        fi
        if [ -f ${CROSS_DIR}/${TARGET_SYS}/lib/libgcc_s.so.* ]; then
                cp -pPR ${CROSS_DIR}/${TARGET_SYS}/lib/libgcc_s.so.* $treedir/lib
        fi
}

EXTRA_OEMAKE += 'QEMU="${QEMU}"'
