DESCRIPTION = "Speex is an Open Source/Free Software patent-free audio compression format designed for speech."
SECTION = "libs"
LICENSE = "BSD"
HOMEPAGE = "http://www.speex.org"
DEPENDS = "libogg"
PR = "r0"

SRC_URI = "http://www.speex.org/download/speex-${PV}.tar.gz"

inherit autotools

do_configure_append() {
  sed -i s/"^OGG_INCLUDES.*$"/"OGG_INCLUDES = "/g src/Makefile
  sed -i s/"^OGG_LDFLAGSS.*$"/"OGG_LDFLAGS = "/g src/Makefile
}

do_stage() {
  oe_libinstall -C libspeex/.libs -so libspeex ${STAGING_LIBDIR}
  install -d ${STAGING_INCDIR}/speex
  install -m 0644 include/speex/speex.h ${STAGING_INCDIR}/speex
  install -m 0644 include/speex/speex_bits.h ${STAGING_INCDIR}/speex
  install -m 0644 include/speex/speex_callbacks.h ${STAGING_INCDIR}/speex
  install -m 0644 include/speex/speex_header.h ${STAGING_INCDIR}/speex
  install -m 0644 include/speex/speex_stereo.h ${STAGING_INCDIR}/speex
}

