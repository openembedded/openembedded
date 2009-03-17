DESCRIPTION = "GPE application launcher"
SECTION = "gpe"
LICENSE = "GPL"
DEPENDS = "libgpewidget libgpelaunch cairo libxsettings-client"
PV = "2.8+svn${SRCDATE}"
PR = "r0"

inherit gpe

SRC_URI = "${GPE_SVN} \
           file://svn-build.patch;patch=1"

S = "${WORKDIR}/${PN}"

export CVSBUILD="no"

DEFAULT_PREFERENCE = "-1"
