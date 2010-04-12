SECTION = "console/network"
DESCRIPTION = "netkit-tftp includes a commandline tftp client."
LICENSE = "BSD"
SRC_URI = "ftp://ftp.uk.linux.org/pub/linux/Networking/netkit/netkit-tftp-${PV}.tar.gz \
	   file://mconfig.patch;patch=1"

EXTRA_OEMAKE = ""
do_compile () {
	oe_runmake 'CC=${CC}' 'LD=${LD}' all
}

do_install () {
	install -d ${D}${bindir}
	install -m 0755 tftp/tftp ${D}${bindir}
}

SRC_URI[md5sum] = "b7262c798e2ff50e29c2ff50dfd8d6a8"
SRC_URI[sha256sum] = "3a43c0010d4e61f412563fd83769d4667d8b8e82903526d21cb9205fe55ad14d"
