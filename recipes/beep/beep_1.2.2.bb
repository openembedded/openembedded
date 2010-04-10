# beep: a console utility to "and allow a little more granularity
# than you get with the default terminal bell"
DESCRIPTION = "A console utility to make a beep noise"
SECTION = "console/utils"
LICENSE = "GPL"
PR = "r3"

SRC_URI  = "http://johnath.com/beep/beep-${PV}.tar.gz"
SRC_URI += "file://linux-input.patch;patch=1"

S = "${WORKDIR}/beep-${PV}"

EXTRA_OEMAKE += 'CC="${CC}"'
EXTRA_OEMAKE += 'FLAGS="${CFLAGS} ${LDFLAGS}"'

# slugos requires beep in boot
BINDIR = "${bindir}"
BINDIR_slugos = "${base_bindir}"

do_install() {
	# this is easier than patching the Makefile...
	install -d "${D}${BINDIR}"
	install -c -m 755 beep "${D}${BINDIR}/beep"
	install -d "${D}${mandir}/man1"
	install -c -m 644 beep.1.gz "${D}${mandir}/man1/beep.1.gz"
}

SRC_URI[md5sum] = "d541419fd7e5642952d7b48cbb40c712"
SRC_URI[sha256sum] = "5c0445dac43950b7c7c3f235c6fb21f620ab3fd2f3aafaf09896e5730fcf49a1"
