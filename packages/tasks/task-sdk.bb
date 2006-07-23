DESCRIPTION = "SDK packages for Opie and GPE"
PR = "r2"
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
    "	

RDEPENDS_task-sdk-base := "\
    glibc \
    glibc-dev \
    audiofile-dev \
    bluez-libs-dev \
    dbus-dev \
    expat-dev \
    fontconfig-dev \
    freetype-dev \
    glib-2.0-dev \
    gstreamer-dev \
    ice-dev \
    ipkg-dev \
    jpeg-dev \
    libapm-dev \
    libdisplaymigration-dev \
    libetpan-dev \
    libgcrypt-dev \
    libglade-dev \
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
    xmu-dev"

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
    esound-gpe-dev \
    libeventdb-dev \
    libgpepimc-dev \
    libgpevtype-dev \
    libgpelaunch-dev \
    libgpewidget-dev"

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
