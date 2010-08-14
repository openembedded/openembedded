DESCRIPTION = "Raptor RDF Parser Library"
SECTION = "libs"
HOMEPAGE = "http://librdf.org/raptor/"
LICENSE = "LGPL 2.1/GPL 2/Apache 2.0"
PR = "r0"
SRC_URI = "http://download.librdf.org/source/raptor-${PV}.tar.gz"

inherit autotools pkgconfig

SRC_URI[md5sum] = "992061488af7a9e2d933df6b694bb876"
SRC_URI[sha256sum] = "db3172d6f3c432623ed87d7d609161973d2f7098e3d2233d0702fbcc22cfd8ca"

