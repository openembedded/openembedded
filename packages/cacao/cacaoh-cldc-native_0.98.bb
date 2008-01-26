require cacaoh-native.inc

DEPENDS += "midpath-cldc-native"

SRC_URI = "\
  http://www.complang.tuwien.ac.at/cacaojvm/download/cacao-${PV}/cacao-${PV}.tar.bz2;md5sum=8b8907c8b925761c9410bcadb9705346 \
  "

EXTRA_OECONF += "\
  --with-classpath-includedir=${STAGING_INCDIR}/classpath \
  --enable-jni \
  --enable-java=cldc1.1 \
  --with-classpath=cldc1.1 \
  --with-classpath-classes=${STAGING_DATADIR}/midpath-cldc/midpath-cldc1.1.jar \
"
		
do_stage() {
	install -m 0755 src/cacaoh/.libs/cacaoh ${STAGING_BINDIR}/cacaoh-cldc-${PV}
}
