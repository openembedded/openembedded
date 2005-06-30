DESCRIPTION = "GNU Classpath standard Java libraries"
HOMEPAGE = "http://www.gnu.org/software/classpath/"
LICENSE = "Classpath"
PRIORITY = "optional"
MAINTAINER = "Rene Wagner <rw@handhelds.org>"
SECTION = "libs"
PR = "r0"

DEPENDS = "glib-2.0 gtk+ libart-lgpl pango jikes-native"
RDEPENDS_${PN} = "${PN}-common (${PV})"

SRC_URI = "${GNU_MIRROR}/${PN}/${P}.tar.gz \
           file://disable-automake-checks.patch;patch=1"

inherit autotools

EXTRA_OECONF = "--with-jikes"

PACKAGES += " ${PN}-common ${PN}-examples"

FILES_${PN} = "${libdir}/${PN}"
FILES_${PN}-common = "${datadir}/${PN}/glibj.zip"
FILES_${PN}-examples = "${datadir}/${PN}/examples"

do_install() {
	autotools_do_install
	mv ${D}${libdir}/security ${D}${libdir}/${PN}
}
