SECTION = "libs"
DEPENDS = "jpeg libusb libexif"
RPEDENDS = "libusb"
DESCRIPTION = "libgphoto2 allows you to access digital cameras"
PR = "r5"

SRC_URI = "${SOURCEFORGE_MIRROR}/gphoto/libgphoto2-${PV}.tar.gz"

EXTRA_OECONF = " --with-drivers=all"
EXTRA_OECONF_mnci = "--with-drivers=canon --without-serial"
LICENSE = "GPL"
inherit autotools pkgconfig

do_stage() {
	autotools_stage_all
}

PACKAGES =+ "libgphoto2-camlibs"
FILES_libgphoto2-camlibs = "/usr/lib/gphoto2_port/ /usr/lib/gphoto2/"
RDEPENDS_libgphoto2 = "libgphoto2-camlibs"
