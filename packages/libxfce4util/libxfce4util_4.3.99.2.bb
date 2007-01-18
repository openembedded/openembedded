require ${PN}.inc

SRC_URI += "\
http://svn.xfce.org/svn/xfce/xfce4-dev-tools/trunk/m4macros/xdt-depends.m4 \
http://svn.xfce.org/svn/xfce/xfce4-dev-tools/trunk/m4macros/xdt-features.m4 \
http://svn.xfce.org/svn/xfce/xfce4-dev-tools/trunk/m4macros/xdt-i18n.m4 \
http://svn.xfce.org/svn/xfce/xfce4-dev-tools/trunk/m4macros/xdt-python.m4 \
http://svn.xfce.org/svn/xfce/xfce4-dev-tools/trunk/m4macros/xdt-xfce.m4"


MACROS="m4/xdt*.m4"

XFCE_HEADERS="debug.h utf8.h xfce-generics.h   xfce-resource.h \
              i18n.h util.h xfce-kiosk.h libxfce4util-config.h  \
              xfce-desktopentry.h xfce-miscutils.h libxfce4util.h \
              xfce-fileutils.h xfce-rc.h xfce-utf8.h \
              xfce-license.h xfce-i18n.h libxfce4util-enum-types.h"

do_configure_prepend() {
    install -m 0755 -d ${S}/m4/
    install -m 0644 ${WORKDIR}/xdt-*.m4 ${S}/m4/
}
