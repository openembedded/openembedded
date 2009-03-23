DESCRIPTION = "Firmware converter for the IXP4xx line of devices"
LICENSE = "Intel Software License Agreement"
PR = "r0"

SRC_URI = "http://You-Have-To-Download-The-Microcode-Manually-So-Please-Read-ixp4xx-npe_2.4.bb-For-Instructions/IPL_ixp400NpeLibrary-2_4.zip"
SRC_URI += "file://IxNpeMicrocode.h"
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
