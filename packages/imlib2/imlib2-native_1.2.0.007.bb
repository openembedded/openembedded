include imlib2.inc
inherit native
DEPENDS = "freetype-native libpng-native jpeg-native"

EXTRA_OECONF = "--disable-mmx \
                --without-x"

do_stage () {
  oe_libinstall -C src/lib libImlib2 ${STAGING_LIBDIR}/
  install -m 0644 ${S}/src/lib/Imlib2.h ${STAGING_INCDIR}/
}
