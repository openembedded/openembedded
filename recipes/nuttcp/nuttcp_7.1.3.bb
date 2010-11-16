DESCRIPTION = "TCP/UDP network testing tool, much like iperf"
HOMEPAGE = "http://www.wcisd.hpc.mil/nuttcp/Nuttcp-HOWTO.html"
SECTION = "console/network"
LICENSE = "GPLv2+"

SRC_URI = "http://www.wcisd.hpc.mil/nuttcp/nuttcp-${PV}.c \
        file://nuttcpd.init"
SRC_URI[md5sum] = "e5f360f8a4cb8f85754ca8708612c4a3"
SRC_URI[sha256sum] = "b8915040e576abe8678713fba01125dd246821f4b426e095e5c9bb2c559a2384"

S = "${WORKDIR}"

inherit update-rc.d

do_compile() {
        ${CC} ${LDFLAGS} nuttcp-${PV}.c -o nuttcp
}
do_install() {
        install -d ${D}${sysconfdir}/init.d
        install -m 0755 ${WORKDIR}/nuttcpd.init ${D}${sysconfdir}/init.d/nuttcp
        install -d ${D}${sbindir}
        install -m 0755 nuttcp ${D}${sbindir}
}

INITSCRIPT_NAME = "nuttcp"
INITSCRIPT_PARAMS = "defaults 60"
