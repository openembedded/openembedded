export IMAGE_BASENAME="twin-image"

DEPENDS = 'task-bootstrap \
          twin \
	  orpheus \
	  nano \
	  vim \
	  mutt'

export IPKG_INSTALL = 'task-bootstrap \
		       twin \
		       orpheus \
		       nano \
		       vim \
		       mutt'

inherit image_ipk
LICENSE = MIT
