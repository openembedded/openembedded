DESCRIPTION = "An X11-based distribution with the Enlightenment Window Manager and Tools"
LICENSE = "MIT"
PR = "r1"

export IMAGE_BASENAME = "e-image"
export IMAGE_LINGUAS = ""

DEPENDS = "task-bootstrap meta-e-x11 xserver-kdrive"

PREFERRED_PROVIDER_virtual/xserver = "xserver-kdrive"
PREFERRED_PROVIDER_virtual/evas = "evas-x11"
PREFERRED_PROVIDER_virtual/ecore = "ecore-x11"
PREFERRED_PROVIDER_virtual/imlib2 = "imlib2-x11"
PREFERRED_PROVIDER_virtual/libxine = "libxine-x11"

export IPKG_INSTALL = "task-bootstrap task-enlightenment-x11 xserver-kdrive-fbdev"

inherit image_ipk
