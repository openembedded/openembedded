DESCRIPTION = "Data files for usbmodeswitch"
LICENSE = "GPLv2"
RDEPENDS_${PN} = "\
    usb-modeswitch \
    tcl \
"
PR="r2"

SRC_URI = "http://www.draisberghof.de/usb_modeswitch/usb-modeswitch-data-${PV}.tar.bz2 \
           file://fix-install-in-makefile.patch \
          "
SRC_URI[md5sum] = "85c16bb87a6f05c2d04b93a22fe87e91"
SRC_URI[sha256sum] = "a81821d3d9ad9e1d3a31ea11d0da9841ca84350f0b445a8f9ea2dbd142cefb46"

do_install() {
	oe_runmake install DESTDIR=${D}
}

PACKAGE_ARCH = "all"
FILES_${PN} += "${base_libdir}/udev/rules.d/40-usb_modeswitch.rules"
