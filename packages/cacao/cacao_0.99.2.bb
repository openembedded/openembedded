require cacao.inc

PR = "r2"

SRC_URI = "http://www.complang.tuwien.ac.at/cacaojvm/download/cacao-${PV}/cacao-${PV}.tar.bz2;md5sum=912e353a26c88ba5f5f59ebb9f688e2f \
	   file://cacao-codegen-arm1.patch;patch=1 \
	   file://cacao-codegen-arm2.patch;patch=1 \
          "
