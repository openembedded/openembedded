require gpsd.inc

DEPENDS += "libusb1"

SRC_URI += "file://libtool.patch \
	    file://configure-libusb.patch"
SRC_URI[gpsd.md5sum] = "ce70bcd707ac1df861d4c72f503c09d1"
SRC_URI[gpsd.sha256sum] = "1520b87d106d198aa42137db4b230615dbd0d06b04e6fcc84e010172fba2da41"

PR = "${INC_PR}.1"

PARALLEL_MAKE = ""

do_install_append() {
	install -d ${D}${base_libdir}/udev/
	install -m 0755 ${S}/gpsd.hotplug.wrapper ${D}${base_libdir}/udev/
}
