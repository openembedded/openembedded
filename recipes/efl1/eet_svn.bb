DESCRIPTION = "EET is the Enlightenment data storage library"
DEPENDS = "zlib jpeg openssl eina"
LICENSE = "MIT BSD"
PV = "1.1.0+svnr${SRCPV}"
PR = "r1"

inherit efl

EXTRA_OECONF = "\
  --enable-openssl \
  --enable-cypher \
  --enable-signature \
  --disable-coverage \
  --enable-old-eet-file-format \
  --disable-assert \
"
