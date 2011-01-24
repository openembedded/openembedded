DESCRIPTION = "SDK task for Scratchbox rootstraps incuding GPE/GTK bits"
PR = "r2"
LICENSE = "MIT"
ALLOW_EMPTY = "1"

RDEPENDS_${PN} = "\
    glib-2.0-utils \
    gdk-pixbuf-loader-png \
    gdk-pixbuf-loader-jpeg \
    gdk-pixbuf-loader-gif \
    gdk-pixbuf-loader-xpm \
    intltool \
    intltool-dev \
    opkg-utils \
    gettext-dev \
    pkgconfig-dev \
    autoconf \
    automake \
    "
