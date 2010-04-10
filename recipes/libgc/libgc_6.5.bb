DESCRIPTION 	= "Garbage collector for C and C++"
LICENSE 	= "As is"
HOMEPAGE	= "http://www.hpl.hp.com/personal/Hans_Boehm/gc/"

DEPENDS		= "sed-native"
SRC_URI 	= "http://www.hpl.hp.com/personal/Hans_Boehm/gc/gc_source/gc6.5.tar.gz"
S 		= "${WORKDIR}/gc6.5"
FILES_${PN}-doc += "/usr/share/gc/"

inherit autotools

do_configure_append() {
	#fix libtool script
	 sed -i 's:${SED}:sed:g' libtool
	 sed -i 's:$SED:sed:g' libtool
}

do_stage() {
	autotools_stage_includes
	install -d ${STAGING_LIBDIR}
	install -m 755 .libs/libgc.so* ${STAGING_LIBDIR}/
}

SRC_URI[md5sum] = "00bf95cdcbedfa7321d14e0133b31cdb"
SRC_URI[sha256sum] = "217df8b36d848a85eb81ec6fa2a411e9bf186a747c2ddb223cb82b5001e4d80b"
