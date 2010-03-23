DESCRIPTION = "Userspace library providing a programming interface (API) to the in-kernel connection tracking state table"
LICENSE = "GPL"
DEPENDS = "libnfnetlink"

SRC_URI = "http://www.netfilter.org/projects/libnetfilter_conntrack/files/libnetfilter_conntrack-${PV}.tar.bz2;name=tar"
SRC_URI[tar.md5sum] = "3c4b4048c914f2694c3ca6de2bb457dc"
SRC_URI[tar.sha256sum] = "9d2919df3794e1e8f2311ad31949698103061206379b75094cb2bf7851378ab2"

S = "${WORKDIR}/libnetfilter_conntrack-${PV}"

inherit autotools_stage pkgconfig