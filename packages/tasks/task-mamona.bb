DESCRIPTION = "Task mamona: Build and Install Mamona Platform"
LICENSE = "MIT"
PR = "r1"
ALLOW_EMPTY = "1"

PACKAGES = "${PN}"

RDEPENDS = "\
    task-mamona-base \
    alsa-conf-base \
    alsa-utils-alsamixer \
    alsa-lib \
    alsa-utils-alsactl \
    alsa-state \
    alsa-utils-alsamixer \
    bluez-utils \
    bluez-utils-compat \
    dbus \
    dbus-glib \
    expat \
    freetype \
    glib-2.0 \
    glibc \
    glibc-utils \
    hal \
    intltool \
    libfontenc \
    libusb \
    libx11 \
    libxau \
    libxdmcp \
    libxext \
    libxfont \
    libxkbfile \
    libxrandr \
    libxrender \
    pointercal \
    tslib \
    tslib-calibrate \
    udev \
    update-modules \
    xserver-kdrive-xomap \
    xserver-kdrive-common \
    xserver-nodm-init \
    xcalibrate \
    xinit \
    xsp \
    xterm \
"

RDEPENDS_append_nokia770 = " \
    libasound-module-ctl-dsp-ctl \
    libasound-module-pcm-alsa-dsp \
    mamona-sound-n770 \
"

RDEPENDS_append_nokia800 = " \
    libasound-module-ctl-dsp-ctl \
    libasound-module-pcm-alsa-dsp \
    mamona-sound-n800 \
"
