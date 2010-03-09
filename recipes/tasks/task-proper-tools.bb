DESCRIPTION = "Full versions of tools provided by busybox"
PR = "r11"

inherit task

RDEPENDS_${PN} = "\
		binutils-symlinks \
		coreutils \
		cpio \
		debianutils \
		diffutils \
		e2fsprogs \
		fbset \
		findutils \
		gawk \
		grep \
		gzip \
		iproute2 \
		iputils \
		less \
		module-init-tools \
		netcat \
		net-tools \
		patch \
		procps \
		psmisc \
		sed \
		tar \
		tcptraceroute \
		util-linux-ng \
		vim \
		wget \
        "
#
# binutils-symlinks provide ar in a way which conflict with busybox - #1465 for more info
#
# busybox tar does not understand '--no-same-owner' option which bitbake use
#
