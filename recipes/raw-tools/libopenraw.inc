DESCRIPTION = "libopenraw is an ongoing project to provide a free software implementation for camera RAW files decoding. " 
LICENSE = "GPLv2"
DEPENDS = "boost jpeg gtk+"

inherit autotools pkgconfig lib_package

PACKAGES =+ "libopenrawgnome"

FILES_libopenrawgnome = "${libdir}/libopenrawgnome.so.*"

