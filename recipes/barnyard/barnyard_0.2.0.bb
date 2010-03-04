DESCRIPTION = "Barnyard is a output system for Snort."
HOMEPAGE = "http://www.snort.org/"
LICENSE = "QPL"
DEPENDS = "libpcap"
RDEPENDS = "libpcap"
PR = "r1"

SRC_URI = " http://dl.snort.org/barnyard/${P}.tar.gz;name=tarball \
          "
SRC_URI[tarball.md5sum] = "be3283028cf414b52b220308ceb411e9"
SRC_URI[tarball.sha256sum] = "09e0f8e095e79cfe70ea069d13e7d02521a504a1f400a45556a634dccfd31a3a"

S = "${WORKDIR}/${P}"

inherit autotools pkgconfig

do_configure_prepend () {
	#fix hardcoded include path
	sed -i -e 's:extra_incl=-I/usr/include/pcap::g' ${S}/configure.in
}

