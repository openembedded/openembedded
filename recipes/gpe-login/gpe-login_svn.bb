DESCRIPTION = "GPE user login screen"
SECTION = "gpe"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "gtk+ libgpewidget gpe-ownerinfo xkbd"
RDEPENDS_${PN} = "xkbd"
RPROVIDES_${PN} = "gpe-session-starter"
PV = "0.93+svn${SRCDATE}"
PR = "r1"

inherit autotools

SRC_URI_OVERRIDES_PACKAGE_ARCH = "1"

SRC_URI = "${GPE_SVN} \
	   file://removeblue-fontsize8.patch"

S = "${WORKDIR}/${PN}"

CONFFILES_${PN} += " \
${sysconfdir}/apm/suspend.d/S98lock-display \
${sysconfdir}/gpe/gpe-login.conf \
${sysconfdir}/gpe/locale.alias \
${sysconfdir}/sysconfig/gpelogin \
${sysconfdir}/X11/gpe-login.keylaunchrc \
${sysconfdir}/X11/gpe-login.gtkrc \
${sysconfdir}/X11/gpe-login.setup \
${sysconfdir}/X11/gpe-login.pre-session \
${sysconfdir}/X11/Xinit.d/99gpe-login \
${sysconfdir}/X11/Xsession.d/50autolock \
"


DEFAULT_PREFERENCE = "-1"
