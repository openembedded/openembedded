DESCRIPTION = "EET is the Enlightenment data storage library"
DEPENDS = "pkgconfig zlib jpeg openssl eina gnutls"
LICENSE = "MIT BSD"
SRCREV = "${EFL_SRCREV}"
PV = "1.3.2+svnr${SRCPV}"
PR = "r2"

inherit efl

BBCLASSEXTEND="native"

EXTRA_OECONF = "\
  --enable-openssl \
  --enable-cypher \
  --enable-signature \
  --disable-coverage \
  --enable-old-eet-file-format \
  --disable-assert \
"
