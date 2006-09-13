DESCRIPTION = "SDK packages for Opie and GPE"
PR = "r5"
LICENSE = MIT
ALLOW_EMPTY = "1"

PACKAGES = "\
    task-sdk-bare \
    task-sdk-base \
    task-sdk-opie \
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
    libasound2 \
    libdisplaymigration-dev \
    libetpan-dev \
    libgcrypt-dev \
    libglade-dev \
    libgnutls-dev \
    libgpg-error-dev \ 
    libidl-dev \
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
    openobex-dev \
    popt-dev \
    readline-dev \
    sqlite-dev \
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
    compositeext-dev \
    damageext-dev \
    fixesext-dev \
    libxcursor-dev \
    libxdmcp-dev \
    libxfixes-dev \
    libxft-dev \
    libxrandr-dev \
    libxrender-dev \
    libxsettings-client-dev \
    randrext-dev \
    recordext-dev \
    renderext-dev \
    resourceext-dev \
    x11-dev \
    xau-dev \
    xcalibrate-dev \
    xcalibrateext-dev \
    xcomposite-dev \
    xdamage-dev \
    xext-dev \
    xextensions-dev \
    xfont-dev \
    xpm-dev \
    xproto-dev \
    xt-dev \
    xtrans-dev \
    xtst-dev"
#    libxss-dev \

RDEPENDS_task-sdk-gpe := "\
    libcontactsdb-dev \
    esound-gpe-dev \
    libeventdb-dev \
    libgpepimc-dev \
    libgpevtype-dev \
    libgpelaunch-dev \
    libgpewidget-dev \
    libhandoff-dev"

RDEPENDS_task-sdk-opie := "\
    libopiebluez2 \
    libopiedb2 \
    libopiecore2 \
    libopienet2 \
    libopiepim2 \
    libopieui2 \
    libqpe1 \
    qte \
    libqtaux2 \
    libmailwrapper"
