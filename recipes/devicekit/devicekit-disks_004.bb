DESCRIPTION = "Block device part of devicekit"
LICENSE = "GPLv2"
DEPENDS = "devicekit zlib sqlite3 policykit parted device-mapper libatasmart udev dbus-glib glib-2.0"

SRC_URI = "http://hal.freedesktop.org/releases/DeviceKit-disks-${PV}.tar.gz"
S = "${WORKDIR}/DeviceKit-disks-${PV}"

inherit autotools_stage
AUTOTOOLS_STAGE_PKGCONFIG = "1"

FILES_${PN} += "${datadir}/dbus-1/ \
                ${datadir}/PolicyKit \
                ${base_libdir}/udev/* \
"

FILES_${PN}-dbg += "${base_libdir}/udev/.debug"


