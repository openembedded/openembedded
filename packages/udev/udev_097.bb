DEFAULT_PREFERENCE = "-1"

DESCRIPTION = "udev is a daemon which dynamically creates and removes device nodes from \
/dev/, handles hotplug events and loads drivers at boot time. It replaces \
the hotplug package and requires a kernel not older than 2.6.15."
DESCRIPTION_libvolume-id = "libvolume_id shared library, \
used to detect the type of a file system and read its metadata."
DESCRIPTION_libvolume-id-dev = "libvolume_id development headers, \
needed to link programs with libvolume_id."

PR = "r2"

SRC_URI = "http://kernel.org/pub/linux/utils/kernel/hotplug/udev-${PV}.tar.gz \
	   file://noasmlinkage.patch;patch=1 \
	   file://flags.patch;patch=1 \
	   file://mount.blacklist \
	   "

require udev.inc

SRC_URI_append_h2200 = " file://50-hostap_cs.rules "
PACKAGE_ARCH_h2200 = "h2200"

INITSCRIPT_PARAMS = "start 03 S ."

PACKAGES =+ "libvolume-id-dev libvolume-id"
PKG_libvolume-id-dev = "libvolume-id-dev"
FILES_libvolume-id-dev = "${includedir}/libvolume_id.h ${libdir}/libvolume_id.a ${libdir}/libvolume_id.so ${libdir}/pkgconfig/libvolume_id.pc"
FILES_libvolume-id = "${base_libdir}/libvolume_id.so.*"
FILES_${PN} += "${base_libdir}/udev/*"
FILES_${PN}-dbg += "${base_libdir}/udev/.debug"
UDEV_EXTRAS = "extras/firmware/ extras/scsi_id/ extras/volume_id/ extras/run_directory/"
EXTRA_OEMAKE += "libudevdir=/lib/udev libdir=${base_libdir} prefix="

do_install () {
	install -d ${D}${usrsbindir} \
		   ${D}${sbindir}
	oe_runmake 'DESTDIR=${D}' INSTALL=install install
	install -d ${D}${sysconfdir}/init.d
	install -m 0755 ${WORKDIR}/init ${D}${sysconfdir}/init.d/udev

	install -d ${D}${sysconfdir}/udev/rules.d/

	install -m 0644 ${WORKDIR}/mount.blacklist     ${D}${sysconfdir}/udev/
	install -m 0644 ${WORKDIR}/local.rules         ${D}${sysconfdir}/udev/rules.d/local.rules
	install -m 0644 ${WORKDIR}/permissions.rules   ${D}${sysconfdir}/udev/rules.d/permissions.rules
	install -m 0644 ${WORKDIR}/udev.rules          ${D}${sysconfdir}/udev/rules.d/udev.rules
	install -m 0644 ${WORKDIR}/links.conf          ${D}${sysconfdir}/udev/links.conf
	if [ "${UDEV_DEVFS_RULES}" = "1" ]; then
		install -m 0644 ${WORKDIR}/devfs-udev.rules ${D}${sysconfdir}/udev/rules.d/devfs-udev.rules
	fi

	install -d ${D}${sysconfdir}/udev/scripts/

	install -m 0755 ${WORKDIR}/mount.sh ${D}${sysconfdir}/udev/scripts/mount.sh
	install -m 0755 ${WORKDIR}/network.sh ${D}${sysconfdir}/udev/scripts

	install -d ${D}${base_libdir}/udev/
}

do_install_append_h2200() {
	install -m 0644 ${WORKDIR}/50-hostap_cs.rules         ${D}${sysconfdir}/udev/rules.d/50-hostap_cs.rules
}
