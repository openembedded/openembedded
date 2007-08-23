DESCRIPTION = "Base task package for GPE Palmtop Environment"
PR = "r8"
LICENSE = "MIT"

inherit task

RDEPENDS_${PN} = "\
    gpe-bootsplash \
    bluez-utils-dbus \
    matchbox \
    xcursor-transparent-theme \
    rxvt-unicode \
    gtk2-theme-angelistic \
    matchbox-themes-gtk \
    xst \
    xhost \
    xrdb \
    gpe-soundserver \
    gpe-dm \
    gpe-login \
    gpe-session-scripts \
    gpe-icons \
    gpe-confd \
    gpe-autostarter \
    startup-monitor \
    libgtkstylus \
    libgpewidget-bin \
    suspend-desktop \
    teleport \
    xauth \
    gdk-pixbuf-loader-png \
    gdk-pixbuf-loader-xpm \
    gdk-pixbuf-loader-jpeg \
    pango-module-basic-x \
    pango-module-basic-fc \
    ttf-bitstream-vera"

