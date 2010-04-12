DESCRIPTION = "lineakd"
SECTION = "gpe/multimedia"
HOMEPAGE = "http://lineak.sourceforge.net"
LICENSE = "GPLv2"
DEPENDS = "virtual/libx11 libxext"
PR = "r0"

SRC_URI = "${SOURCEFORGE_MIRROR}/lineak/lineakd-${PV}.tar.gz \
           file://add-zaurus-remote-support.patch;patch=1"
S = "${WORKDIR}/lineakd-${PV}"

inherit autotools

do_install () {
	oe_runmake 'mandir=${D}/usr/share/man' 'pkglibdir=${D}/usr/lib' 'sysconfdir=${D}/etc' 'DESTDIR=${D}' install
}

PACKAGES += "${PN}-lib"

FILES_${PN}-lib += " \
  ${libdir}/liblineak*"


SRC_URI[md5sum] = "fc1d3add18afbb8e61b8277b89c525c6"
SRC_URI[sha256sum] = "cfde4a06df9fb4f26f8629d4ed3320ea813ba05a25217ec4ff55bbe5da04f504"
