DESCRIPTION = "dvd+rw-tools makes it possible to burn DVD images"
MAINTAINER = "Felix Domke <tmbinc@elitedvb.net>
LICENSE = "GPL"
SECTION = "optional"

#patches are based of debian version 7.1-4

SRC_URI = "http://fy.chalmers.se/~appro/linux/DVD+RW/tools/${PN}-${PV}.tar.gz \
	file://01-growisofs-pioneer.patch;patch=1;pnum=1 \
	file://03-growisofs-dvd-dl.patch;patch=1;pnum=1 \
	file://05-beeping.patch;patch=1;pnum=1 \
	file://08-includes.patch;patch=1;pnum=1 \
	file://09-wctomb.patch"

inherit autotools

EXTRA_OEMAKE = "'CC=${CC}' 'CXX=${CXX}' \
		'CFLAGS=${CFLAGS} ${LDFLAGS}' 'prefix=${D}'"
