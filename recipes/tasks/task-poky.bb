#
# Copyright (C) 2007 OpenedHand Ltd.
#

DESCRIPTION = "Tasks for OpenedHand Poky"
PR = "r31"

PACKAGES = "\
    task-poky-apps-console \
    task-poky-apps-console-dbg \
    task-poky-apps-console-dev \
    task-poky-apps-x11-core \
    task-poky-apps-x11-core-dbg \
    task-poky-apps-x11-core-dev \
    task-poky-apps-x11-games \
    task-poky-apps-x11-games-dbg \
    task-poky-apps-x11-games-dev \
    task-poky-apps-x11-pimlico \
    task-poky-apps-x11-pimlico-dbg \
    task-poky-apps-x11-pimlico-dev \
    task-poky-x11-base \
    task-poky-x11-base-dbg \
    task-poky-x11-base-dev \
    task-poky-x11-sato \
    task-poky-x11-sato-dbg \
    task-poky-x11-sato-dev \
    task-poky-tools-debug \
    task-poky-tools-debug-dbg \
    task-poky-tools-debug-dev \
    task-poky-tools-profile \
    task-poky-tools-profile-dbg \
    task-poky-tools-profile-dev \
    task-poky-tools-testapps \
    task-poky-tools-testapps-dbg \
    task-poky-tools-testapps-dev \
    task-poky-nfs-server \
    task-poky-nfs-server-dbg \
    task-poky-nfs-server-dev \
    "

PACKAGE_ARCH = "${MACHINE_ARCH}"

XSERVER ?= "xserver-xorg xf86-input-evdev xf86-video-fbdev xf86-input-tslib xf86-input-mouse xf86-input-keyboard"

ALLOW_EMPTY = "1"


RDEPENDS_task-poky-apps-console = "\
    avahi-daemon \
    dropbear \
    portmap \
    psplash"

RDEPENDS_task-poky-x11-base = "\
    pointercal \
    matchbox-wm \
#    matchbox-keyboard \
#    matchbox-keyboard-applet \
#    matchbox-keyboard-im \
    matchbox-keyboard-inputmethod \
    matchbox-panel-2 \
    matchbox-desktop-2 \
    ${XSERVER} \
    xserver-common (>= 1.30) \
    xserver-nodm-init \
    ttf-liberation-sans \
    ttf-liberation-mono \
    ttf-liberation-serif \
    xauth \
    xhost \
    xset \
    xrandr"
#    matchbox-panel-2-applets \

RDEPENDS_task-poky-apps-x11-core = "\
    leafpad \
    pcmanfm "

RDEPENDS_task-poky-apps-x11-games = "\
    oh-puzzles"

WEB = "web-webkit"
# WebKit takes too much space to fit on some devices
# List here for now...
WEB_c7x0 = ""
WEB_mx31ads = ""
WEB_mx31phy = ""

RDEPENDS_task-poky-apps-x11-pimlico = "\
    eds-dbus \
    contacts \
    dates \
    tasks "

RDEPENDS_task-poky-x11-sato = "\
    gtk-theme-sato \
    matchbox-desktop-2 \
    matchbox-panel-2 \
    matchbox-common \
    matchbox-session \
    matchbox-stroke \
    matchbox-config-gtk \
    matchbox-themes-gtk \
    xcursor-transparent-theme \
    sato-icon-theme \
    settings-daemon \
    gtk-sato-engine"

RDEPENDS_task-poky-tools-debug = "\
    gdb \
    gdbserver \
    strace"

RDEPENDS_task-poky-tools-profile = "\
    oprofile \
    oprofileui-server \
    powertop"

RDEPENDS_task-poky-tools-profile_qemux86 += "valgrind"

RRECOMMENDS_task-poky-tools-profile = "\
    kernel-module-oprofile"

RDEPENDS_task-poky-tools-testapps = "\
    blktool \
    tslib-calibrate \
    tslib-tests \
    lrzsz \
    alsa-utils-amixer \
    alsa-utils-aplay \
    gst-meta-video \
    gst-meta-audio \
    xrestop \
    xwininfo \
    kexec-tools \
    xprop "

RDEPENDS_task-poky-nfs-server = "\
    nfs-utils"

# rpcinfo can be useful
RRECOMMENDS_task-poky-nfs-server = "\
    glibc-utils"
