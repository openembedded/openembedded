DESCRIPTION = "NPE firmware for the IXP4xx line of devices"
LICENSE = "Intel Public Licence"
PR = "r1"
DEPENDS = "ixp4xx-npe-native"

# You need to download the IPL_ixp400NpeLibrary-2_3_2.zip file (without crypto) from:
# http://www.intel.com/design/network/products/npfamily/ixp400_current.htm
# and put it in your downloads directory so bitbake will find it.
# Make sure you *read* and accept the license - it is not a standard one.

SRC_URI = "http://You-Have-To-Download-The-Microcode-Manually-So-Please-Read-ixp4xx-npe_2.3.2.bb-For-Instructions/IPL_ixp400NpeLibrary-2_3_2.zip"
S = "${WORKDIR}/ixp400_xscale_sw/src/npeDl"

COMPATIBLE_MACHINE = "(nslu2|ixp4xx)"

FILES_${PN} = "${base_libdir}/firmware/NPE-B ${base_libdir}/firmware/NPE-C"

do_compile() {
	${STAGING_BINDIR_NATIVE}/IxNpeMicrocode-${PV} -be
}

do_install() {
	install -d ${D}/${base_libdir}/firmware/
	rm ${S}/NPE-B
	mv ${S}/NPE-B.* ${S}/NPE-B
	install ${S}/NPE-B ${D}/${base_libdir}/firmware/
	rm ${S}/NPE-C
	mv ${S}/NPE-C.* ${S}/NPE-C
	install ${S}/NPE-C ${D}/${base_libdir}/firmware/
}

do_stage() {
	install -d ${STAGING_FIRMWARE_DIR}
	install ${S}/NPE-B ${STAGING_FIRMWARE_DIR}/
	install ${S}/NPE-C ${STAGING_FIRMWARE_DIR}/
}

