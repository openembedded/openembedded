SECTION = "console/network"
DESCRIPTION = "netkit-tftpd includes a tftp server."
DEPENDS = "netkit-base"
RDEPENDS = "netkit-base"
LICENSE = "BSD"
FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/netkit-tftp-${PV}"

SRC_URI = "ftp://ftp.uk.linux.org/pub/linux/Networking/netkit/netkit-tftp-${PV}.tar.gz \
	   file://mconfig.patch;patch=1 \
           file://tftpd_add_debug.patch;patch=1 \
	   file://pack_tftphdr.patch;patch=1"

S = "${WORKDIR}/netkit-tftp-${PV}"

PR = "r7"

EXTRA_OEMAKE = ""
do_compile () {
	oe_runmake 'CC=${CC}' 'LD=${LD}' all
}

do_install () {
	install -d ${D}${sbindir}
	install -m 0755 tftpd/tftpd ${D}${sbindir}/tftpd
}

pkg_postinst () {
	#only run on the device
	if [ -n "$D" ]; then exit 1; fi

	#install inetd.conf line to run tftpd
	echo "tftp    dgram   udp     wait    root    ${sbindir}/tftpd tftpd" >> /etc/inetd.conf

	#force inetd to reload settings
	kill -SIGHUP `cat /var/run/inetd.pid`
}
