#GNU radio image

IMAGE_PREPROCESS_COMMAND = "create_etc_timestamp"

IMAGE_EXTRA_INSTALL ?= ""

SPLASH ?= ' ${@base_contains("MACHINE_FEATURES", "screen", "psplash-zap", "",d)}'

DEPENDS = "task-base-extended \
           ${SPLASH} \
	   "

IMAGE_INSTALL = "task-base-extended \
	    ${IMAGE_EXTRA_INSTALL} \
	    ${SPLASH} \
            oprofile \
            screen \
            ntp ntp-bin \
            make \
            nfs-utils-client \
            gnuradio gnuradio-examples \
	   "

export IMAGE_BASENAME = "gnuradio-image"
IMAGE_LINGUAS = ""

inherit image

