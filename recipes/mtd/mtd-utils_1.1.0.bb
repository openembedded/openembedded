require mtd-utils.inc

PR = "r4"

SRC_URI += "file://add-exclusion-to-mkfs-jffs2-git.patch;patch=1 \
	    file://fix-ignoreerrors-git.patch;patch=1 \
	    file://lzo_1x.patch;patch=1"
