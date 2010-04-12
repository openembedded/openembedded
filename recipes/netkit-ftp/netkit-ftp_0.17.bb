SECTION = "console/network"
DESCRIPTION = "netkit-ftp includes a commandline ftp client."
LICENSE = "BSD"
SRC_URI = "ftp://ftp.uk.linux.org/pub/linux/Networking/netkit/netkit-ftp-${PV}.tar.gz;name=archive \
	   file://mconfig.patch;patch=1 \
       http://ftp.de.debian.org/debian/pool/main/n/netkit-ftp/netkit-ftp_0.17-19.diff.gz;patch=1;name=patch19 "

PR = "r2"

EXTRA_OEMAKE = ""
do_compile () {
	oe_runmake 'CC=${CC}' 'LD=${LD}' 'LDFLAGS=${LDFLAGS}' all
}

do_install () {
	install -d ${D}${bindir}
	install -m 0755 ftp/ftp ${D}${bindir}
}

SRC_URI[archive.md5sum] = "94441610c9b86ef45c4c6ec609444060"
SRC_URI[archive.sha256sum] = "61c913299b81a4671ff089aac821329f7db9bc111aa812993dd585798b700349"
SRC_URI[patch19.md5sum] = "f7c82f2f78f26dcb869eca2ed633c464"
SRC_URI[patch19.sha256sum] = "2168b592ce254ab6f6daf04b4eafb5607b664c48d85f74698a9376e2cc4503aa"
