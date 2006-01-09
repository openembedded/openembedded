PACKAGES = gpe-base-depends gpe-task-base gpe-task-settings gpe-task-pim gpe-task-apps gpe-task-games gpe-task-connectivity
DESCRIPTION = "Meta-package for GPE Palmtop Environment"
MAINTAINER = "Phil Blundell <pb@handhelds.org>"
PR = "r41"

ALLOW_EMPTY = "1"

RDEPENDS_gpe-base-depends := "\
    diet-x11 \
    virtual/xserver"

RDEPENDS_gpe-task-base := "\
    gpe-task-base = \
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
    ttf-bitstream-vera \
    gpe-dm \
    gpe-login \
    gpe-session-scripts \
    gpe-icons \
    gpe-confd \
    gpe-autostarter \
    libgtkstylus \
    detect-stylus \
    suspend-desktop \
    teleport \
    xauth \
    gdk-pixbuf-loader-png \
    gdk-pixbuf-loader-xpm \
    gdk-pixbuf-loader-jpeg \
    pango-module-basic-x \
    pango-module-basic-fc"

RDEPENDS_gpe-task-pim := "\
    gpe-timesheet \
    gpe-todo \
    gpe-calendar \
    gpe-sketchbook \
    gpe-contacts \
    gpe-today \
    gpesyncd"

RDEPENDS_gpe-task-settings := "\
    matchbox-panel-manager \
    gpe-bluetooth \
    gpe-beam \
    gpe-su \
    gpe-conf \
    gpe-clock \
    gpe-mininet \
    gpe-mixer \
    gpe-package \
    gpe-shield \
    gpe-taskmanager \
    keylaunch \
    minilite \
    minimix \
    xmonobut"

RDEPENDS_gpe-task-apps := "\
    gpe-edit \
    gpe-gallery \
    gpe-calculator \
    gpe-clock \
    gpe-plucker \
    gpe-terminal \
    gpe-watch \
    gpe-what \
    matchbox-panel-hacks \
    gpe-aerial \
    gpe-soundbite \
    rosetta"

RDEPENDS_gpe-task-games := "\
    gpe-go \
    gpe-lights \
    gpe-othello \
    gpe-tetris \
    gsoko \
    xdemineur"

RDEPENDS_gpe-task-connectivity := "\
    gpe-mini-browser"
#    gaim
#    linphone-hh

# FIXME - Some dependencies are broken somewhere for this to be needed
DEPENDS += "matchbox-themes-extra"

LICENSE = "MIT"
