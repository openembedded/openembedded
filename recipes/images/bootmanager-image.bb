#Angstrom bootmanager image

SPLASH ?= ' ${@base_contains("MACHINE_FEATURES", "screen", "psplash-angstrom", "",d)}'

DEPENDS = "task-angstrom"
IMAGE_INSTALL = "angstrom-base-depends angstrom-bootmanager ${SPLASH}"

export IMAGE_BASENAME = "bootmanager-image"

inherit image



