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

SRC_URI[md5sum] = "ecea69f775396e4ab6112dcf9066239f"
SRC_URI[sha256sum] = "7e2db39a4e1f41bb327a9a8ef9e5e8359aaed0cc78e642a4ca67659629e3048b"
