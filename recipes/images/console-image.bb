#Angstrom bootstrap image

IMAGE_PREPROCESS_COMMAND = "create_etc_timestamp"

ANGSTROM_EXTRA_INSTALL ?= ""

SPLASH ?= ' ${@base_contains("MACHINE_FEATURES", "screen", "psplash-zap", "",d)}'

DEPENDS = "task-base-extended \
           ${SPLASH} \
	   "

IMAGE_INSTALL = "task-base-extended \
	    ${ANGSTROM_EXTRA_INSTALL} \
	    ${SPLASH} \
	   "

export IMAGE_BASENAME = "console-image"
IMAGE_LINGUAS = ""

inherit image

