require cherokee.inc

PR = "${INC_PR}.1"

DEPENDS = "libpcre openssl mysql"

SRC_URI = "http://www.cherokee-project.com/download/0.99/${PV}/cherokee-${PV}.tar.gz \
           file://cherokee.init "

CONFFILES_${PN} = " \
${sysconfdir}/cherokee/cherokee.conf \
${sysconfdir}/init.d/cherokee \
"
EXTRA_OECONF = "--enable-tls=openssl --disable-static --disable-nls --with-mysql=${STAGING_INCDIR}/mysql"
