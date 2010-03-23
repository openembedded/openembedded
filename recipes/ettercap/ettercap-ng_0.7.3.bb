DESCRIPTION = "network sniffer/interceptor/logger for ethernet LANs. It \
supports active and passive dissection of many protocols (even ciphered ones, \
like SSH and HTTPS)."
SECTION = "console/network"
DEPENDS = "virtual/libiconv libnet libpcap openssl libpcre ncurses zlib libtool"
LICENSE = "GPL"

PR = "r2"

SRC_URI = "${SOURCEFORGE_MIRROR}/ettercap/ettercap-NG-${PV}.tar.gz \
           file://autotools.patch;patch=1 \
           file://configure.patch;patch=1 "

S = "${WORKDIR}/ettercap-NG-${PV}"

inherit autotools

EXTRA_OECONF += "--disable-gtk --with-libncurses=${STAGING_INCDIR}"

FILES_${PN} += "${datadir}/ettercap ${libdir}/ettercap/*.so"
FILES_${PN}-dbg += "${libdir}/ettercap/.debug"
