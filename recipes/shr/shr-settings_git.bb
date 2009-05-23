DESCRIPTION = "Modular settings application for SHR based on python-elementary"
HOMEPAGE = "http://shr-project.org"
SHR_RELEASE ?= "shr"
LICENSE ?= "GPL"
RDEPENDS = "python-elementary python-dbus python-codecs python-shell python-pyrtc python python-edbus dbus-x11"
SECTION = "x11/application"
PV = "0.1.1+r${SRCPV}"
PR = "r4"

inherit setuptools

PACKAGES =+ "\
  ${PN}-addons-illume \
"

RRECOMMENDS_${PN} = "\
  ${PN}-addons-illume \
"

PACKAGE_ARCH_${PN}-addons-illume = "all"

SRC_URI = "git://git.shr-project.org/repo/shr-settings.git;protocol=http;branch=master"
S = "${WORKDIR}/git"
FILES_${PN} += "${prefix}/share/pixmaps"
FILES_${PN} += "${prefix}/share/applications"
FILES_${PN}-addons-illume = "${prefix}/share/applications/shr-settings-addons-illume"
