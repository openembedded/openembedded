PR = "r0"

DEPENDS = "libpam"
RDEPENDS_${PN} = "libpam libpam-meta"

SRC_URI = "http://ftp.sudo.ws/sudo/dist/sudo-${PV}.tar.gz;name=src \
  file://sudo.pamd \
"

SRC_URI[src.md5sum] = "1ae12d3d22e7ffedbf2db26f957676f0"
SRC_URI[src.sha256sum] = "20091ef71018698c674c779f4b57178b2ecb4275fa34909b06219d2688ad14d5"

EXTRA_OECONF += " --with-pam "

require sudo.inc

# Do in the recipe not the common inc as not all SUDO recipes want PAM support.

do_install_append() {
  install -d ${D}${sysconfdir}/pam.d/  
  install -m 0644 ${WORKDIR}/sudo.pamd ${D}${sysconfdir}/pam.d/sudo 
}
