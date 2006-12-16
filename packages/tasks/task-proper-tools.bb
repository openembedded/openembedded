DESCRIPTION = "Proper tools for busybox haters"
PR = "r3"

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
            tar \
	    diffutils \
            less \
            vim \
	    e2fsprogs \
            binutils-symlinks \
            module-init-tools \
	    "


