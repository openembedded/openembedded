PACKAGES = gpe-base-depends gpe-task-base gpe-task-settings gpe-task-pim gpe-task-apps gpe-task-games
DESCRIPTION = "Meta-package for GPE Palmtop Environment"
MAINTAINER = "Phil Blundell <pb@handhelds.org>"
PR = "r36"

ALLOW_EMPTY = 1

gpe-base-depends = "\
    diet-x11 \
    virtual/xserver"

RDEPENDS_gpe-base-depends := "${gpe-base-depends}"
DEPENDS += " ${gpe-base-depends}"

gpe-task-base = "\
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
    teleport \	
    xauth"

RDEPENDS_gpe-task-base := "gdk-pixbuf-loader-png \
			   gdk-pixbuf-loader-xpm \
			   gdk-pixbuf-loader-jpeg \
			   pango-module-basic-x \
			   pango-module-basic-fc \
			   ${gpe-task-base}"
DEPENDS += " ${gpe-task-base}"

gpe-task-pim = "\
    gpe-timesheet \
    gpe-todo \
    gpe-calendar \
    gpe-sketchbook \
    gpe-contacts \
    gpe-today"
RDEPENDS_gpe-task-pim := "${gpe-task-pim}"
DEPENDS += " ${gpe-task-pim}"

gpe-task-settings = "\
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
    xmonobut"

RDEPENDS_gpe-task-settings := "${gpe-task-settings}"
DEPENDS += " ${gpe-task-settings}"

gpe-task-apps = "\
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

RDEPENDS_gpe-task-apps := "${gpe-task-apps}"
DEPENDS += " ${gpe-task-apps}"

gpe-task-games = "\
    gpe-go \
    gpe-lights \
    gpe-othello \
    gpe-tetris \
    gsoko \
    xdemineur"

RDEPENDS_gpe-task-games := "${gpe-task-games}"
DEPENDS += " ${gpe-task-games}"

DEPENDS += "matchbox-themes-extra"

LICENSE = MIT
