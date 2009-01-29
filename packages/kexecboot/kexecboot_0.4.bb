LICENSE = "GPL"
PR = "r1"
DEPENDS = "klibc"
RDEPENDS = "kexec-static"

inherit autotools

# You can create your own *-img.h by doing
# ./make-image-header.sh <file>.png HAND

SRC_URI = "http://projects.linuxtogo.org/~jay7/kexecboot-${PV}.tar.gz \
	file://add-reboot-option.patch;patch=1 \
	file://scan_devices-top.patch;patch=1 \
	file://graphical-no-devices.patch;patch=1 \
	file://switch-cursor-off.patch;patch=1 \
	file://add-sleep.patch;patch=1 \
	file://silent-output-hack.patch;patch=1 \
	file://kexecboot-tosa.patch;patch=1 \
	"

S = "${WORKDIR}/kexecboot-${PV}"

export CC=${TARGET_PREFIX}klcc

# standard oe cflags don't work with klcc
export CFLAGS = ""
export CPPFLAGS = ""
export LDFLAGS = ""

do_install () {
	install -d ${D}${bindir}
	install -m 0755 kexecboot ${D}${bindir}/

	install -d ${D}/proc
	install -d ${D}/mnt
}

FILES_${PN} += " ${bindir}/kexecboot /init /proc /mnt"

pkg_postinst_${PN} () {
	ln -sf ${bindir}/kexecboot $D/init
}
