SECTION = "console/utils"
LICENSE = "GPL"
DEPENDS = ""
DESCRIPTION = "docbook-utils contains scripts for easy conversion \
from DocBook SGML files to other formats (for example, HTML, RTF, \
and PostScript), and for comparing SGML files."

SRC_URI = "ftp://sources.redhat.com/pub/docbook-tools/new-trials/SOURCES/docbook-utils-${PV}.tar.gz"

inherit autotools
