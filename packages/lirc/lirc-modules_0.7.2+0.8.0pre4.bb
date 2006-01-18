DESCRIPTION = "LIRC is a package that allows you to decode and send infra-red signals of many commonly used remote controls."
SECTION = "base"
PRIORITY = "optional"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
MAINTAINER_nslu2 = "Matthias Goebl <matthias.goebl@goebl.net>"
LICENSE = "GPL"
DEPENDS = "virtual/kernel fakeroot-native setserial"
RDEPENDS_nslu2 = "setserial"
PR = "r1"

SRC_URI = "http://lirc.sourceforge.net/software/snapshots/lirc-0.8.0pre4.tar.bz2"
S = "${WORKDIR}/lirc-0.8.0pre4"

inherit autotools module-base

include lirc-config.inc

do_compile() {
	# ${KERNEL_LD} doesn't understand the LDFLAGS, so suppress them
	cd drivers && oe_runmake CC="${KERNEL_CC}" LD="${KERNEL_LD}" LDFLAGS=""
}

fakeroot do_install() {
	oe_runmake -C drivers DESTDIR="${D}" moduledir="/lib/modules/${KERNEL_VERSION}/lirc" install
	rm -rf ${D}/dev
}

do_install_append_nslu2() {
	install -d ${D}${sysconfdir}/modutils/
	echo 'lirc_serial' > ${D}${sysconfdir}/modutils/lirc_serial
	install -d ${D}${sysconfdir}/modprobe.d/
	echo 'install lirc_serial /bin/setserial /dev/ttyS1 uart none; /sbin/modprobe --ignore-install lirc_serial' >${D}${sysconfdir}/modprobe.d/lirc_serial
	install -d ${D}${sysconfdir}/udev/rules.d/
	echo 'KERNEL="lirc0", SYMLINK="lirc"' > ${D}${sysconfdir}/udev/rules.d/lirc.rules
}

pkg_postinst() {
#!/bin/sh
set -e
if [ ! -c $D/dev/lirc ]; then mknod $D/dev/lirc c 61 0; fi
exit 0
}

# nslu2 uses udev, so /dev/lirc0 will be created automatically
# and /dev/lirc will be created by /etc/udev/rules.d/lirc.rules
# (that's the kernel-2.6+udev solution)
pkg_postinst_nslu2() {
	depmod -a
	update-modules
}
pkg_prerm_nslu2() {
	rmmod lirc_serial
	rmmod lirc_dev
}
pkg_postrm_nslu2() {
	update-modules
}

FILES_${PN} = "/lib/modules"
FILES_${PN}_append_nslu2 = " ${sysconfdir}/modutils ${sysconfdir}/modprobe.d ${sysconfdir}/udev/rules.d"
