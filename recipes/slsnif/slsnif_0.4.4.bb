DESCRIPTION = "slsnif is a serial line sniffer. \
It listens to the specified serial port and logs all data coming through it. \
slsnif works transparently for both the device connected to the serial port \
and the controlling software for this device."
LICENSE = "GPL"
SECTION = "console"
PR = "r0"

SRC_URI = "http://www.dakotacom.net/~ymg/files/slsnif-${PV}.tar.gz"

inherit autotools


