DESCRIPTION = "Full versions of tools provided by busybox"
PR = "r4"

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

#
# binutils-symlinks provide ar in a way which conflict with busybox - #1465 for more info
#
# busybox tar does not understand '--no-same-owner' option which bitbake use
#
