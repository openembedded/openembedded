SECTION = "console/network"
DESCRIPTION = "netkit-ftp includes a commandline ftp client."
LICENSE = "BSD"
SRC_URI = "ftp://ftp.uk.linux.org/pub/linux/Networking/netkit/netkit-ftp-${PV}.tar.gz \
	   file://mconfig.patch;patch=1"

EXTRA_OEMAKE = ""
do_compile () {
	oe_runmake 'CC=${CC}' 'LD=${LD}' all
}

do_install () {
	install -d ${D}${bindir}
	install -m 0755 ftp/ftp ${D}${bindir}
}
