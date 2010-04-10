DESCRIPTION = "LIRC is a package that allows you to decode and send infra-red signals of many commonly used remote controls. This package contains the lirc kernel modules."
SECTION = "base"
PRIORITY = "optional"
HOMEPAGE = "http://www.lirc.org"
LICENSE = "GPL"
DEPENDS = "virtual/kernel fakeroot-native setserial"

SRCDATE=${@bb.data.getVar('PV', d, 1)[9:]}

SRC_URI = "${SOURCEFORGE_MIRROR}/lirc/lirc-${PV}.tar.gz"
S = "${WORKDIR}/lirc-${PV}"


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

SRC_URI[md5sum] = "a9e44df2adbd71be586e0df6304605cc"
SRC_URI[sha256sum] = "ab5752e9af2df5f4cd2bd6d4f13872fbb519d7fa1bd3f187cc14dcb163440234"
