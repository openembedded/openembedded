SECTION = "console/network"
DEPENDS = "ncurses openssl"
LICENSE = "GPL"
DESCRIPTION = "Ettercap is a network sniffer/interceptor/logger \
for ethernet LANs. It supports active and passive dissection of \
many protocols (even ciphered ones, like SSH and HTTPS)."

SRC_URI = "${SOURCEFORGE_MIRROR}/ettercap/ettercap-${PV}.tar.gz \
	   file://configure.patch;patch=1"

inherit autotools

EXTRA_OECONF = "--disable-gtk \
	        --with-openssl=${STAGING_LIBDIR}/.."
