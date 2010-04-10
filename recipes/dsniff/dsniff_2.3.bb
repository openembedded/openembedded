DESCRIPTION = "dsniff is a collection of tools for network auditing and penetration testing."
SECTION = "console/network"
HOMEPAGE = "http://www.monkey.org/~dugsong/dsniff/"
AUTHOR = "Dug Song <dugsong@monkey.org>"
LICENSE = "BSD"
PR = "r2"

# There is a significant API change beween 1.0.2a of libnet and
# 1.1.x, dsniff will only work with the older and there is no
# updated version of dnsniff.
DEPENDS = "virtual/db libpcap libnet-1.0 libnids openssl"

SRC_URI = "\
  http://www.monkey.org/~dugsong/dsniff/dsniff-${PV}.tar.gz \
  file://configure.patch;patch=1 \
"

inherit autotools

EXTRA_OECONF = "\
  --without-x --with-db=${STAGING_LIBDIR}/.. \
  --with-libpcap=${STAGING_LIBDIR}/.. \
  --with-libnet=${STAGING_LIBDIR}/.. \
  --with-libnids=${STAGING_LIBDIR}/.. \
  --with-openssl=${STAGING_LIBDIR}/.. \
"
EXTRA_OEMAKE = "'install_prefix=${D}'"

CFLAGS =+ "-I${S}/missing"
LDFLAGS += "-lresolv"

SRC_URI[md5sum] = "183e336a45e38013f3af840bddec44b4"
SRC_URI[sha256sum] = "82e492455486e655c315f027d393dbeb49ad930804acccdc51b30d57e1294ff5"
