require console-base-image.bb

#Angstrom bootstrap image
ANGSTROM_EXTRA_INSTALL ?= ""

IMAGE_INSTALL = "task-base \
	    ${ANGSTROM_EXTRA_INSTALL} \
	    ${SPLASH} \
	    ${ZZAPSPLASH} \
	    "
