PACKAGES = gpe-base-depends gpe-task-base gpe-task-settings gpe-task-pim sectest-task-apps gpe-task-games 
DESCRIPTION = "Meta-package for GPE Security Testing Image"
MAINTAINER = "Bob Davies tyggerbob@rogers.com>"
PR = "r5"

ALLOW_EMPTY = "1"

RDEPENDS_gpe-base-depends := "\
    diet-x11 \
    virtual/xserver"

RDEPENDS_gpe-task-base := "\
    bluez-utils-dbus \
    matchbox \
    xcursor-transparent-theme \
    rxvt-unicode \
    gtk2-theme-angelistic \
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
    gdk-pixbuf-loader-png \
    gdk-pixbuf-loader-xpm \
    gdk-pixbuf-loader-jpeg \
    pango-module-basic-x \
    pango-module-basic-fc"

RDEPENDS_gpe-task-pim := "\
    figment"

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
    xmonobut"

RDEPENDS_sectest-task-apps := "\
    gpe-edit \
    gpe-calculator \
    gpe-clock \
    gpe-terminal \
    gpe-watch \
    gpe-what \
    matchbox-panel-hacks \
    gpe-aerial \
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

# FIXME - we shouldn't need this. which packages don't set their dependencies correctly?
DEPENDS += "matchbox-themes-extra gtk-industrial-engine"

LICENSE = "MIT"
