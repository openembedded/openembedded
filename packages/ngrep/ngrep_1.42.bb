DESCRIPTION = "ngrep strives to provide most of GNU grep's \
common features, applying them to the network layer."
SECTION = "console/network"
PRIORITY = "optional"
DEPENDS = "libpcap pcre"
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
