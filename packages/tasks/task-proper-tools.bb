DESCRIPTION = "Proper tools for busybox haters"
PR = "r2"

PACKAGE_ARCH = "all"
ALLOW_EMPTY_${PN} = "1"

RDEPENDS = "\
            coreutils \
	    findutils \
	    util-linux \
	    gawk \
	    sed \
	    wget \
	    patch \
	    diffutils \
            less \
            vim \
	    e2fsprogs \
            binutils-symlinks \
            module-init-tools \
	    "


