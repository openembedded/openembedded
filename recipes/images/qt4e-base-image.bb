require micro-base-image.bb

TOUCH = ' ${@base_contains("MACHINE_FEATURES", "touchscreen", "tslib tslib-calibrate tslib-tests", "",d)}'

DEPENDS += "task-qt4e"

RDEPENDS_${PN} += " \
	task-qt4e-base \
	task-qt4e-qwt \
	"

IMAGE_INSTALL += "\
	initscripts \
	kernel-modules \
	gdbserver \
	strace \
	module-init-tools \
	task-qt4e-base \
	task-qt4e-qwt \
	${TOUCH} \
"
