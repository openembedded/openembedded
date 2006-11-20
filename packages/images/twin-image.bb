export IMAGE_BASENAME="twin-image"

DEPENDS = '${MACHINE_TASK_PROVIDER} \
          twin \
	  orpheus \
	  nano \
	  vim \
	  mutt'

export IPKG_INSTALL = '${MACHINE_TASK_PROVIDER} \
		       twin \
		       orpheus \
		       nano \
		       vim \
		       mutt'

inherit image_ipk
LICENSE = "MIT"
