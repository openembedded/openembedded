DISTRO_SSH_DAEMON ?= "dropbear"
DISTRO_PACKAGE_MANAGER ?= "opkg-nogpg opkg-collateral"

XSERVER ?= "xserver-kdrive-fbdev"

IMAGE_PREPROCESS_COMMAND = "create_etc_timestamp"

IMAGE_INSTALL = "\
	task-base-extended \
	${DISTRO_SSH_DAEMON} \
	${DISTRO_PACKAGE_MANAGER} \
	pointercal \
	matchbox-wm \
	matchbox-keyboard matchbox-keyboard-applet matchbox-keyboard-im \
	matchbox-desktop \
	${XSERVER} \
	xserver-kdrive-common xserver-nodm-init \
	ttf-liberation-sans ttf-liberation-serif ttf-liberation-mono \
	xauth xhost xset xrandr \
	matchbox-sato \
	matchbox-config-gtk \
	matchbox-themes-gtk \
	matchbox-applet-startup-monitor \
	xcursor-transparent-theme \
	sato-icon-theme \
	settings-daemon \
"

export IMAGE_BASENAME = "${PN}"
IMAGE_LINGUAS = ""

inherit image

