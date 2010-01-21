SECTION = "console/network"
DESCRIPTION = "netkit-ftp includes a commandline ftp client."
LICENSE = "BSD"
SRC_URI = "ftp://ftp.uk.linux.org/pub/linux/Networking/netkit/netkit-ftp-${PV}.tar.gz \
	   file://mconfig.patch;patch=1 \
       http://ftp.de.debian.org/debian/pool/main/n/netkit-ftp/netkit-ftp_0.17-19.diff.gz;patch=1 "

PR = "r2"

EXTRA_OEMAKE = ""
do_compile () {
	oe_runmake 'CC=${CC}' 'LD=${LD}' 'LDFLAGS=${LDFLAGS}' all
}

do_install () {
	install -d ${D}${bindir}
	install -m 0755 ftp/ftp ${D}${bindir}
}
