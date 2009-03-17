require opie-image.bb

DEPENDS += "task-xqtlauncher"

export IMAGE_BASENAME = "opie-xqtlauncher-image"

IMAGE_INSTALL += "task-xqtlauncher task-xqtlauncher-blackbox"
