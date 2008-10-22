DESCRIPTION = "SlingBox is a minimal version of BusyBox with just enough functionality \
to enable ipkg to run on an Unslung NSLU2 device."
HOMEPAGE = "http://www.busybox.net"
LICENSE = "GPL"
SECTION = "base"
PRIORITY = "required"
PR = "r3"
COMPATIBLE_MACHINE = "nslu2"

SRC_URI = "http://www.busybox.net/downloads/busybox-${PV}.tar.gz \
           file://defconfig \
           file://shadow_h_is_required.patch;patch=1 \
           file://df_rootfs.patch;patch=1 \
           file://lazy_umount.patch;patch=1 \
           file://halt.patch;patch=1 \
           file://fdisk-readhex.patch;patch=1 \
           file://trylink-bash.patch;patch=1 \
           file://slingbox_name.patch;patch=1 \
           file://slingbox.patch;patch=1"

S = "${WORKDIR}/busybox-${PV}"

export EXTRA_CFLAGS = "${CFLAGS}"
EXTRA_OEMAKE_append = " V=1 ARCH=arm CROSS_COMPILE=${TARGET_PREFIX}"

FILES_${PN} = "/"
FILES_${PN}-doc = ""
FILES_${PN}-dev = ""
FILES_${PN}-locale = ""

inherit cml1

do_configure () {
	install -m 0644 ${WORKDIR}/defconfig ${S}/.config
	cml1_do_configure
}

do_compile () {
	unset CFLAGS CPPFLAGS CXXFLAGS LDFLAGS
	base_do_compile
}

do_install () {
	unset CFLAGS CPPFLAGS CXXFLAGS LDFLAGS
	oe_runmake "PREFIX=${D}" install

	# Just in case fdisk is compiled in, do not overwrite the Linksys one
	rm -f ${S}/_install/sbin/fdisk

	cp -pPR ${S}/_install/* ${D}/
}
