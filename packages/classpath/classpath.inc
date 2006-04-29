DESCRIPTION = "GNU Classpath standard Java libraries"
HOMEPAGE = "http://www.gnu.org/software/classpath/"
LICENSE = "Classpath"
PRIORITY = "optional"
MAINTAINER = "Rene Wagner <rw@handhelds.org>"
SECTION = "libs"

PBN = "classpath"

SRC_URI = "${GNU_MIRROR}/classpath/${PBN}-${PV}.tar.gz \
           file://disable-automake-checks.patch;patch=1 \
           file://fix-endian-arm-floats.patch;patch=1"

S = ${WORKDIR}/${PBN}-${PV}

inherit autotools

do_stage() {
	install -d ${STAGING_INCDIR}/classpath
	install -m 0755 include/jni* ${STAGING_INCDIR}/classpath/
}

do_install() {
	autotools_do_install
	mv ${D}${libdir}/security ${D}${libdir}/${PBN}
}

PROVIDES = "classpath"
RPROVIDES = "classpath"
