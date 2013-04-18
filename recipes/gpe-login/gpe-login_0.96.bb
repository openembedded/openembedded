DESCRIPTION = "GPE user login screen"
SECTION = "gpe"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "gtk+ libgpewidget gpe-ownerinfo xkbd"
RDEPENDS_${PN} = "xkbd"
RRECOMMENDS_${PN} =  "gpe-theme-clearlooks"
RPROVIDES_${PN} = "gpe-session-starter"

PR = "r0"

SRC_URI_OVERRIDES_PACKAGE_ARCH = "1"

GPE_TARBALL_SUFFIX = "bz2"

inherit gpe autotools pkgconfig


SRC_URI += "file://removeblue-fontsize8.patch"
SRC_URI += " file://chvt-keylaunch.patch "
SRC_URI += " file://c-locale.patch "
SRC_URI += " file://no-deprecated-sysfs.patch "

SRC_URI_append_spitz = "file://brightness-adjust-keyluanchrc.patch"
SRC_URI_append_akita = "file://brightness-adjust-keyluanchrc.patch"
SRC_URI_append_c7x0 = "file://brightness-adjust-keyluanchrc.patch"


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

SRC_URI[md5sum] = "59d6546fb8098076bec61db3fb540cd2"
SRC_URI[sha256sum] = "995023314cc3b9ca851efd77b0a5a35bebd177e04db99b59bcf87306c3ad9131"
