require classpath.inc

DEPENDS = "glib-2.0 libart-lgpl pango libxtst jikes-native zip-native"
PR = "r1"

SRC_URI += "file://disable-automake-checks-v2.patch;patch=1"

S = "${WORKDIR}/classpath-${PV}"

inherit native

EXTRA_OECONF = "--with-jikes --disable-gconf-peer --disable-gtk-peer --disable-plugin --disable-dssi --disable-examples"

do_stage() {
        install -d ${STAGING_INCDIR}/classpath
        install -m 0755 include/jni* ${STAGING_INCDIR}/classpath/
        install -d ${STAGING_DATADIR}/classpath
        install -m 0755 lib/glibj.zip ${STAGING_DATADIR}/classpath/
}

do_install() {
	:
}
