DESCRIPTION = "Task packages for GPE Palmtop Environment"
PR = "r2"
LICENSE = MIT
ALLOW_EMPTY = "1"

PACKAGES = "\
    gpe-base-depends \
    gpe-task-base \
    gpe-task-settings \
    gpe-task-pim \
    gpe-task-apps \
    gpe-task-games \ 
    gpe-task-connectivity \
    gpe-task-apps-extra \
    gpe-task-web \
    gpe-task-desktopapps \
    gpe-task-sectest"

RDEPENDS_gpe-base-depends := "\
    diet-x11 \
    virtual/xserver"

RDEPENDS_gpe-task-base := "\
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
    rosetta \
    gpe-screenshot \
    gpe-windowlist"

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

RDEPENDS_gpe-task-apps-extra := "\
    gpe-filemanager \
    gpe-nmf \
    gpe-soundbite \
    mbmerlin"

RDEPENDS_gpe-task-web := "\
    gpe-irc \
    minimo \
    gaim"

RDEPENDS_gpe-task-desktopapps := "\
    firefox \
    thunderbird \
    galculator \
    gnumeric \
    gpdf \
    totem"

RDEPENDS_gpe-task-sectest := "\
    mbmerlin \
    nmap \
    ettercap \
    stunnel \
    curl \
    dsniff \
    prismstumbler \
    tcpdump \
    kismet \
    hydra \
    thcrut \
    driftnet \
    miniclipboard"
