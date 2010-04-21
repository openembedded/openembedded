DESCRIPTION = "Modular settings application for SHR based on python-elementary"
HOMEPAGE = "http://shr-project.org"
SHR_RELEASE ?= "shr"
LICENSE ?= "GPL"
RDEPENDS = "python-elementary python-dbus python-codecs python-shell python-pyrtc python python-core python-edbus dbus-x11 frameworkd python-phoneutils python-pexpect"
SECTION = "x11/application"
SRCREV = "dec4e519308b87b4acf23c605d7f2a75b75e7ba6"
PE = "1"
PV = "0.1.1+gitr${SRCPV}"
PR = "r9"

inherit setuptools

PACKAGES =+ "\
  ${PN}-addons-illume \
  ${PN}-backup-configuration \
"

RRECOMMENDS_${PN} = "\
  ${PN}-addons-illume \
  ${PN}-backup-configuration \
"

PACKAGE_ARCH_${PN}-addons-illume = "all"
PACKAGE_ARCH_${PN}-backup-configuration = "all"

SRC_URI = "git://git.shr-project.org/repo/shr-settings.git;protocol=http;branch=master"
S = "${WORKDIR}/git"
FILES_${PN} += "${prefix}/share/pixmaps"
FILES_${PN} += "${prefix}/share/applications"
FILES_${PN}-addons-illume = "${prefix}/share/applications/shr-settings-addons-illume"
FILES_${PN}-backup-configuration = "${sysconfdir}/shr-settings/"
CONFFILES_${PN}-backup-configuration = "\
  ${sysconfdir}/shr-settings/backup.conf \
  ${sysconfdir}/shr-settings/backup.blacklist \
  ${sysconfdir}/shr-settings/backup.whitelist \
"
