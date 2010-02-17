# bootstrap image
#
# the Angstrom-specific bits that were originally part of this image
# definition have been moved to angstrom-console-base-image.bb

IMAGE_PREPROCESS_COMMAND = "create_etc_timestamp"

IMAGE_EXTRA_INSTALL ?= ""

ZZAPSPLASH = ' ${@base_contains("MACHINE_FEATURES", "screen", "psplash-zap", "",d)}'

DEPENDS = "task-base \
           ${SPLASH} \
           ${ZZAPSPLASH} \
	   "

IMAGE_INSTALL = "task-base \
	    ${IMAGE_EXTRA_INSTALL} \
	    ${SPLASH} \
	    ${ZZAPSPLASH} \
	    "

IMAGE_LINGUAS = ""

inherit image
