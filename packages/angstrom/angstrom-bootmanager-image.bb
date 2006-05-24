export IMAGE_BASENAME = "Ångström Bootmanager Image"
export IMAGE_LINGUAS = ""
export IPKG_INSTALL = "task-bootstrap angstrom-bootmanager"

inherit image_ipk

DEPENDS += "task-bootstrap angstrom-bootmanager"

LICENSE = "MIT"
