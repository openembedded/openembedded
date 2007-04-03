DESCRIPTION = "SDK packages"
PR = "r6"
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
    alsa-dev \
    audiofile-dev \
    bluez-libs-dev \
    dbus-dev \
    expat-dev \
    fontconfig-dev \
    freetype-dev \
    glib-2.0-dev \
    gstreamer-dev \
    libice-dev \
    ipkg-dev \
    jpeg-dev \
    libapm-dev \
    alsa-lib-dev \
    libdisplaymigration-dev \
    libetpan-dev \
    libgcrypt-dev \
    libglade-dev \
    gnutls-dev \
    libgpg-error-dev \
    libidl-dev \
    libiw-dev \
    libmimedir-dev \
    libpcap-dev \
    libpixman-dev \
    libpng-dev \
    libschedule-dev \
    libsm-dev \
    libsoundgen-dev \
    libsoup-dev \
    libsvg-dev \
    libtododb-dev \
    libts-dev \
    libxml2-dev \
    ncurses-dev \
    openobex-dev \
    popt-dev \
    readline-dev \
    libsqlite-dev \
    zlib-dev \
    libxmu-dev"

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

