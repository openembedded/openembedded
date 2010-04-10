require cherokee.inc

PR = "${INC_PR}.0"

SRC_URI = "http://www.cherokee-project.com/download/0.98/${PV}/cherokee-${PV}.tar.gz \
           file://cherokee.init "

CONFFILES_${PN} = " \
${sysconfdir}/cherokee/cherokee.conf \
${sysconfdir}/init.d/cherokee \
"


SRC_URI[md5sum] = "9f1876232bdfdfa5b4e02ff0636e7241"
SRC_URI[sha256sum] = "701721a58aa79b93a4f3aaf633f0b842a05b07c73996cd44e78a383a7387226d"
