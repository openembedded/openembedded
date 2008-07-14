require cacao-native.inc

PR = "r1"

SRC_URI = "http://jalimo.evolvis.org/repository/sources/cacao-${PV}.tar.bz2;md5sum=9ff10c929bd0cbf15909107c1aff7518"

# force usage of ecj-initial (but Java5-compatible class library)
export JAVAC = "${STAGING_BINDIR_NATIVE}/ecj-initial -bootclasspath ${STAGING_DATADIR_NATIVE}/classpath/glibj.zip"

