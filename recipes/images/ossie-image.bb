DEPENDS = "${MACHINE_TASK_PROVIDER} task-ossie"

IMAGE_LINGUAS = ""
IMAGE_INSTALL = "${MACHINE_TASK_PROVIDER} task-ossie"

OSSIE_URI = "http://192.168.1.81/feed"

FEED_URIS += " \
                no-arch##${OSSIE_URI}/unstable/feed/all \
                base##${OSSIE_URI}/unstable/feed/${TARGET_ARCH}/base \
                python##${OSSIE_URI}/unstable/feed/${TARGET_ARCH}/python \
                debug##${OSSIE_URI}/unstable/feed/${TARGET_ARCH}/debug \
                ${MACHINE}##${OSSIE_URI}/unstable/feed/${TARGET_ARCH}/machine/${MACHINE}"

inherit image
