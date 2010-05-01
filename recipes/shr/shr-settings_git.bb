DESCRIPTION = "Modular settings application for SHR based on python-elementary"
HOMEPAGE = "http://shr-project.org"
SHR_RELEASE ?= "shr"
LICENSE ?= "GPL"
RDEPENDS = "python-elementary python-dbus python-codecs python-shell python-pyrtc python python-core python-edbus dbus-x11 frameworkd python-phoneutils python-pexpect"
SECTION = "x11/application"
SRCREV = "4912195f23519a69932ed474b36b78bd97b1ac1d"
PE = "1"
PV = "0.1.1+gitr${SRCPV}"
PR = "r10"

inherit setuptools

PACKAGES =+ "\
  ${PN}-addons-illume \
  ${PN}-backup-configuration \
"

RRECOMMENDS_${PN} = "\
  ${PN}-addons-illume \
  ${PN}-backup-configuration \
"

do_install_append() {
  install -d ${D}/${sysconfdir}/profile.d/
  install -m 0755 "${WORKDIR}/elementary.sh" "${D}/${sysconfdir}/profile.d/elementary.sh"
}

PACKAGE_ARCH_${PN}-addons-illume = "all"
PACKAGE_ARCH_${PN}-backup-configuration = "all"

SRC_URI = "git://git.shr-project.org/repo/shr-settings.git;protocol=http;branch=master \
           file://elementary.sh"
S = "${WORKDIR}/git"
FILES_${PN} += "${sysconfdir}/profile.d/elementary.sh"
FILES_${PN} += "${prefix}/share/pixmaps"
FILES_${PN} += "${prefix}/share/applications"
FILES_${PN}-addons-illume = "${prefix}/share/applications/shr-settings-addons-illume"
FILES_${PN}-backup-configuration = "${sysconfdir}/shr-settings/"
CONFFILES_${PN} = "${sysconfdir}/profile.d/elementary.sh"
CONFFILES_${PN}-backup-configuration = "\
  ${sysconfdir}/shr-settings/backup.conf \
  ${sysconfdir}/shr-settings/backup.blacklist \
  ${sysconfdir}/shr-settings/backup.whitelist \
"
