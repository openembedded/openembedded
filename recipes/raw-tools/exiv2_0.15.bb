DESCRIPTION = "Exiv2 is a C++ library and a command line utility to access image metadata."
LICENSE = "GPL"
DEPENDS = "tiff zlib" 

SRC_URI = "http://www.exiv2.org/exiv2-${PV}.tar.gz"

inherit autotools pkgconfig lib_package


do_stage() {
       autotools_stage_all
} 



SRC_URI[md5sum] = "bb18d19e1d6fb255dadda456cadec00e"
SRC_URI[sha256sum] = "b72d82e9117308063471993f3832e58064c0599dec3df2bf2a7ce54450984a3e"
