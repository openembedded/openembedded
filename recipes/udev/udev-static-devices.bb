DESCRIPTION = "Provide per-machine static nodes of /dev"
RDEPENDS_${PN} = "udev"

PR = "r1"

SRC_URI = "file://udev_static_devices_tarball"

FILES_${PN} += "${base_libdir}/udev/*"

do_install () {
	install -d ${D}${base_libdir}/udev/devices
	if [ -s ${WORKDIR}/udev_static_devices_tarball ]; then
		install -m 0644 ${WORKDIR}/udev_static_devices_tarball ${D}${base_libdir}/udev/devices.tar.gz
	fi
}

pkg_postinst () {
	ROOT="$D"
	if [ -f "$ROOT/lib/udev/devices.tar.gz" ]; then
		tar -C "$ROOT/lib/udev" -zxf "$ROOT/lib/udev/devices.tar.gz" || exit $?
	fi
}
