DEPENDS = '${MACHINE_TASK_PROVIDER} \
          twin \
	  orpheus \
	  nano \
	  vim \
	  mutt'

IMAGE_INSTALL = '\
    ${MACHINE_TASK_PROVIDER} \
    twin \
    orpheus \
    nano \
    vim \
    mutt'

inherit image
