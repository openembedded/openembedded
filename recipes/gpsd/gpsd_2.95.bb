require gpsd.inc

DEPENDS += "libusb1"

SRC_URI += "file://libtool.patch \
	   "
EXTRA_OECONF += "--disable-libQgpsmm"

SRC_URI[gpsd.md5sum] = "12535a9ed9fecf9ea2c5bdc9840da5ae"
SRC_URI[gpsd.sha256sum] = "832343a53921a8371efa540ba57c91dadedda445e571c1beb97c06539ef450ae"

PR = "${INC_PR}.0"

PARALLEL_MAKE = ""

do_install_append() {
	install -d ${D}${base_libdir}/udev/
	install -m 0755 ${S}/gpsd.hotplug.wrapper ${D}${base_libdir}/udev/
}
