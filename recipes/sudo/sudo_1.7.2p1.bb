PR = "r3"

DEPENDS = "libpam"
RDEPENDS = "libpam libpam-meta"

SRC_URI = "http://ftp.sudo.ws/sudo/dist/sudo-${PV}.tar.gz \
  file://sudo.pamd \
"

EXTRA_OECONF += " --with-pam "

require sudo.inc

# Do in the recipe not the common inc as not all SUDO recipes want PAM support.

do_install_append() {
  install -d ${D}${sysconfdir}/pam.d/  
  install -m 0644 ${WORKDIR}/sudo.pamd ${D}${sysconfdir}/pam.d/sudo 
}
