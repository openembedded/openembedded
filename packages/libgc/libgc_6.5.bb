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
