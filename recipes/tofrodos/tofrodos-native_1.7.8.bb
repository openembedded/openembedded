DESCRIPTION = "Tofrodos is a text file conversion utility that converts ASCII files between the MSDOS and unix format"
LICENSE = "GPLv2"

SRC_URI = "http://tofrodos.sourceforge.net/download/tofrodos-${PV}.tar.gz \
           file://0001-Make-OE-friendly.patch;striplevel=2 \
	   file://0001-Use-enviroment-rather-than-hard-coded-paths.patch;striplevel=2 \
          "
SRC_URI[md5sum] = "aaa044f9817a048e126d9eb7a7535e96"
SRC_URI[sha256sum] = "e1d78226c5b54c0ce8e1c7de8bdd025aec6bf684960d5cee28310cf8dce48bb9"

S = "${WORKDIR}/tofrodos/src"

inherit native

