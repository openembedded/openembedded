#Angstrom bootmanager image

DEPENDS = "task-angstrom"
IMAGE_INSTALL = "angstrom-base-depends angstrom-bootmanager"

export IMAGE_BASENAME = "bootmanager-image"

inherit image



