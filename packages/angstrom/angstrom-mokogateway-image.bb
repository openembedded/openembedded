#Angstrom moko gateway image
# tries to be a companion for openmoko based phones

ANGSTROM_EXTRA_INSTALL ?= ""

DEPENDS = "task-base"
IMAGE_INSTALL = " \
	    task-boot \
	    task-base-bluetooth \
	    bluez-utils \
	    blueprobe \
	   "
export IMAGE_BASENAME = "mokogateway-image"
IMAGE_LINGUAS = ""

inherit image

