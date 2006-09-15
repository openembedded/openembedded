DESCRIPTION = "Firmware converter for the IXP4xx line of devices"
MAINTAINER = "Oyvind Repvik <nail@nslu2-linux.org>"
LICENSE = "Intel Public Licence"
PR = "r1"

SRC_URI = "http://www.intel.com/Please-Read-The-BB-File/IPL_ixp400NpeLibrary-2_3.zip"
SRC_URI += "file://header.patch;patch=1"
inherit native
S = ${WORKDIR}/ixp400_xscale_sw/src/npeDl

do_compile() {
	${CC} -Wall IxNpeMicrocode.c -o IxNpeMicrocode
}

do_stage() {
	install -d ${STAGING_BINDIR}/
	install -m 0755 IxNpeMicrocode ${STAGING_BINDIR}/IxNpeMicrocode
}
