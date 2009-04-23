DESCRIPTION = "The tunctl tool for controlling the TUN/TAP driver in Linux."
SECTION = "net"
LICENSE = "GPL"

SRC_URI = "${SOURCEFORGE_MIRROR}/tunctl/tunctl-${PV}.tar.gz"

do_compile() {
	oe_runmake tunctl
}

do_install() {
	install -d ${D}/${sbindir}
	install -m 755 tunctl ${D}/${sbindir}
}
