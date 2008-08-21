require cacaoh-native.inc

SRC_URI = "\
  http://www.complang.tuwien.ac.at/cacaojvm/download/cacao-${PV}/cacao-${PV}.tar.bz2;md5sum=8b8907c8b925761c9410bcadb9705346 \
  "

do_stage() {
	install -m 0755 src/cacaoh/.libs/cacaoh ${STAGING_BINDIR}/cacaoh-cldc-${PV}
}
