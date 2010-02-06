DESCRIPTION = "XML-LibXML"
SECTION = "libs"
LICENSE = ""
DEPENDS += "libxml2 \
        libxml-sax-perl \
        zlib \
"
PR = "r0"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/P/PA/PAJAS/XML-LibXML-${PV}.tar.gz;name=libxml \
        file://libxml-libxml-perl-disable-libxml2-check.patch;patch=1 \
"
SRC_URI[libxml.md5sum] = "33d4294f708e20c298cfe534d1166844"
SRC_URI[libxml.sha256sum] = "53e6cf06772ba9d85055dc6e4488dbd876d2376e48ef3578fa73246ee98b3ba0"

S = "${WORKDIR}/XML-LibXML-${PV}"

inherit cpan

EXTRA_CPANFLAGS = "INC=-I${STAGING_INCDIR}/libxml2 LIBS=-L${STAGING_LIBDIR}"

BBCLASSEXTEND = "native"

CFLAGS += " -D_GNU_SOURCE "
