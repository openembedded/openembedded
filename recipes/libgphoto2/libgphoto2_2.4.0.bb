DESCRIPTION = "libgphoto2 allows you to access digital cameras"

SECTION = "libs"
LICENSE = "GPL"
DEPENDS = "libtool jpeg virtual/libusb0 libexif"

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



SRC_URI[md5sum] = "a60154772635b693ff08b4f34dea7f61"
SRC_URI[sha256sum] = "0dc26b7a8568dee7634bebbaf9f7d3e3ab9460424e6297a595e41c4fddbbdb79"
