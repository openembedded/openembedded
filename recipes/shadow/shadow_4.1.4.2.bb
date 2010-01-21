DESCRIPTION = "login/password and account utilities"
LICENSE = "GPL"

DEPEND = "libpam"
RDEPEND = "${DEPEND}"

PR = "r6"

EXTRA_OECONF += " --enable-shared  --enable-static --with-libpam --without-libcrack"

inherit autotools

HOMEPAGE = "http://pkg-shadow.alioth.debian.org/"
SRC_URI = "ftp://pkg-shadow.alioth.debian.org/pub/pkg-shadow/shadow-${PV}.tar.bz2 \
           file://login_defs_pam.sed \
"

# Additional Policy files for PAM
SRC_URI_append = " \
           file://pam.d/chfn \ 
           file://pam.d/chpasswd \
           file://pam.d/chsh \
           file://pam.d/login \
           file://pam.d/newusers \
           file://pam.d/passwd \
           file://pam.d/su \
           file://securetty \
"

S = "${WORKDIR}/shadow-${PV}"

CFLAGS_append = " -I../include"

do_install_append() {
  # Ensure that the image has as /var/spool/mail dir so shadow can put mailboxes there if the user
  # reconfigures Shadow to default (see sed below).
  install -d ${D}${localstatedir}/spool/mail/  
  
  install -d ${D}${sysconfdir}/pam.d/  
  install -m 0644 ${WORKDIR}/pam.d/* ${D}${sysconfdir}/pam.d/

  # Remove defaults that are not used when supporting PAM
  sed -i -f ${WORKDIR}/login_defs_pam.sed ${D}${sysconfdir}/login.defs

  # Enable CREATE_HOME by default.
  sed -i 's/#CREATE_HOME/CREATE_HOME/g' ${D}${sysconfdir}/login.defs 
  
  # As we are on an embedded system ensure the users mailbox is in ~/ not 
  # /var/spool/mail by default as who knows where or how big /var is.
  # The system MDA will set this later anyway.
  sed -i 's/MAIL_DIR/#MAIL_DIR/g' ${D}${sysconfdir}/login.defs 
  sed -i 's/#MAIL_FILE/MAIL_FILE/g' ${D}${sysconfdir}/login.defs 

  install -m 0644 ${WORKDIR}/securetty ${D}${sysconfdir}/securetty
}
