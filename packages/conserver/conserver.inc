DESCRIPTION = "Conserver provides remote access to serial port \
consoles and logs all data to a central host."
HOMEPAGE = "http://www.conserver.com/"
SECTION = "console/network"
LICENSE = "BSD"
SRC_URI = "http://www.conserver.com/conserver-${PV}.tar.gz"

inherit autotools

#
# Stop install being called with -s so it doesn't try and run the host strip command
#
EXTRA_OEMAKE=" INSTALL_PROGRAM=install"

#
# Include the examples in the documentation package
#
FILES_${PN}-doc += "${datadir}/examples/conserver"
