MAINTAINER="Oyvind Repvik <nail@nslu2-linux.org>"
DESCRIPTION="Scanner drivers for SANE"
PR="r0"
DEPENDS="jpeg libusb"

SRC_URI="ftp://ftp.sane-project.org/pub/sane/sane-backends-${PV}/sane-backends-${PV}.tar.gz \
	file://sane-plustek.patch;patch=1\
	file://Makefile.in.patch;patch=1"
	
EXTRA_OECONF="--prefix=/usr --sysconfdir=/etc --disable-translations"

inherit autotools


