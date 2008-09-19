DESCRIPTION = "EET is the Enlightenment data storage library"
DEPENDS = "zlib jpeg openssl"
LICENSE = "MIT BSD"
PV = "1.0.1+svnr${SRCREV}"
PR = "r3"

inherit efl

EXTRA_OECONF = "\
  --enable-openssl \
  --enable-cypher \
  --enable-signature \
  --disable-coverage \
  --enable-old-eet-file-format \
  --disable-assert \
"
