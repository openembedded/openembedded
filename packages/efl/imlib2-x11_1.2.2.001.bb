include imlib2.inc
DEPENDS += "libx11 libxext"
PR = "r1"

EXTRA_OECONF = "--disable-mmx \
                --with-x \
                --x-includes=${STAGING_INCDIR} \
                --x-libraries=${STAGING_LIBDIR}"
