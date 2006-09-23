DESCRIPTION = "NPE firmware for the IXP4xx line of devices"
MAINTAINER = "Oyvind Repvik <nail@nslu2-linux.org>"
LICENSE = "Intel Public Licence"
PR = "r4"
DEPENDS = "ixp4xx-npe-native"

SRC_URI = "http://www.intel.com/Please-Read-The-BB-File/IPL_ixp400NpeLibrary-2_1.zip"
S = ${WORKDIR}/ixp400_xscale_sw/src/npeDl

FILES_${PN} = "${base_libdir}/firmware/NPE-B"

do_compile() {
	${STAGING_BINDIR}/IxNpeMicrocode 
}

do_install() {
	install -d ${D}/${base_libdir}/firmware/
        mv ${S}/NPE-B.010c0200 ${S}/NPE-B
	install ${S}/NPE-B ${D}/${base_libdir}/firmware/
}

