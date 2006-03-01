DESCRIPTION = "GNU Classpath modified to work with SableVM"
HOMEPAGE = "http://sablevm.org"
LICENSE = "Classpath"
PRIORITY = "optional"
MAINTAINER = "Rene Wagner <rw@handhelds.org>"
SECTION = "libs"

DEPENDS = "glib-2.0 gtk+ libart-lgpl pango libxtst jikes-native zip-native"
RDEPENDS_${PN} = "${PN}-native (>= ${PV})"

SRC_URI = "http://sablevm.org/download/release/${PV}/${PN}-${PV}.tar.gz \
           file://disable-automake-checks.patch;patch=1"

inherit autotools

EXTRA_OECONF = "--with-compressed-classes=zip"

PACKAGES += " ${PN}-native"

FILES_${PN} = "${datadir}/${PN} \
               ${libdir}/sablevm"
FILES_${PN}-native = "${libdir}/${PN}"

do_install() {
	autotools_do_install
	mv ${D}${libdir}/security ${D}${libdir}/${PN}
}
