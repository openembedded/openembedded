DESCRIPTION = "GNU Classpath standard Java libraries"
HOMEPAGE = "http://www.gnu.org/software/classpath/"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "Classpath"
PROVIDES = "classpath"
RPROVIDES = "classpath"
PR = "r1"

S = "${WORKDIR}/classpath-${PV}"

SRC_URI = "${GNU_MIRROR}/classpath/classpath-${PV}.tar.gz"

DEPENDS = "ecj-native zip-native"

inherit autotools


EXTRA_OECONF = "--with-glibj \
                --with-ecj=${STAGING_BINDIR_NATIVE}/ecj \
                --disable-alsa \
                --disable-gconf-peer \
                --disable-gtk-peer \
                --disable-plugin \
                --disable-dssi \
                --disable-examples \
               "
do_install() {
        :
}

do_stage() {
        install -d ${STAGING_INCDIR}/classpath-minimal/
        install -m 0644 include/jni.h ${STAGING_INCDIR}/classpath-minimal/
        install -m 0644 include/jni_md.h ${STAGING_INCDIR}/classpath-minimal/
        install -d ${STAGING_DATADIR}/java/classpath-minimal/
        install -m 0644 lib/glibj.zip ${STAGING_DATADIR}/java/classpath-minimal/
}

PACKAGES = " "
