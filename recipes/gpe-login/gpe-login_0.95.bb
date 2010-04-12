DESCRIPTION = "GPE user login screen"
SECTION = "gpe"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "gtk+ libgpewidget gpe-ownerinfo xkbd"
RDEPENDS_${PN} = "xkbd"
RRECOMMENDS_${PN} =  "gpe-theme-clearlooks"
RPROVIDES_${PN} = "gpe-session-starter"

PR = "r2"

SRC_URI_OVERRIDES_PACKAGE_ARCH = "1"

GPE_TARBALL_SUFFIX = "bz2"

inherit gpe autotools pkgconfig


SRC_URI += "file://removeblue-fontsize8.patch;patch=1"
SRC_URI += " file://chvt-keylaunch.patch;patch=1 "
SRC_URI += " file://c-locale.patch;patch=1 "
SRC_URI += " file://no-deprecated-sysfs.patch;patch=1 "

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

SRC_URI[md5sum] = "4e6dfd761f62764f98b9f6c2c09f3715"
SRC_URI[sha256sum] = "8bea38af14c98354b1ee023475315ae3ba462d33b136a73cde9d83303b659d84"
