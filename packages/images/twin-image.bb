export IMAGE_BASENAME="twin-image"

DEPENDS = '${MACHINE_TASK_PROVIDER} \
          twin \
	  orpheus \
	  nano \
	  vim \
	  mutt'

export PACKAGE_INSTALL = '${MACHINE_TASK_PROVIDER} \
		       twin \
		       orpheus \
		       nano \
		       vim \
		       mutt'

inherit image
LICENSE = "MIT"
