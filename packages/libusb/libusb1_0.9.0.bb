DESCRIPTION = "libusb is a library to provide userspace \
access to USB devices."
HOMEPAGE = "http://libusb.sf.net"
SECTION = "libs"
LICENSE = "LGPL"

SRC_URI = "\
  ${SOURCEFORGE_MIRROR}/libusb/libusb-${PV}.tar.bz2 \
"
S = "${WORKDIR}/libusb-${PV}"

inherit autotools pkgconfig binconfig lib_package

PARALLEL_MAKE = ""
EXTRA_OECONF = "--disable-build-docs"

export CXXFLAGS += "-lstdc++ -I${STAGING_INCDIR}"

LIBTOOL = "${HOST_SYS}-libtool"
EXTRA_OEMAKE = "'LIBTOOL=${LIBTOOL}'"

do_stage() {
	autotools_stage_all
}

PACKAGES =+ "libusbpp"
FILES_libusbpp = "${libdir}/libusbpp*.so.*"
