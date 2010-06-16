DESCRIPTION = "json C library"
HOMEPAGE = "http://oss.metaparadigm.com/json-c/"
AUTHOR = "Michael Clark and C. Watford"
LICENSE = "MIT/X11"
SECTION = "libs"

SRC_URI = "http://oss.metaparadigm.com/json-c/json-c-${PV}.tar.gz"
S = "${WORKDIR}/json-c-${PV}"

SRC_URI[md5sum] = "3a13d264528dcbaf3931b0cede24abae"
SRC_URI[sha256sum] = "702a486c9bf8e19137d484ab5c49b4ad314eb5e1fe37062a72c0a0fa39439475"

inherit autotools
