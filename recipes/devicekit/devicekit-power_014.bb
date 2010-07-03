DESCRIPTION = "Devicekit power"
LICENSE = "GPLv2"
DEPENDS = "libusb1 udev glib-2.0 dbus-glib policykit"


SRC_URI = "http://www.angstrom-distribution.org/unstable/sources/DeviceKit-power-014.tar.gz"

SRC_URI[md5sum] = "115eed840713d53f073f2d431571662e"
SRC_URI[sha256sum] = "8157388102569b1a0dcd8b26aea754d0159803795280ca96c852f8350d2aa354"

S = "${WORKDIR}/DeviceKit-power-${PV}"

inherit autotools pkgconfig

EXTRA_OECONF = " --with-backend=linux"

do_configure_prepend() {
	gtkdocize
	sed -i -e s:-nonet:\:g ${S}/doc/man/Makefile.am
}	

FILES_${PN} += "${datadir}/dbus-1/ \
                ${datadir}/polkit-1/ \
                ${base_libdir}/udev/* \
               "

FILES_${PN}-dbg += "${base_libdir}/udev/.debug"


