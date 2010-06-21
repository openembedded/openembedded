require linux-libc-headers.inc

HOMEPAGE = "http://ep09.pld-linux.org/~mmazur/linux-libc-headers/"
# license note from the package:
#   Linux-libc-headers are derived from linux kernel headers. For license of a
#   particular header, check it's content, and if copyright notice isn't present,
#   standard linux kernel license applies.
# since we assume GPL for linux i think we can also assume it here
INHIBIT_DEFAULT_DEPS = "1"
PR = "r5"

SRC_URI = "http://ep09.pld-linux.org/~mmazur/linux-libc-headers/linux-libc-headers-${PV}.tar.bz2 \
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
		cp -pPR include/asm/cpu/*  include/asm
	fi
}

do_install() {
	install -d ${D}${includedir}
	cp -pfLR include/linux ${D}${includedir}/
	cp -pfLR include/asm ${D}${includedir}/
}

SRC_URI[md5sum] = "1df3e4fbf2670712cecb4953e2d24834"
SRC_URI[sha256sum] = "8dffedf772a9f75a8cee2a603e1b14e4b7848010dcfa0e6b087afcf4f66da6de"
