DESCRIPTION = "GNU Classpath standard Java libraries"
HOMEPAGE = "http://www.gnu.org/software/classpath/"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "Classpath"
PROVIDES = "classpath"
RPROVIDES = "classpath"

SRC_URI = "${GNU_MIRROR}/classpath/classpath-${PV}.tar.gz \
           file://disable-automake-checks.patch;patch=1 \
           file://gconf_version.patch;patch=1 \
           file://fix-endian-arm-floats.patch;patch=1"

inherit autotools

do_stage() {
	install -d ${STAGING_INCDIR}/classpath
	install -m 0755 include/jni* ${STAGING_INCDIR}/classpath/
}

do_install() {
	autotools_do_install
	mv ${D}${libdir}/security ${D}${libdir}/${PN}
}

PACKAGES =+ "classpath-common classpath-examples classpath-tools"
FILES_classpath-common += "${datadir}/classpath/glibj.zip"
FILES_classpath-examples += "${datadir}/classpath/examples"
FILES_classpath-tools += "${datadir}/classpath/tools.zip ${datadir}/classpath/tools"
FILES_classpath-dev += "${libdir}/*.so"
FILES_classpath-dbg += "${libdir}/classpath/.debug"

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
