SECTION = "x11/libs"
# libxfcegui4 OE build file
# Copyright (C) 2004, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see packages/COPYING)

DESCRIPTION="XFCE Widget library and X Window System interaction"
DEPENDS="libxfce4util gtk+"

inherit xfce pkgconfig

do_stage() {
    install -d ${STAGING_INCDIR}/xfce4
    install -d ${STAGING_INCDIR}/xfce4/libxfcegui4
    
    install -m 644 libxfcegui4/libnetk.h ${STAGING_INCDIR}/xfce4/libxfcegui4
    install -m 644 libxfcegui4/libxfcegui4.h ${STAGING_INCDIR}/xfce4/libxfcegui4
    install -m 644 libxfcegui4/dialogs.h ${STAGING_INCDIR}/xfce4/libxfcegui4
    install -m 644 libxfcegui4/icons.h ${STAGING_INCDIR}/xfce4/libxfcegui4
    install -m 644 libxfcegui4/xfce_clock.h ${STAGING_INCDIR}/xfce4/libxfcegui4
    install -m 644 libxfcegui4/xfce_movehandler.h ${STAGING_INCDIR}/xfce4/libxfcegui4
    install -m 644 libxfcegui4/xfce_decorbutton.h ${STAGING_INCDIR}/xfce4/libxfcegui4
    install -m 644 libxfcegui4/xfce_decortoggle.h ${STAGING_INCDIR}/xfce4/libxfcegui4
    install -m 644 libxfcegui4/xfce_framebox.h ${STAGING_INCDIR}/xfce4/libxfcegui4
    install -m 644 libxfcegui4/xfce_iconbutton.h ${STAGING_INCDIR}/xfce4/libxfcegui4
    install -m 644 libxfcegui4/xfce_togglebutton.h ${STAGING_INCDIR}/xfce4/libxfcegui4
    install -m 644 libxfcegui4/xfce_menubutton.h ${STAGING_INCDIR}/xfce4/libxfcegui4
    install -m 644 libxfcegui4/xfce_marshal.h ${STAGING_INCDIR}/xfce4/libxfcegui4
    install -m 644 libxfcegui4/xfce_systemtray.h ${STAGING_INCDIR}/xfce4/libxfcegui4
    install -m 644 libxfcegui4/gtk_style.h ${STAGING_INCDIR}/xfce4/libxfcegui4
    install -m 644 libxfcegui4/gtktoxevent.h ${STAGING_INCDIR}/xfce4/libxfcegui4
    install -m 644 libxfcegui4/session-client.h ${STAGING_INCDIR}/xfce4/libxfcegui4
    install -m 644 libxfcegui4/preview_filesel.h ${STAGING_INCDIR}/xfce4/libxfcegui4
    install -m 644 libxfcegui4/xinerama.h ${STAGING_INCDIR}/xfce4/libxfcegui4
    install -m 644 libxfcegui4/netk-application.h ${STAGING_INCDIR}/xfce4/libxfcegui4
    install -m 644 libxfcegui4/netk-screen.h ${STAGING_INCDIR}/xfce4/libxfcegui4
    install -m 644 libxfcegui4/netk-util.h ${STAGING_INCDIR}/xfce4/libxfcegui4
    install -m 644 libxfcegui4/netk-window.h ${STAGING_INCDIR}/xfce4/libxfcegui4
    install -m 644 libxfcegui4/netk-window-menu.h ${STAGING_INCDIR}/xfce4/libxfcegui4
    install -m 644 libxfcegui4/netk-workspace.h ${STAGING_INCDIR}/xfce4/libxfcegui4
    install -m 644 libxfcegui4/netk-enum-types.h ${STAGING_INCDIR}/xfce4/libxfcegui4
    install -m 644 libxfcegui4/netk-pager.h ${STAGING_INCDIR}/xfce4/libxfcegui4
    install -m 644 libxfcegui4/netk-tasklist.h ${STAGING_INCDIR}/xfce4/libxfcegui4
    install -m 644 libxfcegui4/netk-trayicon.h ${STAGING_INCDIR}/xfce4/libxfcegui4
    install -m 644 libxfcegui4/netk-marshal.h ${STAGING_INCDIR}/xfce4/libxfcegui4
    
    oe_soinstall libxfcegui4/.libs/libxfcegui4.so.1.0.9 ${STAGING_LIBDIR}/
}
