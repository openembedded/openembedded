DESCRIPTION = "Static version of udev for devices with an old (e.g. <2.6.27) kernel"

SRC_URI = "http://kernel.org/pub/linux/utils/kernel/hotplug/udev-${PV}.tar.gz \
	   file://noasmlinkage.patch;patch=1 \
	   file://flags.patch;patch=1 \
	   file://vol_id_ld.patch;patch=1 \
	   file://udevtrigger_add_devname_filtering.patch;patch=1 \
	   file://libvolume-id-soname.patch;patch=1 \
	   file://mtd-exclude-persistent.patch;patch=1 \
	   "

require udev.inc

S = "${WORKDIR}/udev-${PV}"

export USE_STATIC = "true"

CFLAGS += "-DUSE_STATIC"
LDFLAGS += "-static"

# Overriding PACKAGES is bad, but we only want ${PN}
PACKAGES = "${PN}"
FILES_${PN} = "${base_sbindir}/*-${PV}-static"


UDEV_EXTRAS = "extras/firmware/ extras/scsi_id/ extras/volume_id/"
EXTRA_OEMAKE += "libudevdir=/lib/udev libdir=${base_libdir} prefix="

do_install () {
	install -d ${D}${usrsbindir} \
		   ${D}${sbindir}
	oe_runmake 'DESTDIR=${D}' INSTALL=install install

	mv ${D}${base_sbindir}/udevd ${D}${base_sbindir}/udevd-${PV}-static
	mv ${D}${base_sbindir}/udevadm ${D}${base_sbindir}/udevadm-${PV}-static
}

SRC_URI[md5sum] = "2ea9229208154229c5d6df6222f74ad7"
SRC_URI[sha256sum] = "cc9f58ff58fbd3f5868e1f1e368e3c93e1f441afd0ac1dcbd5d01a9ce5b5b0d7"
