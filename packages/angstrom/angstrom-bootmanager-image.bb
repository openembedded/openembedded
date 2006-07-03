#Angstrom bootmanager image
LICENSE = MIT
MAINTAINER = "Koen Kooi <koen@dominion.kabel.utwente.nl>"
PR = "r0"

DEPENDS = "task-angstrom"
RDEPENDS = "angstrom-base-depends angstrom-bootmanager"

export IMAGE_BASENAME = "bootmanager-image"
export IMAGE_LINGUAS = ""
export IPKG_INSTALL = "${RDEPENDS}"

inherit image_ipk



