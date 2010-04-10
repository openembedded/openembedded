DESCRIPTION = "Devicekit power"
LICENSE = "GPLv2"
DEPENDS = "devicekit glib-2.0 dbus-glib policykit"

SRC_URI = "http://hal.freedesktop.org/releases/DeviceKit-power-${PV}.tar.gz"
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



SRC_URI[md5sum] = "535703fa7b9c323d6388b5aff28cfeeb"
SRC_URI[sha256sum] = "438ac7f22533e04f5b44e0cf23d8b51a5cb69906ea2bbdef0581dc3c7cf19e55"
