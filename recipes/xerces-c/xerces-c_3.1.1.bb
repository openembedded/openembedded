DESCRIPTION = "Xerces-c is a validating xml parser written in C++"
HOMEPAGE = "http://xerces.apache.org/xerces-c/"
SECTION =  "libs"
PRIORITY = "optional"
LICENSE = "Apache-2.0"

SRC_URI = "http://apache.lauf-forum.at/xerces/c/3/sources/${BP}.tar.gz"

inherit autotools pkgconfig

PACKAGES = "libxerces-c \
    libxerces-c-dbg \
    libxerces-c-dev \
    xerces-c-samples \
    xerces-c-samples-dbg \
" 

FILES_libxerces-c = "${libdir}/libxerces-c-3.1.so"
FILES_libxerces-c-dbg = "${libdir}/.debug/"
FILES_libxerces-c-dev = "${libdir}/lib*.la \
    ${libdir}/lib*.a \
    ${libdir}/libxerces-c.so \
    ${libdir}/pkgconfig/xerces-c.pc \
    ${includedir}/xercesc \
"
FILES_xerces-c-samples = "${bindir}/*"
FILES_xerces-c-samples-dbg = "${bindir}/.debug/"

SRC_URI[md5sum] = "6a8ec45d83c8cfb1584c5a5345cb51ae"
SRC_URI[sha256sum] = "a42785f71e0b91d5fd273831c87410ce60a73ccfdd207de1b805d26d44968736"

BBCLASSEXTEND += "native"
