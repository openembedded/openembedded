# Configuration parameters
SHADOW_MAILFILE ?= "Mailbox"
SHADOW_MAILDIR ?= "${localstatedir}/spool/mail"
SHADOW_UTMPDIR ?= "${localstatedir}/utmp"
SHADOW_LOGDIR ?= "${localstatedir}/log"

# Metadata
DESCRIPTION = "Tools to change and administer password and group data."
HOMEPAGE = "http://pkg-shadow.alioth.debian.org/"
LICENSE = "BSD"
SECTION = "base"
DEPENDS += "${@base_contains('DISTRO_FEATURES', 'pam', 'libpam', '', d)}"

INC_PR = "r13"

# Additional Policy files for PAM
PAM_SRC_URI = " \
           file://pam.d/chfn \
           file://pam.d/chpasswd \
           file://pam.d/chsh \
           file://pam.d/login \
           file://pam.d/newusers \
           file://pam.d/passwd \
           file://pam.d/su \
"

SRC_URI = "ftp://pkg-shadow.alioth.debian.org/pub/pkg-shadow/shadow-${PV}.tar.bz2 \
           file://login_defs_pam.sed \
           ${@base_contains('DISTRO_FEATURES', 'pam', '${PAM_SRC_URI}', '', d)} \
           file://securetty \
"

inherit autotools gettext

EXTRA_OECONF += "\
    --disable-account-tools-setuid \
    --without-audit \
    --without-selinux \
    --without-libcrack \
    ${@base_contains('DISTRO_FEATURES', 'pam', '--with-libpam', '--without-libpam', d)} \
"

CFLAGS += "-I../include"

do_configure_prepend () {
    export CONFIG_SITE="${CONFIG_SITE} ${B}/cachedpaths"
    cat <<END >${B}/cachedpaths
shadow_cv_maildir=${SHADOW_MAILDIR}
shadow_cv_mailfile=${SHADOW_MAILFILE}
shadow_cv_utmpdir=${SHADOW_UTMPDIR}
shadow_cv_logdir=${SHADOW_LOGDIR}
shadow_cv_passwd_dir=${bindir}
END
}

do_install_append() {
  # Ensure that /etc/skel is created so any default files that we want copied into new users home
  # dirs can be put in there later (ideal for .xinitrc for example).
  install -d ${D}${sysconfdir}/skel/  
  
  # Ensure that the image has as /var/spool/mail dir so shadow can put mailboxes there if the user
  # reconfigures Shadow to default (see sed below).
  install -d ${D}${SHADOW_MAILDIR}

  if [ -e ${WORKDIR}/pam.d ]; then
      install -d ${D}${sysconfdir}/pam.d/
      install -m 0644 ${WORKDIR}/pam.d/* ${D}${sysconfdir}/pam.d/
  fi

  # Remove defaults that are not used when supporting PAM
  ${@base_contains('DISTRO_FEATURES', 'pam', 'sed -i -f ${WORKDIR}/login_defs_pam.sed ${D}${sysconfdir}/login.defs', '', d)}

  # Enable CREATE_HOME by default.
  sed -i 's/#CREATE_HOME/CREATE_HOME/g' ${D}${sysconfdir}/login.defs

  # As we are on an embedded system ensure the users mailbox is in ~/ not
  # /var/spool/mail by default as who knows where or how big /var is.
  # The system MDA will set this later anyway.
  sed -i 's/MAIL_DIR/#MAIL_DIR/g' ${D}${sysconfdir}/login.defs
  sed -i 's/#MAIL_FILE/MAIL_FILE/g' ${D}${sysconfdir}/login.defs

  install -d ${D}${sbindir} ${D}${base_sbindir} ${D}${base_bindir} 
  for i in passwd chfn newgrp chsh ; do
    mv ${D}${bindir}/$i ${D}${bindir}/$i.${PN}
  done

  mv ${D}${sbindir}/chpasswd ${D}${sbindir}/chpasswd.${PN}
  mv ${D}${sbindir}/vigr ${D}${base_sbindir}/vigr.${PN}
  mv ${D}${sbindir}/vipw ${D}${base_sbindir}/vipw.${PN}
  mv ${D}${bindir}/login ${D}${base_bindir}/login.${PN}

  # Ensure we add a suitable securetty file to the package that has most common embedded TTYs defined.
  install -m 0400 ${WORKDIR}/securetty ${D}${sysconfdir}/securetty 

}

pkg_postinst_${PN} () {
    update-alternatives --install ${bindir}/passwd passwd passwd.${PN} 200
    update-alternatives --install ${sbindir}/chpasswd chpasswd chpasswd.${PN} 200
    update-alternatives --install ${bindir}/chfn chfn chfn.${PN} 200
    update-alternatives --install ${bindir}/newgrp newgrp newgrp.${PN} 200
    update-alternatives --install ${bindir}/chsh chsh chsh.${PN} 200
    update-alternatives --install ${base_bindir}/login login login.${PN} 200
    update-alternatives --install ${base_sbindir}/vipw vipw vipw.${PN} 200
    update-alternatives --install ${base_sbindir}/vigr vigr vigr.${PN} 200
    if [ "x$D" != "x" ]; then
        exit 1
    fi  
	pwconv
	grpconv
}

pkg_prerm_${PN} () {
    for i in passwd chpasswd chfn newgrp chsh login vipw vigr ; do
        update-alternatives --remove $i $i.${PN}
    done
}
