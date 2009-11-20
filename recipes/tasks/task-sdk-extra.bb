DESCRIPTION = "SDK packages"
PR = "r11"
LICENSE = "MIT"
ALLOW_EMPTY = "1"

PACKAGES = "\
    task-sdk-x11 \
    task-sdk-x11-ext \
    task-sdk-gpe"

RDEPENDS_task-sdk-x11 = "\
    atk-dev \
    cairo-dev \
    gconf-dev \
    gtk+-dev \
    gtk-engines-dev \
    libsvg-cairo-dev \
    libmatchbox-dev \
    matchbox-desktop-dev \
    pango-dev \
    renderproto-dev \
    startup-notification-dev"

RDEPENDS_task-sdk-x11-ext = "\
    libxcursor-dev \
    libxdmcp-dev \
    libxft-dev \
    libxsettings-client-dev \
    randrproto-dev \
    libxau-dev \
    calibrateproto-dev \
    compositeproto-dev \
    damageproto-dev \
    xextproto-dev \
    fontsproto-dev \
    libxpm-dev \
    xproto-dev \
    libxt-dev \
    xtrans-dev \
    libxtst-dev"


RDEPENDS_task-sdk-gpe = "\
    libcontactsdb-dev \
    esound-dev \
    libeventdb-dev \
    libgpepimc-dev \
    libgpevtype-dev \
    libgpelaunch-dev \
    libgpewidget-dev \
    libhandoff-dev \
    libxi-dev \
    gconf-dev"
