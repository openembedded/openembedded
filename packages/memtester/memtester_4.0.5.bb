SECTION = "console/utils"
DESCRIPTION = "Utility to test for faulty memory subsystem"
MAINTAINER = "Chris Larson <kergoth@handhelds.org>"
LICENSE = "GPLv2"
PR = "r1"

SRC_URI = "http://pyropus.ca/software/memtester/memtester-${PV}.tar.gz"
SRC_URI += "file://Makefile.patch;patch=1"

S = "${WORKDIR}/memtester-${PV}"

do_compile () {
	echo '${CC} ${CFLAGS} -DPOSIX -c' > conf-cc
	echo '${CC} ${LDFLAGS}' > conf-ld
	oe_runmake
}

do_install () {
	install -d ${D}${bindir}
	install -d ${D}${mandir}/man8
	install -m 0755 memtester ${D}${bindir}/
	install -m 0755 memtester.8 ${D}${mandir}/man8/
}
