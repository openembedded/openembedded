include gpe-collections.bb

MAINTAINER = "Rob Taylor <rjt@cambridgebroadband.com"

PR = "r4"

export IMAGE_BASENAME = "gpe-image-blank-user"

DEPENDS = "task-bootstrap ${GPE_BASE_DEPENDS} ${GPE_BASE} ${GPE_PIM} \
	   ${GPE_BASE_SETTINGS} ${GPE_BASE_APPS} \
	   ${GPE_EXTRA_DEPENDS}"

export IPKG_INSTALL = "task-bootstrap ${GPE_BASE_DEPENDS} ${GPE_BASE} \
           	       ${GPE_PIM} ${GPE_BASE_SETTINGS} \
	               ${GPE_BASE_APPS} ${GPE_EXTRA_DEPENDS} \
		       ${XSERVER} \
		       ${GPE_BASE_RDEPENDS} \
		       ${GPE_EXTRA_INSTALL}"


ROOTFS_POSTPROCESS_COMMAND += "adduser -D user"


inherit image_ipk
LICENSE = MIT
