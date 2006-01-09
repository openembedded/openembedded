DESCRIPTION = "CLucene is a C++ port of Lucene: the high-performance, full-featured text search engine written in Java."
SECTION = "libs"
LICENSE = "LGPL"
PRIORITY = "optional"
SRCDATE = "20040704"
SRC_URI = "cvs://anonymous@cvs.sourceforge.net/cvsroot/clucene;module=. \
	   file://compile-fix.patch;patch=1"
S = "${WORKDIR}"

inherit autotools 

do_stage() {
	oe_libinstall -C src libclucene ${STAGING_LIBDIR}
	install -d ${STAGING_INCDIR}/CLucene/
	install src/CLucene.h ${STAGING_INCDIR}/CLucene/
	cd src
	headers=`find . -name "*.h"`
	for f in $headers
	do
		install -d ${STAGING_INCDIR}/`dirname $f`
		install -m 0644 $f ${STAGING_INCDIR}/$f
	done
	echo > ${STAGING_INCDIR}/CLucene/util/dirent.h
}
