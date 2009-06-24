DESCRIPTION = "Linux Bluetooth Stack Userland libraries V4"
SECTION = "libs"
PRIORITY = "optional"
HOMEPAGE = "http://www.bluez.org"
LICENSE = "GPL"
INC_PR = "r1"

SRC_URI = "http://www.kernel.org/pub/linux/bluetooth/bluez-${PV}.tar.gz \
        file://avinfo-link.patch;patch=1;pnum=0"

S = "${WORKDIR}/bluez-${PV}"

inherit autotools_stage
AUTOTOOLS_STAGE_PKGCONFIG = "1"

EXTRA_OECONF = "\
  --disable-tools \
  --disable-audio \
  --disable-network \
  --disable-serial \
  --disable-service \
  --disable-usb \
"

FILES_${PN} = "${libdir}/libbluetooth.so.*"
