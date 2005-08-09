include imlib2.inc
DEPENDS += "x11 xext"

export FREETYPE_CONFIG = "${STAGING_BINDIR}/freetype-config"

EXTRA_OECONF = "--disable-mmx \
                --with-x \
                --x-includes=${STAGING_INCDIR} \
                --x-libraries=${STAGING_LIBDIR}"
