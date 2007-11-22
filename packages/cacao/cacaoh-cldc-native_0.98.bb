
require cacao.inc

DEPENDS = "ecj-native classpath-minimal-native virtual/cldc-api-1.1-native libtool-native zlib-native"

inherit native

EXTRA_OECONF += "--with-classpath-includedir=${STAGING_INCDIR}/classpath-minimal \
		 --enable-jni \
                 --enable-java=cldc1.1 \
                 --with-classpath=cldc1.1 \
		 --with-classpath-classes=${STAGING_DATADIR}/java/cldc1.1.jar \
                "
do_stage() {
	install -m 0755 src/cacaoh/.libs/cacaoh ${STAGING_BINDIR}/
}
