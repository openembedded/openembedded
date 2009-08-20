DESCRIPTION = "Devicekit power"
LICENSE = "GPLv2"
DEPENDS = "devicekit glib-2.0 dbus-glib policykit"

SRC_URI = "http://hal.freedesktop.org/releases/DeviceKit-power-${PV}.tar.gz"
S = "${WORKDIR}/DeviceKit-power-${PV}"

inherit autotools pkgconfig

do_stage() {
        autotools_stage_all
}

FILES_${PN} += "${datadir}/dbus-1/ \
                ${datadir}/PolicyKit \
                ${base_libdir}/udev/* \
               "

FILES_${PN}-dbg += "${base_libdir}/udev/.debug"


