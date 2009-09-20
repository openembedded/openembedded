require cherokee.inc

PR = "${INC_PR}.0"

SRC_URI = "http://www.cherokee-project.com/download/0.98/${PV}/cherokee-${PV}.tar.gz \
           file://cherokee.init "

CONFFILES_${PN} = " \
${sysconfdir}/cherokee/cherokee.conf \
${sysconfdir}/init.d/cherokee \
"

