DESCRIPTION = "Devicekit power"
LICENSE = "GPLv2"
DEPENDS = "libusb1 udev glib-2.0 dbus-glib policykit"

SRC_URI = "http://hal.freedesktop.org/releases/DeviceKit-power-${PV}.tar.gz;name=archive"
SRC_URI[archive.md5sum] = "935d37f1e14b3c8a1d6dabcd9a38d3ca"
SRC_URI[archive.sha256sum] = "ad3e9a8bd9525d66fadc7fa53ef99e0632aa8cca8fd5bc27483956261153b373"

S = "${WORKDIR}/DeviceKit-power-${PV}"

inherit autotools pkgconfig

EXTRA_OECONF = " --with-backend=linux"

do_configure_prepend() {
	sed -i -e s:-nonet:\:g ${S}/doc/man/Makefile.am
}	

FILES_${PN} += "${datadir}/dbus-1/ \
                ${datadir}/polkit-1/ \
                ${base_libdir}/udev/* \
               "

FILES_${PN}-dbg += "${base_libdir}/udev/.debug"


