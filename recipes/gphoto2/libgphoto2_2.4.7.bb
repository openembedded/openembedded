DESCRIPTION = "libgphoto2 allows you to access digital cameras"
SECTION = "libs"
LICENSE = "GPL"
DEPENDS = "libtool jpeg virtual/libusb0 libexif"

# The .fdi and .rules files were generated with:
#  libgphoto2-2.4.7/packaging/generic$ qemu-arm -s 1048576 -r 2.6.24 -L /OE/angstrom-dev/staging/armv5te-angstrom-linux-gnueabi/ .libs/print-camera-list
# They are release specific, so please regen when adding new releases

SRC_URI = "${SOURCEFORGE_MIRROR}/gphoto/libgphoto2-${PV}.tar.bz2 \
           file://10-camera-libgphoto2-device.fdi \
           file://10-camera-libgphoto2.fdi \
           file://90-libgphoto2.rules \
"

PR = "r1"

inherit autotools pkgconfig lib_package

OE_LT_RPATH_ALLOW=":${libdir}:"
OE_LT_RPATH_ALLOW[export]="1"

EXTRA_OECONF = " --with-drivers=all ac_cv_lib_ltdl_lt_dlcaller_register=yes"

do_configure_append() {
	cd ${S}/libgphoto2_port/
	autoreconf -Wcross --verbose --install --force ${EXTRA_AUTORECONF} $acpaths
	cd ${S}
}

do_install_append() {
    install -d ${D}${datadir}/hal/fdi/information/20thirdparty
    install -m 0644 ${WORKDIR}/*.fdi ${D}${datadir}/hal/fdi/information/20thirdparty/

    install -d ${D}${sysconfdir}/udev/rules.d/
    install -m 0755 ${WORKDIR}/*.rules ${D}${sysconfdir}/udev/rules.d/

    install -d ${D}${bindir}
    install -m 0755 ${S}/packaging/generic/check-ptp-camera ${D}${bindir}/
}

PACKAGES =+ "libgphotoport libgphoto2-camlibs"
FILES_libgphoto2-camlibs = "${libdir}/libgphoto2*/*/*.so*"
RDEPENDS_${PN} = "libgphoto2-camlibs"

FILES_libgphotoport = "${libdir}/libgphoto2_port.so.*" 

FILES_${PN} += "${libdir}/udev/* ${datadir}/hal"
FILES_${PN}-dbg += "${libdir}/*/*/.debug"



