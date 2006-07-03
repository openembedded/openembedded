#Angstrom bootstrap image
LICENSE = MIT
MAINTAINER = "Koen Kooi <koen@dominion.kabel.utwente.nl>"
PR = "r0"

DEPENDS = "task-angstrom"
RDEPENDS = "angstrom-base-depends"

export IMAGE_BASENAME = "bootstrap-image"
export IMAGE_LINGUAS = ""
export IPKG_INSTALL = "angstrom-base-depends"

inherit image_ipk

