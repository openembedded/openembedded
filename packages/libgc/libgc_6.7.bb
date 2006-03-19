DESCRIPTION 	= "Garbage collector for C and C++"
LICENSE 	= "As is"
HOMEPAGE	= "http://www.hpl.hp.com/personal/Hans_Boehm/gc/"

DEPENDS		= "sed-native"
SRC_URI 	= "http://www.hpl.hp.com/personal/Hans_Boehm/gc/gc_source/gc6.7.tar.gz"
S 		= "${WORKDIR}/gc6.7" 
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
