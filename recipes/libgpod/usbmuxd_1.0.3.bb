DESCRIPTION = "This daemon is in charge of multiplexing connections over USB to an iPhone or iPod touch."
LICENSE = "GPLv3/GPLv2/LGPLv2.1"

DEPENDS = "udev libusb1"

inherit cmake pkgconfig

SRC_URI = "http://marcansoft.com/uploads/usbmuxd/usbmuxd-${PV}.tar.bz2;name=archive"
SRC_URI[archive.md5sum] = "a29d017c092ecd76025eef3d01517221"
SRC_URI[archive.sha256sum] = "33cc53afdd20bdfe24e9efcf1b094b7ed0b58908cacf6acd75d4e885a868f8e9"

# Yes, /lib, not ${base_libdir}, see udev recipe
FILES_${PN} += "/lib/udev/rules.d/"

