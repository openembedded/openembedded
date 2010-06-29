DESCRIPTION = "Devicekit power"
LICENSE = "GPLv2"
DEPENDS = "devicekit glib-2.0 dbus-glib policykit"

SRC_URI = "http://cgit.freedesktop.org/DeviceKit/DeviceKit-power/snapshot/DeviceKit-power-${PV}.tar.gz"
S = "${WORKDIR}/DeviceKit-power-${PV}"

inherit autotools pkgconfig

do_configure_prepend() {
	sed -i -e s:-nonet:\:g ${S}/doc/man/Makefile.am
}	

FILES_${PN} += "${datadir}/dbus-1/ \
                ${datadir}/PolicyKit \
                ${base_libdir}/udev/* \
               "

FILES_${PN}-dbg += "${base_libdir}/udev/.debug"

SRC_URI[md5sum] = "2ec93fbd14926101a12c9e4dbbe5937f"
SRC_URI[sha256sum] = "6dfa2623cb5c0b2df9aff00ad6d3213815d7de498855cc6f72c2cd18d50a4cd1"
