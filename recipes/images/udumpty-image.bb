# Image that mimics the default desktop of a certain distro

SPLASH ?= ' ${@base_contains("MACHINE_FEATURES", "screen", "psplash-angstrom", "",d)}'
XSERVER ?= "xserver-xorg \
           xf86-input-evdev \
           xf86-input-mouse \
           xf86-video-fbdev \
           xf86-input-keyboard \
"


ANGSTROM_EXTRA_INSTALL ?= ""

export IMAGE_BASENAME = "Udumpty-image"

DEPENDS = "task-base"
IMAGE_INSTALL = "\
    ${XSERVER} \
    task-base-extended \
    angstrom-x11-base-depends \
    angstrom-gpe-task-base \
    ${ANGSTROM_EXTRA_INSTALL} \
    angstrom-zeroconf-audio \
    angstrom-led-config \ 
    gpe-scap \
    psplash \
    metacity \
    xterm \ 
    epiphany \
    swfdec-mozilla \
    hicolor-icon-theme gnome-icon-theme \
    abiword \
    gnumeric \
    gimp \
    powertop oprofile \
    pidgin \
    totem mplayer omapfbplay \
    gnome-games \
    rt73-firmware zd1211-firmware \
	synergy \
	x11vnc \
	angstrom-gnome-icon-theme-enable \
	gnome-panel \
	gnome-control-center \
	gnome-settings-daemon \
	gnome-session \
    ${SPLASH} \
"

IMAGE_PREPROCESS_COMMAND = "create_etc_timestamp"

#zap root password for release images
ROOTFS_POSTPROCESS_COMMAND += '${@base_conditional("DISTRO_TYPE", "release", "zap_root_password; ", "",d)}'

inherit image
