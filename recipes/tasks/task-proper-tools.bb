DESCRIPTION = "Full versions of tools provided by busybox"
PR = "r16"

inherit task

RDEPENDS_${PN} = "\
		bash \
		bc \
		bind-utils \
		binutils-symlinks \
		bzip2 \
		console-tools \
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
		ifupdown \
		${@base_contains('DISTRO_FEATURES', 'ipv6', 'iproute2', '', d)} \
		iputils-arping \
		${@base_contains('DISTRO_FEATURES', 'ipv6', 'iputils-ping6', '', d)} \
		iputils-ping \
		iputils \
		less \
		minicom \
		mktemp \
		module-init-tools \
		ncurses-tools \
		netcat \
		inetutils \
		net-tools \
		openrdate \
		patch \
		picocom \
		procps \
		psmisc \
		pump \
		realpath \
		sed \
		shadow \
		start-stop-daemon \
		syslog-ng \
		sysvinit \
		tar \
		tcptraceroute \
		tftp-hpa \
		time \
		unzip \
		util-linux-ng \
		vim \
		wget \
        "
#
# binutils-symlinks provide ar in a way which conflict with busybox - #1465 for more info
#
# busybox tar does not understand '--no-same-owner' option which bitbake use
#
