DESCRIPTION = "Modular settings application for SHR based on python-elementary"
HOMEPAGE = "http://shr-project.org"
SHR_RELEASE ?= "shr"
LICENSE ?= "GPL"
RDEPENDS_${PN} = "python-elementary python-dbus python-codecs python-shell python-pyrtc python python-core python-edbus dbus-x11 frameworkd python-phoneutils python-pexpect"
SECTION = "x11/application"
SRCREV = "f712a5ec5617b3de2700794389ada07297b3ff8e"
PE = "1"
PV = "0.1.1+gitr${SRCPV}"
PR = "r12"

inherit setuptools

PACKAGES =+ "\
  ${PN}-addons-illume \
  ${PN}-backup-configuration \
"

RRECOMMENDS_${PN} = "\
  ${PN}-addons-illume \
  ${PN}-backup-configuration \
"

do_configure_append_shr() {
  # change category because EFL_SRCREV 48174 (separate Home module) changes
  # Efreet_Desktop filtering from "sys AND settings OR kbd" to "sys OR settings OR kbd"

  sed -i "s#Categories=Settings;#Categories=Utility;#g" ${S}/data/shr-settings.desktop
}

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
