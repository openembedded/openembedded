DESCRIPTION = "An X11-based distribution with the Enlightenment Window Manager and Tools"
PR = "r3"

include e-image-core.bb

export IMAGE_BASENAME = "e-image"
export IPKG_INSTALL += "task-e-x11"
DEPENDS += "task-e-x11"