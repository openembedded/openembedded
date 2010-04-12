DESCRIPTION = "ngrep strives to provide most of GNU grep's \
common features, applying them to the network layer."
SECTION = "console/network"
PRIORITY = "optional"
DEPENDS = "libpcap libpcre"
LICENSE="ngrep"
SRC_URI = "${SOURCEFORGE_MIRROR}/ngrep/ngrep-${PV}.tar.bz2 \
           file://use-our-pcre.patch;patch=1"

EXTRA_OECONF = "--with-restart --enable-pcre --with-pcap-includes=${STAGING_INCDIR}"
EXTRA_OEMAKE = "INCLUDES=${S}"

inherit autotools

CFLAGS += '-DDROPPRIVS_ONLY_ROOT=0 -DDROPPRIVS_USER=\""nobody\"" -DUSE_DROPPRIVS=1'

do_install () {
	install -d ${D}${bindir}
	install -m 0755 ngrep ${D}${bindir}/
}

SRC_URI[md5sum] = "35e821cfd888e9523a90fb7e5074a072"
SRC_URI[sha256sum] = "fd5a85b48613452fbfc9ce6d6e3fa3f37992731422eb2843235fbf4e02d6f1e9"
