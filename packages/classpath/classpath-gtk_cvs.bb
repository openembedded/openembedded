DESCRIPTION = "GNU Classpath standard Java libraries"
HOMEPAGE = "http://www.gnu.org/software/classpath/"
LICENSE = "Classpath"
PRIORITY = "optional"
SECTION = "libs"
PR = "r1"

SRCDATE_${PN} ?= "20070501"
PV = "0.93+cvs${SRCDATE}"

DEPENDS = "glib-2.0 gtk+ cairo gconf ecj-native zip-native virtual/java-native"
RDEPENDS_${PN} = "classpath-common (>= ${PV})"
RCONFLICTS_${PN} = "classpath-minimal"

SRC_URI = "cvs://anonymous@cvs.savannah.gnu.org/sources/classpath;module=classpath \
           file://disable-automake-checks-v2.patch;patch=1"

S = "${WORKDIR}/classpath"

inherit autotools

EXTRA_OECONF = "--with-ecj=${STAGING_BINDIR_NATIVE}/ecj --with-ecj-jar=${STAGING_BINDIR_NATIVE}/ecj.jar --disable-plugin --disable-dssi --disable-alsa"

PACKAGES = "classpath-dev classpath-doc classpath-common classpath-examples classpath-tools ${PN}"

FILES_classpath-doc = "${datadir}/info ${datadir}/man"
FILES_classpath-dev = "${includedir}"
FILES_${PN} = "${libdir} ${bindir}"
FILES_classpath-common = "${datadir}/classpath/glibj.zip"
FILES_classpath-examples = "${datadir}/classpath/examples"
FILES_classpath-tools = "${datadir}/classpath/tools.zip"

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

PROVIDES = "classpath"
RPROVIDES = "classpath"
