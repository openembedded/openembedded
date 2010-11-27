SECTION = "network/misc"
DESCRIPTION = "DCE Service enumerator for MS Windows systems"
PV = "2.0"
PR = "r0"

SRC_URI = "http://packetstorm.linuxsecurity.com/UNIX/scanners/dcetest-2.0.tar.gz"

DEFAULT_PREFERENCE="-1"


S = "${WORKDIR}/dcetest"
LICENSE = "GPL"
do_compile() {
	oe_runmake dcetest
}

do_install() {
	install -d ${D}${bindir}
	install -m 0755 ${S}/dcetest ${D}${bindir}
}

SRC_URI[md5sum] = "74ee7617c8b01cc641992c1d13dc394b"
SRC_URI[sha256sum] = "4a319a08ae0838234f5b6fbd0b4d2e0fac7560a7553a4e1b043527cc17032aa3"
