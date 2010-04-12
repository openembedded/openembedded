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

LDFLAGS += "-ldl"

SRC_URI[md5sum] = "0aafdd159edb8ad5f0064da87998b47d"
SRC_URI[sha256sum] = "6e97e947bb7ac231b75e3b21a509a2ec0239bcd7e9dbfc6062c520a6d13b0244"
