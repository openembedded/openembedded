DESCRIPTION = "Necessary packages for development at runtime environment"
LICENSE = "MIT"
PR = "r2"
ALLOW_EMPTY = "1"

PACKAGES = "${PN}"

RDEPENDS = "\
  gdb \
  strace \
  udev-usbserial \
"