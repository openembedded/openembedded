DESCRIPTION = "Library for controlling displaylink based usb devices"
LICENSE = "LGPLv2"

SRCREV = "d50f082699787c3c6531df431b35c9ad52a82667"
PV = "0.1.0"
PR_append = "+gitr${SRCREV}"

SRC_URI = "git://anongit.freedesktop.org/libdlo;protocol=git"
S = "${WORKDIR}/git"

inherit lib_package autotools

do_configure_prepend() {
	sed -i -e s:63:61: configure.ac
}

do_install_append() {
	mv ${D}${bindir}/test1 ${D}${bindir}/libdlo-test1
}

