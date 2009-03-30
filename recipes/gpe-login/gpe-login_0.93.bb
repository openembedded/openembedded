DESCRIPTION = "GPE user login screen"
SECTION = "gpe"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "gtk+ libgpewidget gpe-ownerinfo xkbd"
RDEPENDS = "xkbd gpe-theme-clearlooks"
RPROVIDES_${PN} = "gpe-session-starter"
PR = "r1"

SRC_URI_OVERRIDES_PACKAGE_ARCH = "1"

GPE_TARBALL_SUFFIX = "bz2"

inherit gpe autotools pkgconfig


SRC_URI += "file://removeblue-fontsize8.patch;patch=1"
SRC_URI += " file://chvt-keylaunch.patch;patch=1 "
SRC_URI += " file://c-locale.patch;patch=1 "

SRC_URI_append_spitz = "file://brightness-adjust-keyluanchrc.patch;patch=1"
SRC_URI_append_akita = "file://brightness-adjust-keyluanchrc.patch;patch=1"
SRC_URI_append_c7x0 = "file://brightness-adjust-keyluanchrc.patch;patch=1"


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
