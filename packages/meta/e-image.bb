export IMAGE_BASENAME = "e-image"

DEPENDS = "task-bootstrap meta-e-x11 xserver-kdrive"

PREFERRED_PROVIDER_virtual/xserver = "xserver-kdrive"
PREFERRED_PROVIDER_virtual/evas = "evas-x11"
PREFERRED_PROVIDER_virtual/ecore = "ecore-x11"
PREFERRED_PROVIDER_virtual/imlib2 = "imlib2-x11"

export IPKG_INSTALL = "task-bootstrap task-enlightenment-x11 xserver-kdrive-fbdev"

inherit image_ipk
LICENSE = MIT
