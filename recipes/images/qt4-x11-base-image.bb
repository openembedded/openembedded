require micro-base-image.bb

TOUCH = ' ${@base_contains("MACHINE_FEATURES", "touchscreen", "tslib tslib-calibrate tslib-tests", "",d)}'

XSERVER ?= "xserver-xorg \
           xf86-input-evdev \
           xf86-input-tslib \
           xf86-video-fbdev "

DEPENDS += "task-qt4-x11"

RDEPENDS_${PN} += " \
        task-qt4-x11-base \
	task-qt4-x11-qwt \
        "

IMAGE_INSTALL += "\
	initscripts \
	kernel-modules \
	gdbserver \
	strace \
	module-init-tools \
	task-qt4-x11-base \
	task-qt4-x11-qwt \
	${TOUCH} \
	pointercal \
	${XSERVER} \
	ttf-liberation-sans ttf-liberation-serif ttf-liberation-mono \
	xauth xhost xset xrandr \
"
