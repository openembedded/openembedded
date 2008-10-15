SECTION = "console/network"
DESCRIPTION = "netkit-rpc includes rpcgen and rpcinfo."
PR = "r1"
LICENSE = "GPL"
SRC_URI = "ftp://ftp.uk.linux.org/pub/linux/Networking/netkit/netkit-rpc-${PV}.tar.gz \
	   file://gcc4.patch;patch=1 \
	   file://install.patch;patch=1"
S = "${WORKDIR}/netkit-rpc-${PV}"

EXTRA_OEMAKE = ""
do_configure () {
	cat <<END >MCONFIG
BINDIR=${bindir}
SBINDIR=${sbindir}
MANDIR=${mandir}
ROOTBINDIR=/bin
BINMODE=755
DAEMONMODE=755
MANMODE=644
SUIDMODE=4755
PREFIX=${prefix}
EXECPREFIX=${exec_prefix}
ROOTPREFIX=
INSTALLROOT=
CC=${CC}
LD=${LD}
CFLAGS=${CFLAGS}
LDFLAGS=${LDFLAGS}
LIBS=
END
}

do_compile () {
	oe_runmake all
}

do_install () {
	oe_runmake 'INSTALLROOT=${D}' install
}
