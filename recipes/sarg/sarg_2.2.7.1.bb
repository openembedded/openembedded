DESCRIPTION = "Squid Analysis Report Generator"
SECTION = "utils"
DEPENDS = "gd"
RSUGGESTS = "squid"
LICENSE = "GPL"
HOMEPAGE = "http://sarg.sourceforge.net/sarg.php"
PR = "r0"

SRC_URI = " \
	${SOURCEFORGE_MIRROR}/sarg/sarg-${PV}.tar.gz;name=tar \
	file://sarg.conf \
	"
SRC_URI[tar.md5sum] = "0ce83323978e715ce70a6d2ab4f0daa4"
SRC_URI[tar.sha256sum] = "209398e7690876ef9df04ba7f0b4b47c91ea8cdcfd7a54d78f15b5548a2dd32e"

inherit cmake

EXTRA_OECMAKE = "-DSYSCONFDIR:STRING=${sysconfdir}/squid"

do_install_append() {
    install -m 0644 ${WORKDIR}/sarg.conf ${D}${sysconfdir}/squid/sarg.conf
}
