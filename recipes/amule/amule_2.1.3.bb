DESCRIPTION = "aMule is an eMule-like client for the eD2k \
and Kademlia networks, supporting multiple platforms."
HOMEPAGE = "http://www.amule.org"
LICENSE = "GPL"
SECTION = "web"
PRIORITY = "optional"
DEPENDS = "wxbase"


SRC_URI = "${SOURCEFORGE_MIRROR}/amule/aMule-${PV}.tar.bz2 \
           file://parser.patch;patch=1"

S = "${WORKDIR}/aMule-${PV}"

inherit autotools pkgconfig

EXTRA_OECONF = "--enable-amulecmd \
                --enable-webserver \
		--disable-monolithic \
		--enable-amule-daemon \
		--disable-nls"
#		--enable-optimize"

FILES_${PN} += " \
        ${libdir}/xchat"
