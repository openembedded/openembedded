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
    libaudiofile-dev \
    libbluetooth-dev \
    dbus-dev \
    expat-dev \
    fontconfig-dev \
    freetype-dev \
    libglib-2.0-dev \
    gstreamer-dev \
    libice-dev \
    ipkg-dev \
    libjpeg-dev \
    libapm-dev \
    libasound2 \
    libdisplaymigration-dev \
    libetpan-dev \
    libgcrypt-dev \
    libglade-2.0-dev \
    libgnutls-dev \
    libgpg-error-dev \
    libidl-2-dev \
    libiw-dev \
    libmimedir-0.4-dev \
    libpcap-dev \
    libpixman-dev \
    libpng-dev \
    libschedule-dev \
    libsm-dev \
    libsoundgen-dev \
    libsoup-2.2-dev \
    libsvg-dev \
    libtododb-dev \
    libts-dev \
    libxml2-dev \
    ncurses-dev \
    libopenobex-dev \
    libpopt-dev \
    libreadline-dev \
    libsqlite-dev \
    zlib-dev \
    libxmu-dev"

RDEPENDS_task-sdk-x11 := "\
    libatk-1.0-dev \
    libcairo-dev \
    gconf-dbus-dev \
    gtk+-dev \
    gtk-engines-dev \
    libsvg-cairo-dev \
    libmb-dev \
    matchbox-desktop-dev \
    pango-dev \
    libstartup-notification-1-dev"

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
    libesd-dev \
    libeventdb-dev \
    libgpepimc-dev \
    libgpevtype-dev \
    libgpelaunch-dev \
    libgpewidget-dev \
    libhandoff-dev"

