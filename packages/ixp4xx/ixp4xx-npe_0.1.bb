DESCRIPTION = "Firmware for the IXP4xx line of devices"
MAINTAINER = "Oyvind Repvik <nail@nslu2-linux.org>"
LICENSE = "Intel Public Licence"
PR = "r0"

SRC_URI = "http://www.intel.com/Please-Read-The-BB-File/IPL_ixp400AccessLibrary-2_1.zip"
inherit native
S = ${WORKDIR}/ixp400_xscale_sw/src/npeDl

do_compile() {
	${CC} -Wall IxNpeMicrocode.c -o IxNpeMicrocode
	${S}/IxNpeMicrocode 
}

do_install() {
	install -d ${D}/usr/lib/firmware/NPE-B
	install ${S}/NPE-B.010c0200 ${D}/usr/lib/firmware/NPE-B/
}
