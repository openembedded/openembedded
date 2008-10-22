DESCRIPTION = "libgphoto2 allows you to access digital cameras"

SECTION = "libs"
LICENSE = "GPL"
DEPENDS = "libtool jpeg libusb libexif"

PR = "r0"

SRC_URI = "${SOURCEFORGE_MIRROR}/gphoto/libgphoto2-${PV}.tar.bz2"

inherit autotools pkgconfig lib_package

OE_LT_RPATH_ALLOW=":${libdir}:"
OE_LT_RPATH_ALLOW[export]="1"

EXTRA_OECONF = " --with-drivers=all"

PACKAGES =+ "libgphotoport libgphoto2-camlibs"
FILES_libgphoto2-camlibs = "${libdir}/libgphoto2*/*/*.so*"
RDEPENDS_${PN} = "libgphoto2-camlibs"

FILES_libgphotoport = "${libdir}/libgphoto2_port.so.*" 

FILES_${PN} += "${libdir}/udev/*"
FILES_${PN}-dbg += "${libdir}/*/*/.debug"

do_stage() {
        autotools_stage_all
}


