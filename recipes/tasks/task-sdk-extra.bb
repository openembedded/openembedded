DESCRIPTION = "SDK packages"
PR = "r8"
LICENSE = "MIT"
ALLOW_EMPTY = "1"

PACKAGES = "\
    task-sdk-x11 \
    task-sdk-x11-ext \
    task-sdk-gpe"

RDEPENDS_task-sdk-x11 = "\
    atk-dev \
    cairo-dev \
    gconf-dbus-dev \
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
    libxrandr-dev \
    libxrender-dev \
    libxsettings-client-dev \
    randrproto-dev \
    libxau-dev \
    xcalibrateext-dev \
    libxcomposite-dev \
    libxdamage-dev \
    libxext-dev \
    xextproto-dev \
    libxfont-dev \
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
    gconf-dbus-dev"

