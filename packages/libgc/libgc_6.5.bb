DESCRIPTION 	= "Garbage collector for C and C++"
LICENSE 	= "As is"

HOMEPAGE	= "http://www.hpl.hp.com/personal/Hans_Boehm/gc/"

SRC_URI 	= "http://www.hpl.hp.com/personal/Hans_Boehm/gc/gc_source/gc6.5.tar.gz"
S 		= "${WORKDIR}/gc6.5" 

inherit autotools
