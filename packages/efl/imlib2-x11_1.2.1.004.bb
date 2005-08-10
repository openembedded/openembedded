include imlib2.inc
PROVIDES += "virtual/imlib2"
DEPENDS += "x11 xext"

EXTRA_OECONF = "--disable-mmx \
                --with-x \
                --x-includes=${STAGING_INCDIR} \
                --x-libraries=${STAGING_LIBDIR}"
