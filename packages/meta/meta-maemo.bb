
PACKAGES = maemo-task-base maemo-task-apps maemo-task-libs-install
DESCRIPTION = "Meta-package for maemo environment"
MAINTAINER = "Florian Boor <florian@kernelconcepts.de>"
PR = "r1"

ALLOW_EMPTY = 1

maemo-base-depends = "\
    diet-x11 \
    virtual/xserver \
    xpext \
    xsp"

RDEPENDS_maemo-base-depends := "${maemo-base-depends}"
DEPENDS += " ${maemo-base-depends}"

maemo-task-libs-install = "\
                           libsqlite0 \
                           libhildonlgpl0 \
                           libhildonbase0 \
                           libhildonwidgets0 \
                           libhildonfm1"

RDEPENDS_maemo-task-libs-install := "${maemo-task-libs-install}"


maemo-task-base = "\
    bluez-utils-dbus \
    matchbox \
    xcursor-transparent-theme \
    sdk-default-theme \
    sdk-default-theme-config \
    sdk-default-icons \
    sapwood \
    shared-mime-info \
    rxvt-unicode \
    xst \
    xhost \
    xrdb \
    ttf-bitstream-vera \
    libgtkstylus \
    detect-stylus \
    outo \
    sapwood \
    hildon-initscripts \
    libosso \
    osso-af-utils \
    osso-af-startup \
    osso-core-config \
    osso-gnome-vfs2 \
    osso-thumbnail \
    xauth"

RDEPENDS_maemo-task-base := "gdk-pixbuf-loader-png \
			   gdk-pixbuf-loader-xpm \
			   gdk-pixbuf-loader-jpeg \
			   pango-module-basic-x \
			   pango-module-basic-fc \
			   ${maemo-task-base}"
DEPENDS += " ${maemo-task-base}"

maemo-task-apps = "\
    osso-gwobex \
    osso-gwconnect \
    osso-bttools \
    hildon-status-bar \
    hildon-home \
    hildon-navigator \
    hildon-control-panel"

RDEPENDS_maemo-task-apps := "${maemo-task-apps}"
DEPENDS += " ${maemo-task-apps}"

LICENSE = MIT
