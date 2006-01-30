include imlib2.inc

SRC_URI = "cvs://anonymous@thinktux.net/root;module=e17/libs/imlib2;date=${PV}"
S = "${WORKDIR}/imlib2"

DEPENDS += "x11 xext"

EXTRA_OECONF = "--disable-mmx \
                --with-x \
                --x-includes=${STAGING_INCDIR} \
                --x-libraries=${STAGING_LIBDIR}"
