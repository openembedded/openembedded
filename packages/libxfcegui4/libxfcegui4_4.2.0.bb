SECTION = "x11/libs"
# libxfcegui4 OE build file
# Copyright (C) 2004, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see packages/COPYING)

DESCRIPTION="XFCE Widget library and X Window System interaction"
DEPENDS="libxfce4util dbh libxml2 gtk+"

inherit xfce pkgconfig

FILES_${PN} += "/usr/lib/xfce4/modules/* /usr/share/xfce4/mime/ \
	/usr/share/icons/hicolor/"

XFCE_HEADERS= "dialogs.h        netk-trayicon.h         xfce-icontheme.h \
	gtk_style.h      netk-util.h           xfce_aboutdialog.h \
	gtktoxevent.h    netk-window-action-menu.h  xfce_clock.h \
	icons.h          netk-window-menu.h    xfce_decorbutton.h \
	libnetk.h        netk-window.h         xfce_decortoggle.h \
	libxfcegui4-config.h  netk-workspace.h      xfce_framebox.h \
	libxfcegui4.h    preview_filesel.h     xfce_iconbutton.h \
	netk-application.h    session-client.h      xfce_marshal.h \
	netk-class-group.h    xfce-appmenuitem.h    xfce_menubutton.h \
	netk-enum-types.h     xfce-colorbutton.h    xfce_movehandler.h \
	netk-marshal.h   xfce-exec.h           xfce_scaled_image.h \
	netk-pager.h     xfce-filechooser.h    xfce_systemtray.h \
	netk-screen.h    xfce-gdk-extensions.h      xfce_togglebutton.h \
	netk-tasklist.h  xfce-gtk-extensions.h      xinerama.h"

MODULE_HEADERS="combo.h  constants.h  mime.h  mime_icons.h"

do_stage() {
    install -d ${STAGING_INCDIR}/xfce4/libxfcegui4
    install -d ${STAGING_INCDIR}/xfce4/xfce4-modules
    install -d ${STAGING_LIBDIR}/xfce4/modules

    for file in ${XFCE_HEADERS}; do
    	install -m 644 libxfcegui4/$file ${STAGING_INCDIR}/xfce4/libxfcegui4
    done 

    for file in ${MODULE_HEADERS}; do
    	install -m 644 xfce4-modules/headers/$file \
		${STAGING_INCDIR}/xfce4/xfce4-modules
    done 

    oe_libinstall -C libxfcegui4 -so libxfcegui4 ${STAGING_LIBDIR}

    oe_libinstall -C xfce4-modules/mime-icons -so libxfce4_mime_icons \
    ${STAGING_LIBDIR}/xfce4/modules
    oe_libinstall -C xfce4-modules/combo -so libxfce4_combo \
    ${STAGING_LIBDIR}/xfce4/modules
    oe_libinstall -C xfce4-modules/mime-applications -so libxfce4_mime \ 
    ${STAGING_LIBDIR}/xfce4/modules
}
