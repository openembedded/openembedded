DEPENDS = "udev"
LICENSE = "LGPL"

SRCREV = "a80d7d5c25e88adea7b8e843cdb57143e6cfb46b"
SRC_URI = "git://git.0pointer.de/libatasmart.git;protocol=git \
	file://strpool.patch"

S = "${WORKDIR}/git"
PR = "r2"

inherit autotools lib_package

do_install_append() {
	sed -i -e s://:/:g -e s:${base_libdir}/libudev.la:-ludev:g ${D}${libdir}/libatasmart.la
}
