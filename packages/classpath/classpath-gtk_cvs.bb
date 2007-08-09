require classpath.inc

PR = "r2"

SRCDATE_${PN} ?= "20070501"
PV = "0.93+cvs${SRCDATE}"

### note from Laibsch: bug 2523 has information on how to build this package
DEPENDS = "glib-2.0 gtk+ cairo gconf ecj-native zip-native virtual/java-native libxtst"
RDEPENDS_${PN} = "classpath-common (>= ${PV})"
RCONFLICTS_${PN} = "classpath-minimal"

SRC_URI = "cvs://anonymous@cvs.savannah.gnu.org/sources/classpath;module=classpath \
           file://disable-automake-checks-v2.patch;patch=1"

S = "${WORKDIR}/classpath"

EXTRA_OECONF = "--with-ecj=${STAGING_BINDIR_NATIVE}/ecj --with-ecj-jar=${STAGING_BINDIR_NATIVE}/ecj.jar --disable-plugin --disable-dssi --disable-alsa"

do_stage() {
	install -d ${STAGING_INCDIR}/classpath
	install -m 0755 include/jni* ${STAGING_INCDIR}/classpath/
	install -d ${STAGING_DATADIR}/classpath
	install -m 0755 lib/glibj.zip ${STAGING_DATADIR}/classpath/
}

do_install() {
	autotools_do_install
	mv ${D}${libdir}/security ${D}${libdir}/${PN}
}
