DESCRIPTION = "Bluetooth-alsa headset module"
SECTION = "kernel/modules"
HOMEPAGE = "http://bluetooth-alsa.sourceforge.net/"
LICENSE = "GPL"
DEPENDS = "alsa-lib bluez-libs"

inherit module

SRC_URI = "${SOURCEFORGE_MIRROR}/bluetooth-alsa/btsco-0.41.tar.gz \
	   file://makefile.patch;patch=1"

S = "${WORKDIR}/btsco-${PV}/kernel"

MAKE_TARGETS = "KERNEL_PATH=${STAGING_KERNEL_DIR} MAKE='make -e'"

do_install() {
	install -m 0755 -d ${D}${base_libdir}/modules/${KERNEL_VERSION}/extra
	install -m 0644 ${S}/snd-bt-sco${KERNEL_OBJECT_SUFFIX} ${D}${base_libdir}/modules/${KERNEL_VERSION}/extra/
}
