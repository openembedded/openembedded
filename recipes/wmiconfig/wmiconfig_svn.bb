DESCRIPTION = "Atheros 6K Wifi configuration utility"
LICENSE = "GPL"
SECTION = "console/network"
SRCREV = "5394"
PV = "0.0.0+svnr${SRCPV}"
PR = "r1"

SRC_URI = "svn://svn.openmoko.org/trunk/src/target;module=AR6kSDK.build_sw.18;proto=http"
S = "${WORKDIR}/AR6kSDK.build_sw.18/host/tools/wmiconfig"

export CC := "${CC}"

TARGET_CC_ARCH += "${LDFLAGS}"

do_install() {
	install -d ${D}${bindir}
	install -m 0755 wmiconfig ${D}${bindir}
}

