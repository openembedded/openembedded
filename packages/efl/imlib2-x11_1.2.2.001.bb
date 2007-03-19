require imlib2.inc
DEPENDS += "virtual/libx11 libxext"
PR = "r2"

EXTRA_OECONF = "--disable-mmx \
                --with-x \
                --x-includes=${STAGING_INCDIR} \
                --x-libraries=${STAGING_LIBDIR}"
