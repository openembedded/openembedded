require cacao.inc

PR = "r0"

SRC_URI = "http://www.complang.tuwien.ac.at/cacaojvm/download/cacao-${PV}/cacao-${PV}.tar.bz2 \
	   file://cacao-codegen-arm1.patch;patch=1 \
	   file://cacao-codegen-arm2.patch;patch=1 \
     "

