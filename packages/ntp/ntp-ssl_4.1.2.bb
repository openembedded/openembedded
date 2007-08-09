require ntp_${PV}.bb
DEPENDS = "openssl"
PR = "r2"

S = "${WORKDIR}/ntp-${PV}"

EXTRA_OECONF = "--with-openssl-libdir=${STAGING_LIBDIR} \
	        --with-openssl-incdir=${STAGING_INCDIR}/openssl"

