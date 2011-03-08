DESCRIPTION = "Drivers and libraries for the Xbox Kinect device"
LICENSE = "GPLv2"

DEPENDS = "libusb1 freeglut libxi libxmu"

PV = "0.0"
PR = "r0+gitr${SRCPV}"
SRCREV = "3b0f4160b1d56c277014"
SRC_URI = "git://github.com/OpenKinect/libfreenect.git;protocol=git"

inherit cmake

S = "${WORKDIR}/git"



