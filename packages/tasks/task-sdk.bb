DESCRIPTION = "SDK packages"
PR = "r7"
LICENSE = "MIT"
ALLOW_EMPTY = "1"

PACKAGES = "\
    task-sdk-bare \
    task-sdk-base \
    task-sdk-x11 \
    task-sdk-x11-ext \
    task-sdk-gpe"

RDEPENDS_task-sdk-bare := "\
    glibc \
    glibc-dev \
    libgcc1 \
    "

RDEPENDS_task-sdk-base := "\
    glibc \
    glibc-dev \
    libgcc1 \
    ipkg-dev \
    "

RDEPENDS_task-sdk-x11 := "\
    atk-dev \
    cairo-dev \
    gconf-dbus-dev \
    gtk+-dev \
    gtk-engines-dev \
    libsvg-cairo-dev \
    libmatchbox-dev \
    matchbox-desktop-dev \
    pango-dev \
    startup-notification-dev"

RDEPENDS_task-sdk-x11-ext := "\
    libxcursor-dev \
    libxdmcp-dev \
    libxft-dev \
    libxrandr-dev \
    libxrender-dev \
    libxsettings-client-dev \
    randrext-dev \
    resourceext-dev \
    libx11-dev \
    libxau-dev \
    libxcalibrate-dev \
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


RDEPENDS_task-sdk-gpe := "\
    libcontactsdb-dev \
    esound-dev \
    libeventdb-dev \
    libgpepimc-dev \
    libgpevtype-dev \
    libgpelaunch-dev \
    libgpewidget-dev \
    libhandoff-dev"

