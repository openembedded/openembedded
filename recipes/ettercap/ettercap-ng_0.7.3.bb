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

SRC_URI[md5sum] = "28fb15cd024162c55249888fe1b97820"
SRC_URI[sha256sum] = "c74239052d62565c13a82f9bbf217a4fdcce4b34949e361b53bb3f28e3168543"
