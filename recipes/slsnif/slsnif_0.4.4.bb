DESCRIPTION = "slsnif is a serial line sniffer. \
It listens to the specified serial port and logs all data coming through it. \
slsnif works transparently for both the device connected to the serial port \
and the controlling software for this device."
LICENSE = "GPL"
SECTION = "console"
PR = "r0"

SRC_URI = "http://www.dakotacom.net/~ymg/files/slsnif-${PV}.tar.gz"

inherit autotools



SRC_URI[md5sum] = "78eeff8ba36ee0c3a954ec0878d2a997"
SRC_URI[sha256sum] = "315eb08a14255c137b435cb4f3c1dbfa67427be1c6bec62ff77a54246161c83e"
