DESCRIPTION = "Task for ti-demo-x11"

PR = "r1"

inherit task 

ECONFIG ?= "places e-wm-config-angstrom e-wm-config-angstrom-touchscreen e-wm-config-angstrom-widescreen e-wm-config-default"

RDEPENDS_${PN} = "\
    task-base-extended \
    task-gstreamer-ti \
    angstrom-x11-base-depends \
    angstrom-gpe-task-base \
    angstrom-gpe-task-settings \
    angstrom-zeroconf-audio \
    angstrom-led-config \ 
    gpe-scap \
    mime-support e-wm ${ECONFIG} \
    xterm \
    firefox midori \
    hicolor-icon-theme gnome-icon-theme \
    mplayer \
    angstrom-gnome-icon-theme-enable \
    picodlp-control \
    connman-gnome \
    gnome-bluetooth \
    alsa-utils-aplay \
    alsa-utils-alsamixer \
    libgles-omap3 \
    libgles-omap3-x11demos \
    libgles-omap3-tests \
"

# Install all kernel modules
RRECOMMENDS_${PN} += " \
	kernel-modules \
    rt73-firmware \
	zd1211-firmware \
"

PACKAGE_ARCH = "${MACHINE_ARCH}"
RRECOMMENDS_${PN}_append_armv7a = " \
	gnash gnash-browser-plugin \
	omapfbplay \
"

