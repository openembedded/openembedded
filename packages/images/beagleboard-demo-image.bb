# Demo image for beagleboard

XSERVER ?= "xserver-xorg \
           xf86-input-evdev \
           xf86-input-mouse \
           xf86-video-fbdev \
           xf86-input-keyboard \
"

ANGSTROM_EXTRA_INSTALL ?= ""

export IMAGE_BASENAME = "Beagleboard-demo-image"

DEPENDS = "task-base"
IMAGE_INSTALL = "\
    ${XSERVER} \
    task-base-extended \
    angstrom-x11-base-depends \
    angstrom-gpe-task-base \
    angstrom-gpe-task-settings \
    ${ANGSTROM_EXTRA_INSTALL} \
    angstrom-zeroconf-audio \
    angstrom-led-config \ 
    gpe-scap \
    psplash \
    e-wm exhibit \
    xterm xmms \
    epiphany firefox midori \
    swfdec-mozilla \
    hicolor-icon-theme gnome-icon-theme \
    jaaa nmap iperf gnuplot \
    abiword \
    gnumeric \
    gimp \
    powertop oprofile \
    pidgin \
#    irssi \
    mplayer omapfbplay \
    gnome-games \
    rt73-firmware zd1211-firmware \
    stalonetray \
	synergy \
	x11vnc \
"

IMAGE_PREPROCESS_COMMAND = "create_etc_timestamp"

#zap root password for release images
ROOTFS_POSTPROCESS_COMMAND += '${@base_conditional("DISTRO_TYPE", "release", "zap_root_password; ", "",d)}'

inherit image
