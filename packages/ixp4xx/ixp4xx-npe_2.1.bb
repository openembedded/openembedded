DESCRIPTION = "NPE firmware for the IXP4xx line of devices"
LICENSE = "Intel Public Licence"
PR = "r6"
DEPENDS = "ixp4xx-npe-native"

SRC_URI = "http://www.intel.com/Please-Read-The-BB-File/IPL_ixp400NpeLibrary-2_1.zip"
S = "${WORKDIR}/ixp400_xscale_sw/src/npeDl"

COMPATIBLE_MACHINE = "(nslu2|ixp4xx)"

FILES_${PN} = "${base_libdir}/firmware/NPE-B"

do_compile() {
	${STAGING_BINDIR_NATIVE}/IxNpeMicrocode-${PV} -be
}

do_install() {
	install -d ${D}/${base_libdir}/firmware/
	rm ${S}/NPE-B
	mv ${S}/NPE-B.* ${S}/NPE-B
	install ${S}/NPE-B ${D}/${base_libdir}/firmware/
}

