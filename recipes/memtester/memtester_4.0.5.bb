SECTION = "console/utils"
DESCRIPTION = "Utility to test for faulty memory subsystem"
LICENSE = "GPLv2"
PR = "r2"

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

SRC_URI[md5sum] = "f6328b4863caf8f2013489c82c26cd1d"
SRC_URI[sha256sum] = "cd907918ff4a7d1eea4ed618c181da0e0894bcfcdb1e3e4909a2795da120ae4c"
