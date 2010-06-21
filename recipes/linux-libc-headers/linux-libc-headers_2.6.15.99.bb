require linux-libc-headers.inc

# This package is derived from the original linux-libc-headers at
#   http://ep09.pld-linux.org/~mmazur/linux-libc-headers/
# More specifically, llh-2.6.12.0 was patched up to 2.6.16-rc6 with
# the official linux patches (where applicable) and then fixed up just
# enough to build glibc-2.4. BEWARE!
#
# license note from the linux-libc-headers package:
#   Linux-libc-headers are derived from linux kernel headers. For license of a
#   particular header, check it's content, and if copyright notice isn't present,
#   standard linux kernel license applies.
# since we assume GPL for linux i think we can also assume it here
DEFAULT_PREFERENCE = "-1"
INHIBIT_DEFAULT_DEPS = "1"
PR = "r7"

SRC_URI = "http://ewi546.ewi.utwente.nl/OE/eabi/linux-libc-headers-${PV}.tar.bz2 \
	file://keyboard.patch \
	file://asm-arch-irqs.patch \
	file://linux-netdevice.patch \
	file://linux-netfilter_ipv4.patch \
	file://linux-rtc.patch \
	file://linux-videodev2.patch \
	file://3477-1.patch"

S = "${WORKDIR}/linux-libc-headers-${PV}"

do_configure () {
	if test !  -e include/asm-$ARCH; then
		oefatal unable to create asm symlink in kernel headers
	fi
	rm "include/asm"
	cp -pPR "include/asm-$ARCH" "include/asm"
	if test "$ARCH" = "arm"; then
		cp -pPR include/asm/arch-ebsa285 include/asm/arch
	elif test "$ARCH" = "sh"; then
		cp -pPR include/asm/cpu-${TARGET_ARCH} include/asm/cpu || die "unable to create include/asm/cpu"
	fi
}

do_install() {
	install -d ${D}${includedir}
	cp -pfLR include/linux ${D}${includedir}/
	cp -pfLR include/asm ${D}${includedir}/
	cp -pfLR include/asm-generic ${D}${includedir}/
}


SRC_URI[md5sum] = "0ab7fdfc84522e16bfe78b8e0cc66bfa"
SRC_URI[sha256sum] = "c8630034519e525347e0cb8435bdf0edf9fbad2d16392768ba142c06681b2305"
