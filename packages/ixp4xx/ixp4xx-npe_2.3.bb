DESCRIPTION = "NPE firmware for the IXP4xx line of devices"
LICENSE = "Intel Public Licence"
PR = "r6"
DEPENDS = "ixp4xx-npe-native"

SRC_URI = "http://www.intel.com/Please-Read-The-BB-File/IPL_ixp400NpeLibrary-2_3.zip"
S = ${WORKDIR}/ixp400_xscale_sw/src/npeDl

FILES_${PN} = "${base_libdir}/firmware/NPE-B"

do_compile() {
#        if test '${ARCH_BYTE_SEX}' = be
#        then
		${STAGING_BINDIR}/IxNpeMicrocode-${PV} -be
#        fi
#        if test '${ARCH_BYTE_SEX}' = le
#        then
#                ${STAGING_BINDIR}/IxNpeMicrocode-${PV} -le
#        fi
}

do_install() {
	install -d ${D}/${base_libdir}/firmware/
	rm ${S}/NPE-B
	mv ${S}/NPE-B.* ${S}/NPE-B
	install ${S}/NPE-B ${D}/${base_libdir}/firmware/
}

