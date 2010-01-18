DESCRIPTION = "Linux Bluetooth Stack Userland libraries V4"
SECTION = "libs"
PRIORITY = "optional"
HOMEPAGE = "http://www.bluez.org"
LICENSE = "GPL"
INC_PR = "r1"

FILESPATHPKG .= ":bluez4-${PV}:bluez4"

SRC_URI = "http://www.kernel.org/pub/linux/bluetooth/bluez-${PV}.tar.gz"

S = "${WORKDIR}/bluez-${PV}"

#inherit autotools_stage pkgconfig
inherit autotools_stage

EXTRA_OECONF = "\
  --disable-tools \
  --disable-audio \
  --disable-network \
  --disable-serial \
  --disable-service \
  --disable-usb \
"

FILES_${PN} = "${libdir}/libbluetooth.so.*"
FILES_${PN}-dev += "\
  ${libdir}/bluetooth/plugins/*.la \
  ${libdir}/alsa-lib/*.la \
  ${libdir}/gstreamer-0.10/*.la \
"
