#Angstrom distcc image

IMAGE_PREPROCESS_COMMAND = "create_etc_timestamp"

DEPENDS = "bridge-utils task-boot distcc task-native-sdk"

IMAGE_INSTALL = "task-base \
		distcc \
		task-native-sdk \
		bridge-utils \
		task-proper-tools \
		mtd-utils \
		wireless-tools \
		iptables"

export IMAGE_BASENAME = "distcc-slave-image"
IMAGE_LINGUAS = ""

IMAGE_FSTYPES += "ubi"

inherit image

