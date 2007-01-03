DESCRIPTION = "mdev is a small busybox utility for maintaining a   \
dynamic /dev directory and is here packaged separately from        \
busybox. This adds a very small extra overhead in rootfs size      \
(approx 4kB) but allows greater flexibility."
HOMEPAGE = "http://www.busybox.net"
LICENSE = "GPL"
PR = "r5"

S = "${WORKDIR}/busybox-${PV}"

SRC_URI = "http://www.busybox.net/downloads/busybox-${PV}.tar.gz \
	   file://mdevdelnodes.patch;patch=1 \
	   file://mdevfirmware.patch;patch=1 \
           file://defconfig \
	   file://mdev.sh \
	   file://mdev.conf \
	   file://firmware \
	   "

export EXTRA_CFLAGS = "${CFLAGS}"
EXTRA_OEMAKE_append = " CROSS=${HOST_PREFIX}"

FILES_${PN} = "${sysconfdir}/init.d/mdev.sh ${sysconfdir}/mdev.conf ${base_sbindir}/mdev ${base_libdir}/mdev/firmware"

INITSCRIPT_PACKAGES = "${PN}"
INITSCRIPT_NAME_${PN} = "mdev.sh"
INITSCRIPT_PARAMS_${PN} = "start 04 S ."
CONFFILES_${PN} = "${sysconfdir}/mdev.conf"

inherit cml1 update-rc.d

do_configure () {
	install -m 0644 ${WORKDIR}/defconfig ${S}/.config.oe

	echo "CROSS_COMPILER_PREFIX=\"${TARGET_PREFIX}\"" > ${S}/.config
	echo "USING_CROSS_COMPILER=y" >> ${S}/.config

	sed -e 	'/CROSS_COMPILER_PREFIX/d' \
	    -e 	'/USING_CROSS_COMPILER/d' \
		'${S}/.config.oe' >>'${S}/.config'
	cml1_do_configure
}

do_compile () {
	unset CFLAGS
	base_do_compile
}

do_install () {
	mv ${S}/busybox ${S}/mdev

	install -d ${D}${base_sbindir}
	install -m 0755 ${S}/mdev ${D}${base_sbindir}/

	install -d ${D}${sysconfdir}/init.d
	install -m 644 ${WORKDIR}/mdev.conf ${D}${sysconfdir}/
	install -m 0755 ${WORKDIR}/mdev.sh ${D}${sysconfdir}/init.d/

	install -d ${D}${base_libdir}/mdev
	install -m 0755 ${WORKDIR}/firmware ${D}${base_libdir}/mdev/firmware
}
