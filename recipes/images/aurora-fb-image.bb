###############################################################################
# Aurora Framebuffer Image
###############################################################################

require aurora-image.inc

TOUCH = ' ${@base_contains("MACHINE_FEATURES", "touchscreen", "tslib tslib-calibrate tslib-tests", "",d)}'

export IMAGE_BASENAME = "aurora-fb-image"

IMAGE_INSTALL += " \
	task-qt4e-base \
	${TOUCH} \
	pointercal \
"
