DESCRIPTION = "Task package for maemo environment"
LICENSE = "MIT"
ALLOW_EMPTY = "1"
PR = "r0"

PACKAGES = "\
    maemo-task-base \
    maemo-task-apps \
    maemo-task-libs-install \
    maemo-task-theme"

RDEPENDS_maemo-base-depends = "\
    diet-x11 \
    virtual/xserver \
    xpext \
    xsp"

RDEPENDS_maemo-task-libs-install = "\
    libsqlite \
    hildon-lgpl \
    libhildonbase \
    libhildonwidgets \
    hildon-fm"

RDEPENDS_maemo-task-base = "\
    gdk-pixbuf-loader-png \
    gdk-pixbuf-loader-xpm \
    gdk-pixbuf-loader-jpeg \
    pango-module-basic-x \
    pango-module-basic-fc \
    bluez-utils-dbus \
    matchbox \
    shared-mime-info \
    rxvt-unicode \
    xst \
    xhost \
    xrdb \
    libgtkstylus \
    outo \
    hildon-initscripts \
    libosso \
    osso-af-utils \
    osso-af-startup \
    osso-core-config \
    osso-gnome-vfs2 \
    osso-thumbnail \
    xauth \
    esd"

RDEPENDS_maemo-task-theme = "\
    xcursor-transparent-theme \
    sdk-default-theme \
    sdk-default-theme-config \
    sdk-default-icons \
    sapwood \
    ttf-bitstream-vera \
    sapwood \
    osso-sounds"

RDEPENDS_maemo-task-apps = "\
    osso-gwobex \
    osso-gwconnect \
    osso-bttools \
    hildon-status-bar \
    hildon-home \
    hildon-navigator \
    hildon-control-panel \
    osso-application-installer \
    osso-app-killer \
    osso-screenshot-tool \
    gpe-todo-hildon \
    gpe-contacts-hildon \
    gpe-mini-browser-hildon"
