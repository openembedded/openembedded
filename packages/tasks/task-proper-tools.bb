DESCRIPTION = "Full versions of tools provided by busybox"
PR = "r6"

inherit task

RDEPENDS_${PN} = "\
            coreutils \
	    findutils \
	    util-linux-ng \
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
