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
