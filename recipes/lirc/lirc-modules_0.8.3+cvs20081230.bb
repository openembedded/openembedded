DESCRIPTION = "LIRC is a package that allows you to decode and send infra-red signals of many commonly used remote controls. This package contains the lirc kernel modules."
SECTION = "base"
PRIORITY = "optional"
HOMEPAGE = "http://www.lirc.org"
LICENSE = "GPL"
DEPENDS = "virtual/kernel fakeroot-native setserial"
PR = "r0"

SRCDATE=${@bb.data.getVar('PV', d, 1)[9:]}

SRC_URI = "cvs://anonymous@lirc.cvs.sourceforge.net/cvsroot/lirc;module=lirc;method=pserver;cvsdate=${SRCDATE}"
S = "${WORKDIR}/lirc"


inherit autotools module

require lirc-config.inc

MAKE_TARGETS = "KERNEL_PATH=${STAGING_KERNEL_DIR} MAKE='make V=1' -C drivers"

fakeroot do_install() {
	oe_runmake -C drivers DESTDIR="${D}" moduledir="/lib/modules/${KERNEL_VERSION}/lirc" install
	rm -rf ${D}/dev
}

# this is for distributions that don't use udev
pkg_postinst_append() {
if [ ! -c $D/dev/lirc -a ! -f /sbin/udevd ]; then mknod $D/dev/lirc c 61 0; fi
}

FILES_${PN} = "/lib/modules"
