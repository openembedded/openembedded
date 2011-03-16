inherit task

PV = "1.1"
PR = "r4"

PACKAGE_ARCH = "all"
ALLOW_EMPTY = "1"

ECONFIG ?= "places e-wm-config-angstrom"
EMENU ?= "e-wm-menu"

PACKAGES =+ "task-beagleboard-validation-base task-beagleboard-validation-gui task-beagleboard-validation-gui-extras"

RDEPENDS_task-beagleboard-validation-base = "\
    task-base-extended \
    task-omap-drivers \
    bc \
    e2fsprogs-mke2fs \
    util-linux-ng-fdisk util-linux-ng-sfdisk \
    dosfstools \
    beagleboard-test-scripts \
    sox \
    alsa-utils-aplay \
    ti-dsplink-examples \
    i2c-tools \
    memtester \
    cpuburn-neon \
    evtest \
    devmem2 \
    mtd-utils \
    mplayer \
    nmap iperf \
    powertop oprofile \
    angstrom-led-config \
    cron ntpdate \
    picodlp-control \
    openssh-scp openssh-ssh \
    nodejs \
"


RDEPENDS_task-beagleboard-validation-gui = " \
    angstrom-x11-base-depends \
    angstrom-gpe-task-base \
    angstrom-gpe-task-settings \
    angstrom-zeroconf-audio \
    gpe-scap \
    mime-support e-wm ${ECONFIG} ${EMENU} \
    xterm \
    hicolor-icon-theme gnome-icon-theme \
    synergy \
    angstrom-gnome-icon-theme-enable \
    network-manager-applet \
    gnome-bluetooth \
    x11vnc angstrom-x11vnc-xinit \
"

RDEPENDS_task-beagleboard-validation-gui-extras = "\
    matrix-gui \
    midori \
"

