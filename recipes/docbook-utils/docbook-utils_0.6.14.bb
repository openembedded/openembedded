SECTION = "console/utils"
LICENSE = "GPL"
DEPENDS = ""
DESCRIPTION = "docbook-utils contains scripts for easy conversion \
from DocBook SGML files to other formats (for example, HTML, RTF, \
and PostScript), and for comparing SGML files."

SRC_URI = "ftp://sources.redhat.com/pub/docbook-tools/new-trials/SOURCES/docbook-utils-${PV}.tar.gz"

inherit autotools

SRC_URI[md5sum] = "6b41b18c365c01f225bc417cf632d81c"
SRC_URI[sha256sum] = "48faab8ee8a7605c9342fb7b906e0815e3cee84a489182af38e8f7c0df2e92e9"
