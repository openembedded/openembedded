DESCRIPTION = "Firmware converter for the IXP4xx line of devices"
LICENSE = "Intel Public Licence"
PR = "r1"

SRC_URI = "http://You-Have-To-Download-The-Microcode-Manually-So-Please-Read-ixp4xx-npe_2.3.2.bb-For-Instructions/IPL_ixp400NpeLibrary-2_3_2.zip"
SRC_URI += "file://IxNpeMicrocode.h"
do_unpack[depends] += "unzip-native:do_populate_staging"
inherit native
S = "${WORKDIR}/ixp400_xscale_sw/src/npeDl"

do_compile() {
	mv ${WORKDIR}/IxNpeMicrocode.h ${S}/
	gcc -Wall IxNpeMicrocode.c -o IxNpeMicrocode
}

do_stage() {
	mv ${S}/IxNpeMicrocode ${S}/IxNpeMicrocode-${PV}
	install -d ${STAGING_BINDIR}/
	install -m 0755 ${S}/IxNpeMicrocode-${PV} ${STAGING_BINDIR}/
}

SRC_URI[md5sum] = "7cecfaae78431a851bc854264a5ee994"
SRC_URI[sha256sum] = "31e1c0fb75d1463a6a8badd621d8169e2f8c681d9eb876ff9d5bb261f0e6b451"
