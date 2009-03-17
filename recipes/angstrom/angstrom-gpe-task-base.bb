DESCRIPTION = "Task packages for the Angstrom distribution"
PR = "r36"

inherit task

PACKAGE_ARCH = "${MACHINE_ARCH}"

RDEPENDS_${PN} = "\
    gpe-scap \
    matchbox \
    matchbox-panel-hacks \
    matchbox-applet-startup-monitor \
    xcursor-transparent-theme \
    rxvt-unicode \
    gpe-terminal \
    matchbox-keyboard \
    xkbd \
    xkbd-layout-ru \
    gpe-theme-clearlooks \
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
    ${@base_contains("MACHINE_FEATURES", "touchscreen", "libgtkstylus", "",d)} \
    suspend-desktop \
    teleport \
    xauth \
    gdk-pixbuf-loader-png \
    gdk-pixbuf-loader-xpm \
    gdk-pixbuf-loader-jpeg \
    pango-module-basic-x \
    pango-module-basic-fc \
    ${@base_contains("COMBINED_FEATURES", "bluetooth", "gpe-bluetooth", "",d)} \
    ${@base_contains("COMBINED_FEATURES", "bluetooth", "bluez-gnome", "",d)} \
    "

