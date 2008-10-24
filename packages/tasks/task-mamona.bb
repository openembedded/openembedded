DESCRIPTION = "Task mamona: Build and Install Mamona Platform"
LICENSE = "MIT"
PR = "r5"
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
    libmamona-im0 \
    libusb \
    libx11 \
    libxau \
    libxdmcp \
    libxext \
    libxfont \
    libxkbfile \
    libxrandr \
    libxrender \
    matchbox-keyboard \
    netm-cli \
    networkmanager \
    pointercal \
    python-core \
    tslib \
    tslib-calibrate \
    udev \
    wireless-tools \
    wpa-supplicant \
    wpa-supplicant-passphrase \
    xserver-kdrive-xomap \
    xserver-kdrive-common \
    xserver-nodm-init \
    xcalibrate \
    xinit \
    xsp \
"

RDEPENDS_append_nokia770 = " \
    cx3110x-770he \
    libasound-module-ctl-dsp-ctl \
    libasound-module-pcm-alsa-dsp \
    mamona-sound-n770 \
"

RDEPENDS_append_nokia800 = " \
    cx3110x-chinooke \
    libasound-module-ctl-dsp-ctl \
    libasound-module-pcm-alsa-dsp \
    mamona-sound-n800 \
"

