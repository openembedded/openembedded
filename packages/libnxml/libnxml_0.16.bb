HOMEPAGE = "http://www2.autistici.org/bakunin/codes.php"
DESCRIPTION = "nXML is a C library for parsing, writing and creating XML 1.0 and 1.1 files or streams. It supports utf-8, utf-16be and utf-16le, ucs-4 (1234, 4321, 2143, 2312)"
LICENSE = "LGPL"

DEPENDS = "curl"

inherit autotools pkgconfig

SRC_URI = "http://www2.autistici.org/bakunin/libnxml/libnxml-${PV}.tar.gz;md5sum=85b6a42a9e17a23c01b2f2ed0ece0563"


do_stage() {
    autotools_stage_all
}
