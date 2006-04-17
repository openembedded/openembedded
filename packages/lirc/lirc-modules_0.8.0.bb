DESCRIPTION = "LIRC is a package that allows you to decode and send infra-red signals of many commonly used remote controls. This package contains the lirc kernel modules."
SECTION = "base"
PRIORITY = "optional"
MAINTAINER = "Matthias Goebl <matthias.goebl@goebl.net>"
HOMEPAGE = "http://www.lirc.org"
LICENSE = "GPL"
DEPENDS = "virtual/kernel fakeroot-native setserial"
RDEPENDS_nslu2 = "setserial"
PR = "r3"

SRC_URI = "${SOURCEFORGE_MIRROR}/lirc/lirc-${PV}.tar.gz"
S = "${WORKDIR}/lirc-${PV}"

inherit autotools module

include lirc-config.inc

MAKE_TARGETS = "KERNEL_PATH=${STAGING_KERNEL_DIR} MAKE='make -e' -C drivers"

fakeroot do_install() {
	oe_runmake -C drivers DESTDIR="${D}" moduledir="/lib/modules/${KERNEL_VERSION}/lirc" install
	rm -rf ${D}/dev
}

# nslu2 uses udev, so /dev/lirc0 will be created automatically
# and /dev/lirc will be created by /etc/udev/rules.d/lirc.rules
# (that's the kernel-2.6+udev solution)
do_install_append_nslu2() {
	install -d ${D}${sysconfdir}/modutils/
	echo 'lirc_serial' > ${D}${sysconfdir}/modutils/lirc_serial
	install -d ${D}${sysconfdir}/modprobe.d/
	echo 'install lirc_serial /bin/setserial /dev/ttyS1 uart none; /sbin/leds ready on; /sbin/modprobe --ignore-install lirc_serial' >${D}${sysconfdir}/modprobe.d/lirc_serial
	install -d ${D}${sysconfdir}/udev/rules.d/
	echo 'KERNEL="lirc0", SYMLINK="lirc"' > ${D}${sysconfdir}/udev/rules.d/lirc.rules
}

# this is for distributions that don't use udev
pkg_postinst_append() {
if [ ! -c $D/dev/lirc -a ! -f /sbin/udevd ]; then mknod $D/dev/lirc c 61 0; fi
}

FILES_${PN} = "/lib/modules"
FILES_${PN}_append_nslu2 = " ${sysconfdir}/modutils ${sysconfdir}/modprobe.d ${sysconfdir}/udev/rules.d"
