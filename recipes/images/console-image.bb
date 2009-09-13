#Angstrom bootstrap image
require console-base-image.bb

DEPENDS += "task-base-extended \
	   "

IMAGE_INSTALL += "task-base-extended \
	    "

export IMAGE_BASENAME = "console-image"
