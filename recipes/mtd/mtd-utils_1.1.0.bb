require mtd-utils.inc

PR = "r4"

SRC_URI += "file://add-exclusion-to-mkfs-jffs2-git.patch;patch=1 \
	    file://fix-ignoreerrors-git.patch;patch=1 \
	    file://lzo_1x.patch;patch=1"

SRC_URI[md5sum] = "05aa9b015625aa20afba728fb7ee47b3"
SRC_URI[sha256sum] = "a74b0cc7ec668418389d9f56f85ca8a4619b8674a2d90f5e51bfb8ae9a0667de"
