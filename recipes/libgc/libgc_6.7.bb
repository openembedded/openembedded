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

SRC_URI[md5sum] = "be780413a0360306ad3b701e45fa8871"
SRC_URI[sha256sum] = "b678dd4354e0305fc57fef9aa4fd1f316e8a5de33e5048e712fbc32d42ecea7c"
