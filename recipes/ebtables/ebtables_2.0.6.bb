DESCRIPTION = "Utility that enables basic Ethernet frame filtering on a Linux bridge, MAC NAT and brouting."
PRIORITY = "optional"
LICENSE = "GPL"
SECTION = "console/network"
PR = "r2"

TARGET_CC_ARCH += "${LDFLAGS}"

SRC_URI = "${SOURCEFORGE_MIRROR}/ebtables/ebtables-v${PV}.tar.gz \
           file://gcc34.patch;patch=1 \
           file://gcc4.patch;patch=1 \
           file://installnonroot.patch;patch=1 \
           file://installcreatedirs.patch;patch=1"
S = "${WORKDIR}/ebtables-v${PV}"

do_compile () {
	oe_runmake 'BINPATH=/sbin/' 'MANDIR=${mandir}/' \
		   'ETHERTYPESPATH=${sysconfdir}/' 'KERNEL_INCLUDES=${STAGING_INCDIR}'
}

do_install () {
	oe_runmake 'BINPATH=${D}${base_sbindir}/' 'MANDIR=${D}${mandir}/' \
		   'ETHERTYPESPATH=${D}${sysconfdir}/' install
}

SRC_URI[md5sum] = "c4559af2366c764c6c42a3fdd40d60d3"
SRC_URI[sha256sum] = "6b5a71790120977a96d5a468ed69987107c5079f14b0a4081f460b3b14fbf952"
