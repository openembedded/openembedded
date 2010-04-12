DESCRIPTION = "VDE can be used: (i) to create a general purpose tunnel (every protocol that runs on a Ethernet can be put into the tunnel) (ii) to connect a set of virtual machine to the Internet with no need of free access of tuntap (iii) to support mobility: a VDE can stay interconnected despite of the change of virtual cables, i.e. the change of IP addresses and interface in the real world"
LICENSE = "GPLv2"
HOMEPAGE = "http://vde.sf.net"

RRECOMMENDS = "kernel-module-tun kernel-module-tap"

inherit autotools pkgconfig

SRC_URI = "${SOURCEFORGE_MIRROR}/vde/${P}.tar.bz2"


SRC_URI[md5sum] = "d97a8dbc72942c57542f50322b538a48"
SRC_URI[sha256sum] = "05b473815f9706387a3c5eaeb4da2e492f624e0b7783432179454f9d69bb973c"
