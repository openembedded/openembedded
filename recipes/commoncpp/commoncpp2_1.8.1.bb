DESCRIPTION = "GNU Common C++"
HOMEPAGE = "http://freshmeat.net/projects/commoncpp2"
LICENSE = "GPL"
PARALLEL_MAKE = ""

SRC_URI = "\
  ftp://ftp.gnu.org/gnu/commoncpp/commoncpp2-${PV}.tar.gz \
  file://cppcompliance.patch \
"

inherit autotools

SRC_URI[md5sum] = "4804b184e609154ba2bc0aa9f61dc6ef"
SRC_URI[sha256sum] = "53ced4aff74e28a1d8018eb2b4974519028db3c12471ab6dff1c873578c9af4e"
