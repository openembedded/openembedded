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

SRC_URI[md5sum] = "5afed8bdd6020dc5bf0ba9ec83b947f1"
SRC_URI[sha256sum] = "0581b5eafba9a993d035467c51bfa85fa76ca46043fab95e6f7592ad8f4f38e1"
