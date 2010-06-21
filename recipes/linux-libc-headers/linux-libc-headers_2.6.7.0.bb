require linux-libc-headers.inc

INHIBIT_DEFAULT_DEPS = "1"
NATIVE_INSTALL_WORKS = "0"
PR = "r5"
# NOTE: no need to package these headers, since the c library includes them.
PACKAGES = ""

SRC_URI = "http://ep09.pld-linux.org/~mmazur/linux-libc-headers/linux-libc-headers-${PV}.tar.bz2 \
	   file://sh-missing.patch \
	   file://keyboard.patch"
S = "${WORKDIR}/linux-libc-headers-${PV}"

do_configure () {
	if test !  -e include/asm-$ARCH; then
		oefatal unable to create asm symlink in kernel headers
	fi
	cp -pPR "include/asm-$ARCH" "include/asm"
	if test "$ARCH" = "arm"; then
		cp -pPR include/asm/arch-ebsa285 include/asm/arch
	elif test "$ARCH" = "sh"; then
		cp -pPR include/asm/cpu-${TARGET_ARCH} include/asm/cpu || die "unable to create include/asm/cpu"
	fi
}

do_stage () {
	install -d ${STAGING_INCDIR}
	rm -rf ${STAGING_INCDIR}/linux ${STAGING_INCDIR}/asm
	cp -pfLR include/linux ${STAGING_INCDIR}/
	cp -pfLR include/asm ${STAGING_INCDIR}/
	ln -sf ${STAGING_KERNEL_DIR}/include/linux/wireless.h ${STAGING_INCDIR}/linux/wireless.h
}

SRC_URI[md5sum] = "ac14861e5fa7e52d98a6174add34084d"
SRC_URI[sha256sum] = "455f352e2ec707e4abf02091c4c49ffa5611294eb75959c25d77967a02636577"
