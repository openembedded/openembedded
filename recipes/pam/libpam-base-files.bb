DESCRIPTION = "Linux-PAM authentication library for Linux. Base configuration files"

SECTION = "libs"
PRIORITY = "optional"
LICENSE = "GPLv2"
DEPENDS = ""
RDEPENDS_${PN} = "libpam"
RRECOMMENDS_${PN} = "libpam-meta"

PR = "r7"

SRC_URI = " \
           file://pam.d/* \
"

do_install() {         
          install -d ${D}${sysconfdir}/pam.d/     
          install -m 0644 ${WORKDIR}/pam.d/* ${D}${sysconfdir}/pam.d/
}
