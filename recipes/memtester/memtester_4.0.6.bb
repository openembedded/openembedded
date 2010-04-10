SECTION = "console/utils"
DESCRIPTION = "Utility to test for faulty memory subsystem"
LICENSE = "GPLv2"
PR = "r0"

SRC_URI = "http://pyropus.ca/software/memtester/old-versions/memtester-${PV}.tar.gz"
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

SRC_URI[md5sum] = "0e6f7335075443ed0863a0df75689359"
SRC_URI[sha256sum] = "2a4bf8bdac96d6498e323b93954099fb13a9d92ddd5704aa6553940b86a071bb"
