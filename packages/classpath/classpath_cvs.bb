DESCRIPTION = "GNU Classpath standard Java libraries"
HOMEPAGE = "http://www.gnu.org/software/classpath/"
LICENSE = "Classpath"
PRIORITY = "optional"
MAINTAINER = "Rene Wagner <rw@handhelds.org>"
SECTION = "libs"
PV = "0.20+cvs${SRCDATE}"

DEFAULT_PREFERENCE = "-1"

DEPENDS = "glib-2.0 gtk+ libart-lgpl pango xtst jikes-native zip-native"
RDEPENDS_${PN} = "${PN}-common (>= ${PV})"

SRC_URI = "cvs://anoncvs@cvs.gnu.org/cvsroot/classpath;method=pserver;rsh=ssh;module=classpath \
           file://disable-automake-checks.patch;patch=1"
S = "${WORKDIR}/classpath"

inherit autotools

EXTRA_OECONF = "--with-jikes"

PACKAGES += " ${PN}-common ${PN}-examples"

FILES_${PN} = "${libdir}/${PN}"
FILES_${PN}-common = "${datadir}/${PN}/glibj.zip"
FILES_${PN}-examples = "${datadir}/${PN}/examples"

do_stage() {
	install -d ${STAGING_INCDIR}/classpath
	install -m 0755 include/jni* ${STAGING_INCDIR}/classpath/
}

do_install() {
	autotools_do_install
	mv ${D}${libdir}/security ${D}${libdir}/${PN}
}
