DESCRIPTION = "hdparm is a Linux shell utility for viewing \
and manipulating various IDE drive and driver parameters."
SECTION = "console/utils"
PRIORITY = "optional"
LICENSE = "BSD"

SRC_URI = "${SOURCEFORGE_MIRROR}/hdparm/hdparm-${PV}.tar.gz \
	   file://bswap.patch;patch=1 \
	   file://uclibc.patch;patch=1"

do_install () {
	install -d ${D}/${sbindir} ${D}/${mandir}/man8
	oe_runmake 'DESTDIR=${D}' install
}

SRC_URI[md5sum] = "0c12672f3a09c14ad0b0882f15fc9389"
SRC_URI[sha256sum] = "08688a6a46ba495494bf838f8f26103e797584c1888eca94e43a171e1b37246d"
