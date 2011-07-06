DISTRO_SSH_DAEMON ?= "dropbear"
DISTRO_PACKAGE_MANAGER ?= "opkg opkg-collateral"

XSERVER ?= "xserver-kdrive-fbdev"

IMAGE_PREPROCESS_COMMAND = "create_etc_timestamp"

EVDEV_INSTALL = "\
        xinput-calibrator \
"

IMAGE_INSTALL = "\
	task-base-extended \
	${DISTRO_SSH_DAEMON} \
	${DISTRO_PACKAGE_MANAGER} \
	pointercal \
	${XSERVER} \
	xserver-common xserver-nodm-init \
	ttf-liberation-sans ttf-liberation-serif ttf-liberation-mono \
	xauth xhost xset xrandr \
	xcursor-transparent-theme \
	matchbox2 \
	${EVDEV_INSTALL} \
"

export IMAGE_BASENAME = "${PN}"
IMAGE_LINGUAS = ""

inherit image
