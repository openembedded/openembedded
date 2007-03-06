DESCRIPTION = "Task packages for GPE Palmtop Environment Phone Edition"
PR = "r1"
LICENSE = "MIT"
ALLOW_EMPTY = "1"

PACKAGES = "\
    gpephone-base-depends \
    gpephone-task-base \
    gpephone-task-settings \
    gpephone-task-pim \
    gpephone-task-connectivity \
    gpephone-task-apps \
    gpephone-task-development"

RDEPENDS_gpephone-base-depends := "\
    diet-x11 \
    virtual/xserver"

RDEPENDS_gpephone-task-development := "\
    rxvt-unicode \
    xmonobut \
    gpe-terminal \
    gpe-edit \
    gdb \
    strace \
    e2fsprogs"

RDEPENDS_gpephone-task-base := "\
    cms92init \
    gsmmux \
    connect \
    phoneserver \
    soundserver \
    voicecall \
    sms \
    audioplayer \
    videoplayer \
    addressbook \
    calendar \
    gpe-applauncher \
    gpe-phonepanel \
    gpe-bootsplash \
    gpe-bootsplash-theme-gpephone \
    bluez-utils-dbus \
    matchbox \
    xcursor-transparent-theme \
    gtk2-theme-angelistic \
    matchbox-themes-gtk \
    xst \
    xhost \
    xrdb \
    gpe-soundserver \
    ttf-bitstream-vera \
    ttf-dejavu-sans \
    ttf-dejavu-sans-mono \
    gpe-dm \
    gpe-login \
    gpe-session-scripts-phone \
    gpe-icons \
    gpe-confd \
    gpe-autostarter \
    libgtkstylus \
    xauth \
    gdk-pixbuf-loader-png \
    gdk-pixbuf-loader-xpm \
    gdk-pixbuf-loader-jpeg \
    gdk-pixbuf-loader-gif \
    pango-module-basic-x \
    pango-module-basic-fc \
    detect-stylus"

RDEPENDS_gpephone-task-pim := "\
     gpesyncd"

RDEPENDS_gpephone-task-settings := "\
    gpe-su \
    gpe-conf \
    gpe-clock \
    gpe-mixer \
    gpe-taskmanager \
    keylaunch \
    minilite"

RDEPENDS_gpephone-task-apps := "\
    gpe-watch \
    gpe-what \
    matchbox-panel-hacks \
    gpe-scap \
    gpe-windowlist"

RDEPENDS_gpephone-task-connectivity := "\
"
