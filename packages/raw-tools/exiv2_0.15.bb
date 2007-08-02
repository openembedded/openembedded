DESCRIPTION = "Exiv2 is a C++ library and a command line utility to access image metadata."
LICENSE = "GPL"
DEPENDS = "tiff zlib" 

SRC_URI = "http://www.exiv2.org/exiv2-${PV}.tar.gz"

inherit autotools pkgconfig lib_package


do_stage() {
       autotools_stage_all
} 


