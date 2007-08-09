DESCRIPTION = "Task packages for the Angstrom distribution"
PR = "r31"
ALLOW_EMPTY = "1"

PACKAGE_ARCH = "${MACHINE_ARCH}"

RDEPENDS = "\
    matchbox \
    matchbox-panel-hacks \
    xcursor-transparent-theme \
    rxvt-unicode \
    gpe-terminal \
    matchbox-keyboard \
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
    ${@base_contains("MACHINE_FEATURES", "keyboard", "", "libgtkinput",d)} \
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

