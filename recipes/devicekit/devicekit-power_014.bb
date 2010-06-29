DESCRIPTION = "Devicekit power"
LICENSE = "GPLv2"
DEPENDS = "libusb1 udev glib-2.0 dbus-glib policykit"


SRC_URI = "http://cgit.freedesktop.org/DeviceKit/DeviceKit-power/snapshot/DeviceKit-power-${PV}.tar.gz;name=archive"

SRC_URI[archive.md5sum] = "570846c933df16b768082879b5ee0605"
SRC_URI[archive.sha256sum] = "ae450e86443df825b31a664562f12117983ebd7d106f5c5cd82ca2f38791166d"

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


