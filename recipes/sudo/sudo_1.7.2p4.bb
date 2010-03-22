PR = "r3"

DEPENDS = "libpam"
RDEPENDS = "libpam libpam-meta"

SRC_URI = "http://ftp.sudo.ws/sudo/dist/sudo-${PV}.tar.gz;name=src \
  file://sudo.pamd \
"

SRC_URI[src.md5sum] = "3989e5a00538247d7dcef8b514076752"
SRC_URI[src.sha256sum] = "57d9adbdffa881e32894231079da7d68ffe99f46942818b63baadf6c795b7bdd"

EXTRA_OECONF += " --with-pam "

require sudo.inc

# Do in the recipe not the common inc as not all SUDO recipes want PAM support.

do_install_append() {
  install -d ${D}${sysconfdir}/pam.d/  
  install -m 0644 ${WORKDIR}/sudo.pamd ${D}${sysconfdir}/pam.d/sudo 
}
