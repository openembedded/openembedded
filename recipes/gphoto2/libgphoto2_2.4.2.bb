DESCRIPTION = "libgphoto2 allows you to access digital cameras"

SECTION = "libs"
LICENSE = "GPL"
DEPENDS = "libtool jpeg virtual/libusb0 libexif"

PR = "r0"

SRC_URI = "${SOURCEFORGE_MIRROR}/gphoto/libgphoto2-${PV}.tar.bz2"

inherit autotools pkgconfig lib_package

OE_LT_RPATH_ALLOW=":${libdir}:"
OE_LT_RPATH_ALLOW[export]="1"

EXTRA_OECONF = " --with-drivers=all ac_cv_lib_ltdl_lt_dlcaller_register=yes"

PACKAGES =+ "libgphotoport libgphoto2-camlibs"
FILES_libgphoto2-camlibs = "${libdir}/libgphoto2*/*/*.so*"
RDEPENDS_${PN} = "libgphoto2-camlibs"

FILES_libgphotoport = "${libdir}/libgphoto2_port.so.*" 

FILES_${PN} += "${libdir}/udev/*"
FILES_${PN}-dbg += "${libdir}/*/*/.debug"

do_stage() {
        autotools_stage_all
}



SRC_URI[md5sum] = "714859617c0b616855f6906280010c5d"
SRC_URI[sha256sum] = "f319655b272186ad76ab73317b7e8c5e3b87d51c1265ce676f02e8c312745226"
