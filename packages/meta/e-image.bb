DESCRIPTION = "An X11-based distribution with the Enlightenment Window Manager and Tools"
PR = "r2"

include e-image-core.bb

export IMAGE_BASENAME = "e-image"
export IPKG_INSTALL += "task-enlightenment-x11"